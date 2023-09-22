package ksv.fe.core.models;

/**
 * S - соответствует
 * O - соответствует
 * L - соответствует
 * I - не интерфейс
 * D - расширяет абстракцию, создать через абстракцию возможно
 */
public class ComplexNumber extends AbstractComplexNumber {

    public ComplexNumber() {
        super();
    }

    public ComplexNumber(double realPart, double imaginaryPart) {
        super(realPart, imaginaryPart);
    }


    @Override
    public String toString() {
        return String.format("(%s + %si)", realPart, imaginaryPart);
    }
}
