package datastructure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LinkedBinTree<T> {
	
	private TreeNode root;
	private int size;
	public static class TreeNode{
		Object data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		public TreeNode(Object data){
			this.data = data;
		}
	}
	
	public LinkedBinTree(T data){
		this.root = new TreeNode(data);
		size++;
	}
	
	//为指定节点添加子节点
	public TreeNode add(TreeNode node,T data,boolean isLeft){
		if(isLeft && node.left!=null){
			throw new RuntimeException("左子节点已存在"); 
		}
		if(!isLeft && node.right!=null){
			throw new RuntimeException("右子节点已存在"); 
		}
		TreeNode newnode = new TreeNode(data);
		newnode.parent = node;
		if(isLeft){
			node.left = newnode;
		}else{
			node.right = newnode;
		}
		size++;
		return newnode;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public TreeNode getRoot(){
		return root;
	}
	
	//返回指定节点的父节点(非根节点)
	public T parent(TreeNode child){
		return (T) child.parent.data;
	}
	
	//返回指定节点的左子节点(非叶子节点)
	public T leftNode(TreeNode parent){
		return (T) parent.left.data;
	}
	
	//返回指定节点的右子节点(非叶子节点)
	public T rightNode(TreeNode parent){
		return (T) parent.right.data;
	}
	
	//返回深度
	public int deep(){
		return deep(root);
	}

	private int deep(TreeNode node) {
		if(node==null){
			return 0;
		}
		if(node.left==null && node.right==null){
			return 1;
		}
		else{
			int leftdeep = deep(node.left);
			int rightdeep = deep(node.right);
			int max = leftdeep > rightdeep ? leftdeep : rightdeep;
			return max+1;
		}
	}
	
	//深度优先遍历-前序遍历
	public List<TreeNode> perIterator(){
		return perIterator(root);
	}
	
	public List<TreeNode> perIterator(TreeNode node){
		List<TreeNode> list = new ArrayList<LinkedBinTree.TreeNode>();
		list.add(node);
		if(node.left!=null){
			list.addAll(perIterator(node.left));
		}
		if(node.right!=null){
			list.addAll(perIterator(node.right));
		}
		return list;
	}
	
	public List<TreeNode> breadthFirst(){
		return breadthFirst(root);
	}
	
	//广度优先遍历
	public List<TreeNode> breadthFirst(TreeNode node){
		List<TreeNode> list = new ArrayList<LinkedBinTree.TreeNode>();
		Queue<TreeNode> queue = new ArrayDeque<LinkedBinTree.TreeNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			list.add(queue.peek());
			TreeNode treenode = queue.poll();
			if(treenode.left !=null){
				queue.add(treenode.left);
			}
			if(treenode.right !=null){
				queue.add(treenode.right);
			}
		}
		return list;
	}
}
