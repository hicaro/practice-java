package queue;

import queue.Queue;

public class Tests {

	public static void run() throws Exception {
		testEmpty();
		testEnqueue();
		testDequeue();
	}

	public static void testEmpty() {
		Queue<Integer> queue = new Queue<Integer>();
		assert (queue.isEmpty());

		queue.enqueue(3);
		assert (!queue.isEmpty());
	}

	public static void testEnqueue() {
		Queue<Double> queue = new Queue<Double>();
		queue.enqueue(12.3);
		queue.enqueue(4.235);
		queue.enqueue(5.4);
		queue.enqueue(7.0);
		queue.enqueue(885314.32214);

		assert (!queue.isEmpty());
	}

	public static void testDequeue() throws Exception {
		Queue<Integer> queue = new Queue<Integer>();

		queue.enqueue(100);
		queue.enqueue(200);
		assert (queue.dequeue() == 100);
		queue.enqueue(300);
		assert (queue.dequeue() == 200);
		queue.enqueue(400);
		queue.enqueue(500);
		queue.enqueue(600);
		queue.enqueue(700);
		assert (queue.dequeue() == 300);
		assert (queue.dequeue() == 400);
		assert (queue.dequeue() == 500);
		assert (queue.dequeue() == 600);
		assert (queue.dequeue() == 700);

		assert (queue.isEmpty());
	}
}
