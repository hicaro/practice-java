package queue;

import queue.SinglyLinkedList;

public class Queue<T> {
	
	private SinglyLinkedList<T> list;
	
	public Queue(){
		this.list = new SinglyLinkedList<T>();
	}
	
	public void enqueue(T value){
		list.push_back(value);
	}
	
	public T dequeue() throws Exception{
		return list.pop_front();
	}
	
	public boolean isEmpty(){
		return this.list.isEmpty();
	}
}
