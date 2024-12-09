package ua.kyrylo.bieliaiev.collection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.LongStream;
import org.junit.jupiter.api.Test;

class MyQueueTest {

  @Test
  void addAndPoll() {
    MyQueue<Integer> queue = new MyQueue<>();

    queue.add(1);
    queue.add(2);
    queue.add(5);

    assertEquals(3, queue.size());
    assertEquals(1, queue.poll());
    assertEquals(2, queue.poll());
    assertEquals(5, queue.poll());
    assertEquals(0, queue.size());
  }

  @Test
  void clear() {
    MyQueue<String> queue = new MyQueue<>();

    queue.add("Hello");
    queue.add("World");

    queue.clear();

    assertEquals(0, queue.size());
  }

  @Test
  void peek() {
  }

  @Test
  void testAll() {
    MyQueue<Long> queue = new MyQueue<>();

    LongStream.range(0, 10)
        .forEach(queue::add);

    assertEquals(10, queue.size());

    queue.poll();

    assertEquals(9, queue.size());
    assertEquals(1L, queue.peek());
    assertEquals(9, queue.size());

    queue.clear();

    assertEquals(0, queue.size());

    queue.add(123L);

    assertEquals(1, queue.size());
    assertEquals(123L, queue.peek());
  }
}