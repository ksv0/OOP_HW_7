package ui;
/**
 * S - соответствует
 * O - соответствует
 * L - соответствует
 * I - не интерфейс
 * D - класс абстрактный
 */
import core.mvp.view.View;

public abstract class AbstractApp {
    protected View view;
    public abstract void run();
    public abstract void close();
}
