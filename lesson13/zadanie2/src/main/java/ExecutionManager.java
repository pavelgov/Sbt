

/**
 * Created by User on 14.10.2017.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
