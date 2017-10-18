import message.Command;
import message.Message;

import java.net.Socket;

import static message.Command.GET_MSG;
import static message.Command.LOG_IN;
import static message.Command.SEND_MSG;

/**
 * Created by User on 18.10.2017.
 */
public class ThreadServer implements Runnable {
    Socket socket;
    private String login = null;

    public ThreadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Получили подключение");
            System.out.println(socket.getRemoteSocketAddress().toString());

            if (login == null) {  //отправляем запрос на авторизацию
                SocketUtils.sendBySocket(new Message(Command.LOG_IN), socket);
                System.out.println("отправили запрос на авторизацию");
            }

            while (socket.isConnected()) {  //получаем сообщения от клиента
                Message message = SocketUtils.getBySocket(socket);
                if (message != null) {
                    System.out.println("Получен message");
                    if (message.getComand() == LOG_IN) {         //получили сообщение от пользователя с логином
                        Server.map.put(message.getLogin(), new Message());  //записали нового пользователя в мапу участников чата
                        System.out.println("Пользователь " + message.getLogin() + " авторизован");
                        //!!!!!нужно отправить сообщение о том что зарегестрирован
                    }

                    if (message.getComand() == GET_MSG) {            //клиент просит отправить получ. сообщение
                        System.out.println("Пользователь "+ message.getLogin()+ "сделал запрос на получение писем");
                        System.out.println((Server.map.get(message.getLogin())).getLogin() + ">>" + (Server.map.get(message.getLogin()).getText()));

                        SocketUtils.sendBySocket(Server.map.get(message.getLogin()),socket); //отправляем текст запросившему сообщение
                        System.out.println("Запрос отправлен");
                    }
                    if (message.getComand() == SEND_MSG) {            //просит отправить сообщение другому пользователю
                        System.out.println("Пользователь "+ message.getLogin()+" отправил сообщение "+message.getReceiver()+"записано в базу");
                        Server.map.put(message.getReceiver(), message); //!!! будет перезаписывать
                    }

                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка потока");
        }
    }
}
