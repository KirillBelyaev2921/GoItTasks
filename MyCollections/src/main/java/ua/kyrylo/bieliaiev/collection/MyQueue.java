package ua.kyrylo.bieliaiev.collection;

public class MyQueue<T> {


  private final Node<T> dummyHead;
  private final Node<T> dummyTail;
  private int size;

  public MyQueue() {
    dummyHead = new Node<>(null);
    dummyTail = new Node<>(null);
    size = 0;
    Node.connectTwoNodes(dummyHead, dummyTail);
  }

  public void add(T item) {
    Node.connectThreeNodes(dummyTail.getPrev(), new Node<>(item), dummyTail);
    size++;
  }

  public void clear() {
    Node.connectTwoNodes(dummyHead, dummyTail);
    size = 0;
  }

  public int size() {
    return size;
  }

  public T peek() {
    if (size == 0) {
      return null;
    } else {
      return dummyHead.getNext().getValue();
    }
  }

  public T poll() {
    if (size == 0) {
      return null;
    } else {
      Node<T> node = dummyHead.getNext();
      Node.connectTwoNodes(dummyHead, dummyHead.getNext().getNext());
      size--;
      return node.getValue();
    }
  }

}
