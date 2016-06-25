package datastructure.bag;

public class Demo {
	public static void main(String[] args) {
		MyLindedListBag<String> bag = new MyLindedListBag<String>();
		bag.add("1");
		bag.add("7");
		bag.add("2");
		bag.add("5");
		bag.add("2");
		bag.add("8");
		for (String string : bag) {
			System.out.println(string);
		}
	}
}
