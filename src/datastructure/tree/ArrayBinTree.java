package datastructure.tree;

public class ArrayBinTree<T> {
	
	private final int DEFAULT_DEEP = 8;
	private int deep;//���
	private int arraySize;
	private Object[] datas;
	
	public ArrayBinTree(){
		this.deep = DEFAULT_DEEP;
		this.arraySize = (int) Math.pow(2, deep)-1;
		datas = new Object[arraySize];
	}
	
	public ArrayBinTree(T data){
		this.deep = DEFAULT_DEEP;
		this.arraySize = (int) Math.pow(2, deep)-1;
		datas = new Object[arraySize];
		datas[0] = data;
	}
	
	public ArrayBinTree(int deep,T data){
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, this.deep)-1;
		datas = new Object[arraySize];
		datas[0] = data;
	}
	
	//Ϊָ���ڵ�����ӽڵ�
	public void add(int index,T data,boolean isLeft){
		if(datas[index] ==null){
			throw new RuntimeException("�˴�Ԫ��Ϊ��");
		}
		if(isLeft && datas[2*index+1]!=null){
			throw new RuntimeException("����Ԫ���Ѿ�����");
		}
		if(!isLeft && datas[2*index+2]!=null){
			throw new RuntimeException("����Ԫ���Ѿ�����");
		}
		if(2 * index + 1 > arraySize){
			throw new RuntimeException("�ײ��������");
		}
		if(isLeft){
			datas[2 * index+1] = data;
		}else{
			datas[2 * index+2] = data;
		}
	}
	
	public boolean isEmpty(){
		return datas[0]==null;
	}
	
	public T getRoot(){
		return (T) datas[0];
	}
	
	//����ָ���ڵ�ĸ��ڵ�(�Ǹ��ڵ�)
	public T parent(int index){
		return (T) datas[index-1 /2];
	}
	
	//����ָ���ڵ�����ӽڵ�(��Ҷ�ӽڵ�)
	public T left(int index){
		if(2*index+1>arraySize){
			throw new RuntimeException("���");
		}
		return (T) datas[2*index+1];
	}
	
	//����ָ���ڵ�����ӽڵ�(��Ҷ�ӽڵ�)
	public T right(int index){
		if(2*index+1>arraySize){
			throw new RuntimeException("���");
		}
		return (T) datas[2*index+2];
	}
	
	//�����������
	public int deep(){
		return deep;
	}
	
	//����ָ���ڵ��λ��
	public int getIndex(T data){
		for (int i = 0; i < arraySize; i++) {
			if(datas[i].equals(data)){
				return i;
			}
		}
		return -1;
	}
}
