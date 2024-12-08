package ua.kyrylo.bieliaiev.collection;

public class MyLinkedList<T> implements MyList<T> {

  private Node<T> dummyHead;
  private Node<T> dummyTail;
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

}
