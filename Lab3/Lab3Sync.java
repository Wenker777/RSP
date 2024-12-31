package Lab3;

public class Lab3Sync {
    public static final int ITERATIONS = 100000;
    private static int counter = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        int n = 5;
        int m = 5;

        long startTime = System.currentTimeMillis();

        Thread[] incrementThreads = new Thread[n];
        Thread[] decrementThreads = new Thread[m];

        for (int i = 0; i < n; i++) {
            incrementThreads[i] = new Thread(new IncrementTask());
            incrementThreads[i].start();
        }

        for (int i = 0; i < m; i++) {
            decrementThreads[i] = new Thread(new DecrementTask());
            decrementThreads[i].start();
        }

        try {
            for (int i = 0; i < n; i++) {
                incrementThreads[i].join();
            }
            for (int i = 0; i < m; i++) {
                decrementThreads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Значение счётчика: " + counter);
        System.out.println("Время выполнения: " + executionTime + " ms");
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                synchronized (lock) {
                    int localCounter = counter;
                    localCounter++;
                    counter = localCounter;
                }
            }
        }
    }

    static class DecrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                synchronized (lock) {
                    int localCounter = counter;
                    localCounter--;
                    counter = localCounter;
                }
            }
        }
    }
}
