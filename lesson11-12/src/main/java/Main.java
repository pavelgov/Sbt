/**
 * Created by User on 28.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        ThreadPool pool = new ScalableThreadPool(2,3);
        //   ThreadPool pool = new FixedThreadPool(4);

        pool.execute(() -> {
            int a = 11;
            int b = 9;
            System.out.println(a * b);
        });

        pool.execute(() -> System.out.println(2));
        pool.execute(() -> System.out.println(3));
        pool.execute(() -> System.out.println(4));
        pool.execute(() -> System.out.println(5));
        pool.execute(() -> System.out.println(6));
        pool.execute(() -> System.out.println(7));
        pool.execute(() -> System.out.println(8));
        pool.execute(() -> System.out.println(9));

        pool.start();
    }
}
