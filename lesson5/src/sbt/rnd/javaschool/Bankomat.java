package sbt.rnd.javaschool;

import sbt.rnd.javaschool.exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 03.09.2017.
 */
/*
public class Bankomat implements Terminal {
    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private int pin;
    private int id = -1;
    private int pinCount = 0;
    private boolean isEntered;


    public Bankomat() {


        while (true) {
            //  if (pinCount > 3) throw new Exception(); //Более 3х пин - кодов


            //проверяем вошли в систему или еще нет
            //ввели верный пин
                try {
                    checkPin();
                    String itemMenu = reader.readLine();
                    if (itemMenu.equals("1")) balance();
                    else if (itemMenu.equals("2")) setCash();
                    else if (itemMenu.equals("3")) getCash();
                    else if (itemMenu.equals("exit")) {
                        System.out.println("Работа завершена.");
                        id = -1;
                        break;
                    } else throw new WrongItemMenuException();
                } catch (WrongItemMenuException e) {

                } catch (NotDivideHundred e) {

                } catch (ErrorConnectionException e) {
                    System.err.println("Ошибка сети. Попробуйте еще раз");
                } catch (NotEnoughtMoney e) {
                    System.err.println("Не достаточно денег");

                } catch (IOException e) {}




        }



    public boolean checkPin() throws IOException, WrongItemMenuException {
        System.out.println("Введите pin - код");

        pin = Integer.parseInt(reader.readLine());

        pinCount++;
        id = (pinValidator.checkPin(pin));
        if (id == -1) {
            System.out.println("Аккаунт заблокирован.");
            throw new WrongItemMenuException();                //кидаем эксепшн

        } else {
            System.out.println("Выберите операцию");
            System.out.println("1 - Узнать баланс");
            System.out.println("2 - Пополнить баланс");
            System.out.println("3 - Снять наличными");
            System.out.println("exit - Завершить работу");
            pinCount = 0;
            isEntered = true;
            return true;
        }
    }
}
*/
