package sbt.rnd.javaschool;

public class Node<T> {

    private Node next;
    private Node previous;
    private T t;

    public Node() {
        this.next = null;
        this.previous = null;
    }

    public Node(T t) {
        this.t = t;
        this.next = null;
        this.previous = null;
    }


    public Node(Node previous, T t, Node next) {
        this.next = next;
        this.previous = previous;
        this.t = t;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
