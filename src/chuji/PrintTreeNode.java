package chuji;

import java.util.Stack;

/**
 * 打印二叉树
 * @author Watcher
 *
 */
public class PrintTreeNode {

	/**
	 * 递归版先序遍历
	 * @param root
	 */
	public void preOrder(TreeNode root){
		if(root==null)
			return;
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	/**
	 * 递归版中序遍历
	 * @param root
	 */
	public void inOrder(TreeNode root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}
	
	/**
	 * 递归版后序遍历
	 * @param root
	 */
	public void posOrder(TreeNode root){
		if(root==null)
			return;
		posOrder(root.left);
		posOrder(root.right);
		System.out.println(root.val);
	}

	
	/**
	 * 非递归版先序遍历
	 * @param root
	 */
	public void preOrderUnrec(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.pop();
			System.out.println(root.val);
			if(root.right!=null)
				stack.push(root.left);
			if(root.left!=null)
				stack.push(root.right);
		}
	}
	
	/**
	 * 非递归版中序遍历
	 * @param root
	 */
	public void inOrderUnrec(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty()||root!=null){
			if(root!=null){
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				System.out.println(root.val);
				root = root.right;
			}
		}
	}
	
	
	/**
	 * 非递归版后序遍历
	 * @param root
	 */
	public void posOrderUnrec(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		while(!stack1.isEmpty()){
			root = stack1.pop();
			stack2.push(root);
			if(root.left!=null)
				stack1.push(root.left);
			if(root.right!=null)
				stack1.push(root.right);
		}
		while(!stack2.isEmpty())
			System.out.println(stack2.pop().val);
	}
	
	
	
	
}
