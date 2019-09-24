//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P08 ASCII Art
// Files:           NA
// Course:          CS 300, 1st Semester, 2018
//
// Author:    Shaan Gagneja
// Email:   sgagneja@wisc.edu
// Lecturer's Name: Alexi Brooks
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;

/**
 * This class creates a Stack which implements StackADT<DrawingChange>
 * 
 * @author Shaan Gagneja
 */
public class DrawingStack implements StackADT<DrawingChange>{

  private Node<DrawingChange> n;
	
  /**
   * This is the constructor for the DrawingStack class
   */
  public DrawingStack() {
	this.n = null;
  }

  /**
   * Adds an element onto the stack
   * 
   * @param the element to be added to the stack
   * @throws IllegalArgumentException if the element is null
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
	if(element == null) {
	  throw new NullPointerException("Element is null in the stack");
	}
	if(n == null) {
	  n = new Node<DrawingChange>(element, null);
	}else {
	  Node<DrawingChange> currNode = n;
	  n = new Node<DrawingChange>(element, null);
	  n.setNext(currNode);
	}
  }
	
  /**
   * Returns the element at the top of the list and removes it from the list
   * @return the element at the top of the list
   */
  @Override
  public DrawingChange pop() {
	if(isEmpty()) {
	  return null;
	}else {
	  Node<DrawingChange> currNode = n;
	  n = n.getNext();
	  return currNode.getData();
	}
  }

  /**
   * Returns the element at the top of the list
   * @return the element at the top of the list
   */
  @Override
  public DrawingChange peek() {
	if(isEmpty()) {
	  return null;
	}else {
	  return n.getData();
	}
  }

  /**
   * Returns whether the stack is empty
   * 
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if(this.n == null) {
	  return true;
	}
	return false;
  }

  /**
   *  Returns the size of the stack
   *  @return the size of the stack
   */
  @Override
  public int size() {
	int size = 1;
	if(n == null) {
	  return 0;
	}
	Node<DrawingChange> node = n;
	while(node.getNext()!= null) {
	  size ++;
	  node = node.getNext();
	}
	return size;
  }

  /**
   * Returns the iterator of the stack
   * 
   * @return the iterator
   */
  @Override
  public Iterator<DrawingChange> iterator() {
	return this.iterator();
  }
}
