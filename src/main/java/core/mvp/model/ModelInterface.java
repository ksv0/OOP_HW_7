package core.mvp.model;
/**
 * S - не класс
 * O - не класс
 * L - не класс
 * I - разделение не требуется
 * D - завязан на абстрактном комплексном числе
 */
import core.models.AbstractComplexNumber;


public interface ModelInterface {

    void setCurrentNumbers(AbstractComplexNumber first, AbstractComplexNumber second);
    void shuffleCurrentNumbers();

    AbstractComplexNumber getFirst();

    AbstractComplexNumber getSecond();
    void setCurrentNumbers();

    AbstractComplexNumber createComplexNumber(String message);

    String toString(char c,boolean flag);

    String toString(char c);
}
