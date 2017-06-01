package singly;

public class SinglyLinkedList<T> {
	
	@SuppressWarnings("hiding")
	private class Node<T> {

		public Node<T> next;		
		public T value;			
	}
	
	private Node<T> head = null;
	private Node<T> tail = null;
	
	private int size = 0;
	
	public SinglyLinkedList() { }
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return (this.size == 0);
	}
	
	public T value_at(int index)throws Exception{
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}
		if (index >= this.size){
			throw new Exception("Index out of bounds");
		}
		
		Node<T> current = this.head;
		
		for (int i=0; i < index; i++){
			current = current.next;
		}
		
		return current.value;
	}
	
	public void push_front(T value){
		Node<T> node = new Node<T>();
		
		node.value = value;
		node.next = this.head;
		
		this.head = node;
		if(this.tail == null){
			this.tail = node;
		}
		
		this.size++;
	}
	
	public T pop_front() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}
		
		T value = this.head.value;
		
		// contains only one element
		if(this.head == this.tail){
			this.head = null;
			this.tail = null;
		}
		else {
			this.head = this.head.next;
		}
		
		this.size--;
		
		return value;
	}
	
	public void push_back(T value){
		Node<T> node = new Node<T>();
		
		node.value = value;
		node.next = null;
		
		// list is empty
		if(this.head == null){
			this.head = node;						
		}
		else {
			this.tail.next = node;
		}
		this.tail = node;
		
		this.size++;
	}
	
	public T pop_back() throws Exception{
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}
		
		T value = this.tail.value;
		
		// contains only one element			
		if(this.head == this.tail){
			this.head = null;
			this.tail = null;
		}
		else {
			Node<T> previous = this.head;
			while(previous.next != this.tail){
				previous = previous.next;
			}
			
			previous.next = null;
			this.tail = previous;
		}
		
		this.size--;
		
		return value;
	}
	
	public T front(){
		return this.head.value;
	}
	
	public T back(){
		return this.tail.value;
	}
	
	public void insert(int index, T value){
		if(index == 0){
			this.push_front(value);
		}
		else if(index >= this.size) {
			this.push_back(value); 
		}
		else {
			Node<T> node = new Node<T>();			
			node.value = value;
			
			Node<T> current = this.head;
			for (int i = 0; i < index-1; i++){
				current = current.next;
			}
			
			node.next = current.next;
			current.next = node;
			
			this.size++;
		}
	}
	
	public void erase(int index) throws Exception{
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}
		if (index >= this.size){
			throw new Exception("Index out of bounds");
		}
		
		if(index == 0){
			this.pop_front();
		}
		else if(index == (this.size - 1)) {
			this.pop_back();
		}
		else {
			Node<T> current = this.head;
			for (int i = 0; i < index-1; i++){
				current = current.next;
			}
			
			current.next = current.next.next;
			this.size--;
		}
	}
	
	public T value_n_from_end(int reverse_index) throws Exception{
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}
		
		int index = this.size - reverse_index;		
		if (index < 0){
			throw new Exception("Index out of bounds");
		}
		
		Node<T> current = this.head;
		
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		
		return current.value;
		
	}
	
	public void reverse(){
		if(!isEmpty()){
			// contains two elements
			if(this.head.next == this.tail){
				Node<T> aux = this.tail;
				this.tail = this.head;
				this.head = aux;
			}
			// contains three or more
			else if(this.head != this.tail){
				Node<T> current, successor, aux;
				
				current = this.head;
				successor = this.head.next;
				
				do{
					aux = successor.next;				
					successor.next = current;
					
					current = successor;
					successor = aux;
					
				} while(successor != null);
				
				this.tail = this.head;
				this.head = current;
				this.tail.next = null;
			}
		}
	}
	
	public void remove_value(T value) throws Exception{
		int index = 0;
		
		Node<T> current = this.head;
		while(current != null && current.value != value){
			current = current.next;
			index++;
		}
		
		if(current != null){
			this.erase(index);
		}
	}

}
