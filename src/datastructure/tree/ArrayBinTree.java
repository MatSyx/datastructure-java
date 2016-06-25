package datastructure.tree;

public class ArrayBinTree<T> {
	
	private final int DEFAULT_DEEP = 8;
	private int deep;//深度
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
	
	//为指定节点添加子节点
	public void add(int index,T data,boolean isLeft){
		if(datas[index] ==null){
			throw new RuntimeException("此处元素为空");
		}
		if(isLeft && datas[2*index+1]!=null){
			throw new RuntimeException("左子元素已经存在");
		}
		if(!isLeft && datas[2*index+2]!=null){
			throw new RuntimeException("右子元素已经存在");
		}
		if(2 * index + 1 > arraySize){
			throw new RuntimeException("底层数组溢出");
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
	
	//返回指定节点的父节点(非根节点)
	public T parent(int index){
		return (T) datas[index-1 /2];
	}
	
	//反回指定节点的左子节点(非叶子节点)
	public T left(int index){
		if(2*index+1>arraySize){
			throw new RuntimeException("溢出");
		}
		return (T) datas[2*index+1];
	}
	
	//反回指定节点的右子节点(非叶子节点)
	public T right(int index){
		if(2*index+1>arraySize){
			throw new RuntimeException("溢出");
		}
		return (T) datas[2*index+2];
	}
	
	//返回树的深度
	public int deep(){
		return deep;
	}
	
	//返回指定节点的位置
	public int getIndex(T data){
		for (int i = 0; i < arraySize; i++) {
			if(datas[i].equals(data)){
				return i;
			}
		}
		return -1;
	}
}
