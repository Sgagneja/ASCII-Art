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

public class DrawingChange {
	public final int x; // x coordinate for a change
	public final int y; // y coordinate for a change
	public final char prevChar; // previous character in the (x,y)
	public final char newChar; // new character in the (x,y)
	
	/**
	 * The constructor for the DrawingChangeClass
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param prevChar the previous char at (x,y)
	 * @param newChar the current char at (x, y)
	 */
	public DrawingChange(int x, int y, char prevChar, char newChar) {
	  this.x = x;
	  this.y = y;
	  this.prevChar = prevChar;
	  this.newChar = newChar;
	}
}
