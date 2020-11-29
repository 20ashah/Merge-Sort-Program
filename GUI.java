
/*
 Arjun Shah
 E Block
 4/2/19
 Program Description:
 This program allows the user to enter up to 10 integers. The user
 can then sort the list of integers they entered using merge sort.
 They can also search for a particular number using binary search.
*/

import BreezySwing.*;
import javax.swing.*;
import java.util.*;

public class GUI extends GBFrame {

	// declaring GUI components that will be put in the window
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, add;
	private JLabel numLabel;
	private IntegerField numField;
	private JMenuItem sort, search, reset, quit;

	private Back back = new Back(); // for holding the sorted list

	// list of inputs by the user
	private ArrayList<Integer> inputs = new ArrayList<Integer>();

	// constructor for setting the components onto the GUI window
	public GUI() {
		b1 = addButton(" ", 1, 1, 1, 1);
		b2 = addButton(" ", 1, 2, 1, 1);
		b3 = addButton(" ", 1, 3, 1, 1);
		b4 = addButton(" ", 1, 4, 1, 1);
		b5 = addButton(" ", 1, 5, 1, 1);
		b6 = addButton(" ", 1, 6, 1, 1);
		b7 = addButton(" ", 1, 7, 1, 1);
		b8 = addButton(" ", 1, 8, 1, 1);
		b9 = addButton(" ", 1, 9, 1, 1);
		b10 = addButton(" ", 1, 10, 1, 1);
		addLabel(" ", 2, 4, 1, 1);
		numLabel = addLabel("Enter a Number: ", 3, 4, 1, 1);
		numField = addIntegerField(0, 3, 5, 1, 1);
		add = addButton("Add Number", 4, 5, 1, 1);
		reset = addMenuItem("File", "Reset");
		quit = addMenuItem("File", "Quit");
		sort = addMenuItem("Options", "Merge Sort");
		search = addMenuItem("Options", "Binary Search");
		numField.setText("");

	}

	// method for performing actions when buttons are clicked
	public void buttonClicked(JButton button) {
		if (button == add) { // if user clicks the add button
			// error checking user input
			if (!numField.isValidNumber()) { // if number is an invalid integer
				messageBox("Invalid Integer!");
			} else if (inputs.size() == 10) { // if the array is already full
				messageBox("Max Number of Integers Entered!");
			} else {
				inputs.add(numField.getNumber()); // add number to the array
				addNumsToButtons(); // edit labels to the buttons
			}
			// set cursor and highlight to the inputed field
			numField.requestFocus();
			numField.selectAll();
		}
	}

	// method for performing actions on the menu bar
	public void menuItemSelected(JMenuItem item) {
		// disable input fields and buttons
		numField.setText("");
		add.setEnabled(false);
		numField.setEnabled(false);
		// sets the user's list and sorts it
		back = new Back(inputs);
		back.sort(0, inputs.size() - 1);
		if (item == sort) { // if user clicks the sort option
			int[] nums = back.getSorted(); // sorted array
			try {
				// setting each of the buttons to the number in the array
				b1.setText(nums[0] + "");
				b2.setText(nums[1] + "");
				b3.setText(nums[2] + "");
				b4.setText(nums[3] + "");
				b5.setText(nums[4] + "");
				b6.setText(nums[5] + "");
				b7.setText(nums[6] + "");
				b8.setText(nums[7] + "");
				b9.setText(nums[8] + "");
				b10.setText(nums[9] + "");
			} catch (Exception e) {
				// do nothing if there is an index out of bounds error
			}
		} else if (item == search) { // if user clicks the search option
			// opens a new dialog box for entering search information
			BinarySearchDialog dialog = new BinarySearchDialog(this, back, inputs.size());
			dialog.setVisible(true);
		} else if (item == quit) { // if user clicks the quit option
			System.exit(0); // exit the program
		} else if (item == reset) { // if user clicks the reset option
			// enable user inputs and buttons
			add.setEnabled(true);
			numField.setEnabled(true);
			inputs.clear(); // clear the input array
			// reset labels on all buttons
			b1.setText(" ");
			b2.setText(" ");
			b3.setText(" ");
			b4.setText(" ");
			b5.setText(" ");
			b6.setText(" ");
			b7.setText(" ");
			b8.setText(" ");
			b9.setText(" ");
			b10.setText(" ");
		}
	}

	// method for naming each button appropriately
	public void addNumsToButtons() {
		try {
			// setting each number to the number in the unsorted array
			b1.setText(inputs.get(0) + "");
			b2.setText(inputs.get(1) + "");
			b3.setText(inputs.get(2) + "");
			b4.setText(inputs.get(3) + "");
			b5.setText(inputs.get(4) + "");
			b6.setText(inputs.get(5) + "");
			b7.setText(inputs.get(6) + "");
			b8.setText(inputs.get(7) + "");
			b9.setText(inputs.get(8) + "");
			b10.setText(inputs.get(9) + "");
		} catch (Exception e) {
			// do nothing if there is an index out of bounds error
		}

	}

	// main method for creating the GUI window
	public static void main(String[] args) {
		GUI window = new GUI();
		window.setSize(1500, 300);
		window.setVisible(true);
	}

}
