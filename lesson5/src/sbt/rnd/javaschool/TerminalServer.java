package sbt.rnd.javaschool;


import sbt.rnd.javaschool.exceptions.ErrorConnectionException;

import java.util.HashMap;


public class TerminalServer {
    public static HashMap<Integer, Integer> clients = new HashMap<>();

    static {
        clients.put(0, 55000);
        clients.put(1, 5010);
        clients.put(2, 10325);
        clients.put(3, 30000);
    }

    public boolean cashToAccount(int id, int sum) throws ErrorConnectionException {
        if (!errorConnection()) { //если нет ошибки соединения
            clients.put(id, clients.get(id) + sum);//по ид кладем на счет деньги
            return true;
        } else return false;

    }

    public boolean cashFromAccount(int id, int sum) throws ErrorConnectionException {
        if (!errorConnection() && sum <= clients.get(id)) { //если нет ошибки соединения и денег на счету достаточно
            clients.put(id, clients.get(id) - sum);       //вычитаем со счета деньги, которые снимаем
            return true;
        } else return false;
    }


    public int getBalance(int id)  {
        return clients.get(id);
    }

    public boolean errorConnection() throws ErrorConnectionException  {
        int rand = (int) (Math.random() * 15);
        if (rand < 3) { //цифра регулирует коэффициент частоты ошибок
            throw new ErrorConnectionException();
        }
        else return false;


        //   }


    }

}
