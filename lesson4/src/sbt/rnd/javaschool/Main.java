package sbt.rnd.javaschool;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("first container");              //добавление
        myLinkedList.add("second container");
        myLinkedList.add("third container");
        myLinkedList.add("four container");
        myLinkedList.add("five container");
        myLinkedList.show(myLinkedList);
        System.out.println("");

        System.out.println(myLinkedList.get(2));         //метод get
        System.out.println("");

        myLinkedList.remove(0);                            //удаление
        myLinkedList.show(myLinkedList);
        System.out.println("");


        ArrayList<String> list = new ArrayList<>();
        list.add("list 1");
        list.add("list 2");
        myLinkedList.addAll(list);                         // копирование из листа в лист
        myLinkedList.show(myLinkedList);
        System.out.println("");

        Iterator<String> iter = myLinkedList.iterator();   //итератор
        String s;
        while (iter.hasNext()) {
            s = iter.next();
            if (s.equals("five container"))
                iter.remove();
        }

        myLinkedList.show(myLinkedList);
        System.out.println("");

        myLinkedList.copy(list);                      //метод copy
        myLinkedList.show(myLinkedList);

    }

}
