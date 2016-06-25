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
		//用于判断找到的位置在左边还是右边
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
		//如果删除的节点没有左右节点。
		if(target.left==null && target.right==null){
			//如果是根节点
			if(target == root){
				root = null;
			}
			//如果删除的节点在父节点的左边
			if(target.parent.left == target){
				//删除左节点
				target.parent.left = null;
			}else{
				//删除右节点
				target.parent.right = null;
			}
			target.parent = null;
		}
		//如果删除的节点有左节点没有右节点。
		else if(target.left!=null && target.right==null){
			//如果是根节点
			if(target == root){
				root = target.left;
			}
			//如果删除的节点在父节点的左边
			if(target.parent.left == target){
				//删除左节点
				target.parent.left = target.left;
			}else{
				//删除右节点
				target.parent.right = target.right;
			}
			//修改替换节点的父节点
			target.left.parent = target.parent;
		}
		//如果删除的节点没有左节点有右节点。
		else if(target.left==null && target.right!=null){
			//如果是根节点
			if(target == root){
				root = target.right;
			}
			//如果删除的节点在父节点的左边
			if(target.parent.left == target){
				//删除左节点(目标节点的右节点代替!)
				target.parent.left = target.right;
			}else{
				//删除右节点(目标节点的右节点代替!)
				target.parent.right = target.right;
			}
			//修改替换节点的父节点
			target.right.parent = target.parent;
		}
		//如果删除的节点左右节点都存在.
		else{
			if(target == root){
				target.left = root.left;
				target.left = root.right;
				root = target.left;
			}else{
				//获取左子树最大节点
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
			//弹出
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
