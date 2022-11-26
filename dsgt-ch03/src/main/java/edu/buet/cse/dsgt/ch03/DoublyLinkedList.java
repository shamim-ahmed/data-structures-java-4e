package edu.buet.cse.dsgt.ch03;

import java.util.Iterator;

/**
 * Interface for Doubly Linked List
 * 
 * @author Shamim Ahmed
 *
 * @param <E>
 */
public interface DoublyLinkedList<E> {
  int getSize();

  boolean isEmpty();

  boolean contains(E element);

  void addFirst(E element);

  void addLast(E element);

  void addBefore(E targetElem, E newElem);

  void addAfter(E targetElem, E newElem);

  E removeFirst();

  E removeLast();

  void remove(E element);
  
  Iterator<E> getIterator();
}
