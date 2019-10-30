public class ThreadExtends extends Thread {
    private Counter counter;

    public ThreadExtends(Counter counter) {
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
