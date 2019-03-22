package synclearn.caslearn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;

/**
 * @author fengjie
 * @date 2019:03:14
 */
public class Test {

    public static void main(String[] args) {
        TestBean bean = new TestBean();
        AtomicReference<TestBean> bean1 = new AtomicReference<>(bean);

        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
//                    bean1.getAndUpdate(testBean -> {
//                        testBean.setI(testBean.getI() + 1);
//                        testBean.setJ(testBean.getJ() + 1);
//                        return testBean;
//                    });
                    bean1.get().increaseI();
                    bean1.get().increateJ();
                }
            });
            ts.add(t);
        }

        for (Thread t : ts) {
            t.start();
        }

        while (Thread.activeCount() > 2) {
//            System.out.println(Thread.activeCount() + " threadCount");
        }

        System.out.println("i : " + bean1.get().getI() + ", j : " + bean1.get().getJ());

    }

}
