import message.Command;
import message.Message;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by User on 15.10.2017.
 */
public class Server {
 private static final int COUNT_CLIENTS = 10;
    volatile static HashMap<String, Message> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket;

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_CLIENTS);

        while (true) {
            try {
                socket = serverSocket.accept(); //при подключении нового клиента
                executorService.execute(new ThreadServer(socket));
            } catch (IOException e) {
                System.err.println("Ошибка тредпула");
            }
            // Создаем для каждого клиента обработчик в отдельном потоке
        }

    }


}

