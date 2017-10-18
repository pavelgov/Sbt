import message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by User on 16.10.2017.
 */
public class SocketUtils {

    public static boolean sendBySocket(Message message, Socket socket) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(message);
            out.flush();



        } catch (IOException e) {
            System.err.println("Ошибка отправки объекта сообщения");
            return false;
        }
        return true;
    }
    public static Message getBySocket(Socket socket) {
        Message message = null;
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            message = (Message) in.readObject();

        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }

        return message;
    }
}
