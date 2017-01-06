package net.datastructures;

import net.datastructures.AVLTree;
import net.datastructures.BTPosition;
import net.datastructures.Entry;

public class ExtendedAVLTree<K, V> extends AVLTree{

	
	/**
	 * Q1: This class method creates an identical copy of the AVL tree specified by the parameter
	 * and returns a reference to the new AVL tree.

	 * @param tree
	 * @return
	 */
	public static <K, V> AVLTree<K, V> clone(AVLTree<K, V> tree){
		AVLTree<K, V> newTree = new AVLTree<K, V>();
		newTree.insert(tree.root.element().getKey(), tree.root.element().getValue());
		cloneSubtrees(tree.root, newTree.root);
		newTree.size = tree.size();
		return newTree;
	}
	
	/**
	 * 
	 * @param originalNode
	 * @param clonedNode
	 */
	private static <K, V> void cloneSubtrees(BTPosition<Entry<K,V>> originalNode, 
			BTPosition<Entry<K,V>> newNode){
		
		AVLNode<K, V> leftChild = new AVLNode<K, V>();
		AVLNode<K, V> rightChild = new AVLNode<K, V>();
		
		// linked the left child with the newNode
		newNode.setLeft(leftChild);
		leftChild.setParent(newNode);
		
		// linked the right child with the newNode
		newNode.setRight(rightChild);
		rightChild.setParent(newNode);
		
		// if there is a left child of original node, copy the element to the new leftChild
		// and clone left child from original node to leftChild
		if (originalNode.getLeft().element() != null){
			leftChild.setElement(originalNode.getLeft().element());
			cloneSubtrees(originalNode.getLeft(), leftChild);
		}
		
		
		// if there is a right child of original node, copy the element to the new rightChild
		// and clone right child from original node to rightChild
		if (originalNode.getRight().element() != null){
			rightChild.setElement(originalNode.getLeft().element());
			cloneSubtrees(originalNode.getRight(), leftChild);
		}	
	}
	
	/**
	 * Q2:
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public static <K, V> AVLTree<K, V> merge(AVLTree<K,V> tree1,
			AVLTree<K,V> tree2 ){
		AVLTree<K, V> mergedTree = new AVLTree<K, V>();
        
        
        // Transferred tree1 and tree2 into 2 sorted lists
        PositionList<Position<Entry<K,V>>> mergedList = new NodePositionList<Position<Entry<K,V>>>();
        PositionList<Position<Entry<K,V>>> PList_1 = new NodePositionList<Position<Entry<K,V>>>();
        PositionList<Position<Entry<K,V>>> Plist_2 = new NodePositionList<Position<Entry<K,V>>>();
        // Creates a list storing the the nodes in the subtree of a node, ordered according to the in-order traversal of the subtree(LinkedBinaryTree.java)
        tree1.inorderPositions(tree1.root(), Plist_1);
        tree2.inorderPositions(tree2.root(), Plist_2);
        
        // Merge 2 listed lists
        while(!Plist_1.isEmpty() && !Plist_2.isEmpty()){
        	Plist_1
        }
        
		return mergedTree;
	}
	
	public static <K, V> void print(AVLTree<K, V> tree){
		
	}
}
