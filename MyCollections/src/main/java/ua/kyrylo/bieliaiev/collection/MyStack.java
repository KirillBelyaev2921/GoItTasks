package ua.kyrylo.bieliaiev.collection;

import java.util.NoSuchElementException;

public class MyStack<T> {

  private final MyLinkedList<T> stack = new MyLinkedList<>();

  public MyStack() {
  }

  public void push(T item) {
    stack.add(item);
  }

  public void remove(int index) {
    stack.remove(index);
  }

  public void clear() {
    stack.clear();
  }

  public int size() {
    return stack.size();
  }

  public T peek() {
    if (size() == 0) {
      throw new NoSuchElementException();
    } else {
      return stack.getLast();
    }
  }

  public T pop() {
    if (size() == 0) {
      throw new NoSuchElementException();
    } else {
      return stack.removeLast();
    }
  }
}
