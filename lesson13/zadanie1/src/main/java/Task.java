import java.util.concurrent.Callable;

/**
 * Created by User on 14.10.2017.
 */
public class Task<T> {
    Callable<? extends T> callable;
    volatile T result;
    volatile TaskException taskException;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (taskException != null)       //Если при просчете результата произошел Exception
            throw taskException;
        if (result != null)              //если работа уже была выполнена
            return result;

        synchronized (this) {            //синхронизируем чтобы потоки по очереди выполняли call
            try {
                result = callable.call();
            } catch (Exception e) {
                throw taskException = new TaskException(e); //выкидываем и одновременно присваиваем свой эксепш для следующих потоков
            }
        }
        return result;
    }
}
