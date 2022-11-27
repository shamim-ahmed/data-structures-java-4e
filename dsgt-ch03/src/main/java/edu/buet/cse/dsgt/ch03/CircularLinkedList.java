package edu.buet.cse.dsgt.ch03;

/**
 * An interface for Circular Linked List
 * 
 * @author Shamim Ahmed
 *
 * @param <E>
 */
public interface CircularLinkedList<E> extends Iterable<E> {
  int getSize();

  boolean isEmpty();

  void addFirst(E element);

  E removeFirst();
  
  void addLast(E element);
  
  E removeLast();
}
