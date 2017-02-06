package LeetCode.Array;

import java.util.HashMap;

public class Construct_Binary_Tree_In_Pre_Traversal {
	//Definition for a binary tree node.
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	 
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(inorder == null || preorder == null || inorder.length != preorder.length)
			return null;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++){
			map.put(inorder[i], i);
		}
		return buildTreePostIn(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);      
	}
	
	private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] preorder, int ps, int pe, 
            HashMap<Integer,Integer> map){
		if (ps > pe || is > ie) 
			return null;
		int element = preorder[ps];
		int index = map.get(element);
		TreeNode root = new TreeNode(element);
		root.left = buildTreePostIn(inorder, is, index - 1, preorder, ps + 1, pe, map);
		// 左侧子树所有子节点的个数index - is, 加上当前这个root节点 + 1
		root.right = buildTreePostIn(inorder, index + 1, ie, preorder, ps + index - is + 1, pe, map);
		return root;
	}
	
	public static void main(String[] args){
		int[] inorder = {1,2,3};
		int[] preorder = {1,2,3};
		Construct_Binary_Tree_In_Pre_Traversal test = new Construct_Binary_Tree_In_Pre_Traversal();
		TreeNode t = test.buildTree(inorder, preorder);
		System.out.println(t);
	}
}
