package core.mvp.presenter;
/**
 * S - не класс
 * O - соответствует
 * L - соответствует
 * I - дальнейшее разделение не требуется, да и не возможно
 * D - соответствует
 */

import core.models.AbstractComplexNumber;
import core.mvp.model.ModelInterface;

public interface PresenterInterface extends CalcInterface {
    ModelInterface getModel();
}
