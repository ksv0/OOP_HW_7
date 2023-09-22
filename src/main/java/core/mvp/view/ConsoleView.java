package core.mvp.view;
/**
 * S - соответствует
 * O - соответствует
 * L - соответствует
 * I - не интерфейс
 * D - реализует интерфейс, создать через интерфейс возможно
 */

import java.util.Scanner;

public class ConsoleView implements View {
    public Scanner in;

    public ConsoleView(Scanner in) {
        this.in = in;
    }

    public int getInt() {
        String temp = get();
        try {
            return Integer.parseInt(temp);
        } catch (Exception e) {
            System.out.println("не целое число, давай заново");
            return getInt();
        }
    }

    @Override
    public String get() {
        return in.nextLine();
    }

    @Override
    public Double getDouble() {
        String temp = get();
        try {
            return Double.parseDouble(temp);
        } catch (Exception e) {
            System.out.println("не число, давай заново");
            return getDouble();
        }
    }

    @Override
    public void set(String value) {
        System.out.println(value);
    }


    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }
}

