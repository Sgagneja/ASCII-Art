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

/**
 * This tests the methods written in the lab
 * @author Shaan Gagneja
 */
public class AsciiTest {

  /**
   * Tester method for Stack's push and peek methods
   * @return true if the methods work as intended
   */
  public static boolean testStackPushPeek(){
	DrawingStack stack = new DrawingStack();
	DrawingChange element = new DrawingChange(1, 1, 'a', 'b');
	stack.push(element);
	if(stack.peek() == element) {
      return true;
	}
	return false;
  }

  /**
   * Tester method for Stack's pop method
   * @return true if the method works as intended
   */
  public static boolean testStackPop(){
	DrawingStack stack = new DrawingStack();
	DrawingChange element = new DrawingChange(1, 1, 'a', 'b');
	stack.push(element);
	if(stack.pop() == element) {
	  if(stack.peek() == null) {
	    return true;
	  }
	}
	return false;
  }
 
  /**
   * Tester method for Stack's size method
   * @return true if the method works as intended
   */
  public static boolean testStackSize(){
	DrawingStack stack = new DrawingStack();
	DrawingChange element = new DrawingChange(1, 1, 'a', 'b');
	stack.push(element);
	if(stack.size() == 1) {
      return true;
	}
	return false;
  }
 
  /**
   * Tester method for Canvas' draw method
   * @return true if the method works as intended
   */
  public static boolean testCanvasDraw() {
	Canvas c = new Canvas(10,10);
	c.draw(1, 1, 'c');
	char[][] ch = c.getDrawingArray();
	if(ch[c.getUndoStack().peek().x][c.getUndoStack().peek().y] == 'c') {
	  DrawingChange dc = new DrawingChange(1, 1, ' ', 'c');
	  if(c.getUndoStack().peek().x == dc.x) {
		if(c.getUndoStack().peek().y == dc.y) {
		  if(c.getUndoStack().peek().prevChar == dc.prevChar) {
		    if(c.getUndoStack().peek().newChar == dc.newChar) {
		    	return true;
		    }
		  }
		}
	  }
	}
	return false;
  }

  /**
   * Tester method for Canvas' undo method
   * @return true if the method works as intended
   */
  public static boolean testCanvasUndo() {
	Canvas c = new Canvas(10,10);
	if(c.undo()) {
	  return false;
	}
	c.draw(1, 1, 'c');
	DrawingChange dc = c.getUndoStack().peek();
	char[][] ch = c.getDrawingArray();
	if(c.undo()) {
	  if(c.getRedoStack().peek().x == dc.x) {
		if(c.getRedoStack().peek().y == dc.y) {
		  if(c.getRedoStack().peek().prevChar == dc.prevChar) {
			if(c.getRedoStack().peek().newChar == dc.newChar) {
			  if(ch[c.getRedoStack().peek().x][c.getRedoStack().peek().y] == ' ') {
			    return true;
			  }
		    }
		  }
		}
	  }
	}
	return false;
  }

  /**
   * Tester method for Canvas' redo method
   * @return true if the method works as intended
   */
  public static boolean testCanvasRedo() {
	Canvas c = new Canvas(10,10);
	if(c.redo()) {
	  return false;
	}
	c.draw(1, 1, 'c');
	char[][] ch = c.getDrawingArray();
	c.undo();
	DrawingChange dc = c.getRedoStack().peek();
	if(c.redo()) {
	  if(c.getUndoStack().peek().x == dc.x) {
		if(c.getUndoStack().peek().y == dc.y) {     
		  if(c.getUndoStack().peek().prevChar == dc.prevChar) {
			if(c.getUndoStack().peek().newChar == dc.newChar) {
			  if(ch[c.getUndoStack().peek().x][c.getUndoStack().peek().y] == 'c') {
				return true;
			  }
			}
		  }
	    }
	  }
	}
	return false;
  }
  /**
   * Compiles the tests for the stack and checks if they work as intended
   * @return true if the methods work as intended
   */
  public static boolean runStackTestSuite() {
	if(!testStackPushPeek()) {
	  System.out.println("Stack's push or peek method does not work as intended");
	  return false;
	}
	if(!testStackPop()) {
	  System.out.println("Stack's pop method does not work as intended");
	  return false;
	}
	if(!testStackSize()) {
	  System.out.println("Stack's size method does not work as intended");
	  return false;
	}
	return true;
  }
  /**
   * Main method for the AsciiTest class
   * @param args the list of arguments
   */
  public static void main(String[]args) {
	if(!runStackTestSuite()) {
	  System.out.println("One or more tests do not work as intended");
	}
	if(!testCanvasDraw()) {
	  System.out.println("Canvas' draw method does not work as intended");
	}
	if(!testCanvasUndo()) {
	  System.out.println("Canvas' undo method does not work as intended");
	}
	if(!testCanvasRedo()) {
	  System.out.println("Canvas' redo method does not work as intended");
	}
  }
}
