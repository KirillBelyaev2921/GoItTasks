package ua.kyrylo.bieliaiev.collection;

public class MyHashMap<K, V> {

  private final int capacity = 1753; // Prime capacity
  private final Node<K, V>[] nodes = new Node[capacity];
  private int size = 0;

  public MyHashMap() {
    clear();
  }

  public V put(K key, V value) {
    Node<K, V> node = nodes[getIndex(key)];
    while (node.next != null) {
      if (node.next.key.equals(key)) {
        V oldValue = node.next.value;
        node.next.value = value;
        return oldValue;
      }
      node = node.next;
    }
    node.next = new Node<>(key, value);
    size++;
    return null;
  }

  public V remove(K key) {
    Node<K, V> node = nodes[getIndex(key)];
    while (node.next != null) {
      if (node.next.key.equals(key)) {
        V oldValue = node.next.value;
        node.next = node.next.next;
        size--;
        return oldValue;
      }
      node = node.next;
    }
    return null;
  }

  public void clear() {
    for (int i = 0; i < capacity; i++) {
      nodes[i] = new Node<>(null, null);
    }
    size = 0;
  }

  public int size() {
    return size;
  }

  public V get(K key) {
    Node<K, V> node = nodes[getIndex(key)].next;
    while (node != null) {
      if (node.key.equals(key)) {
        return node.value;
      }
      node = node.next;
    }
    return null;
  }

  private int getIndex(K key) {
    int hash = key.hashCode();
    return ((hash % capacity) + capacity) % capacity;
  }

  private static class Node<K, V> {
    private final K key;
    private V value;
    private Node<K, V> next;
    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}
