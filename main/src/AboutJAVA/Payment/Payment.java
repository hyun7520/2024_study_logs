package AboutJAVA.Payment;

public interface Payment {

    void payProcess(String account, double payment);

    void payDone();
}
