package edu.buet.cse.dsgt.ch03;

public interface SinglyLinkedList<E> {
  int getSize();
  boolean isEmpty();
  void addFirst(E element);
  void addLast(E element);
  E removeFirst();
  E removeLast();
}
