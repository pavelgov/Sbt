/**
 * Created by User on 14.10.2017.
 */
public class Main {
    public static void main(String[] args) {
        Runnable[] tasks = new Runnable[]{
                new Runnable() {
                    public void run() {
                        System.out.println("task1");
                    }
                },
                new Runnable() {
                    public void run() {
                        System.out.println("task2");
                    }
                },
                new Runnable() {
                    public void run() {
                        System.out.println("task3");
                    }
                },
                new Runnable() {
                    public void run() {
                        System.out.println("task4");
                    }
                }
        };

        Runnable callback = () -> System.err.println("\nCallback run now!\n");

        ExecutionManagerImpl executionManager = new ExecutionManagerImpl();
        executionManager.execute(callback,tasks);

    }
}
