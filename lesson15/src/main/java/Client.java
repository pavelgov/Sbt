import message.Command;
import message.Message;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static message.Command.GET_MSG;
import static message.Command.LOG_IN;
import static message.Command.SEND_MSG;

/**
 * Created by User on 15.10.2017.
 */
public class Client {
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 1234;
    private static String LOGIN;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String serverHost = DEFAULT_HOST;
        int serverPort = DEFAULT_PORT;
        Scanner scanner = new Scanner(System.in);
        try {
            Socket client = new Socket(serverHost, serverPort);


            String line = null;


            // while (!(line = scanner.nextLine()).equals("EXIT")) {  //получаем сообщения от сервера

            while (true) {
                Message message = SocketUtils.getBySocket(client);
                if (message != null) {
                    System.out.println(message.getComand());
                    if (message.getComand() == LOG_IN) {  //просит залогиниться
                        System.out.println("Введите логин:");
                        line = scanner.nextLine();
                        SocketUtils.sendBySocket(login(line), client);
                    }
                    if (message.getComand() == SEND_MSG) { //просит прочитать сообщение
                        System.out.println("Получено сообщение:");
                        System.out.println(message.getLogin() + ">>" + message.getText()); //выводим сообщение
                    }
                }

                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();

                    if (line.startsWith("send")) {     //вводим сообщение на отправку текста участнику чата
                        SocketUtils.sendBySocket(sendMessage(line), client);
                        System.out.println("Отправили сообщение");
                    }
                    if (line.startsWith("get")) { //вводим сообщение на получение текста
                        SocketUtils.sendBySocket(getMessage(), client);
                        System.out.println("Отправили запрос на получение сообщения");
                    }
                }

            }






        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Message login(String login) { //создает объект сообщения с логином
        Message message = null;
        LOGIN = login;
        message = new Message(login, LOG_IN);   //создает сообщение с логином и командой LOG_IN
        return message;
    }

    private static Message sendMessage(String line) {//создаем объект сообщения на получение текста с сервера
        Message message = null;
        String[] splitLine = line.split(" "); //разбиваем на части через пробел

        if (splitLine.length == 3 && splitLine[0].equals("send") && LOGIN != null) {  //если строка разбилась на 3 части
            message = new Message(LOGIN, Command.SEND_MSG, splitLine[1], splitLine[2]); //создаем объект отправки
        }
        return message;
    }

    private static Message getMessage() {  //создаем объект сообщения на получение текста с сервера
        return new Message(LOGIN, GET_MSG);
    }

}


