package ua.kyrylo.bieliaiev.collection;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

  private Object[] array;
  private int capacity;
  private int size;

  public MyArrayList(int capacity) {
    this.capacity = capacity;
    array = new Object[capacity];
  }

  public MyArrayList() {
    this(16);
  }

  @Override
  public void add(T item) {
    if (size == capacity) {
      expandArray();
    } else {
      array[size++] = item;
    }
  }

  @Override
  public void remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    for (int i = index; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    size--;
  }

  @Override
  public void clear() {
    for (int i = 0; i < size; i++) {
      array[i] = null;
    }
    size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T get(int index) {
    return (T) array[index];
  }

  private void expandArray() {
    capacity *= 2;
    array = Arrays.copyOf(array, capacity);
  }
}
