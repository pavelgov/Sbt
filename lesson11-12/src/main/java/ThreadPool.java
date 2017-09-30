/**
 * Created by User on 28.09.2017.
 */
public interface ThreadPool {

    void start();

    void execute(Runnable runnable);
}
