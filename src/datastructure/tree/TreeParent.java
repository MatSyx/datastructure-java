package datastructure.tree;

import java.util.ArrayList;
import java.util.List;
/**
 * 父亲表示法.每个节点都包含这父节点的索引。缺点是每次查询获得子节点都要遍历一遍整个数组
 * @author Administrator
 *
 * @param <T>
 */
public class TreeParent<T> {
	
	private final int default_size = 100;
	private int nodeSize;
	//存放节点数组
	private Node[] nodes;
	//节点数
	private int size;
	
	public static class Node<T>{
		T data;
		//父节点下标地址
		int parent;
		public Node(T data,int parent){
			this.data = data;
			this.parent = parent;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", parent=" + parent + "]";
		}
		
	}
	
	public TreeParent(T data){
		nodeSize = default_size;
		nodes = new Node[nodeSize];
		nodes[0] = new Node<T>(data,-1);
	}
		
	//为指定节点添加子节点
	public void addNode(T data,Node<T> parentNode){
		//找到数组为空的地方添加数据
		for (int i = 0; i < nodeSize; i++) {
			if(nodes[i] == null){
				nodes[i] = new Node<T>(data, getIndexByNode(parentNode));
				size++;
				return;
			}
		}
	}
	
	public boolean isEmpty(){
		return size<=0;
	}
	
	public int length(){
		return size;
	}
	
	public Node<T> getRoot(){
		return nodes[0];
	}
	
	//返回树的深度
	public int deep(){
		int max = 0;
		for (int i = 0; i < nodeSize && nodes[i]!=null; i++) {
			int def = 1;
			int m = nodes[i].parent;
			//如果父节点存在
			while (m!=-1 && nodes[m]!=null) {
				m = nodes[m].parent;
				def++;
			}
			if(max < def){
				max = def;
			}
		}
		return max;
	}
	
	//返回指定节点的父节点(非根节点)
	public Node<T> parent(Node<T> childNode){
		return nodes[childNode.parent];
	}
	
	//返回指定节点的所有子节点(非叶子节点)
	public List<Node<T>> child(Node parentNode){
		List<Node<T>> list = new ArrayList<Node<T>>();
		for (int i = 0; i <= size; i++) {
			if(nodes[i].parent == getIndexByNode(parentNode)){
				list.add(nodes[i]);
			}
		}
		return list;
	}
	
	public int getIndexByNode(Node node){
		for (int i = 0; i < nodeSize; i++) {
			if(nodes[i] == node){
				return i;
			}
		}
		return -1;
	}
}
