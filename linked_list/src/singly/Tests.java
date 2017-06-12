package singly;

import singly.SinglyLinkedList;

public class Tests {
	
	public static void runTests() 
	{
		testSizeEmpty();
		testSize1to2();
		testEmpty();
		testValueAt();
		testPushFront();
		testPopFront();
		testPushBack();
		testPopBack();
		testInsertFromEmpty();
		testInsertFromNonEmpty();
		testInsertBack();
		testInsertMiddle();
		testErase();
		testEraseFirst();
		testEraseLast();
		testValueNFromEnd();
		testReverseOne();
		testReverseTwo();
		testReverseThree();
		testRemoveNone();
		testRemoveOnly();
		testRemoveFirst();
		testRemoveLast();
		testRemoveMiddle();
	}
	
	public static void testSizeEmpty()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		assert(list.size() == 0);
	}
	
	public static void testSize1to2()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.push_front(4);

		assert(list.size() == 1);
	
		list.push_front(9);
		assert(list.size() == 2);
	}
	
	public static void testEmpty()
	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		assert(list.isEmpty());
		
		list.push_front("word");
		assert(!list.isEmpty());
	}
	
	public static void testValueAt()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
				
		try {
			list.push_front(99);
			assert(list.value_at(0) == 99);
			
			list.push_front(3);
			list.push_front(122);
			assert(list.value_at(0) == 122);
			assert(list.value_at(1) == 3);
			assert(list.value_at(2) == 99);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testPushFront()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		try {
			list.push_front(753);
			list.push_front(159);
			
			assert(list.size() == 2);
			assert(list.value_at(0) == 159);
			assert(list.value_at(1) == 753);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testPopFront()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.push_front(12);
			list.push_front(11);
			
			assert(list.pop_front() == 11);
			assert(list.pop_front() == 12);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void testPushBack()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		try {
			list.push_back(123);
			list.push_back(456);
			
			assert(list.size() == 2);
			assert(list.value_at(0) == 123);
			assert(list.value_at(1) == 456);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testPopBack()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.push_back(33);
			list.push_back(36);
			
			assert(list.pop_back() == 36);
			assert(list.pop_back() == 33);
			assert(list.size() == 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testInsertFromEmpty()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		list.insert(0, 3);
		assert(list.front() == 3);
	}
		

	public static void testInsertFromNonEmpty()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		list.push_front(123);		
		list.insert(0, 3);
		assert(list.front() == 3);
		assert(list.back() == 123);
	}
	
	public static void testInsertBack()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		list.push_front(123);		
		list.insert(1, 3);
		
		assert(list.back() == 3);
	}
	
	public static void testInsertMiddle()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		try{
			list.push_back(123);
			list.push_back(456);	
			list.push_back(999);	
			list.insert(2, 777);
			
			assert(list.value_at(1) == 456);
			assert(list.value_at(2) == 777);
			assert(list.back() == 999);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testErase()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try{
			list.push_back(44);
			list.erase(0);

			assert(list.size() == 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	public static void testEraseFirst()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try{
			list.push_back(44);
			list.push_back(55);
			list.erase(0);
	
			assert(list.size() == 1);
			assert(list.front() == 55);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	public static void testEraseLast()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		try{
			list.push_back(44);
			list.push_back(55);
			list.erase(1);
	
			assert(list.size() == 1);
			assert(list.front() == 44);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	public static void testValueNFromEnd()
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		try {
			list.push_back(44);
			list.push_back(55);
			list.push_back(66);

			assert (list.value_n_from_end(1) == 66);
			assert (list.value_n_from_end(2) == 55);
			assert (list.value_n_from_end(3) == 44);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	public static void testReverseOne() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.push_back(44);

			list.reverse();

			assert (list.front() == 44);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testReverseTwo() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.push_back(44);
			list.push_back(55);

			list.reverse();

			assert (list.front() == 55);
			assert (list.back() == 44);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testReverseThree() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.push_back(44);
			list.push_back(55);
			list.push_back(66);

			list.reverse(); 

			assert (list.value_at(0) == 66);
			assert (list.value_at(1) == 55);
			assert (list.value_at(2) == 44);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testRemoveNone() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.remove_value(5);

			assert (list.size() == 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testRemoveOnly() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.push_back(5);
			list.remove_value(5);

			assert (list.size() == 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testRemoveFirst() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.push_back(5);
			list.push_back(22);
			list.remove_value(5);

			assert (list.size() == 1);
			assert (list.front() == 22);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testRemoveLast() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.push_back(5);
			list.push_back(22);
			list.remove_value(5);

			assert (list.size() == 1);
			assert (list.front() == 22);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testRemoveMiddle() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		try {
			list.push_back(5);
			list.push_back(22);
			list.remove_value(5);

			assert (list.size() == 1);
			assert (list.front() == 22);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
