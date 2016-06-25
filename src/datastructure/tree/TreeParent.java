package datastructure.tree;

import java.util.ArrayList;
import java.util.List;
/**
 * ���ױ�ʾ��.ÿ���ڵ㶼�����⸸�ڵ��������ȱ����ÿ�β�ѯ����ӽڵ㶼Ҫ����һ����������
 * @author Administrator
 *
 * @param <T>
 */
public class TreeParent<T> {
	
	private final int default_size = 100;
	private int nodeSize;
	//��Žڵ�����
	private Node[] nodes;
	//�ڵ���
	private int size;
	
	public static class Node<T>{
		T data;
		//���ڵ��±��ַ
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
		
	//Ϊָ���ڵ�����ӽڵ�
	public void addNode(T data,Node<T> parentNode){
		//�ҵ�����Ϊ�յĵط��������
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
	
	//�����������
	public int deep(){
		int max = 0;
		for (int i = 0; i < nodeSize && nodes[i]!=null; i++) {
			int def = 1;
			int m = nodes[i].parent;
			//������ڵ����
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
	
	//����ָ���ڵ�ĸ��ڵ�(�Ǹ��ڵ�)
	public Node<T> parent(Node<T> childNode){
		return nodes[childNode.parent];
	}
	
	//����ָ���ڵ�������ӽڵ�(��Ҷ�ӽڵ�)
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
