package core.models;

/**
 * S - соответствует
 * O - соответствует
 * L - соответствует
 * I - не интерфейс
 * D - класс абстрактный
 */
public abstract class AbstractComplexNumber {
    protected double realPart;

    protected double imaginaryPart;


    public AbstractComplexNumber() {
        realPart = 0;
        imaginaryPart = 0;
    }

    public AbstractComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public abstract String toString();
}
