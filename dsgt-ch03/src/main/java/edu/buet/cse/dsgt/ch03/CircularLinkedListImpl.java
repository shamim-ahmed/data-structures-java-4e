package edu.buet.cse.dsgt.ch03;

import java.util.Iterator;

/**
 * An implementation of Circular Linked List
 * 
 * @author Shamim Ahmed
 *
 */
public class CircularLinkedListImpl<E> implements CircularLinkedList<E> {
  // When the list is empty, both head and tail will be null.
  // When the list has only one item, both head and tail point to the same node.
  // Otherwise, the head will point to the first Node and the tail will point to the last node.
  private Node<E> head;
  private Node<E> tail;
  private int size;

  /**
   * Default constructor
   */
  public CircularLinkedListImpl() {
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
   * Add the given element as the first item in the list
   * 
   * @param element the given element
   */
  @Override
  public void addFirst(E element) {
    Node<E> p = new Node<>(element);

    if (isEmpty()) {
      head = p;
      head.setNext(p);
      tail = head;
    } else {
      p.setNext(head);
      tail.setNext(p);
      head = p;
    }

    size++;
  }

  /**
   * Remove the first item from the list
   * 
   * @return an element of type E
   * @throws IllegalStateException if the list is empty
   */
  @Override
  public E removeFirst() {
    if (isEmpty()) {
      throw new IllegalStateException("List is empty");
    }

    E result = head.getElement();

    if (size == 1) {
      head.setNext(null);
      head = tail = null;
    } else {
      Node<E> p = head.getNext();
      tail.setNext(p);
      head.setNext(null);
      head = p;
    }

    size--;
    return result;
  }

  @Override
  public void addLast(E element) {
    Node<E> p = new Node<>(element);

    if (isEmpty()) {
      p.setNext(p);
      head = tail = p;
    } else {
      p.setNext(head);
      tail.setNext(p);
      tail = p;
    }

    size++;
  }

  @Override
  public E removeLast() {
    if (isEmpty()) {
      throw new IllegalStateException("List is empty");
    }

    E result = tail.getElement();;

    if (size == 1) {
      tail.setNext(null);
      head = tail = null;
    } else {
      Node<E> p = head;

      while (p.getNext() != tail) {
        p = p.getNext();
      }

      p.setNext(head);
      tail.setNext(null);
      tail = p;
    }

    size--;
    return result;
  }

  /**
   * Return an iterator for the list
   * 
   * @return an Iterator
   */
  @Override
  public Iterator<E> iterator() {
    return new CircularLinkedListIterator();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    StringBuilder resultBuilder = new StringBuilder();
    resultBuilder.append("[");

    if (!isEmpty()) {
      Node<E> p = head;

      do {
        E val = p.getElement();
        resultBuilder.append(val);
        p = p.getNext();

        if (p != head) {
          resultBuilder.append(", ");
        }
      } while (p != head);
    }

    resultBuilder.append("]");
    return resultBuilder.toString();
  }

  private class CircularLinkedListIterator implements Iterator<E> {
    private int index;
    private Node<E> current;

    CircularLinkedListIterator() {
      index = 0;
      current = head;
    }

    @Override
    public boolean hasNext() {
      return index < size;
    }

    @Override
    public E next() {
      E element = current.getElement();
      current = current.getNext();
      index++;

      return element;
    }
  }
}
