package datastructure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SortedBinTree<T> {
	
	public static class Node{
		Object data;
		Node parent;
		Node left;
		Node right;
		public Node(Object data,Node parent,Node left,Node right){
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	}
	
	public Node root;
	public int nodeSize;
	
	public SortedBinTree(T data){
		root = new Node(data, null, null, null);
		nodeSize++;
	}
	
	public void add(T data){
		Node current = root;
		Node parent = null;
		//�����ж��ҵ���λ������߻����ұ�
		int i = 0;
		while (current!=null) {
			parent = current;
			i =  data.toString().compareTo((String) current.data);
			if(i>0){
				current = current.right;
			}else{
				current = current.left;
			}
		}
		Node newnode = new Node(data, parent, null, null);
		if(i>0){
			parent.right = newnode;
		}else{
			parent.left = newnode;
		}
	}
	
	public void remove(T data){
		Node target = getNode(data);
		//���ɾ���Ľڵ�û�����ҽڵ㡣
		if(target.left==null && target.right==null){
			//����Ǹ��ڵ�
			if(target == root){
				root = null;
			}
			//���ɾ���Ľڵ��ڸ��ڵ�����
			if(target.parent.left == target){
				//ɾ����ڵ�
				target.parent.left = null;
			}else{
				//ɾ���ҽڵ�
				target.parent.right = null;
			}
			target.parent = null;
		}
		//���ɾ���Ľڵ�����ڵ�û���ҽڵ㡣
		else if(target.left!=null && target.right==null){
			//����Ǹ��ڵ�
			if(target == root){
				root = target.left;
			}
			//���ɾ���Ľڵ��ڸ��ڵ�����
			if(target.parent.left == target){
				//ɾ����ڵ�
				target.parent.left = target.left;
			}else{
				//ɾ���ҽڵ�
				target.parent.right = target.right;
			}
			//�޸��滻�ڵ�ĸ��ڵ�
			target.left.parent = target.parent;
		}
		//���ɾ���Ľڵ�û����ڵ����ҽڵ㡣
		else if(target.left==null && target.right!=null){
			//����Ǹ��ڵ�
			if(target == root){
				root = target.right;
			}
			//���ɾ���Ľڵ��ڸ��ڵ�����
			if(target.parent.left == target){
				//ɾ����ڵ�(Ŀ��ڵ���ҽڵ����!)
				target.parent.left = target.right;
			}else{
				//ɾ���ҽڵ�(Ŀ��ڵ���ҽڵ����!)
				target.parent.right = target.right;
			}
			//�޸��滻�ڵ�ĸ��ڵ�
			target.right.parent = target.parent;
		}
		//���ɾ���Ľڵ����ҽڵ㶼����.
		else{
			if(target == root){
				target.left = root.left;
				target.left = root.right;
				root = target.left;
			}else{
				//��ȡ���������ڵ�
				Node leftMaxNode = target.left;
				if(leftMaxNode.right!=null){
					leftMaxNode = leftMaxNode.right;
				}
				if(target.parent.left == target){
					target.parent.left = target.left;
				}
				if(target.parent.right == target){
					target.parent.right = target.left;
				}
				leftMaxNode.right = target.right;
				target.right.parent = leftMaxNode;
			}
		}
	}
	
	public Node getNode(T data){
		Node current = root;
		while (current!=null) {
			int i =  data.toString().compareTo((String) current.data);
			if(i>0){
				current = current.right;
			}else if(i<0){
				current = current.left;
			}else{
				return current;
			}
		}
		return null;
	}
	
	public List<Node> inIterator(){
		return inIterator(root);
	}
	
	public List<Node> inIterator(Node node){
		List<Node> list = new ArrayList<Node>();
		if(node.left!=null){
			list.addAll(inIterator(node.left));
		}
		list.add(node);
		if(node.right!=null){
			list.addAll(inIterator(node.right));
		}
		return list;
	}
	
	public List<Node> breadthFirst(){
		List<Node> list = new ArrayList<SortedBinTree.Node>();
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			list.add(queue.peek());
			//����
			Node pollNode = queue.poll();
			if(pollNode.left!=null){
				queue.add(pollNode.left);
			}
			if(pollNode.right!=null){
				queue.add(pollNode.right);
			}
		}
		return list;
	}
}
