package ksv.fe.ui;
/**
 * S - соответствует
 * O - соответствует
 * L - соответствует
 * I - не интерфейс
 * D - соответствует
 */

import ksv.fe.core.models.AbstractComplexNumber;
import ksv.fe.core.models.ComplexNumber;
import ksv.fe.core.models.Logger;
import ksv.fe.core.models.LoggerInterface;
import ksv.fe.core.mvp.presenter.Presenter;
import ksv.fe.core.mvp.presenter.PresenterInterface;
import ksv.fe.core.mvp.view.ConsoleView;
import ksv.fe.core.mvp.view.View;

import java.util.Scanner;

public class App extends AbstractApp {
    public void run() {
        boolean runnable = true;
        try (Scanner in = new Scanner(System.in)) {
            view = new ConsoleView(in);
            PresenterInterface presenter = new Presenter(view);
            LoggerInterface logger = new Logger(view);
            presenter.newNumbers();
            logger.appendLog(presenter.getModel().toString());
            while (runnable) {
                view.set(" ");
                view.set(presenter.getModel().toString());
                view.set("""
                                                
                        Что делаем?
                                                
                        1 - сложить числа                       5 - разделить первое число на второе
                        2 - вычесть первое число из второго     6 - разделить второе число на первое
                        3 - вычесть второе число из первого     7 - показать логи
                        4 - перемножить числа                   8 - ввести новые числа
                                                                0 - выход
                        """);
                int answer = view.getInt();
                for (int i = 0; i < 10; i++) {
                    view.set("\n\n\n\n\n\n\n\n\n\n");
                }
                switch (answer) {
                    case 1 -> {
                        AbstractComplexNumber res = presenter.sum();
                        view.set(String.format("Ответ: %s", res));
                        logger.appendLog(String.format("%s = %s ", presenter.getModel().toString('+'), res));
                    }
                    case 2 -> {
                        AbstractComplexNumber res = presenter.subtract(false);
                        view.set(String.format("Ответ: %s", res));
                        logger.appendLog(String.format("%s = %s ", presenter.getModel().toString('-'), res));
                    }
                    case 3 -> {
                        AbstractComplexNumber res = presenter.subtract(true);
                        view.set(String.format("Ответ: %s", res));
                        logger.appendLog(String.format("%s = %s ", presenter.getModel().toString('-', true), res));
                    }
                    case 4 -> {
                        AbstractComplexNumber res = presenter.multiply();
                        view.set(String.format("Ответ: %s", res));
                        logger.appendLog(String.format("%s = %s ", presenter.getModel().toString('*'), res));
                    }
                    case 5 -> {
                        try {
                            AbstractComplexNumber res = presenter.divide(false);
                            view.set(String.format("Ответ: %s", res));
                            logger.appendLog(String.format("%s = %s ", presenter.getModel().toString('/'), res));
                        } catch (Exception e) {
                            view.set(e.getMessage());
                            logger.appendLog("Попытались поделить на ноль, не получилось");
                        }
                    }
                    case 6 -> {
                        try {
                            AbstractComplexNumber res = presenter.divide(true);
                            view.set(String.format("Ответ: %s", res));
                            logger.appendLog(String.format("%s = %s ", presenter.getModel().toString('/', true), res));
                        } catch (Exception e) {
                            view.set(e.getMessage());
                            logger.appendLog("Попытались поделить на ноль, не получилось");
                        }
                    }
                    case 7 -> {
                        logger.showLog();
                        logger.appendLog("Запрошены логи");
                    }
                    case 8 -> {
                        presenter.newNumbers();
                        logger.appendLog(presenter.getModel().toString());
                    }
                    case 0 -> {
                        runnable = false;
                        logger.appendLog("Завершение работы программы");
                    }
                    default -> {
                        view.set("если бы мы назначили что то на эту цифру, то да исполнили бы, а так ничего не произойдет");
                        logger.appendLog("Введена некорректная команда");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void close() {
        view.set("До свидания");
    }
}