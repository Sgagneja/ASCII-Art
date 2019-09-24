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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Class that creates the UI
 * @author Shaan Gagneja
 *
 */
public class AsciiArt {
  
  /**
   * prints the menu that will be shown every time the while loop loops
   */
  public static void printM() {
	System.out.println("======== MENU ========\n" + 
			"[1] Create a new canvas\n" + 
			"[2] Draw a character\n" + 
			"[3] Undo drawing\n" + 
			"[4] Redo drawing\n" + 
			"[5] Show current canvas\n" + 
			"[6] Show drawing old\n" + 
			"[7] Exit");
  }
  
  /**
   * Runs the main application by responding to user input and calling the 
   * correct method
   * @param args
   */
  public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	Canvas canvas = null;
	int cnt = 1; 
	ArrayList<String> old = new ArrayList<>(); 
	ArrayList<String> re = new ArrayList<>(); 
	while(true) {
      printM();
      System.out.print("> ");
      String input = in.nextLine();
      try { // Check if the value is actually an integer
    	    Integer.parseInt(input);
      }catch(NumberFormatException e) {
    	    System.out.println("The initial command must be between 1 and 7");
    	    continue; 
      }int num = Integer.parseInt(input);
      if(num > 7 || num < 1) {
    	    System.out.println("Your input must be between 1 and 7");
    	    continue;
      }else if(num == 1) {
    	    System.out.print("Width > ");
    	    String w = in.nextLine();
    	    System.out.print("Height > ");
    	    String h = in.nextLine();
    	    try { // check if the width and height are integers
    	    	  Integer.parseInt(w);
    	    	  Integer.parseInt(h);
    	    }catch(NumberFormatException e) {
    	    	  System.out.println("You must enter a number");
    	    	  continue;
    	    }
    	    int width = Integer.parseInt(w);
    	    int height = Integer.parseInt(h);
    	    try {
    	      new Canvas(width, height);
    	    }catch(IllegalArgumentException e) {
    	    	  System.out.println("Neither the height nor width can be <= 0");
    	    	  continue;
    	    }
    	    canvas = new Canvas(width, height);
      }else if(num == 2) {
    	    System.out.print("Row > ");
    	    String r = in.nextLine();
    	    System.out.print("Col > ");
    	    String c = in.nextLine();
    	    try {
    	    	  Integer.parseInt(r);
  	    	  Integer.parseInt(c);
    	    }catch(NumberFormatException e) {
    	    	  System.out.println("You must enter a number");
    	    	  continue;
    	    }
    	    int row = Integer.parseInt(r);
    	    int col = Integer.parseInt(c);
    	    if(row < 0 || col < 0) {
    	    	  System.out.println("You cannot enter a negative number for the row/column");
    	    	  continue;
    	    }
    	    System.out.print("Character > ");
    	    String ch = in.nextLine();
    	    if(ch.length() != 1) {
    	    	  System.out.println("You must enter a single character value");
    	    	  continue;
    	    }
    	    try {
    	    	  Integer.parseInt(ch);
    	    	  System.out.println("You cannot enter a number");
    	    	  continue;
    	    }catch(NumberFormatException e) {}
    	    char charac = ch.charAt(0);
    	    try {
    	      canvas.draw(row, col, charac);
    	    }catch(IllegalArgumentException e) {
    	    	  System.out.println("The row or column did not fit the canvas");
    	    	  continue;
    	    }
    	    canvas.draw(row, col, charac);
    	    old.add(cnt + ". draw \'" + charac + "\' on (" + col + "," + row + ")");
    	    cnt++;
      }
      else if(num == 3) {
    	    if(canvas.undo() == false) {
    	    	  System.out.println("There is nothing to undo.");
    	    	  continue;
    	    }canvas.undo();
    	    re.add(old.get(old.size()-1));
    	    old.remove(old.size() -1);
    	    cnt--;
      }
      else if(num == 4) {
    	    if(canvas.redo() == false) {
    	    	  System.out.println("There is nothing to redo.");
    	    	  continue;
    	    }canvas.redo();
    	    old.add(re.get(re.size()-1));
    	    cnt++;
      }
      else if(num == 5) {
    	    System.out.println(canvas);
      }
      else if(num == 6) {
    	    for(int i = old.size()-1; i>=0; i--) {
    	    	  System.out.println(old.get(i));
    	    }
      }
      else if(num == 7) {
  	    System.out.println("Bye!");
  	    break;
      }
	}
  }
}

