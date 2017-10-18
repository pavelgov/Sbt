import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by User on 14.10.2017.
 */
public class ContextImpl implements Context {
    ThreadPoolExecutor threadPoolExecutor;

    public int getCompletedTaskCount() {
        return (int)threadPoolExecutor.getCompletedTaskCount();
    }

    public int getFailedTaskCount() {
        return 0;
    }

    public int getInterruptedTaskCount() {
        return 0;
    }

    public void interrupt() {

    }

    public boolean isFinished() {
        return false;
    }
}
