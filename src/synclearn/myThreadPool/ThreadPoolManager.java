package synclearn.myThreadPool;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fengjie
 * @date 2019:03:11
 */
public class ThreadPoolManager implements ThreadPool {

    private static Integer workNum = 5;

    WorkThread[] workThreads;

    private static volatile Integer executeTaskNumber = 0;

    private Queue<Runnable> taskQueue = new ConcurrentLinkedDeque<>();

    private static volatile ThreadPoolManager threadPool;

    private AtomicLong threadNum = new AtomicLong();

    private ThreadPoolManager() {

    }

    private ThreadPoolManager(int workerNum) {
        if (workNum > 0) {
            ThreadPoolManager.workNum = workerNum;
        }

        workThreads = new WorkThread[ThreadPoolManager.workNum];

        for (int i = 0; i < ThreadPoolManager.workNum; i++) {
            workThreads[i] = new WorkThread();
            Thread thread = new Thread(workThreads[i], "ThreadPool-worker-" + threadNum.incrementAndGet());
            thread.start();
            System.out.println("初始化线程总数量：" + (i + 1) + ",当前线程名称是：ThreadPool-worker-" + threadNum);
        }
    }

    public static ThreadPool getThreadPool(int workNum) {
        if (workNum > 0) {
            ThreadPoolManager.workNum = workNum;
        }

        if (threadPool == null) {
            synchronized (ThreadPoolManager.class) {
                if (threadPool == null) {
                    threadPool = new ThreadPoolManager(ThreadPoolManager.workNum);
                }
            }
        }
        return threadPool;
    }


    @Override
    public void execute(Runnable task) {
        synchronized (taskQueue){
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    @Override
    public void execute(Runnable[] tasks) {

    }

    @Override
    public void execute(List<Runnable> tasks) {

    }

    @Override
    public int getExecuteTaskNumber() {
        return 0;
    }

    @Override
    public int getWaitTaskNumber() {
        return 0;
    }

    @Override
    public int getWorkThreadNumber() {
        return 0;
    }

    @Override
    public void destroy() {

    }

    private class WorkThread implements Runnable {
        //线程是否可用
        private boolean isRunning = true;

        @Override
        public void run() {
            Runnable r = null;
            while (isRunning) {
                synchronized (taskQueue) {
                    while (isRunning && taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!taskQueue.isEmpty()) {
                        r = taskQueue.poll();
                    }
                }

                if (r != null) {
                    r.run();
                }
                synchronized (executeTaskNumber) {
                    executeTaskNumber++;
                }
                r = null;
            }
        }

        public void shutdown() {
            isRunning = false;
        }

    }
}
