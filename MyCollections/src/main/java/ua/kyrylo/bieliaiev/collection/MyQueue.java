package ua.kyrylo.bieliaiev.collection;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> {

  private final MyLinkedList<T> queue = new MyLinkedList<>();

  public MyQueue() {
  }

  public void add(T item) {
    queue.add(item);
  }

  public void clear() {
    queue.clear();
  }

  public int size() {
    return queue.size();
  }

  public T peek() {
    if (size() == 0) {
      throw new NoSuchElementException();
    } else {
      return queue.getFirst();
    }
  }

  public T poll() {
    if (size() == 0) {
      throw new NoSuchElementException();
    } else {
      return queue.removeFirst();
    }
  }

}
