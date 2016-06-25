package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import datastructure.tree.TreeParent.Node;

/**
 * �ӽڵ�����ʾ�����ŵ��ǻ�ȡ�ӽڵ���ȱ���ǻ�ȡ���ڵ��鷳Ҫ����������
 * @author Administrator
 *
 * @param <T>
 */
public class TreeChild<T> {
	
	private final int default_size = 100;
	private int nodeSize;
	//��Žڵ�����
	private Node[] nodes;
	//�ڵ���
	private int size;
	
	public static class SonNode{
		//��¼��ǰ�ڵ��λ��
		int index;
		SonNode next;
		
	}
	public static class Node<T>{
		T data;
		//��¼��һ���ӽڵ�
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
	
	//Ϊָ���ڵ�����ӽڵ�
	public void addNode(T data,Node parent){
		for (int i = 0; i < nodeSize; i++) {
			if(nodes[i] == null){
				nodes[i] = new Node<T>();
				nodes[i].data = data;
				
				//β�巨
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
	
	
	//����ָ���ڵ�������ӽڵ�(��Ҷ�ӽڵ�)
	public List<Node<T>> child(Node parentNode){
		List<Node<T>> list = new ArrayList<Node<T>>();
		for (SonNode current = parentNode.first; current!=null; current = current.next) {
			list.add(nodes[current.index]);
		}
		return list;
	}
	
	//����ָ���ڵ�ĵ�i���ӽڵ�(��Ҷ�ӽڵ�)
	public Node<T> child(Node parentNode,int i){
		int count = 0;
		for (SonNode current = parentNode.first; current!=null; current = current.next,count++) {
			if(count == i){
				return nodes[current.index];
			}
		}
		return null;
	}
	
	//�������
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
