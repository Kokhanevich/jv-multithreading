public class ThreadImplements implements Runnable {
    private Counter counter;

    public ThreadImplements(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            counter.incrementCount();
            System.out.println(Thread.currentThread().getName() + " - " + counter.getCount());
        }
    }
}
