package sbt.rnd.javaschool;

import sbt.rnd.javaschool.exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by User on 06.09.2017.
 */
public class ATM implements Terminal {
    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private int pin;
    private int id = -1;
    private static int pinCount = 0;
    private boolean isEntered;
    static long lastTimeOfLock = 0;

    public ATM() {

        while (true) {
            try {

                if (checkPin()) {                                  //если ввели верный пин
                    showMenu();                                   //показываем меню
                    String itemMenu = reader.readLine();          //смотрим что выбрал

                    if (itemMenu.equals("1")) balance();
                    else if (itemMenu.equals("2")) setCash();
                    else if (itemMenu.equals("3")) getCash();
                    else if (itemMenu.equals("exit")) {
                        System.out.println("Работа завершена.");
                        break;
                    } else throw new WrongItemMenuException();
                }
            } catch (AccountIsLockedException e) {
                System.err.println("Банкомат заблокирован, осталось " + e.getMessage() + " сек.");
            } catch (ErrorConnectionException e) {
                System.err.println("Ошибка сети, попробуйте еще раз");
            } catch (WrongItemMenuException e) {
                System.err.println("Неверный пункт меню");
            } catch (NotDivideHundred notDivideHundred) {
                System.err.println("Сумма должны быть кратной 100");
            } catch (IOException e) {
                System.err.println("Ошибка ввода");
            }
        }

    }

    @Override
    public void balance() {
        System.out.println("Ваш баланс " + server.getBalance(id) + " руб");
    }

    @Override
    public void getCash() throws IOException, ErrorConnectionException, NotDivideHundred {
        System.out.println("Введите сумму");
        int suma = Integer.parseInt(reader.readLine());  //сумма денег
        divideHundred(suma);
        if (server.cashFromAccount(id, suma))  //снять деньги ...
            System.out.println("Деньги сняты.");

    }

    @Override
    public void setCash() throws ErrorConnectionException, IOException, NotDivideHundred {
        System.out.println("Введите сумму");
        int suma = Integer.parseInt(reader.readLine());  //сумма денег
        divideHundred(suma);
        if (server.cashToAccount(id, suma))  //если деньги сняли то ...
            System.out.println("Баланс пополнен");
    }

    public void divideHundred(int sum) throws NotDivideHundred {
        if (sum % 100 == 0) return;
        else throw new NotDivideHundred();
    }

    public boolean checkPin() throws IOException, AccountIsLockedException {
        if (!isEntered) {
            System.out.println("Введите pin - код");
            pin = Integer.parseInt(reader.readLine());
            id = (pinValidator.checkPin(pin)); //проверяем на сервере


            if (id == -1) { //введен не верный пин
                pinCount++;

                if (pinCount >= 3)                         //кидаем экспшен и
                    checklock(new Date().getTime());//проверяем не прошло ли 5 сек
                else System.out.println("Введен не верный пин");

                return false;
            } else {
                isEntered = true;
                return true;
            }
        }
        return true;

    }

    public static void checklock(long currentTime) throws AccountIsLockedException {

        if (lastTimeOfLock == 0) {
            lastTimeOfLock = new Date().getTime();
            throw new AccountIsLockedException(5);
        } else {
            long result = (new Date().getTime() - lastTimeOfLock) / 1000;
            if (result < 15) {                                         //если меньше 5 сек
                lastTimeOfLock = new Date().getTime();
                throw new AccountIsLockedException(15 - result);
            } else {                                                  //если больше 5 сек
                pinCount = 0;
                lastTimeOfLock = 0;
            }
        }

    }


    public void showMenu() {
        System.out.println("Выберите операцию:");
        System.out.println("1 - Узнать баланс");
        System.out.println("2 - Пополнить баланс");
        System.out.println("3 - Снять наличными");
        System.out.println("exit - Завершить работу");
        System.out.println();
    }
}
