package ua.kyrylo.bieliaiev.collection;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {

  @Test
  void addAndGet() {
    MyList<Integer> list = new MyLinkedList<>();

    list.add(1);
    list.add(2);
    list.add(5);

    assertEquals(3, list.size());
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(5, list.get(2));
  }

  @Test
  void remove() {
    MyList<String> list = new MyLinkedList<>();
    list.add("Hello");
    list.add("World");

    list.remove(0);

    assertEquals(1, list.size());
    assertEquals("World", list.get(0));
  }

  @Test
  void clear() {
    MyList<Object> list = new MyLinkedList<>();
    list.add("Hello");
    list.add("World");
    list.add(1);

    list.clear();

    assertEquals(0, list.size());
  }

  @Test
  void size() {
    MyList<Point> list = new MyLinkedList<>();
    list.add(new Point(0, 0));
    list.add(new Point(50, 50));

    int size = list.size();

    assertEquals(2, size);
  }
}