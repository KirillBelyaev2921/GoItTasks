package ua.kyrylo.bieliaiev;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class Task2 {

  private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
  private final CyclicBarrier barrier = new CyclicBarrier(4);

  public void multithreadingFizzBuzz(int n) {
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new FizzBuzzRunner(n, this::noFizzbuzz, barrier));
    exec.execute(new FizzBuzzRunner(n, this::fizz, barrier));
    exec.execute(new FizzBuzzRunner(n, this::buzz, barrier));
    exec.execute(new FizzBuzzRunner(n, this::fizzbuzz, barrier));
    exec.execute(() -> {
      int i = 0;
      while (i < n) {
        if (number()) {
          i++;
        }
      }
    });

    exec.shutdown();

  }

  private void noFizzbuzz(int i) {
    if (i % 3 != 0 && i % 5 != 0) {
      queue.add("" + i);
    }
  }

  private void fizz(int i) {
    if (i % 3 == 0 && i % 5 != 0) {
      queue.add("fizz");
    }
  }
  private void buzz(int i) {
    if (i % 3 != 0 && i % 5 == 0) {
      queue.add("buzz");
    }
  }
  private void fizzbuzz(int i) {
    if (i % 3 == 0 && i % 5 == 0) {
      queue.add("fizzbuzz");
    }
  }
  private boolean number() {
    if (!queue.isEmpty()) {
      System.out.println(queue.poll());
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    new Task2().multithreadingFizzBuzz(150);
  }

  private static class FizzBuzzRunner implements Runnable {

    private final int n;
    private final IntConsumer consumer;
    private final CyclicBarrier barrier;

    public FizzBuzzRunner(int n, IntConsumer consumer, CyclicBarrier barrier) {
      this.n = n;
      this.consumer = consumer;
      this.barrier = barrier;
    }

    @Override
    public void run() {
      for (int i = 1; i <= n; i++) {
        consumer.accept(i);
        try {
          barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

}
