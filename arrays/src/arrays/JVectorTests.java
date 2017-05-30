package arrays;

import arrays.JVector;

public class JVectorTests {

	public static void runTests() 
	{
	  testSize();
	  testIsEmpty();
	  testCapacity();
	  testValueAt();
	  testPop();
	  testInsert();
	  testDelete();
	  testRemove();
	  testFind();
	};
	
	public static void testSize()
	{
		JVector tester = new JVector(3);

		assert (tester.size() == 0);

		int items_to_add = 5;
		for (int i = 0; i < items_to_add; ++i) {
			tester.push(i + 1);
		}
		assert (tester.size() == items_to_add);
	}
	
	public static void testIsEmpty()
	{
		JVector tester = new JVector(3);
		assert(tester.isEmpty());
	}
	
	public static void testCapacity()
	{
		JVector tester = new JVector(3);
		// test increasing size
		assert (tester.capacity() == 3);
		
		for (int i = 0; i < 17; ++i) {
			tester.push(i + 1);
		}
		assert (tester.capacity() == 24); 
		
		for (int j = 0; j < 20; ++j) {
			tester.push(j + 1);
		}
		assert (tester.capacity() == 48);

		// test decreasing size
		for (int k = 0; k < 30; ++k) {
			tester.pop();
		}
		assert (tester.capacity() == 24);
		
		for (int k = 0; k < 7; ++k) {
			tester.pop();
		}
		assert (tester.capacity() == 3);
	}
	
	public static void testValueAt()
	{
		JVector tester = new JVector(3);
		tester.push(4);
		tester.push(9);
		tester.push(12);
		try {
			assert (tester.at(0) == 4);
			assert (tester.at(1) == 9);
			assert (tester.at(2) == 12);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public static void testPop()
	{
		JVector tester = new JVector(1);
		tester.push(3);

		int popped = tester.pop();
		assert (popped == 3);
		tester.push(9);
		tester.push(8);

		assert (tester.size() == 2);
		int popped2 = tester.pop();
		assert (popped2 == 8);
		assert (tester.size() == 1);
		
	}
	
	public static void testInsert() {
		JVector tester = new JVector(3);
		tester.push(5);
		tester.push(7);
		tester.push(9);
		
		try {
			tester.insert(0, 4);
			assert (tester.at(0) == 4);
			assert (tester.at(1) == 5);
			assert (tester.at(2) == 7);
			assert (tester.at(3) == 9);
			
			tester.insert(3, 8);
			assert (tester.at(3) == 8);
			assert (tester.at(4) == 9);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public static void testPrepend() {
		JVector tester = new JVector(3);
		tester.push(9);
		tester.push(8);
		tester.push(7);
		
		try {
			tester.prepend(6);
			assert (tester.size() == 4);
			
			assert (tester.at(0) == 6);
			assert (tester.at(1) == 9);
			assert (tester.at(3) == 7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public static void testDelete() {
		JVector tester = new JVector(1);
		tester.push(5);
		
		try {
			tester.delete(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert (tester.size() == 0);

		tester.push(9);
		tester.push(10);
		tester.push(11);
		
		try {
			tester.delete(1);
			assert (tester.size() == 2);
			assert (tester.at(0) == 9);
			assert (tester.at(1) == 11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void testRemove() {
		JVector tester = new JVector(5);
		tester.push(50);
		tester.push(2);
		tester.push(50);
		tester.push(4);
		tester.push(50);
		
		try {
			tester.remove(50);
			
			assert (tester.size() == 2);
			assert (tester.at(0) == 2);
			assert (tester.at(1) == 4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public static void testFind() {
		JVector tester = new JVector(3);
		tester.push(4);
		tester.push(7);
		tester.push(11);
		assert (tester.find(5) == -1);
		assert (tester.find(4) == 0);
		assert (tester.find(7) == 1);
		assert (tester.find(11) == 2);
	}
}
