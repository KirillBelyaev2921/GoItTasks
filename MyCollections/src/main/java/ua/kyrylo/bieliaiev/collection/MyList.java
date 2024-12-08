package ua.kyrylo.bieliaiev.collection;

public interface MyList<T> {

  void add(T item);
  void remove(int index);
  void clear();
  int size();
  T get(int index);

}
