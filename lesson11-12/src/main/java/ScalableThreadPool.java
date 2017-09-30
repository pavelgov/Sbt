import java.util.ArrayDeque;
import java.util.Queue;

public class ScalableThreadPool implements ThreadPool {
    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private int minThreadCount;
    private int maxThreadCount;
    private volatile int currentThreads;

    public ScalableThreadPool(int minThreadCount, int maxThreadCount) {
        this.minThreadCount = minThreadCount;
        this.maxThreadCount = maxThreadCount;
    }

    @Override
    public void start() {
        for (int i = 0; i < minThreadCount; i++) {
            new Worker(tasks, minThreadCount, currentThreads).start();
        }
        currentThreads = minThreadCount;
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (tasks) {
            tasks.add(runnable);
            if (!tasks.isEmpty() && (currentThreads < maxThreadCount)) {
                new Worker(tasks, minThreadCount, currentThreads).start();
            }
            tasks.notifyAll();
        }
    }

}