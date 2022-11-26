package edu.buet.cse.dsgt.ch03;

import java.util.Iterator;

/**
 * An implementation of Doubly Linked List
 * 
 * @author Shamim Ahmed
 *
 * @param <E>
 */
public class DoublyLinkedListImpl<E> implements DoublyLinkedList<E> {
  private final DLNode<E> header;
  private final DLNode<E> trailer;
  private int size;

  /**
   * Default constructor
   */
  public DoublyLinkedListImpl() {
    header = new DLNode<>();
    trailer = new DLNode<>();
    header.setNext(trailer);
    trailer.setPrevious(header);
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
   * Return true if the list contains the given element, false otherwise
   * 
   * @return a boolean
   */
  @Override
  public boolean contains(E element) {
    DLNode<E> p = find(element);

    return p != null;
  }

  /**
   * Add the given element as the first item in the list
   * 
   * @param element the given element
   */
  @Override
  public void addFirst(E element) {
    DLNode<E> p = new DLNode<>(element);
    DLNode<E> q = header.getNext();
    header.setNext(p);
    q.setPrevious(p);
    p.setNext(q);
    p.setPrevious(header);
    size++;
  }


  /**
   * Add the given element as the last item in the list
   * 
   * @param element the given element
   */
  @Override
  public void addLast(E element) {
    DLNode<E> q = new DLNode<>(element);
    DLNode<E> p = trailer.getPrevious();
    p.setNext(q);
    trailer.setPrevious(q);
    q.setPrevious(p);
    q.setNext(trailer);
    size++;
  }


  /**
   * Add a given element before a specified element in the list
   * 
   * @param targetElem the specified element that is already in the list
   * @param newElem the new element that will be added in the list
   * @throws IllegalArgumentException if targetElem is not in the list
   */
  @Override
  public void addBefore(E targetElem, E newElem) {
    DLNode<E> q = find(targetElem);

    if (q == null) {
      throw new IllegalArgumentException(String.format("%s is not in List", targetElem));
    }

    DLNode<E> p = q.getPrevious();
    DLNode<E> r = new DLNode<>(newElem);

    p.setNext(r);
    q.setPrevious(r);
    r.setPrevious(p);
    r.setNext(q);
    size++;
  }

  /**
   * Add a given element after a specified element in the list
   * 
   * @param targetElem the specified element that is already in the list
   * @param newElem the new element that will be added in the list
   * @throws IllegalArgumentException if targetElem is not in the list
   */
  @Override
  public void addAfter(E targetElem, E newElem) {
    DLNode<E> p = find(targetElem);

    if (p == null) {
      throw new IllegalArgumentException(String.format("%s is not in List", targetElem));
    }

    DLNode<E> q = p.getNext();
    DLNode<E> r = new DLNode<>(newElem);

    p.setNext(r);
    q.setPrevious(r);
    r.setPrevious(p);
    r.setNext(q);
    size++;
  }

  /**
   * Remove the first element from the list
   * 
   * @return E
   * @throws IllegalStateException if the list is empty
   */
  @Override
  public E removeFirst() {
    if (isEmpty()) {
      throw new IllegalStateException("List is empty");
    }

    DLNode<E> p = header.getNext();
    DLNode<E> q = p.getNext();
    header.setNext(q);
    q.setPrevious(header);
    p.setNext(null);
    p.setPrevious(null);
    size--;

    return p.getElement();
  }

  /**
   * Remove the last element from the list
   * 
   * @return E
   * @throws IllegalStateException if the list is empty
   */
  @Override
  public E removeLast() {
    if (isEmpty()) {
      throw new IllegalStateException("List is empty");
    }

    DLNode<E> q = trailer.getPrevious();
    DLNode<E> p = q.getPrevious();
    p.setNext(trailer);
    trailer.setPrevious(p);
    q.setNext(null);
    q.setPrevious(null);
    size--;

    return q.getElement();
  }

  /**
   * Return the given element from the list
   * 
   * @throws IllegalStateException if the list is empty
   * @throws IllegalArgumentException if the element is not in the list
   */
  @Override
  public void remove(E element) {
    if (isEmpty()) {
      throw new IllegalStateException("List is emtpy");
    }

    DLNode<E> r = find(element);

    if (r == null) {
      throw new IllegalArgumentException(String.format("%s is not in List", element));
    }

    DLNode<E> p = r.getPrevious();
    DLNode<E> q = r.getNext();

    p.setNext(q);
    q.setPrevious(p);
    r.setNext(null);
    r.setPrevious(null);
    size--;
  }

  // Return the DLNode containing the given element
  private DLNode<E> find(E element) {
    DLNode<E> result = null;
    DLNode<E> p = header.getNext();

    while (p != trailer) {
      E val = p.getElement();

      if (val == null) {
        if (element == null) {
          result = p;
          break;
        }
      } else {
        if (val.equals(element)) {
          result = p;
          break;
        }
      }

      p = header.getNext();
    }

    return result;
  }
  
  @Override
  public Iterator<E> getIterator() {
    return new DoublyLinkedListIterator();
  }

  /**
   * Return a String representation of the list
   * 
   * @return a String
   */
  @Override
  public String toString() {
    StringBuilder resultBuilder = new StringBuilder();
    resultBuilder.append("[");
    DLNode<E> p = header.getNext();

    while (p != trailer) {
      E val = p.getElement();
      resultBuilder.append(val);
      p = p.getNext();

      if (p != trailer) {
        resultBuilder.append(", ");
      }
    }

    resultBuilder.append("]");
    return resultBuilder.toString();
  }

  public class DoublyLinkedListIterator implements Iterator<E> {
    private DLNode<E> cur;

    public DoublyLinkedListIterator() {
      cur = header;
    }

    @Override
    public boolean hasNext() {
      return cur.getNext() != trailer;
    }

    @Override
    public E next() {
      cur = cur.getNext();

      if (cur == trailer) {
        throw new IllegalStateException("No more elements in List");
      }

      return cur.getElement();
    }
  }
}
