package sample;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JFileChooser;

/*
Problem:
Read words from a text file and print out the words and their count in descending order by count.

Steps to attempt:
1. read from a text file by word
2. save every word into a hashmap and increment their count by 1
3. sort the hashmap by count value in descending order
4. print out the sorted hashmap
*/

public class WordCount {

	public static void main(String[] args) throws Exception {
		
		//created a hashmap that takes a string(word) and integer(counter)
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//creates a file chooser to allow finding and selecting a file
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			//Get the selected file
			java.io.File file = fileChooser.getSelectedFile();
			Scanner sc = new Scanner(file);
			
			//while the text file has a next line, continue to read from file
		    while(sc.hasNextLine()) {
		    	//get the nextLine() and also set all words to lowercase to easier find all similar words ("Hello" and "hello" should match as "hello")
		    	Scanner sc2 = new Scanner(sc.nextLine().toLowerCase());
		    	//while there is a next word, increase counter by 1
		    	while(sc2.hasNext()) {
		    		//use a delimiter to remove symbols from words ("hello" and "hello." should match as "hello")
		    		((Scanner)sc2).useDelimiter("\\W+");
		    		incrementValue(map, sc2.next());
		    	}
				sc2.close();	
		    }
			sc.close();
			
			//sort hashmap by descending order
			HashMap<String, Integer> map2 = sortByValue(map); 
			  
	        //print the sorted hashmap in a table
			System.out.printf("%-15s %15s %n", "WORD", "COUNT");
			for(Map.Entry<String, Integer> sortedMap : map2.entrySet()) {
				System.out.println("--------------------------------------");
				System.out.printf("%-15s %15s %n", sortedMap.getKey(), sortedMap.getValue());
	        }
		}
		else{
			System.out.println("No file selected");
		}

		
	}

	
	//increment counter by 1 if found in hashmap
	public static<K> void incrementValue(Map<K,Integer> map, K key) {
		Integer count = map.containsKey(key) ? map.get(key) : 0;
		map.put(key, ++count);
	}
	
	
	//sort hashmap by value in descending order and return the new hashmap
	public static HashMap<String, Integer> sortByValue(Map<String, Integer> map) { 
        //create a list from elements of HashMap 
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet()); 
  
        //sort the list in descending order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() { 
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
            	//can swap o2 and o1 to sort in ascending order if you want
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        //put data from sorted list to new hashmap  
        HashMap<String, Integer> newMap = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> temp : list) { 
        	newMap.put(temp.getKey(), temp.getValue()); 
        } 
        return newMap; 
    } 
	
}
