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
 * This class creates a Canvas
 * @author Shaan Gagneja
 */
public class DrawingStackIterator implements Iterator<DrawingChange>{
  private Node<DrawingChange> n;	
  private DrawingStack stack;
  private Iterator<DrawingChange> it;

  /**
   * Constructor for the DrawingStackIterator class
   * @param node the node of the stack
   */
  public DrawingStackIterator(Node<DrawingChange> node) {
    this.n = node;
    this.stack = new DrawingStack();
    this.it = stack.iterator();
  }

  /**
   * Checks if the node has next value
   * @return true if it does, false otherwise
   */
  @Override
  public boolean hasNext() {
    if(this.n == null) {
    	  return false;
    }
    return true;
  }

  /**
   * Gets the nextNode's value after checking if it has another value
   * @return the node's value
   */
  @Override
  public DrawingChange next() {
	if(hasNext()) {
	  Node<DrawingChange> node = n;
	  if(n.getNext() != null) {
		n = n.getNext();
	  }else {
		n = null;
	  }return node.getData();
	}return null;
  }
  
  /**
   * Gets the iterator for this stack
   * @return the stack's iterator
   */
  public Iterator<DrawingChange> iterator(){
	return this.it;
  }
}
