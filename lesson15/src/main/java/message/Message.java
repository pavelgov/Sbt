package message;

import java.io.Serializable;

/**
 * Created by User on 15.10.2017.
 */
public class Message implements Serializable {
    private String login;
    private Command comand;
    private String receiver;
    private String text;

    public Message() {

    }

    public Message(String login, Command comand) {
        this.login = login;
        this.comand = comand;
    }

    public Message(Command comand) {
        this.comand = comand;
    }

    public Message(String login, Command comand, String receiver, String text) {
        this.login = login;
        this.comand = comand;
        this.receiver = receiver;
        this.text = text;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Command getComand() {
        return comand;
    }

    public void setComand(Command comand) {
        this.comand = comand;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
