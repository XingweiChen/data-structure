package assignment_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyDList extends DList{
	
	/**
	 * 
	 */
	public MyDList(){
		super();
	}
	
	/**
	 * If f is a String of filename, then Scan the file, initialize the Double Linked with these
	 * Strings, else if f is a String then initialize the Double Linked list with this String.
	 * The complexity is O(n)
	 * @param f String
	 * @throws FileNotFoundException
	 */
	public MyDList(String f) throws FileNotFoundException{
		header = new DNode(f, null, null);
		trailer = new DNode(null, header, null);
		header.setNext(trailer);
		size = 1;
		File file = new File(f);
		if(file.exists()){
			Scanner input = new Scanner(new FileInputStream("src\\assignment_1\\myfile.txt"));
			if(input.hasNext()){
				header.setElement(input.next());
				DNode current_node = header;
				while(input.hasNext()){
					current_node.setNext(new DNode(input.next(), null, null));
					current_node.getNext().setPrev(current_node);
					current_node = current_node.getNext();
					size++;
				}
				trailer.setPrev(current_node);
				current_node.setNext(trailer);
			}
			input.close();
		}
	}
	
	/**
	 * This function is used to outprint the List and use ' -> ' as interval.
	 * The complexity is O(n)
	 */
	public void printList(){
		DNode current_node = header;
		if(current_node.getElement() == null)
			System.out.println("This is an empty list!");
		else{
			System.out.print(current_node.getElement());
			while(current_node.getNext().getElement() != null){
				current_node = current_node.getNext();
				System.out.print(" -> " + current_node.getElement());
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param u The Double Linked List for clone.
	 * @return
	 */
	public static MyDList cloneList(MyDList u){
		MyDList newList = new MyDList();
		if (u.isEmpty())
			return newList;
		else{
			DNode current_node = u.header;
			DNode newNode = new DNode(current_node.getElement(), null, null);
			newList.header = newNode;
			while(current_node.getNext().getElement() != null){
				current_node = current_node.getNext();
				newNode.setNext(new DNode(current_node.getElement(), newNode, null));
				newNode = newNode.getNext();
			}
			DNode newTrailer = new DNode(null, newNode, null);
			newNode.setNext(newTrailer);
		}
		newList.size = u.size;
		return newList;
		
	}
	
	public static MyDList union(MyDList u, MyDList v){
		if(u.isEmpty())
			return v;
		else if(v.isEmpty())
			return u;
		else{
			DNode current_node = u.header;
			while(current_node.getNext().getElement() != null){
				current_node = current_node.getNext();
			}
			current_node.setNext(v.header);
			while(current_node.getNext().getElement() != null){
				current_node = current_node.getNext();
				u.size++;
			}
			u.trailer.setPrev(current_node);
			current_node.setNext(u.trailer);
			return u;
		}
	}
	
	public static MyDList intersection(MyDList u, MyDList v){
		if(u.isEmpty()){
			return u;}
		else if(v.isEmpty())
			return v;
		else{
			MyDList newList = new MyDList();
			DNode new_node = newList.header;
			DNode current_node = u.header;
			while(current_node.getElement() != null){
				boolean flag = false;
				DNode v_cnode = v.header;
				while(v_cnode.getElement() != null){
					if(v_cnode.getElement() == current_node.getElement()){
						flag = true;
						break;
					}
					v_cnode = v_cnode.getNext();
				}
				if(flag){
					if (new_node.getElement() == null){
						new_node = new DNode(current_node.getElement(), null, null);
						newList.header = new_node;
					}
					new_node.setNext(new DNode(current_node.getElement(), null, null));
					new_node.getNext().setPrev(new_node);
					new_node = new_node.getNext();
				}
				current_node = current_node.getNext();
			}
			return newList;
		}
	}
}
