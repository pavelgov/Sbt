import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by User on 28.09.2017.
 */
public class FixedThreadPool implements ThreadPool {
    private Queue<Runnable> tasks = new ArrayDeque<>();
    private int threadCount;

    public FixedThreadPool(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public void start() {
        for (int i = 0; i < threadCount; i++) {
            new Worker(tasks).start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (tasks) {
            tasks.add(runnable);
            tasks.notifyAll();
        }
    }

}

