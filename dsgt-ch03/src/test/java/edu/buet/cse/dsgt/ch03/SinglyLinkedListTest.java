package edu.buet.cse.dsgt.ch03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import org.junit.Test;

public class SinglyLinkedListTest {
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
}
