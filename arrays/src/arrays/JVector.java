package arrays;

public class JVector {
	private int capacity;
	private int size;
	private int[] array;
	
	public JVector(int capacity)
	{
		this.capacity = capacity;
		this.size = 0;
		this.array = new int[this.capacity];
	}
	
	public int size()
	{
		return this.size;
	}
	
	public int capacity()
	{
		return this.capacity;
	}
	
	public boolean isEmpty()
	{
		return (this.size == 0);
	}
	
	public int at(int index) throws Exception
	{
		this.checkBounds(index);
		return this.array[index];
	}
	
	public void push(int item)
	{
		this.expand();
		this.array[this.size++] = item;
	}
	
	public void insert(int index, int item) throws Exception
	{
		this.checkBounds(index);
		this.expand();
		
		for (int i = this.size; i > index; i--){
			this.array[i] = this.array[i-1];
		}
		
		this.array[index] = item;
		this.size++;
	}
	
	public void prepend(int item) throws Exception
	{
		this.insert(0, item);
	}
	
	public int pop()
	{
		this.shrink();
		return this.array[--this.size];
	}
	
	public int delete(int index) throws Exception
	{
		this.checkBounds(index);
		this.shrink();
		
		int aux = this.array[index]; 
		
		for (int i = index; i < this.size-1; i++){
			this.array[i] = this.array[i+1];
		}

		this.size--;
		return aux;
	}
	
	public void remove(int item) throws Exception
	{
		for (int i = 0; i < this.size; i++){  
			if(this.array[i] == item){
				this.delete(i);
				// as a item is removed and the array is shifted to the left
				i--;
			}
		}
	}
	
	public int find(int item)
	{
		for (int i = 0; i < this.size; i++){
			if(this.array[i] == item){
				return i;
			}
		}
		
		// return -1 in case of not finding the referred item		
		return -1;
	}
	
	private void checkBounds(int index) throws Exception
	{
		if(index < 0 || index >= this.size) {
			throw new Exception("Index out of bounds.");
		}
	}
	
	private void expand()
	{
		if (this.size == this.capacity){
			this.capacity = this.capacity * 2; 
			
			int[] aux = new int[this.capacity];
			for (int i = 0; i < this.size; i++){
				aux[i] = this.array[i];
			}
			this.array = aux;
		}
	}
	
	private void shrink()
	{
		if(this.size <= this.capacity / 4){
			this.capacity = this.capacity / 2;
			
			int[] aux = new int[this.capacity];
			for (int i = 0; i < this.size; i++){
				aux[i] = this.array[i];
			}
			this.array = aux;
		}
	}
	
	public String toString()
	{
		String ret = "[ ";
		
		for(int i = 0; i < this.size; i++){
			ret += this.array[i] + " ";
		}
		
		ret += "]";
		
		return ret;
	}
}
