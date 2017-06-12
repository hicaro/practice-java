package hash;

import hash.HashObject;

public class HashTable {
	
	private int size = 0;
	
	private HashObject[] table;
	
	public HashTable(int size){
		this.size = size;
		this.table = new HashObject[this.size];
	}
	
	private int hash(String key, int trial){
		return (this.auxiliary_hash(key) + trial) % this.size;
	}
	
	private int auxiliary_hash(String key){
		long hash = 0;
		
		for(int i = 0; i < key.length(); i++){
			hash = hash * 31 + key.charAt(i);
		}
		
		return (int)(hash % this.size);
	}
	
	public void add(String key, String value){
		int trial = 0;
		
		while(trial < this.size){
			int index = hash(key, trial);
			
			if(this.table[index] == null){
				this.table[index] = new HashObject();
				this.table[index].key = key;
				this.table[index].value = value;
				break;
			}
			else if(this.table[index].key == null || this.table[index].key == key){
				this.table[index].key = key;
				this.table[index].value = value;
				break;
			}
			
			trial++;
		}		
	}
	
	public void remove(String key){
		int trial = 0;
		
		while(trial < this.size){
			int index = hash(key, trial);
			
			if(this.table[index] == null){
				break;
			}
			
			if(this.table[index].key == key){
				this.table[index].key =  null;
				this.table[index].value =  null;
			}
			
			trial++;
		}	
	}
	
	public String get(String key){
		int trial = 0;
		
		while(trial < this.size){
			int index = hash(key, trial);
			
			if(this.table[index] == null){
				break;
			}
			
			if(this.table[index].key == key){
				return this.table[index].value;
			}
			
			trial++;
		}	
		
		return null;
	}
	
	public boolean exists(String key){
		int trial = 0;
		
		while(trial < this.size){
			int index = hash(key, trial);
			
			if(this.table[index] == null){
				return false;
			}
			
			if(this.table[index].key == key){
				return true;
			}
			
			trial++;
		}	
		
		return false;
	}
}
