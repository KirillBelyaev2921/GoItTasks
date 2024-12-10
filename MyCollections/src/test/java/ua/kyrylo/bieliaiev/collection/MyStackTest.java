package ua.kyrylo.bieliaiev.collection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.LongStream;
import org.junit.jupiter.api.Test;

class MyStackTest {

  @Test
  void pushAndPop() {
    MyStack<Integer> queue = new MyStack<>();

    queue.push(1);
    queue.push(2);
    queue.push(5);

    assertEquals(3, queue.size());
    assertEquals(5, queue.pop());
    assertEquals(2, queue.pop());
    assertEquals(1, queue.pop());
    assertEquals(0, queue.size());
  }

  @Test
  void remove() {
    MyStack<String> list = new MyStack<>();
    list.push("Hello");
    list.push("World");

    list.remove(0);

    assertEquals(1, list.size());
    assertEquals("World", list.peek());
  }

  @Test
  void clear() {
    MyStack<String> queue = new MyStack<>();

    queue.push("Hello");
    queue.push("World");

    queue.clear();

    assertEquals(0, queue.size());
  }

  @Test
  void testAll() {
    MyStack<Long> queue = new MyStack<>();

    LongStream.range(0, 10)
        .forEach(queue::push);

    assertEquals(10, queue.size());

    queue.pop();

    assertEquals(9, queue.size());
    assertEquals(8L, queue.peek());
    assertEquals(9, queue.size());

    queue.clear();

    assertEquals(0, queue.size());

    queue.push(123L);

    assertEquals(1, queue.size());
    assertEquals(123L, queue.peek());
  }
}