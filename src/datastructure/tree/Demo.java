package datastructure.tree;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import datastructure.tree.LinkedBinTree.TreeNode;
import datastructure.tree.TreeParent.Node;

public class Demo {
	public static void main(String[] args) {
		/**
		 * 父亲表示法.每个节点都包含这父节点的索引。缺点是每次查询获得子节点都要遍历一遍整个数组
		 */
//		TreeParent<String> tree = new TreeParent<String>("A");
//		tree.addNode("B", tree.getRoot());
//		tree.addNode("C", tree.getRoot());
//		tree.addNode("D", tree.getRoot());
//		
//		List<Node<String>> list = tree.child(tree.getRoot());
//		for (Node<String> node : list) {
//			System.out.println("A --> "+node.data);
//		}
//		
//		tree.addNode("E", list.get(0));
//		tree.addNode("F", list.get(2));
//		tree.addNode("G", list.get(2));
//		
//		List<Node<String>> list1 = tree.child(list.get(0));
//		for (Node<String> node : list1) {
//			System.out.println("B --> "+node.data);
//		}
//		
//		
//		List<Node<String>> list2 = tree.child(list.get(2));
//		for (Node<String> node : list2) {
//			System.out.println("C --> "+node.data);
//		}
//		
//		tree.addNode("K", list2.get(1));
//		
//		List<Node<String>> list3 = tree.child(list2.get(1));
//		for (Node<String> node : list3) {
//			System.out.println("G --> "+node.data);
//		}
//		
//		System.out.println(tree.deep());
		
		/**
		 * 子节点链表示法。优点是获取子节点灵活，缺点是获取父节点麻烦要遍历整个树
		 */
//		TreeChild<String> tree = new TreeChild<String>("A");
//		tree.addNode("B", tree.getRoot());
//		tree.addNode("C", tree.getRoot());
//		tree.addNode("D", tree.getRoot());
//		tree.addNode("E", tree.getRoot());
//		List<datastructure.tree.TreeChild.Node<String>> list = tree.child(tree.getRoot());
//		for (datastructure.tree.TreeChild.Node<String> node : list) {
//			System.out.println(node.data);
//		}
//		
//		tree.addNode("F", list.get(0));
//		tree.addNode("G", list.get(0));
//		
//		List<datastructure.tree.TreeChild.Node<String>> list1 = tree.child(list.get(0));
//		for (datastructure.tree.TreeChild.Node<String> node : list1) {
//			System.out.println(node.data);
//		}
//		
//		System.out.println("获取指定节点的第i个子节点:"+tree.child(tree.getRoot(), 3).data);
//		System.out.println("深度:"+tree.deep());
		
		/**
		 * 顺序二叉树，缺点浪费空间。优点是方便操作。
		 * 底层使用数组保存数据
		 */
//		ArrayBinTree<String> arrayBinTree = new ArrayBinTree<String>("A");
//		arrayBinTree.add(0, "B", true);
//		arrayBinTree.add(0, "C", false);
//	    int	b = arrayBinTree.getIndex("B");
//		arrayBinTree.add(b, "D", true);
//		arrayBinTree.add(b, "E", false);
//		System.out.println(arrayBinTree.left(0));
//		System.out.println(arrayBinTree.right(0));
//		System.out.println(arrayBinTree.left(b));
//		System.out.println(arrayBinTree.right(b));
//		System.out.println(arrayBinTree.deep());
		
		/**
		 * 三叉二叉树
		 */
//		LinkedBinTree<String> linkedBinTree = new LinkedBinTree<String>("A");
//		LinkedBinTree.TreeNode b = linkedBinTree.add(linkedBinTree.getRoot(), "B", true);
//		LinkedBinTree.TreeNode c = linkedBinTree.add(linkedBinTree.getRoot(), "C", false);
//		LinkedBinTree.TreeNode d = linkedBinTree.add(b, "D", true);
//		linkedBinTree.add(b, "E", false);
//		linkedBinTree.add(c, "F", true);
//		linkedBinTree.add(c, "G", false);
//		linkedBinTree.add(d, "H", false);
//		System.out.println(linkedBinTree.leftNode(linkedBinTree.getRoot()));
//		System.out.println(linkedBinTree.rightNode(linkedBinTree.getRoot()));
//		System.out.println(linkedBinTree.leftNode(b));
//		System.out.println(linkedBinTree.rightNode(b));
//		System.out.println(linkedBinTree.deep());
		//深度优先遍历-前序遍历
//		List<TreeNode> list = linkedBinTree.perIterator();
//		for (TreeNode treeNode : list) {
//			System.out.println(treeNode.data);
//		}
		//广度优先遍历
//		List<TreeNode> breadth = linkedBinTree.breadthFirst();
//		for (TreeNode treeNode : breadth) {
//			System.out.println(treeNode.data);
//		}
		
		/**
		 * 二分搜索树
		 */
		SortedBinTree<String> sortedBinTree = new SortedBinTree<String>("13");
		sortedBinTree.add("33");
		sortedBinTree.add("21");
		sortedBinTree.add("12");
		sortedBinTree.add("65");
		sortedBinTree.add("21");
		sortedBinTree.add("78");
		//深度优先遍历
//		List<datastructure.tree.SortedBinTree.Node> list = sortedBinTree.inIterator();
//		for (datastructure.tree.SortedBinTree.Node node : list) {
//			System.out.println(node.data);
//		}
		//广度优先遍历
		List<datastructure.tree.SortedBinTree.Node> breadthFirst = sortedBinTree.breadthFirst();
		for (datastructure.tree.SortedBinTree.Node node : breadthFirst) {
			System.out.println(node.data);
		}
	}
}
