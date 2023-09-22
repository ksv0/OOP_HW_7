package ksv.fe.core.mvp.model;
/**
 * S - не класс
 * O - не класс
 * L - не класс
 * I - разделение не требуется
 * D - завязан на абстрактном комплексном числе
 */
import ksv.fe.core.models.AbstractComplexNumber;
import ksv.fe.core.models.ComplexNumber;

/**
 *
 */
public interface ModelInterface {

    void setCurrentNumbers(AbstractComplexNumber first, AbstractComplexNumber second);
    void shuffleCurrentNumbers();

    AbstractComplexNumber getFirst();

    AbstractComplexNumber getSecond();

    String toString(char c,boolean flag);

    String toString(char c);
}
