package WordCounter;
//Module 9 Glenney Tello 10/18/2022

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Glenney Tello
 * @version 5
 * @since 11/1/2022
 * Adding documentation to the most recent word counter to make it more user friendly
 * and to practice documenting in Java.
 * The import above was required for the following code to function.
 */

// 4th attempt at creating a functioning word analyzer/ counter 
public class WordCounterFive {

	  /**
	  * This method is for counting the number of words within a selected text file and 
	  * outputting the top 20 word occurrences/frequency.
	  * 
	  * @param args This is the main parameter for the WordCounterFour method
	  */

public static void main(String args[]) {
	//Providing desktop location of the text file to scan.
	/**
	*@param args Creation of String and Integer Values for the counter.
	*@returns top 20 word frequency via counter/"if" command to count and break command to end the loop. 
	*/
	Map<String, Integer> theRaven = poemMap("C:\\Users\\glenn\\OneDrive\\Desktop\\Homework\\Edgar.txt");
	//Creating List to pull entries from the poem
	List<Entry<String, Integer>> list = sortWords(theRaven);
	//Adding variable for future counter 
	var counter = 0;
	/**
	 * Setting counter to 0 and creating loop to read string
	 */
	for (Map.Entry<String, Integer> entry : list) {
	
	if (entry.getValue() > 0) {
	//Pulling values for output
		System.out.println(entry.getKey() + " : " + entry.getValue());
			}	
	/**
	 * Adding counter to only display top 20 results 
	 * and adding break to terminate the loop after top 20
	 */
	    ++counter;
	    if (counter == 20) {
	        break;
	// break used to terminate loop
	    	}
		}
	}

public static Map<String, Integer> poemMap(String Raven) {
	/**Creating Hash Map
	 * @param Raven Reads String and separates words based on punctuation marks and spaces.
	 * @return theRaven string/ integer hash map.
	 */
	Map<String, Integer> theRaven = new HashMap<>();
	//using File and data input streams instead of just file. Using buffer reader instead of scan.
	try (FileInputStream file = new FileInputStream(Raven);
	DataInputStream data = new DataInputStream(file);
	BufferedReader br = new BufferedReader(new InputStreamReader(data))) {
	/**
	 * Giving String no value instead of defined length
	 */
	String line = null;
	while ((line = br.readLine()) != null) {
	/**
	 * Making all words lowercase and adding a split method  
	 */
	String[] words = line.toLowerCase().split("[\\s.?;:,\"]+");
	/**
	 * "for" command used to help separate words and give a corresponding value.
	 * If only one recognized word is seen, it will default to displaying a 1 next to it.
	 */
	
	for (String word : words) {
		if (theRaven.containsKey(word)) {
			theRaven.put(word, (theRaven.get(word) + 1));} 
		else {
	theRaven.put(word, 1);
}}}} 
	//catching exceptions 
	catch (IOException a) {
	a.printStackTrace();
}
//close out reader
	return theRaven;
}

	
public static List<Entry<String, Integer>> sortWords(Map<String, Integer> theRaven) {
	/**
	 * List and Array made to help sort the number of occurrences
	 */
	Set <Entry<String, Integer>> entries = theRaven.entrySet();
	//Creating ArrayList 
	List<Entry<String, Integer>> list = new ArrayList<>(entries);
	//Sorting array from the highest word frequency to the least
	Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	//Comparing both Map.Entry<Strings,Integer> and returning the output 

public int compare(Map.Entry<String, Integer> one, Map.Entry<String, Integer> two) {
	/**
	 * Compare needed to display the proper output of word frequency
	 * @returns highest to lowest word frequency
	 */
	return (two.getValue()).compareTo(one.getValue());
}});
	return list;
}}
