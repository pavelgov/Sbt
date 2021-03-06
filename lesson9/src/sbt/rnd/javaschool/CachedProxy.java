package sbt.rnd.javaschool;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 20.09.2017.
 */
public class CachedProxy {
    HashMap<String, Integer> map = new HashMap<>();


    private String getStrFromArgs(Method method, Object[] mArgs) {
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        List<Object> identityArgList = Arrays.asList(annotation.identityBy());
        List<Object> presentArgList = new ArrayList();

        if (identityArgList.isEmpty()) presentArgList = Arrays.asList(mArgs);//если нет аргументов в аннотации
        else {
            for (Object o : mArgs) {                        //перебираем аргументы массива
                if (identityArgList.contains(o.getClass())) //если совпадают с арг. из аннотации то
                    presentArgList.add(o);                  //они должны участвовать в расчетах, доб.в финальный лист
            }
        }

        StringBuilder args = new StringBuilder();

        for (int i = 0; i < presentArgList.size(); i++) {    //преобразуем массив аргументов в одну строку
            args.append(presentArgList.get(i) + " ");
        }
        return method.getName() + " " + args.toString(); //все аргументы и метод одной строкой
    }

    private String getFilename(Method method) {
        String filename;
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        if (annotation.fileNamePrefix().isEmpty()) {
            filename = method.getName();
        } else filename = annotation.fileNamePrefix();
        return filename;
    }

    private void setToFile(Method method, Object[] mArgs, Integer result) {
        String input = getStrFromArgs(method, mArgs); //получаем аргументы в виде строки
        map.put(input, result);
        String filename = getFilename(method);

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            System.out.println("Ошибка сериализации");
        }


    }

    private Integer getFromFile(Method method, Object[] mArgs) {

        String filename = getFilename(method);

        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream oin = new ObjectInputStream(fis);
            map = (HashMap) oin.readObject();

        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        String input = getStrFromArgs(method, mArgs);
        return map.get(input);
    }


    public <T> T create(final Class<T> cl, final T code) {
        return (T) Proxy.newProxyInstance(cl.getClassLoader(), new Class<?>[]{cl}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                Object result = getFromFile(method, args);

                if (result == null) {
                    //если в кэше (файле) ничего не оказалось значит выполнить операцию
                    result = method.invoke(code, args);
                    //  запишем результат в файл
                    setToFile(method, args, (Integer) result);
                }
                return result;
            }
        });


    }
}
