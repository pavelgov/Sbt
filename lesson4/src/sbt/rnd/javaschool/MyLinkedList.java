package sbt.rnd.javaschool;

import java.util.Collection;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> previous;
    private Node<T> next;
    private int size = 0;
    private Node<T> first;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T t) {

        if (first == null) {
            firstAdd(t);
        } else {
            Node<T> node = new Node<T>(t);
            node.setPrevious(previous); //ставим ссылку на пред эл-т в текущем эл
            next = node;
            previous.setNext(next); //ставим ссылку next в предыдущем эл-те на текущий
            previous = node;        //ссылка для будущего элемента поля prev
        }
        size++;

        return true;
    }

    private boolean firstAdd(T t) {
        Node<T> node = new Node<T>(t);
        first = node;
        previous = node;
        return true;
    }

    private Node<T> getByIndex(int index) {
        Node<T> node = null;
        if (!isEmpty() && (index >= 0 && index < size)) {
            node = first;
            for (int i = 1; i <= index; i++) {
                node = node.getNext();
            }
        }
        return node;
    }

    public T get(int index) {
        T element;
        if (index < size()) {
            element = getByIndex(index).getT();
        } else throw new IndexOutOfBoundsException();
        return element;
    }

    private void removeLinks(Node node) {
        if (node.getPrevious() != null)              //если не первый элемент
            node.getPrevious().setNext(node.getNext());//берем ссылку next у предыдущего эл. и заменяем на следующий эл
        else {                                     // если первый то
            first = node.getNext();               //первым становится след.элемент
            first.setPrevious(null);               // ссылку у первого эл. на пред делаем null
        }

        if (node.getNext() != null)                            //если не последний элемент
            node.getNext().setPrevious(node.getPrevious()); // у следующего заменяем ссылку prev на предыдущий эл
        else node.setNext(null);                            // если последний то next делаем null

        size--;
    }

    public boolean remove(Object o) {
        if (size() >= 0) {
            Node<T> node = first;

            for (int i = 0; i < size(); i++) {
                if (node.getT().equals(o)) { // если найден элемент который нужно удалить
                    removeLinks(node);
                    return true;
                }
                node = node.getNext();
            }
            return true;
        }
        return false;
    }

    public boolean add(int index, T element) {
        Node<T> eNode = new Node<T>(element);
        if (index >= 0 && index < size()) {

            Node<T> node = first;
            for (int i = 0; i < size(); i++) {
                if (index == 0) {                     //если первый элемент
                    eNode.setNext(node);              //ссылку у текущего на следующий
                    node.setPrevious(eNode);          //у следующего на текущий
                    first = eNode;
                    size++;
                    return true;
                } else {
                    if (index == i) {
                        if (index == size()) {       //если последний элемент
                            node.setNext(eNode);     //ссылку предыдущего на вставляемый элемент
                            eNode.setPrevious(node); //ссылку в текущем на предыдущий элемент

                        } else {
                            node.getPrevious().setNext(eNode);     //ссылку предыдущего на вставляемый элемент
                            eNode.setPrevious(node.getPrevious()); //ссылку в текущем на предыдущий элемент
                            eNode.setNext(node);                   //ссылку у текущего на след.элемент
                            node.setPrevious(eNode);               // ссылку в следующем на текущий элемент
                        }
                        size++;
                        return true;
                    }
                }
                node = node.getNext();
            }
        }
        return false;
    }

    public boolean remove(int index) {
        if (index >= 0 && index < size()) {

            Node<T> node = first;
            for (int i = 0; i < size(); i++) {
                if (index == i) {
                    removeLinks(node);
                    //   size--;
                    return true;
                }
                node = node.getNext();
            }
            return true;
        }
        return false;
    }

    public boolean addAll(Collection<? extends T> from) {
        T[] masiv = (T[]) from.toArray();

        for (int i = 0; i < masiv.length; i++) {
            add(masiv[i]);
        }
        return true;
    }

    public boolean copy(Collection<? extends T> src) {
        T[] masiv = (T[]) src.toArray();
        Node<T> node = first;

        if (src.size() > size()) return false; //проверяем чтобы то куда мы будем записывать не был меньше источника
        else {
            for (int i = 0; i < masiv.length; i++) {
                node.setT(masiv[i]);
                node = node.getNext();
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr<T> implements Iterator {
        private int cursor = 0;  // индекс возвращаемого элемента итератора

        @Override
        public Object next() {
            if (cursor >= size)
                throw new NoSuchElementException();

            return get(cursor++);
        }


        public boolean hasNext() {
            if (cursor < size()) return true;
            else return false;
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove(cursor - 1);
        }
    }

    public void show(MyLinkedList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
