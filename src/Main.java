import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Main m = new Main();
		//m.mathPrintThePattern(4);
		//m.mathPrintTable();
		//m.arrayMaxMinArray();
		//m.arraySecondLargest();
		m.arraySumOfArrayElements();
	}
	public void mathPrintThePattern(int n) {
		int newN = n;
		for (int i = n; i > 0; i--) { //this controls the number of rows generated
			String aRow = ""; //Store a row in this premade string. Resets this each time the main loop runs so former loop contents are not printed out again and each run of this loop generates a new row
			int currentIntTracker = n; //at the beginning of each row, resets the current integer being parsed to 'n', as it is decreased each time the nested loop runs
			for (int j = newN; j > 0; j--) { //This controls the elements on each individual row
				String currentInt = currentIntTracker + " "; //currentIntTracker stores the current integer that is being added to the row. For the first run of this nested loop, it will be 'n', then 'n-1', and so on.
				String repeat = currentInt.repeat(i); //this repeats the string by "i", the string being the current Integer (i.e. 5, 4, 3, etc. and the output will be 5555 if i = 4)
				aRow = aRow + repeat; //adds the repeated string generated from above to the row string, for printing later
				currentIntTracker -= 1; //decreases the currentInt, basically turning 'n' into 'n-1' for the next run of this loop
			}
			System.out.println(aRow); //once the nested loop has run fully for this row, the string storing this row info is printed out. This is done for each running of the main loop, and thus each row as well.
		}
	}
	public void mathPrintTable(){
		//takes an input 'rows' for the rows, based on that input, takes 'rows' number of  numbers. Nested for loop.

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of rows to generate: ");
		int noOfRows = sc.nextInt(); //make this from user input
		for (int i = 0; i < noOfRows; i++) {
			String aRow = "";
			System.out.println("Enter the row " + i + " integer to use.");
			int currentRowElement = sc.nextInt();
			for (int j = 1; j < 11; j++) {
				int currentElement = currentRowElement * j;
				aRow = aRow + currentElement + " ";
			}
			System.out.println(aRow);
		}
		sc.close();
	} //requirements: output should all come out together, and put in constraints for input
	public void userGeneratedArrays(){

	}
	public void arrayMaxMinArray(){

		/*
		* Constraints:
		*
		* Number of arrays provided must be between 1 and 100
		* Size of each array should be between 1 and 1000
		* Each individual array element should be between 1 and 10^12
		* */

		Scanner sc = new Scanner(System.in);
		int noOfArrays = 0;
		while(true) { //will check if the number of arrays provided is within the constraints of 1 and 100. If not, will repeatedly ask user for a valid number.
			System.out.println("Enter the number of arrays to parse into max and min. Must be between 1 and 100. ");
			noOfArrays = sc.nextInt();
			if(noOfArrays >= 1 && noOfArrays <=100){
				System.out.println("Valid number of arrays, continuing.");
				break;
			} else {
				System.out.println("Invalid entry, please try again");
			}
		}

		for (int i = 0; i < noOfArrays; i++) { //loops through each individual array
			int sizeOfArray = 0;
			while(true) { //will check if the size of array provided is within the constraints of 1 and 1000. If not, will repeatedly ask user for a valid number.
				System.out.println("Enter the size of array number: " + (i + 1) + ", must be between 1 and 1000");
				sizeOfArray = sc.nextInt();
				if(sizeOfArray >= 1 && sizeOfArray <=1000){
					System.out.println("Valid number of elements within array, continuing.");
					break;
				} else {
					System.out.println("Invalid entry! Please try again");
				}
			}
			int currentArray[];
			currentArray = new int[sizeOfArray]; //creates an array of the desired size

			for (int j = 0; j < sizeOfArray; j++) {
				int currentElementToAddToArray = 0;
				while(true) { //will check if the element to put into array is within the constraints of 1 and 10^12. If not, will repeatedly ask user for a valid number.
					System.out.println("Add element of index number: " + j + " to the array, must be between 1 and 10^12");
					currentElementToAddToArray = sc.nextInt();
					if(currentElementToAddToArray >= 1 && currentElementToAddToArray <= Math.pow(10, 12)){
						System.out.println("Valid element given, continuing");
						break;
					} else {
						System.out.println("Invalid number! Try again.");
					}
				}
				currentArray[j] = currentElementToAddToArray;
			}
			System.out.println(Arrays.toString(currentArray)); //converts the array to a string for printing
			int currentMax = currentArray[0];
			int indexOfCurrentMax = 0;
			for (int j = 0; j < sizeOfArray; j++) { //will loop thru the array and see what is the maximum number
				int nextNo = currentArray[j];
				if(nextNo > currentMax){
					currentMax = nextNo;
					indexOfCurrentMax = j;
				}
			}
			System.out.println("Max number in this array is: " + currentMax + " and the index of this number is: " + indexOfCurrentMax);
			int currentMin = currentArray[0];
			int indexOfCurrentMin = 0;
			for (int j = 0; j < sizeOfArray; j++) { //will loop thru the array and see what is the maximum number
				int nextNo = currentArray[j];
				if(nextNo < currentMin){
					currentMin = nextNo;
					indexOfCurrentMin = j;
				}
			}
			System.out.println("Min number in this array is: " + currentMin + " and the index for this number is " + indexOfCurrentMin);
		}
	}
	public void arraySecondLargest(){
		//take a user defined array, and get the second largest number
		//ideas: Get the array, reorder it from largest to smallest, then get second index.
		//ideas: can also get the largest number, remove it from the array, and then get the next largest number. or just skip the largest without removing.

		/*Scanner sc = new Scanner(System.in);
		int noOfArrays = 0;
		while(true) { //will check if the number of arrays provided is within the constraints of 1 and 100. If not, will repeatedly ask user for a valid number.
			System.out.println("Enter the number of arrays to parse into max and min. Must be between 1 and 100. ");
			noOfArrays = sc.nextInt();
			if(noOfArrays >= 1 && noOfArrays <=100){
				System.out.println("Valid number of arrays, continuing.");
				break;
			} else {
				System.out.println("Invalid entry, please try again");
			}
		}

		for (int i = 0; i < noOfArrays; i++) { //loops through each individual array
			int sizeOfArray = 0;
			while (true) { //will check if the size of array provided is within the constraints of 1 and 1000. If not, will repeatedly ask user for a valid number.
				System.out.println("Enter the size of array number: " + (i + 1) + ", must be between 1 and 1000");
				sizeOfArray = sc.nextInt();
				if (sizeOfArray >= 1 && sizeOfArray <= 1000) {
					System.out.println("Valid number of elements within array, continuing.");
					break;
				} else {
					System.out.println("Invalid entry! Please try again");
				}
			}
			int currentArray[];
			currentArray = new int[sizeOfArray]; //creates an array of the desired size

			for (int j = 0; j < sizeOfArray; j++) {
				int currentElementToAddToArray = 0;
				while (true) { //will check if the element to put into array is within the constraints of 1 and 10^12. If not, will repeatedly ask user for a valid number.
					System.out.println("Add element of index number: " + j + " to the array, must be between 1 and 10^12");
					currentElementToAddToArray = sc.nextInt();
					if (currentElementToAddToArray >= 1 && currentElementToAddToArray <= Math.pow(10, 12)) {
						System.out.println("Valid element given, continuing");
						break;
					} else {
						System.out.println("Invalid number! Try again.");
					}
				}
				currentArray[j] = currentElementToAddToArray;
			}
			System.out.println(Arrays.toString(currentArray)); //converts the array to a string for printing
		} */

		//just add a new array making mechanism here with user input. 1 array, array size up to 500 and array elements value up to 1200

		int[] arraySecondLargest = {100, 55, 63, 101, 101, 100};
		int largestVal = 0;
		for(int l = 0; l < arraySecondLargest.length; l++){ //the largest value is acquired in this loop
			int currentVal = arraySecondLargest[l];
			if(currentVal > largestVal){
				largestVal = currentVal;
			}
		}
		int secondLargestVal = 0;
		System.out.println("Largest value in array is: " + largestVal);
		for (int l = 0; l < arraySecondLargest.length; l++) { //the second largest value is acquired in this loop
			int currentVal = arraySecondLargest[l];
			if(currentVal == largestVal){ //if the largest value from above is acquired, it is skipped
				System.out.println("Skipping the largest value");
			} else if (currentVal > secondLargestVal){
				secondLargestVal = currentVal;
			}
		}
		System.out.println("The second largest value is: " + secondLargestVal);
	}
	public void arraySumOfArrayElements(){
		Scanner sc = new Scanner(System.in);
		int noOfArrays = 0;
		while(true) { //will check if the number of arrays provided is within the constraints of 1 and 100. If not, will repeatedly ask user for a valid number.
			System.out.println("Enter the number of arrays to parse into max and min. Must be between 1 and 100. ");
			noOfArrays = sc.nextInt();
			if(noOfArrays >= 1 && noOfArrays <=100){
				System.out.println("Valid number of arrays, continuing.");
				break;
			} else {
				System.out.println("Invalid entry, please try again");
			}
		}

		for (int i = 0; i < noOfArrays; i++) { //loops through each individual array
			int sizeOfArray = 0;
			while(true) { //will check if the size of array provided is within the constraints of 1 and 1000. If not, will repeatedly ask user for a valid number.
				System.out.println("Enter the size of array number: " + (i + 1) + ", must be between 1 and 1000");
				sizeOfArray = sc.nextInt();
				if(sizeOfArray >= 1 && sizeOfArray <=100){
					System.out.println("Valid number of elements within array, continuing.");
					break;
				} else {
					System.out.println("Invalid entry! Please try again");
				}
			}
			int currentArray[];
			currentArray = new int[sizeOfArray]; //creates an array of the desired size

			for (int j = 0; j < sizeOfArray; j++) {
				int currentElementToAddToArray = 0;
				while(true) { //will check if the element to put into array is within the constraints of 1 and 10^12. If not, will repeatedly ask user for a valid number.
					System.out.println("Add element of index number: " + j + " to the array, must be between 1 and 10^12");
					currentElementToAddToArray = sc.nextInt();
					if(currentElementToAddToArray >= 1 && currentElementToAddToArray <= 100){
						System.out.println("Valid element given, continuing");
						break;
					} else {
						System.out.println("Invalid number! Try again.");
					}
				}
				currentArray[j] = currentElementToAddToArray;
			}
			System.out.println(Arrays.toString(currentArray)); //converts the array to a string for printing
			int sum = 0;
			for (int j = 0; j < sizeOfArray; j++) { //will loop thru the array add up the numbers
				int currentNo = currentArray[j];
				sum += currentNo;
			}
			System.out.println("The sum of elements in this array is: " + sum);
		}
	}
}