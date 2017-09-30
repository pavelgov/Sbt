import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by User on 28.09.2017.
 */
public class FixedThreadPool implements ThreadPool {
    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private final int threadCount;

    public FixedThreadPool(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public void start() {
        for (int i = 0; i < threadCount; i++) {
            new Worker().start();
            System.out.println("Стартуем поток номер "+i);


        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (tasks) {
            tasks.add(runnable);
            tasks.notifyAll();
        }
    }

    public class Worker extends Thread {
        @Override
        public void run() {

            Runnable r;

            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                            System.out.println("Ждем");
                        } catch (InterruptedException ignored) {}
                    }
                    r = tasks.poll();
                    System.out.println(Thread.currentThread().getName());
                }

                    r.run();

            }
        }


    }
}

