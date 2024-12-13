package ua.kyrylo.bieliaiev;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Task5 {

  public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
    Iterator<T> firstIter = first.iterator();
    Iterator<T> secondIter = second.iterator();
    Iterator<T> zipperIterator = new ZipperIterator<>(firstIter, secondIter);
    Iterable<T> zipperIterable = () -> zipperIterator;
    return StreamSupport.stream(zipperIterable.spliterator(), false);
  }

  private static class ZipperIterator<T> implements Iterator<T> {

    private final Iterator<T> first;
    private final Iterator<T> second;
    private int counter = 0;

    public ZipperIterator(Iterator<T> first, Iterator<T> second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean hasNext() {
      if (counter % 2 == 0) {
        return first.hasNext() && second.hasNext();
      } else {
        return true;
      }
    }

    @Override
    public T next() {
      if (counter++ % 2 == 0) {
        return first.next();
      } else {
        return second.next();
      }
    }
  }

}
