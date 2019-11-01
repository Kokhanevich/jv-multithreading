import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumCounterUsingForkJoin extends RecursiveTask<Integer> {
    private List<Integer> list;
    private Integer sum;

    public SumCounterUsingForkJoin(List<Integer> list) {
        this.list = list;
        this.sum = 0;
    }

    @Override
    protected Integer compute() {
        System.out.println("Thread with name " + Thread.currentThread().getName() + " started");
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
