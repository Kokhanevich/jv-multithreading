public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        System.out.println("Hello from main thread " + Thread.currentThread().getName());

        ThreadExtends threadExtends = new ThreadExtends(counter);
        threadExtends.setName("ExtendsThread");
        threadExtends.start();

        ThreadImplements threadImplements = new ThreadImplements(counter);
        Thread thread = new Thread(threadImplements);
        thread.setName("ImplementsThread");
        thread.start();

    }
}
