package assignment_1;

import assignment_1.MyDList;

public class Snippet{
	 public static void main(String[] args) throws Exception{
	 
	   System.out.println("please type some strings, one string each line and an empty line for the end of input:");
	    /** Create the first doubly linked list
	    by reading all the strings from the standard input. */
	   MyDList firstList = new MyDList("stdin");
	    
	   /** Print all elememts in firstList */
	   firstList.printList();
	   
	   /** Create the second doubly linked list                         
	    by reading all the strings from the file myfile that contains some strings. */

	   /** Replace the argument by the full path name of the text file */  
	   MyDList secondList=new MyDList("src//assignment_1//myfile.txt");
	
	   /** Print all elememts in secondList */                     
	   secondList.printList();
	
	   /** Clone firstList */
	   MyDList thirdList = MyDList.cloneList(firstList);
	
	   /** Print all elements in thirdList. */
	   thirdList.printList();
	
	   /** Clone secondList */
	   MyDList fourthList = MyDList.cloneList(secondList);
	
	   /** Print all elements in fourthList. */
	   fourthList.printList();
	    
	   /** Compute the union of firstList and secondList */
	   MyDList fifthList = MyDList.union(firstList, secondList);
	
	   /** Print all elements in thirdList. */ 
	   fifthList.printList(); 
	   
	   /** Compute the intersection of thirdList and fourthList */
	   MyDList sixthList = MyDList.intersection(thirdList, fourthList);
	
	   /** Print all elements in fourthList. */
	   sixthList.printList();
	  }
}

/*
String input = "";
try{
	FileReader reader = new FileReader(f);
	BufferedReader in = new BufferedReader(reader);
	input = in.readLine();
	while(input != null){
		System.out.print(input);
		input = in.readLine();
	}
	in.close();
} catch (IOException e){
	header = new DNode(f, null, null);
	trailer = new DNode(null, header, null);
	header.setNext(trailer);
	size = 1;
}
*/