package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import datastructure.tree.TreeParent.Node;

/**
 * 子节点链表示法。优点是获取子节点灵活，缺点是获取父节点麻烦要遍历整个树
 * @author Administrator
 *
 * @param <T>
 */
public class TreeChild<T> {
	
	private final int default_size = 100;
	private int nodeSize;
	//存放节点数组
	private Node[] nodes;
	//节点数
	private int size;
	
	public static class SonNode{
		//记录当前节点的位置
		int index;
		SonNode next;
		
	}
	public static class Node<T>{
		T data;
		//记录第一个子节点
		SonNode first; 
		SonNode last; 
	}
	
	public TreeChild(T data){
		nodeSize = default_size;
		nodes = new Node[nodeSize];
		nodes[0] = new Node<T>();
		nodes[0].data = data;
		nodes[0].first = null;
	}
	
	//为指定节点添加子节点
	public void addNode(T data,Node parent){
		for (int i = 0; i < nodeSize; i++) {
			if(nodes[i] == null){
				nodes[i] = new Node<T>();
				nodes[i].data = data;
				
				//尾插法
				SonNode oldLast = parent.last;
				parent.last = new SonNode();
				parent.last.index = i;
				
				if(parent.first == null){
					parent.first = parent.last;
				}else{
					oldLast.next = parent.last;
				}
				
				size++;
				return;
			}
		}
	}
	
	
	//返回指定节点的所有子节点(非叶子节点)
	public List<Node<T>> child(Node parentNode){
		List<Node<T>> list = new ArrayList<Node<T>>();
		for (SonNode current = parentNode.first; current!=null; current = current.next) {
			list.add(nodes[current.index]);
		}
		return list;
	}
	
	//返回指定节点的第i个子节点(非叶子节点)
	public Node<T> child(Node parentNode,int i){
		int count = 0;
		for (SonNode current = parentNode.first; current!=null; current = current.next,count++) {
			if(count == i){
				return nodes[current.index];
			}
		}
		return null;
	}
	
	//树的深度
	public int deep(){
		int max = 0;
		for (int i = 1; i < nodeSize; i++) {
			if(nodes[i]!=null){
				int num = 1;
				for (SonNode current = nodes[i].first; current!=null; current = current.next) {
					num++;
				}
				if(max < num){
					max = num;
				}
			}
		}
		return max;
	}
	
	public Node getRoot(){
		return nodes[0];
	}
	
}
