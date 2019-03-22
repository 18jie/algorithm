package synclearn.caslearn;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fengjie
 * @date 2019:03:14
 */
public class TestBean {

    private AtomicInteger i;

    private AtomicInteger j;

    public TestBean() {
        i = new AtomicInteger();
        j = new AtomicInteger();
    }

    public int getI() {
        return i.get();
    }

    public int getJ() {
        return j.get();
    }

    public void increaseI() {
        i.getAndIncrement();
    }

    public void increateJ() {
        j.getAndIncrement();
    }
}
