package ua.kyrylo.bieliaiev.collection;

public class Node<T> {

  private T value;
  private Node<T> next;
  private Node<T> prev;

  public Node(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public Node<T> getPrev() {
    return prev;
  }

  public void setPrev(Node<T> prev) {
    this.prev = prev;
  }

  public static <T> void connectTwoNodes(Node<T> first, Node<T> second) {
    first.setNext(second);
    second.setPrev(first);
  }

  public static <T> void connectThreeNodes(Node<T> first, Node<T> second, Node<T> third) {
    first.setNext(second);
    second.setPrev(first);
    second.setNext(third);
    third.setPrev(second);
  }
}