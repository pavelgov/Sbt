package sbt.rnd.javaschool;

public class Main {

    public static void main(String[] args) {
        Calculator c =  new CalculatorImp();
        c = CachedProxy.create(Calculator.class, c);

        System.out.println(c.minus(33,44));
        System.out.println(c.minus(33,44));//берем из кеша

        System.out.println(c.plus(3,4));
        System.out.println(c.plus(3,4));//берем из кеша

        System.out.println(c.delit(15,3));
        System.out.println(c.umnojit(5,3));
        System.out.println(c.delit(15,3));  //берем из кеша
        System.out.println(c.umnojit(5,3));//берем из кеша


    }
}
