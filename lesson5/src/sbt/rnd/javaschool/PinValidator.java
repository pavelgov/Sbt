package sbt.rnd.javaschool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Проверяет введенные данные и кидает эксепшн
 * если ввели не корректные цифры
 */
public class PinValidator {
    private  static HashMap<Integer, Integer> pins = new HashMap<>();

    static {
        pins.put(0, 1234);
        pins.put(1, 2500);
        pins.put(2, 6566);
        pins.put(3, 2377);

    }

    public int checkPin(int pin) {
        for (Map.Entry<Integer, Integer> entry : pins.entrySet()) {
            if (pin == entry.getValue())  //ищем пин в базе клиентов
                return entry.getKey();   // если найден возвращаем id
        }
        return -1;                       //если нет, то -1
    }
}
