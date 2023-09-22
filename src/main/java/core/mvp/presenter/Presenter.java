package core.mvp.presenter;
/**
 * S - соответствует
 * O - соответствует
 * L - соответствует
 * I - не интерфейс
 * D - реализует интерфейс, создать через интерфейс возможно
 */

import core.models.AbstractComplexNumber;
import core.models.ComplexNumber;
import core.mvp.model.Model;
import core.mvp.model.ModelInterface;
import core.mvp.view.View;

import java.util.Scanner;

public class Presenter implements PresenterInterface {
    private ModelInterface model;
    private View view;
    private Scanner in;

    public Presenter(View view) {
        this.model = new Model(view);
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
