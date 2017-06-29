package tree;

import tree.BST;

public class Tests {
	
	public static void run() {
		print();
		testIsEmpty();
		testOneInsert();
		testManyInsert();
		testGetMin();
		testGetMax();
		testGetHeight();
		testRemoveRootOne();
		testRemoveRootMany();
		testRemoveLeaves();
		testIsBinarySearchTree();
		testIsNotBinarySearchTree();
	}
	
	public static void print(){
		BST _tree = __create_tree();
		
		printArray("Pre order", _tree.pre_order());
		printArray("In order", _tree.in_order());
		printArray("Post order", _tree.post_order());
		printArray("Level order", _tree.level_order());
	}
	
	private static void printArray(String msg, int[] array){
		System.out.printf("%s: [ ", msg);
		for (int x=0; x < array.length; x++){
			System.out.printf("%d ", array[x]);
		}
		System.out.println("]");
	}
	
	public static void testIsEmpty(){
	    BST _tree = new BST();
	    assert _tree.is_empty();
	}

	public static void testOneInsert(){
	    BST _tree = new BST();
	    _tree.insert(30);

	    assert _tree.exists(30);
	}

	public static void testManyInsert(){
	    BST _tree = new BST();
	    _tree.insert(25);
	    _tree.insert(10);
	    _tree.insert(30);
	    _tree.insert(35);

	    assert _tree.exists(10);
	    assert _tree.exists(25);
	    assert _tree.exists(30);
	    assert _tree.exists(35);
	}

	public static void testGetMin(){
	    BST _tree = __create_tree();

	    assert _tree.get_min() == 1;
	}

	public static void testGetMax(){
	    BST _tree = __create_tree();

	    assert _tree.get_max() == 17;
	}

	public static void testGetHeight(){
	    BST _tree = __create_tree();

	    assert _tree.get_height() == 4;
	}

	public static void testRemoveRootOne(){
	    BST _tree = new BST();
	    _tree.insert(7);
	    _tree.remove(7);

	    assert _tree.is_empty();
	}

	public static void testRemoveRootMany(){
	    BST _tree = __create_tree();
	    _tree.remove(7);
	    
	    assert _tree.root.value == 8;
	}

	public static void testRemoveLeaves(){
	    BST _tree = __create_tree();
	    _tree.remove(1);
	    _tree.remove(17);

	    assert _tree.get_min() == 3;
	    assert _tree.get_max() == 15;
	}

	public static void testIsBinarySearchTree(){
	    BST _tree = __create_tree();

	    assert _tree.is_binary_search_tree();
	}

	public static void testIsNotBinarySearchTree(){
	    BST _tree = __create_tree();
	    _tree.root.value = 2;

	    assert !_tree.is_binary_search_tree();
	}

	public static BST __create_tree(){
	    BST _tree = new BST();
	    _tree.insert(7);
	    _tree.insert(5);
	    _tree.insert(3);
	    _tree.insert(1);
	    _tree.insert(4);
	    _tree.insert(6);
	    _tree.insert(12);
	    _tree.insert(9);
	    _tree.insert(8);
	    _tree.insert(10);
	    _tree.insert(15);
	    _tree.insert(13);
	    _tree.insert(17);

	    return _tree;
	}
}
