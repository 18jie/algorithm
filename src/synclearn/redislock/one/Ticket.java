package synclearn.redislock.one;

import java.util.concurrent.CountDownLatch;

/**
 * @author fengjie
 * @date 2019:03:21
 */
public class Ticket {
    private static CountDownLatch latch = new CountDownLatch(1);
    private int ticktes = 98;

    public synchronized void reduce() {
        if ((ticktes - 1) >= 0) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticktes -= 1;
            System.out.println(Thread.currentThread().getName() + "成功:卖出" + 1 + "张，库存剩余:" + ticktes + "张");
        } else {
            System.out.println(Thread.currentThread().getName() + "失败:库存不足" + 1 + "张，库存剩余：" + ticktes + "张");
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 100; i++) {
            new Thread(ticket::reduce).start();
        }
        latch.countDown();
    }

}
