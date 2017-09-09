package sbt.rnd.javaschool;

import java.io.*;
import java.lang.reflect.*;
import java.lang.reflect.InvocationHandler;
import java.util.Scanner;

/**
 * Кэширующий прокси
 */
public class CachedProxy {

    private static void setToFile(Method method, Object[] mArgs, Integer res) throws IOException {
        StringBuilder args = new StringBuilder();
        String result = String.valueOf((Integer) res);

        for (int i = 0; i < mArgs.length; i++) {  //преобразуем массив аргументов в одну строку
            args.append(mArgs[i] + " ");
        }

        File file = new File("cache.txt");
        PrintStream fr = null;
        try {

            fr = new PrintStream(new FileOutputStream(file, true));
            fr.println(method.getName() + " " + args);
            fr.println(result);

        } catch (IOException e) {
        } finally {
            fr.close();
        }
    }

    private static Object getFromFile(Method method, Object[] mArgs) throws IOException {
        File file = new File("cache.txt");
        StringBuilder args = new StringBuilder();
        Integer result = null;

        for (int i = 0; i < mArgs.length; i++) {    //преобразуем массив аргументов в одну строку
            args.append(mArgs[i] + " ");
        }
        String input = method.getName() + " " + args.toString(); //все аргументы и метод одной строкой

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String res = scanner.nextLine();
                if (line.equals(input)) {           //сравниваем с аргументами
                    result = new Integer(Integer.parseInt(res));
                    break;
                }
            }
        } catch (IOException e) {
            // log error
        }
        return result;
    }


    public static <T> T create(final Class<T> cl, final T code) {

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

