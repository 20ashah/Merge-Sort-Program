
/*
 This class is the dialog box that is opened when the user wants to 
 search the list for a particular number  
*/

import javax.swing.*;
import BreezySwing.*;

public class BinarySearchDialog extends GBDialog {

	private Back back = new Back(); // for holding the list of entered numbers

	// declaring GUI components to be put in the window
	private JLabel searchLabel;
	private IntegerField searchField;
	private JButton searchButton;
	private JTextField output;

	private int size = 0; // number of items the user entered

	// constructor for adding GUI components and transferring information
	public BinarySearchDialog(JFrame parent, Back b, int length) {
		// transferring previous information from last class
		super(parent);
		back = b;
		size = length;

		searchLabel = addLabel("Search Number: ", 1, 1, 1, 1);
		searchField = addIntegerField(0, 1, 2, 1, 1);
		searchButton = addButton("Search", 2, 1, 1, 1);
		output = addTextField("", 3, 1, 10, 1);

		setTitle("Binary Search");
		setSize(500, 150);

	}

	// method for performing actions when buttons are clicked
	public void buttonClicked(JButton button) {
		if (button == searchButton) { // if search button is clicked
			// error checking user inputs
			if (!searchField.isValidNumber()) { // if number is not valid
				messageBox("Invalid Number!");
			} else {
				// finds index of number using binary search
				int index = back.binarySearch(0, size - 1, searchField.getNumber());
				if (index != -1) { // if number is not in the array
					output.setText("Number found at index " + index);
				} else {
					output.setText("Number wasn't found in the list");
				}
			}
		}
	}
}
