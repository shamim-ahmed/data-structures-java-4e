package edu.buet.cse.dsgt.ch03;

public class DLNode<E> {
  private E element;
  private DLNode<E> previous;
  private DLNode<E> next;

  public DLNode() {
    this(null, null, null);
  }

  public DLNode(E element) {
    this(element, null, null);
  }

  public DLNode(E element, DLNode<E> previous, DLNode<E> next) {
    this.element = element;
    this.previous = previous;
    this.next = next;
  }

  public E getElement() {
    return element;
  }

  public void setElement(E element) {
    this.element = element;
  }

  public DLNode<E> getPrevious() {
    return previous;
  }

  public void setPrevious(DLNode<E> previous) {
    this.previous = previous;
  }

  public DLNode<E> getNext() {
    return next;
  }

  public void setNext(DLNode<E> next) {
    this.next = next;
  }
}
