package sbt.rnd.javaschool;

/**
 * Реализация интерфейса калькулятор
 */
public class CalculatorImp implements Calculator {

    @Override
    public Integer plus(int a, int b) {
        return a+b;
    }

    @Override
    public Integer minus(int a, int b) {
        return a-b;
    }

    @Override
    public Integer delit(int a, int b) {
        return a/b;
    }

    @Override
    public Integer umnojit(int a, int b) {
        return a*b;
    }

}
