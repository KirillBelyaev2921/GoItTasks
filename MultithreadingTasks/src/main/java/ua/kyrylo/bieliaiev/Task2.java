package ua.kyrylo.bieliaiev;

import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class Task2 {

  private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
  private final CyclicBarrier barrier = new CyclicBarrier(4);

  public void multithreadingFizzBuzz(int n) {
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(
        new FizzBuzzRunner(n, i -> i % 3 != 0 && i % 5 != 0, i -> "" + i, queue, barrier));
    exec.execute(
        new FizzBuzzRunner(n, i -> i % 3 == 0 && i % 5 != 0, i -> "fizz", queue, barrier));
    exec.execute(
        new FizzBuzzRunner(n, i -> i % 3 != 0 && i % 5 == 0, i -> "buzz", queue, barrier));
    exec.execute(
        new FizzBuzzRunner(n, i -> i % 3 == 0 && i % 5 == 0, i -> "fizzbuzz", queue, barrier));
    exec.execute(() -> {
      int i = 0;
      while (i < n) {
        if (!queue.isEmpty()) {
          System.out.println(queue.poll());
          i++;
        }
      }
    });

    exec.shutdown();


  }

  public static void main(String[] args) {
    new Task2().multithreadingFizzBuzz(15);
  }

  private static class FizzBuzzRunner implements Runnable {

    private final int n;
    private final IntPredicate predicate;
    private final Function<Integer, String> function;
    private final Queue<String> queue;
    private final CyclicBarrier barrier;

    public FizzBuzzRunner(int n, IntPredicate predicate, Function<Integer, String> function,
        Queue<String> queue, CyclicBarrier barrier) {
      this.n = n;
      this.predicate = predicate;
      this.function = function;
      this.queue = queue;
      this.barrier = barrier;
    }

    @Override
    public void run() {
      for (int i = 1; i <= n; i++) {
        if (predicate.test(i)) {
          queue.add(function.apply(i));
        }
        try {
          barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

}
