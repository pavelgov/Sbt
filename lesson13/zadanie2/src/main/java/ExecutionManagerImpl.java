import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by User on 14.10.2017.
 */
public class ExecutionManagerImpl implements ExecutionManager {
    Context context;
    public Context execute(Runnable callback, Runnable... tasks) {
        ExecutorService threadPool =  Executors.newFixedThreadPool(10);

        for (Runnable task : tasks) {
            threadPool.execute(task);
        }
        
        threadPool.execute(callback);
        return context;
    }
}
