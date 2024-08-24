package AboutJAVA.Thread;

public class Counter {

    private static int count = 0;

    public synchronized void increase() {
        count++;
    }

    public synchronized int show() {
        return count;
    }
}
