package edu.buet.cse.dsgt.ch03;

import java.util.Iterator;

/**
 * Interface for Singly Linked List
 * 
 * @author Shamim Ahmed
 *
 * @param <E>
 */
public interface SinglyLinkedList<E> {
  int getSize();

  boolean isEmpty();

  void addFirst(E element);

  void addLast(E element);

  E removeFirst();

  E removeLast();

  boolean contains(E element);

  public Iterator<E> getIterator();
}
