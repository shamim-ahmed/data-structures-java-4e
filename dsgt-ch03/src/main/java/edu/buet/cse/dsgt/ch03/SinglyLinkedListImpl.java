package edu.buet.cse.dsgt.ch03;

import java.util.Iterator;

/**
 * An implementation of Singly Linked List
 * 
 * @author Shamim Ahmed
 *
 * @param <E>
 */
public class SinglyLinkedListImpl<E> implements SinglyLinkedList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  public SinglyLinkedListImpl() {
    head = tail = null;
    size = 0;
  }

  /**
   * Return the size of the list
   * 
   * @return an int
   */
  @Override
  public int getSize() {
    return size;
  }

  /**
   * Return true if the list is empty, false otherwise
   * 
   * @return a boolean
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Add the given element at the start of the list
   * 
   * @param element the given element
   */
  @Override
  public void addFirst(E element) {
    Node<E> temp = new Node<>(element);
    temp.setNext(head);

    if (isEmpty()) {
      head = tail = temp;
    } else {
      head = temp;
    }

    size++;
  }

  /**
   * Add the given element at the end of the list
   * 
   * @param element the given element
   */
  @Override
  public void addLast(E element) {
    Node<E> temp = new Node<>(element);

    if (isEmpty()) {
      head = tail = temp;
    } else {
      tail.setNext(temp);
      tail = temp;
    }

    size++;
  }

  /**
   * Remove the first element from the list
   * 
   * @return an element of type E
   */
  @Override
  public E removeFirst() {
    if (isEmpty()) {
      throw new IllegalStateException("SinglyLinkedList is empty");
    }

    Node<E> temp = head;
    head = head.getNext();
    size--;

    if (isEmpty()) {
      tail = head;
    }

    return temp.getElement();
  }

  /**
   * Remove the last element from the list
   * 
   * @return an element of type E
   */
  @Override
  public E removeLast() {
    if (isEmpty()) {
      throw new IllegalStateException("SinglyLinkedList is empty");
    }

    if (size == 1) {
      Node<E> temp = tail;
      head = tail = null;
      size = 0;

      return temp.getElement();
    } else {
      Node<E> p = head;

      while (p.getNext() != tail) {
        p = p.getNext();
      }

      Node<E> temp = tail;
      p.setNext(null);
      tail = p;
      size--;

      return temp.getElement();
    }
  }

  /**
   * Return true of the list contains the given element, false otherwise
   * 
   * @return a boolean
   */
  public boolean contains(E element) {
    Node<E> p = head;
    boolean found = false;

    while (p != null && !found) {
      E val = p.getElement();

      if (val == null) {
        if (element == null) {
          found = true;
          break;
        }
      } else {
        if (val.equals(element)) {
          found = true;
          break;
        }
      }

      p = p.getNext();
    }

    return found;
  }

  /**
   * Return an iterator for the list
   * 
   * @return an Iterator
   */
  @Override
  public Iterator<E> getIterator() {
    return new SinglyLinkedListIterator();
  }

  /**
   * The toString implementation for SinglyLinkedList
   * 
   * @return a String
   */
  @Override
  public String toString() {
    StringBuilder resultBuilder = new StringBuilder();
    resultBuilder.append("[");

    Node<E> p = head;

    for (int i = 0; i < size; i++) {
      resultBuilder.append(p.getElement());
      p = p.getNext();

      if (p != null) {
        resultBuilder.append(", ");
      }
    }

    resultBuilder.append("]");

    return resultBuilder.toString();
  }

  public class SinglyLinkedListIterator implements Iterator<E> {
    private Node<E> p = head;

    @Override
    public boolean hasNext() {
      return p != tail;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new IllegalStateException("No more elements in list");
      }

      E val = p.getElement();
      p = p.getNext();
      return val;
    }
  }
}
