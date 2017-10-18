/**
 * Created by User on 14.10.2017.
 */
public class TaskException extends RuntimeException  {
    public TaskException() {
    }

    public TaskException(String message) {
        super(message);
    }

    public TaskException(Throwable cause) {
        super(cause);
    }
}
