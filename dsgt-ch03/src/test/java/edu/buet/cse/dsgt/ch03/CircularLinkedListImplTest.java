package edu.buet.cse.dsgt.ch03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.stream.IntStream;

import org.junit.Test;

public class CircularLinkedListImplTest {
  @Test
  public void testSize() {
    CircularLinkedList<Integer> myList = new CircularLinkedListImpl<>();
    assertTrue("List is not empty", myList.isEmpty());
    assertEquals("List size is different than expected", 0, myList.getSize());

    IntStream.rangeClosed(1, 10).forEach(myList::addFirst);

    assertEquals("List size is different than expected", 10, myList.getSize());
    assertFalse(myList.isEmpty());
  }

  @Test
  public void testAddFirst() {
    CircularLinkedList<Integer> myList = new CircularLinkedListImpl<>();
    IntStream.rangeClosed(1, 10).forEach(myList::addFirst);

    Integer n = 10;

    while (!myList.isEmpty()) {
      Integer val = myList.removeFirst();
      assertEquals("value is different than expected", n, val);
      n--;
    }
  }

  @Test
  public void testAddLast() {
    CircularLinkedList<Integer> myList = new CircularLinkedListImpl<>();
    IntStream.rangeClosed(1, 10).forEach(myList::addLast);

    Integer n = 10;

    while (!myList.isEmpty()) {
      Integer val = myList.removeLast();
      assertEquals("value is different than expected", n, val);
      n--;
    }
  }

  @Test
  public void testIterator() {
    CircularLinkedList<Integer> myList = new CircularLinkedListImpl<>();
    IntStream.rangeClosed(1, 10).forEach(myList::addLast);
    Iterator<Integer> iter = myList.iterator();
    Integer n = 1;

    while (iter.hasNext()) {
      Integer val = iter.next();
      assertEquals("value is different than expected", n, val);
      n++;
    }
  }
}
