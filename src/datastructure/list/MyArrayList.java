package datastructure.list;

import java.util.Arrays;

public class MyArrayList<T> {
	
	//Ĭ�ϵײ����鳤��
	private int defaultArraySite = 50;
	
	//�ײ�����
	private Object[] array;
	
	//���Ա���
	private int site;
	
	public MyArrayList(){
		array = new Object[defaultArraySite];
	}
	
	public MyArrayList(int arratSite){
		array = new Object[arratSite];
	}
	
	public void insert(int index,T data){
		
		//��֤�ײ㳤�ȳ���
		expand();
		
		if(index > site){
			throw new ArrayIndexOutOfBoundsException("�±�Խ��");
		}
		//����ƶ�
		for (int i = site; i > index; i--) {
			array[i+1] = array[i];
		}
		array[index] = data;
		site++;
	}
	
	public void add(T data){
		insert(site,data);
	}
	
	public void delete(int index){
		if(index >= site){
			throw new ArrayIndexOutOfBoundsException("�±�Խ��");
		}
		for (int i = index; i <= site; i++) {
			array[i] = array[i+1];
		}
	}
	
	public int length(){
		return site;
	}
	
	//����
	public void expand(){
		//��ȡ�ײ����鳤��
		int current = array.length;
		if(site == current-1){
			Object[] newarray = Arrays.copyOf(array, current*2);
			array = newarray;
		}
	}
	
	public T get(int index){
		if(index >= site){
			throw new ArrayIndexOutOfBoundsException("�±�Խ��");
		}
		return (T) array[index];
	}

	@Override
	public String toString() {
		return "MyArrayList [array=" + Arrays.toString(array) + "]";
	}
	
	
}
