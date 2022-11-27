package edu.buet.cse.dsgt.ch03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.stream.IntStream;

import org.junit.Test;

public class SinglyLinkedListImplTest {
  @Test
  public void testSize() {
    SinglyLinkedList<Integer> myList = new SinglyLinkedListImpl<>();
    assertTrue("list is not empty", myList.isEmpty());
    assertEquals("list size is not zero", 0, myList.getSize());

    IntStream.rangeClosed(1, 10).forEach(i -> myList.addLast(i));

    assertFalse("list is empty", myList.isEmpty());
    assertEquals("list size is different than expected", 10, myList.getSize());
  }

  @Test
  public void testAddFirst() {
    SinglyLinkedList<Integer> myList = new SinglyLinkedListImpl<>();
    IntStream.rangeClosed(1, 10).forEach(i -> myList.addFirst(i));

    Integer n = 10;

    while (!myList.isEmpty()) {
      Integer val = myList.removeFirst();
      assertEquals("value is different than expected", n, val);
      n--;
    }
  }

  @Test
  public void testAddLast() {
    SinglyLinkedList<Integer> myList = new SinglyLinkedListImpl<>();
    IntStream.rangeClosed(1, 10).forEach(i -> myList.addLast(i));

    Integer n = 1;

    while (!myList.isEmpty()) {
      Integer val = myList.removeFirst();
      assertEquals("value is different than expected", n, val);
      n++;
    }
  }

  @Test
  public void testRemoveLast() {
    SinglyLinkedList<Integer> myList = new SinglyLinkedListImpl<>();
    IntStream.rangeClosed(1, 10).forEach(i -> myList.addLast(i));

    Integer n = 10;

    while (!myList.isEmpty()) {
      Integer val = myList.removeLast();
      assertEquals("value is different than expected", n, val);
      n--;
    }
  }

  @Test
  public void testToString() {
    SinglyLinkedList<Integer> myList = new SinglyLinkedListImpl<>();
    assertEquals("toString output is different than expected", "[]", myList.toString());

    IntStream.rangeClosed(1, 10).forEach(i -> myList.addFirst(i));
    String expected = "[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]";
    assertEquals("toString output is different than expected", expected, myList.toString());
  }

  @Test
  public void testContains() {
    SinglyLinkedList<Integer> myList = new SinglyLinkedListImpl<>();
    assertFalse("list contains non-existent element", myList.contains(1));

    IntStream.rangeClosed(1, 10).forEach(i -> myList.addLast(i));
    myList.addFirst(null);

    assertEquals("size is different than expected", 11, myList.getSize());

    for (int i = 1; i <= 10; i++) {
      assertTrue(String.format("list does not contain %d", i), myList.contains(Integer.valueOf(i)));
    }

    assertTrue("list does not contain null", myList.contains(null));
    assertFalse("list contains non-existent element", myList.contains(50));
  }

  @Test
  public void testIterator() {
    SinglyLinkedList<Integer> myList = new SinglyLinkedListImpl<>();
    IntStream.rangeClosed(1, 1).forEach(i -> myList.addLast(i));

    Iterator<Integer> iter = myList.iterator();
    Integer i = 1;

    while (iter.hasNext()) {
      Integer val = iter.next();
      assertEquals("value is different than expected", i, val);
      i++;
    }
  }

  @Test
  public void testIteratorWithEmptyList() {
    SinglyLinkedList<Integer> myList = new SinglyLinkedListImpl<>();
    Iterator<Integer> iter = myList.iterator();
    assertFalse(iter.hasNext());
  }

  @Test
  public void testIteratorWithOneItem() {
    SinglyLinkedList<Integer> myList = new SinglyLinkedListImpl<>();
    myList.addFirst(1);
    Iterator<Integer> iter = myList.iterator();

    assertTrue(iter.hasNext());
    assertEquals("value is different than expected", Integer.valueOf(1), iter.next());
    assertFalse(iter.hasNext());
  }
}
