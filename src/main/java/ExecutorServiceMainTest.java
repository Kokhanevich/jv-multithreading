import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMainTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Creating list of numbers
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            integers.add(random.nextInt((100 - 1) + 1) + 1);
        }

        // Creating and executing our threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int sum = 0;
        int fromIndex = 0;
        int toIndex = 100000;
        for (int i = 0; i < 10; i++) {
            Future<Integer> subSum = executorService.submit(
                    new ThreadGetSumUsingExecutor(integers.subList(fromIndex, toIndex)));
            fromIndex += 100000;
            toIndex += 100000;
            sum += subSum.get();
        }
        System.out.println(sum);
        executorService.shutdown();
    }
}
