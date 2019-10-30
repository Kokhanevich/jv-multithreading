import java.util.List;
import java.util.concurrent.Callable;

public class ThreadGetSumUsingExecutor implements Callable<Integer> {
    private List<Integer> list;
    private Integer sum;

    public ThreadGetSumUsingExecutor(List<Integer> list) {
        this.list = list;
        sum = 0;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread with name " + Thread.currentThread().getName() + " started");
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
