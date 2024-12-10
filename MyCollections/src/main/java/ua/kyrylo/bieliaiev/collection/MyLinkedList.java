package ua.kyrylo.bieliaiev.collection;

import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

  private final Node<T> dummyHead;
  private final Node<T> dummyTail;
  private int size;

  public MyLinkedList() {
    dummyHead = new Node<>(null);
    dummyTail = new Node<>(null);
    size = 0;
    Node.connectTwoNodes(dummyHead, dummyTail);
  }

  @Override
  public void add(T item) {
    Node.connectThreeNodes(dummyTail.getPrev(), new Node<>(item), dummyTail);
    size++;
  }

  @Override
  public void remove(int index) {
    Node<T> node = getNode(index);
    Node.connectTwoNodes(node.getPrev(), node.getNext());
    size--;
  }

  @Override
  public void clear() {
    Node.connectTwoNodes(dummyHead, dummyTail);
    size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T get(int index) {
    return getNode(index).getValue();
  }

  public T getFirst() {
    return getFirstNode().getValue();
  }

  public T getLast() {
    return getLastNode().getValue();
  }

  public T removeFirst() {
    Node<T> node = getFirstNode();
    remove(node);
    return node.getValue();
  }

  public T removeLast() {
    Node<T> node = getLastNode();
    remove(node);
    return node.getValue();
  }

  private Node<T> getNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node<T> node = dummyHead.getNext();
    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    return node;
  }

  private Node<T> getFirstNode() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return dummyHead.getNext();
  }

  private Node<T> getLastNode() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return dummyTail.getPrev();
  }

  private void remove(Node<T> node) {
    Node.connectTwoNodes(node.getPrev(), node.getNext());
    size--;
  }

}
