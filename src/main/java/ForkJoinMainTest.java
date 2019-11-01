import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinMainTest {
    private static final int POOL_SIZE = 10;
    private static final int RANGE = 10_000;
    private static final int NUMBER_ELEMENTS = 1_000_000;

    public static void main(String[] args) {
        // Creating list of numbers
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < NUMBER_ELEMENTS; i++) {
            integers.add(random.nextInt((100 - 1) + 1) + 1);
        }

        // Using ForkJoinPool
        int sum = 0;
        int fromIndex = 0;
        int toIndex = RANGE;
        for (int i = 0; i < POOL_SIZE; i++) {
            Integer subSum = new ForkJoinPool().invoke(
                    new SumCounterUsingForkJoin(integers.subList(fromIndex, toIndex)));
            fromIndex += RANGE;
            toIndex += RANGE;
            sum += subSum;
        }
        System.out.println(sum);
    }
}
