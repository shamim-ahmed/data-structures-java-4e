package edu.buet.cse.dsgt.ch03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import org.junit.Test;

public class DoublyLinkedListImplTest {
  @Test
  public void testSize() {
    DoublyLinkedList<Integer> myList = new DoublyLinkedListImpl<>();
    assertEquals("size is different than expected", 0, myList.getSize());
    assertTrue("list is not empty", myList.isEmpty());

    IntStream.rangeClosed(1, 10).forEach(i -> myList.addLast(i));

    assertEquals("size is different than expected", 10, myList.getSize());
    assertFalse("list is empty", myList.isEmpty());

    for (int i = 1; i <= 5; i++) {
      Integer val = myList.removeFirst();
      assertEquals("value is different than expected", Integer.valueOf(i), val);
    }

    assertEquals("size is different than expected", 5, myList.getSize());
  }

  @Test
  public void testAddFirst() {
    DoublyLinkedList<Integer> myList = new DoublyLinkedListImpl<>();
    IntStream.rangeClosed(1, 10).forEach(i -> myList.addFirst(i));
    assertEquals("size is different than expected", 10, myList.getSize());

    Integer n = 10;

    while (!myList.isEmpty()) {
      Integer val = myList.removeFirst();
      assertEquals("value is different than expected", n, val);
      n--;
    }

    assertEquals("size is different than expected", 0, myList.getSize());
  }

  @Test
  public void testAddLast() {
    DoublyLinkedList<Integer> myList = new DoublyLinkedListImpl<>();
    IntStream.rangeClosed(1, 10).forEach(i -> myList.addLast(i));

    Integer n = 10;

    while (!myList.isEmpty()) {
      Integer val = myList.removeLast();
      assertEquals("value is different than expected", n, val);
      n--;
    }

    assertEquals("size is different than expected", 0, myList.getSize());
  }
}
