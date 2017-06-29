package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	
	public class TreeNode {
		public TreeNode parent = null;
		public TreeNode left = null;
		public TreeNode right = null;
		public int value;
		
		public TreeNode(TreeNode parent, int value){
			this.value = value;
			this.parent = parent;
		}
	}
	
	public TreeNode root = null;
	
	private int size = 0;
	
	public BST(){ }
	
	public boolean is_empty(){
		return this.size == 0;
	}
	
	public void insert(int value){
		if (this.root == null){
			this.root = new TreeNode(null, value);
		}
		else {
			TreeNode current = this.root;
			while (current.left != null && value < current.value
					|| current.right != null && value > current.value){
				
				if (value < current.value){
					current = current.left;
				}
				
				else if (value > current.value){
					current = current.right;
				}
			}
			
			if (value < current.value){
				current.left = new TreeNode(current, value);
			}
			
			else if (value > current.value){
				current.right = new TreeNode(current, value);
			}
			
			else {
				return;
			}
		}
		
		this.size++;
	}
	
	public void remove(int value){
		this.remove(value, this.root);
	}
	
	public void remove(int value, TreeNode node){
		// tree is not empty
		if (node != null){
			while (node != null){
				
				if (value < node.value){
					node = node.left;
				}
				
				else if (value > node.value){
					node = node.right;
				}
				
				else {
					break;
				}
			}
			
			// value was found
			if (node != null){
				this.size--;
				
				// has no children
				if (node.left == null && node.right == null){
					// node has a parent
					if (node.parent != null){
						// is left
                        if (node.parent.left == node){
                        	node.parent.left = null;
                        }
                        // is right
                        else if (node.parent.right == node){
                        	node.parent.right = null;
                        }
					}
					// it is the tree root
					else {
						this.root = null;
					}
				}
				
				// contains only left child
				else if (node.left != null && node.right == null){
					// node has a parent
					if (node.parent != null){
						// is left
	                    if (node.parent.left == node){
	                    	node.parent.left = node.left;
	                    }
	                    // is right
	                    else if (node.parent.right == node){
	                    	node.parent.right = node.left;
	                    }
					}
					// it is the tree root
					else {
						this.root = node.left;
					}
				}
				
				// contains only right child
				else if (node.left == null && node.right != null){
					// node has a parent
					if (node.parent != null){
						// is left
	                    if (node.parent.left == node){
	                    	node.parent.left = node.right;
	                    }
	                    // is right
	                    if (node.parent.right == node){
	                    	node.parent.right = node.right;
	                    }
					}
					// it is the tree root
					else {
						this.root = node.right;
					}
				}
				
				// has two children - copy the smallest element and delete it
				// from the right subtree
				else {
					int val = this.get_min(node.right); 
					node.value = val;
					// value was not removed, it was swapped
					this.size++;
					this.remove(val, node.right);
				}
			}
		}
	}
	
	public int get_node_count(){
		return this.size;
	}
	
	public int[] pre_order(){
		return this._pre_order(this.root);
	}
	
	private int[] _pre_order(TreeNode node){
		if (node != null){
			int[] current = {node.value};
			int[] left = this._pre_order(node.left);
			int[] right = this._pre_order(node.right);
			
			int[] array = new int[1 + left.length + right.length];
			
			System.arraycopy(current, 0, array, 0, current.length);
			System.arraycopy(left, 0, array, current.length, left.length);
			System.arraycopy(right, 0, array, current.length + left.length, right.length);
			
			return array;
		}
		return new int[0];
	}
	
	public int[] in_order(){
		return this._in_order(this.root);
	}
	
	private int[] _in_order(TreeNode node){
		if (node != null){	
			int[] left = this._in_order(node.left);
			int[] current = {node.value};		
			int[] right = this._in_order(node.right);
			
			int[] array = new int[1 + left.length + right.length];
			
			System.arraycopy(left, 0, array, 0, left.length);
			System.arraycopy(current, 0, array, left.length, current.length);		
			System.arraycopy(right, 0, array, current.length + left.length, right.length);
			
			return array;
		}
		return new int[0];
	}
	
	public int[] post_order(){
		return this._post_order(this.root);
	}
	
	private int[] _post_order(TreeNode node){
		if (node != null){
			int[] left = this._post_order(node.left);
			int[] right = this._post_order(node.right);
			int[] current = {node.value};
			
			int[] array = new int[1 + left.length + right.length];
			
			System.arraycopy(left, 0, array, 0, left.length);
			System.arraycopy(right, 0, array, left.length, right.length);
			System.arraycopy(current, 0, array, right.length + left.length, current.length);		
					
			return array;
		}
		return new int[0];
	}
	
	public int[] level_order(){
		int[] array = new int[this.size];
		int items = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(this.root);
		
		while (!q.isEmpty()){
			TreeNode current = q.poll();
			
			if (current != null){
				array[items++] = current.value;
				q.add(current.left);
				q.add(current.right);
			}
		}
		
		return array;
	}
	
	public boolean exists(int value){
		return this.exists(value, this.root);
	}
	
	public boolean exists(int value, TreeNode node){
		// tree is not empty
		while (node != null){
			if (value < node.value){
				node = node.left;
			}
			
			else if (value > node.value){
				node = node.right;
			}
			
			else {
				return true;
			}
		}
		
		return false;
	}
	
	public int get_height(){
		return this.get_height(this.root);
	}
	
	public int get_height(TreeNode node){
		return this._get_height(node);
	}
	
	private int _get_height(TreeNode node){
		if (node == null){
			return 0;
		}
		
		return 1 + Math.max(this._get_height(node.left), this._get_height(node.right));
	}
	
	public int get_min(){
		return this.get_min(this.root);
	}	
	
	public int get_min(TreeNode node){
		
		// tree is empty
		if (node == null){
			return -1;
		}
		
		while (node.left != null){
			node = node.left;
		}
		
		return node.value;
	}
	
	public int get_max(){
		return this.get_max(this.root);
	}	
	
	public int get_max(TreeNode node){
		// tree is empty
		if (node == null){
			return -1;
		}
		
		while (node.right != null){
			node = node.right;
		}
		
		return node.value;
	}
	
	public int get_successor(int value){
		return this.get_successor(value, this.root);
	}
	
	public int get_successor(int value, TreeNode node){
		// tree is empty
		if (node == null){
			return -1;
		}
		
		while (node != null){
			if (value < node.value){
				node = node.left;
			}
			
			else if (value > node.value){
				node = node.right;
			}
			
			else {
				break;
			}
		}
		
		// value not found
		if (node == null){
			return -1;
		}
		
		// if there is a right subtree
		if (node.right != null){
			return this.get_min(node.right);
		}
		
		// return first left ancestor
		// (current is in the left ancestor's subtree)
		TreeNode parent = node.parent;
		
		while (parent != null && node == parent.right){
			node = parent;
			parent = parent.parent;
		}
		
		if (parent != null){
			return parent.value;
		}
		
		return -1;
		
	}
	
	public boolean is_binary_search_tree(){
		return this.is_binary_search_tree(this.root);
	}
	
	public boolean is_binary_search_tree(TreeNode node){
		int[] ordered = this._in_order(node);
		
		for (int x=1; x < ordered.length; x++){
			if (!(ordered[x-1] < ordered[x])){
				return false;
			}
		}
		
		return true;
	}

}
