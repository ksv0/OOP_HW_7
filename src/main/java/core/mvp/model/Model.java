package ksv.fe.core.mvp.model;
/**
 * S - класс работает только с массивом комплексных чисел и не делает ничего более
 * O - соответствует
 * L - класс ничего не наследует
 * I - не интерфейс
 * D - завязан на абстрактном комплексном числе
 */

import ksv.fe.core.models.AbstractComplexNumber;
import ksv.fe.core.models.ComplexNumber;

public class Model implements ModelInterface {
    private AbstractComplexNumber[] currentNumbers;

    public Model() {
        currentNumbers = new ComplexNumber[2];
    }

    @Override
    public void setCurrentNumbers(AbstractComplexNumber first, AbstractComplexNumber second) {
        currentNumbers[0] = first;
        currentNumbers[1] = second;
    }

    @Override
    public void shuffleCurrentNumbers() {
        AbstractComplexNumber temp = currentNumbers[0];
        currentNumbers[0] = currentNumbers[1];
        currentNumbers[1] = temp;
    }

    @Override
    public AbstractComplexNumber getFirst() {
        return currentNumbers[0];
    }

    @Override
    public AbstractComplexNumber getSecond() {
        return currentNumbers[1];
    }




    public String toString(char c){
        return toString(c,false);
    }
    @Override
    public String toString(char c, boolean flag) {
        if (flag) {
            shuffleCurrentNumbers();
        }
        String temp = String.format(
                "(%s + %si) %s (%s + %si)",
                currentNumbers[0].getRealPart(),
                currentNumbers[0].getImaginaryPart(),
                c,
                currentNumbers[1].getRealPart(),
                currentNumbers[1].getImaginaryPart());
        if (flag) {
            shuffleCurrentNumbers();
        }
        return temp;
    }

    @Override
    public String toString() {
        return String.format(
                "Текущие числа (%s + %si) и (%s + %si)",
                currentNumbers[0].getRealPart(),
                currentNumbers[0].getImaginaryPart(),
                currentNumbers[1].getRealPart(),
                currentNumbers[1].getImaginaryPart());
    }

    public AbstractComplexNumber[] getCurrentNumbers() {
        return currentNumbers;
    }

    public void setCurrentNumbers(AbstractComplexNumber[] currentNumbers) {
        this.currentNumbers = currentNumbers;
    }
}
