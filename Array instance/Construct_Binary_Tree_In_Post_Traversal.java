package LeetCode.Array;

import java.util.HashMap;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * 		You may assume that duplicates do not exist in the tree.
 * 
 * @author Xingwei Chen
 */
public class Construct_Binary_Tree_In_Post_Traversal {
	 //Definition for a binary tree node.
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
			if (inorder == null || postorder == null || inorder.length != postorder.length)
				return null;
			// 用于快速查找,postorder最后一个元素pe在inorder中的索引
			HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
			for (int i=0;i<inorder.length;++i)
				map.put(inorder[i], i);
			return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
		                          postorder.length-1,map);
		}
	 	/**
	 	 * 
	 	 * @param inorder
	 	 * @param is		the start index of inorder
	 	 * @param ie		the end index of inorder
	 	 * @param postorder	
	 	 * @param ps	the start of postorder
	 	 * @param pe	the end of postorder
	 	 * @param hm
	 	 */
		private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
		                                 HashMap<Integer,Integer> map){
			if (ps>pe || is>ie) return null;
			TreeNode root = new TreeNode(postorder[pe]);
			int ri = map.get(postorder[pe]);
			// postorder的最后一个元素pe是这个子树的根节点, 因此在inorder中, pe左侧属于左子树, pe右侧属于右子树
			TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, map);
			TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, map);
			root.left = leftchild;
			root.right = rightchild;
			return root;
		}
}
