package ksv.fe.core.mvp.presenter;
/**
 * S - не класс
 * O - соответствует
 * L - соответствует
 * I - дальнейшее разделение не требуется
 * D - соответствует
 */

import ksv.fe.core.models.AbstractComplexNumber;

public interface CalcInterface {

    AbstractComplexNumber sum();

    AbstractComplexNumber subtract(boolean flag);

    AbstractComplexNumber multiply();

    AbstractComplexNumber divide(boolean flag) throws Exception;
}
