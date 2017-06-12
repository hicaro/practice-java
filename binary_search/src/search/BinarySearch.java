package search;


public class BinarySearch {
	
	private static final int[] array = new int[]{1,2,3,5,8,13,21,34,55,89};
	
	public static void main(String[] args){
		testNotFound();
		testFindStart();
		testFindMiddle();
		testFindEnd();
		testNotFoundRecursive();
		testFindStartRecursive();
		testFindMiddleRecursive();
		testFindEndRecursive();
	}
	
	public static void testNotFound(){
		assert(BinarySearch.binary_search(BinarySearch.array, 99) == -1);
	}
	
	public static void testFindStart(){
		assert(BinarySearch.binary_search(BinarySearch.array, 1) == 0);
	}

	public static void testFindMiddle(){
		assert(BinarySearch.binary_search(BinarySearch.array, 13) == 5);
	}
	
	public static void testFindEnd(){
		assert(BinarySearch.binary_search(BinarySearch.array, 89) == 9);
	}
	
	public static void testNotFoundRecursive(){
		assert(BinarySearch.binary_search_recursive(BinarySearch.array, 99, 0, 9) == -1);
	}
	
	public static void testFindStartRecursive(){
		assert(BinarySearch.binary_search_recursive(BinarySearch.array, 1, 0, 9) == 0);
	}
	
	public static void testFindMiddleRecursive(){
		assert(BinarySearch.binary_search_recursive(BinarySearch.array, 13, 0, 9) == 5);
	}
	
	public static void testFindEndRecursive(){
		assert(BinarySearch.binary_search_recursive(BinarySearch.array, 89, 0, 9) == 9);
	}
	
	public static int binary_search(int[] array, int value){
		int min = 0, max = array.length - 1, middle; 
		
		while(max >= min){ 
			middle = (int)((max + min) / 2); 
			
			if(array[middle] == value){
				return middle;
			}
			else if(array[middle] > value){
				max = middle - 1;
			}
			else{
				min = middle + 1;
			}
		}
		
		return -1;
	}
	
	public static int binary_search_recursive(int[] array, int value, int min, int max){
		if(min > max){
			return -1;
		}
		int middle = (int)(max + min) / 2;
		if(array[middle] == value){
			return middle;
		}
		else if(array[middle] > value){
			return binary_search_recursive(array, value, min, middle - 1);
		}
		else{
			return binary_search_recursive(array, value, middle + 1, max);
		}
	}
	
}
