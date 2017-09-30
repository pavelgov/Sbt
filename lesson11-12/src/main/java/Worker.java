import java.util.Queue;

/**
 * Created by User on 30.09.2017.
 */
public class Worker extends Thread {
    Queue<Runnable> tasks;
    private int minThreadCount;
    private volatile int currentThreads;

    public Worker(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    public Worker(Queue<Runnable> tasks, int minThreadCount, int currentThreads) {
        this.tasks = tasks;
        this.minThreadCount = minThreadCount;
        this.currentThreads = currentThreads;
    }

    @Override
    public void run() {

        Runnable r;

        while (true) {
            synchronized (tasks) {
                while (tasks.isEmpty()) {
                    try {
                        tasks.wait();
                        if (currentThreads > minThreadCount) {
                            currentThreads--;
                            return;
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
                r = tasks.poll();
            }

            r.run();

        }
    }
}



