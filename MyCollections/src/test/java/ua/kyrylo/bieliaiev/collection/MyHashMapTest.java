package ua.kyrylo.bieliaiev.collection;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import org.junit.jupiter.api.Test;

class MyHashMapTest {

  @Test
  void put() {
    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    myHashMap.put(1, "one");
    myHashMap.put(2, "two");
    myHashMap.put(3, "three");

    assertEquals(3, myHashMap.size());
    assertEquals("one", myHashMap.get(1));
    assertEquals("two", myHashMap.get(2));
    assertEquals("three", myHashMap.get(3));

    String oldValue = myHashMap.put(3, "four");
    assertEquals("three", oldValue);
    assertEquals("four", myHashMap.get(3));

    String nullValue = myHashMap.put(5, "five");
    assertNull(nullValue);
    assertEquals(4, myHashMap.size());
  }

  @Test
  void remove() {
    MyHashMap<String, String> myHashMap = new MyHashMap<>();
    myHashMap.put("oneKey", "oneValue");
    myHashMap.put("twoKey", "twoValue");
    myHashMap.put("threeKey", "threeValue");

    assertEquals(3, myHashMap.size());

    String oldValue = myHashMap.remove("oneKey");

    assertEquals(2, myHashMap.size());
    assertEquals("oneValue", oldValue);

    String nullValue = myHashMap.remove("fourKey");

    assertNull(nullValue);
    assertEquals(2, myHashMap.size());
  }

  @Test
  void testAll() {
    MyHashMap<Point, String> myHashMap = new MyHashMap<>();

    myHashMap.put(new Point(0, 0), "0");
    myHashMap.put(new Point(10, 0), "x");
    myHashMap.put(new Point(0, 10), "y");
    myHashMap.put(new Point(10, 10), "y = x");

    assertEquals(4, myHashMap.size());
    assertEquals("0", myHashMap.get(new Point(0, 0)));
    assertEquals("x", myHashMap.get(new Point(10, 0)));

    myHashMap.remove(new Point(10, 10));

    assertEquals(3, myHashMap.size());

    myHashMap.put(new Point(5, 10), "y = 2x");

    assertEquals(4, myHashMap.size());

    myHashMap.clear();

    assertEquals(0, myHashMap.size());

    myHashMap.put(new Point(100, 100), "y = x");

    assertEquals(1, myHashMap.size());
    assertNull(myHashMap.get(new Point(0, 0)));
    assertEquals("y = x", myHashMap.get(new Point(100, 100)));
  }
}