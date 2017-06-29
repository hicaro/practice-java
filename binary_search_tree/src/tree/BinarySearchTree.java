package tree;

import tree.Tests;

public class BinarySearchTree {
	
	public static void main(String[] args){
		System.out.println("Running tests...");
		try {
			Tests.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		System.out.println("All passed");
	}
}
