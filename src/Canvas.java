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
 * This class creates a Canvas
 * @author Shaan Gagneja
 */
public class Canvas {
  private final int width;  // width of the canvas
  private final int height; // height of the canvas
	 
  private char [][] drawingArray; // 2D character array to store the drawing
	 
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  
  /**
   * Constructor. Throws IllegalArgumentException if width or height is 0 or negative
   * A Canvas is initially blank (use the space ' ' character)
   * @param width canvas width
   * @param height canvas height
   * @throws IllegalArgumentException width/height must be positive & > 0
   */
  public Canvas(int width, int height) throws IllegalArgumentException{
	if(width <=0 || height<=0) {
	  throw new IllegalArgumentException("width/height cannot be 0 or negative!");
	}
	drawingArray = new char[height][width];
	for(int i = 0; i < height; i++) {
	  for(int j = 0; j < width; j++) {
		drawingArray[i][j] = ' ';
	  }
	}
	this.width = width;
	this.height = height;
	this.undoStack = new DrawingStack();
	this.redoStack = new DrawingStack();
  } 
  
  /**
   *  Draw a character at the given position
   *  This method should throw an IllegalArgumentException if the drawing 
   *  position is outside the canvas
   * If that position is already marked with a different character, overwrite it.
   * After making a new change, add a matching DrawingChange to the undoStack so 
   * that we can undo if needed.
   * After making a new change, the redoStack should be empty.
   * @param row row at which the char is drawn
   * @param col column at which the char is drawn
   * @param c the char that is being drawn
   */
  public void draw(int row, int col, char c) { 
	if(width < row || row<0 || height< col || col<0) {
	  throw new IllegalArgumentException("row/col provided is outside the canvas!");
	}
	undoStack.push(new DrawingChange(row, col, drawingArray[row][col], c));
	drawingArray[row][col] = c;
  }
  
  /**
   * Undo the most recent drawing change. Return true if successful. 
   * False otherwise. An undone DrawingChange should be added to the redoStack 
   * so that we can redo if needed.
   * 
   * @return true if undo was successful, false if the stack is empty
   */
  public boolean undo() {
	if(undoStack.peek() == null) {
	  return false;
	}
	DrawingChange d = undoStack.pop();
	drawingArray[d.x][d.y] = d.prevChar;
	redoStack.push(d);
	return true;
  } 
  
  /**
   * Redo the most recent undone drawing change. Return true if successful. 
   * False otherwise. A redone DrawingChange should be added (back) to the 
   * undoStack so that we can undo again if needed.
   * 
   * @return true if redo was successful, false if the stack is empty
   */
  public boolean redo() { 
	if(redoStack.peek() == null) {
	  return false;
	}
	DrawingChange d = redoStack.pop();
	drawingArray[d.x][d.y] = d.newChar;
	undoStack.push(d);
	return true;
  } 
  
  /** Return a printable string version of the Canvas.
  * Format example: [_ is blank. Use System.lineSeparator() to put a newline character between rows]
  * X___X
  * _X_X_
  * __X__
  * _X_X_
  * X___X
  * 
  * @return the string version of the Canvas
  */ 
  public String toString() {
	String s = "";
	for(int i = 0; i < height; i++) {
	  for(int j = 0; j < width; j++) {
	    s += drawingArray[i][j];
	  }
	  s += System.lineSeparator();
	}
	return s;
  } 
  
  /**
   * Getter for the drawingArray
   * @return the 2d array
   */
  public char[][] getDrawingArray(){
	return this.drawingArray;
  }
  
  /**
   * Getter for the undoStack
   * @return the stack
   */
  public DrawingStack getUndoStack(){
		return this.undoStack;
  }
  
  /**
   * Getter for the redoStck
   * @return the stack
   */
  public DrawingStack getRedoStack(){
		return this.redoStack;
  }
}
