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
	
	//Ϊָ���ڵ�����ӽڵ�
	public TreeNode add(TreeNode node,T data,boolean isLeft){
		if(isLeft && node.left!=null){
			throw new RuntimeException("���ӽڵ��Ѵ���"); 
		}
		if(!isLeft && node.right!=null){
			throw new RuntimeException("���ӽڵ��Ѵ���"); 
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
	
	//����ָ���ڵ�ĸ��ڵ�(�Ǹ��ڵ�)
	public T parent(TreeNode child){
		return (T) child.parent.data;
	}
	
	//����ָ���ڵ�����ӽڵ�(��Ҷ�ӽڵ�)
	public T leftNode(TreeNode parent){
		return (T) parent.left.data;
	}
	
	//����ָ���ڵ�����ӽڵ�(��Ҷ�ӽڵ�)
	public T rightNode(TreeNode parent){
		return (T) parent.right.data;
	}
	
	//�������
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
	
	//������ȱ���-ǰ�����
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
	
	//������ȱ���
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
