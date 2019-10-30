import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinMainTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Creating list of numbers
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            integers.add(random.nextInt((100 - 1) + 1) + 1);
        }

        // Using ForkJoinPool
        int sum = 0;
        int fromIndex = 0;
        int toIndex = 100000;
        for (int i = 0; i < 10; i++) {
            Integer subSum = new ForkJoinPool().invoke(
                    new SumCounterUsingForkJoin(integers.subList(fromIndex, toIndex)));
            fromIndex += 100000;
            toIndex += 100000;
            sum += subSum;
        }
        System.out.println(sum);
    }
}
