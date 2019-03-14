package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Queue;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class QueueTest {
	
	Queue<Integer> q1;
	
	void setUp1() {
		q1 = new LinkedList<>();
	}

	@Test
	void Ordertest() {
		setUp1();
		Integer[] numbers = StackTest.randomArray(5000, -500, 500);
		for (Integer number : numbers) {
			q1.add(number);
		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != q1.poll()) {
				fail();
			}
		}
	}
	
	@Test
	void Empty() {
		setUp1();
		int num = (int)(Math.random() * 25);
		q1.add(num);
		assertFalse(q1.isEmpty());
		assertEquals((int)q1.peek(), num);
		assertFalse(q1.isEmpty());
		assertEquals((int)q1.poll(), num);
		assertTrue(q1.isEmpty());
	}
	
	@Test
	void emptyExeptionInPollTest() {
		setUp1();
		assertNull(q1.poll());
	}
	
	@Test
	void emptyExeptionInFrontTest() {
		setUp1();
		assertNull(q1.peek());	
	}

}
