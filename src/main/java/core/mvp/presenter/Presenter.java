package ksv.fe.core.mvp.presenter;
/**
 * S - соответствует со скрипом, newNumbers() и createComplexNumber(String message) можно переместить в модель
 * O - соответствует
 * L - соответствует
 * I - не интерфейс
 * D - реализует интерфейс, создать через интерфейс возможно
 */

import ksv.fe.core.models.AbstractComplexNumber;
import ksv.fe.core.models.ComplexNumber;
import ksv.fe.core.mvp.model.Model;
import ksv.fe.core.mvp.model.ModelInterface;
import ksv.fe.core.mvp.view.View;

import java.util.Scanner;

public class Presenter implements PresenterInterface {
    private ModelInterface model;
    private View view;
    private Scanner in;

    public Presenter(View view) {
        this.model = new Model();
        this.view = view;
    }

    @Override
    public AbstractComplexNumber sum() {
        AbstractComplexNumber res = new ComplexNumber(0.0, 0.0);
        res.setRealPart(model.getFirst().getRealPart() + model.getSecond().getRealPart());
        res.setImaginaryPart(model.getFirst().getImaginaryPart() + model.getSecond().getImaginaryPart());
        return res;
    }

    @Override
    public AbstractComplexNumber subtract(boolean flag) {
        if (flag) {
            model.shuffleCurrentNumbers();
        }
        AbstractComplexNumber res = new ComplexNumber(0.0, 0.0);
        res.setRealPart(model.getFirst().getRealPart() - model.getSecond().getRealPart());
        res.setImaginaryPart(model.getFirst().getImaginaryPart() - model.getSecond().getImaginaryPart());
        if (flag) {
            model.shuffleCurrentNumbers();
        }
        return res;
    }

    @Override
    public AbstractComplexNumber multiply() {
        AbstractComplexNumber res = new ComplexNumber(0.0, 0.0);
        res.setRealPart((model.getFirst().getRealPart() * model.getSecond().getRealPart()) -
                (model.getFirst().getImaginaryPart() * model.getSecond().getImaginaryPart()));
        res.setImaginaryPart((model.getFirst().getImaginaryPart() * model.getSecond().getRealPart()) +
                (model.getFirst().getRealPart() * model.getSecond().getImaginaryPart()));
        return res;
    }

    @Override
    public AbstractComplexNumber divide(boolean flag) throws Exception {
        if (flag) {
            model.shuffleCurrentNumbers();
        }
        if (model.getSecond().getRealPart() == 0 || model.getSecond().getImaginaryPart() == 0) {
            throw new Exception("На ноль делить, себя не уважать");
        }
        AbstractComplexNumber res = new ComplexNumber(0.0, 0.0);
        res.setRealPart(((model.getFirst().getRealPart() * model.getSecond().getRealPart()) +
                (model.getFirst().getImaginaryPart() * model.getSecond().getImaginaryPart())) /
                ((model.getSecond().getRealPart() * model.getSecond().getRealPart()) +
                        (model.getSecond().getImaginaryPart() * model.getSecond().getImaginaryPart())));
        res.setImaginaryPart((((model.getFirst().getImaginaryPart() * model.getSecond().getRealPart()) -
                (model.getFirst().getRealPart() * model.getSecond().getImaginaryPart())) /
                ((model.getSecond().getRealPart() * model.getSecond().getRealPart()) +
                        (model.getSecond().getImaginaryPart() * model.getSecond().getImaginaryPart()))));
        if (flag) {
            model.shuffleCurrentNumbers();
        }
        return res;
    }

    @Override
    public void newNumbers() {
        model.setCurrentNumbers(createComplexNumber("первого"), createComplexNumber("второго"));
    }

    @Override
    public AbstractComplexNumber createComplexNumber(String message) {
        Double real, imaginary;
        System.out.printf("Введите действительную часть %s числа: ", message);
        real = view.getDouble();
        System.out.printf("Введите мнимую часть %s числа: ", message);
        imaginary = view.getDouble();
        return new ComplexNumber(real, imaginary);
    }

    public ModelInterface getModel() {
        return model;
    }

    public void setModel(ModelInterface model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }
}
