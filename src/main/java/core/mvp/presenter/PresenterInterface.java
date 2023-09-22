package ksv.fe.core.mvp.presenter;
/**
 * S - не класс
 * O - соответствует
 * L - соответствует
 * I - дальнейшее разделение не требуется
 * D - соответствует
 */

import ksv.fe.core.models.AbstractComplexNumber;
import ksv.fe.core.mvp.model.ModelInterface;

public interface PresenterInterface extends CalcInterface {
    void newNumbers();

    AbstractComplexNumber createComplexNumber(String message);

    ModelInterface getModel();
}
