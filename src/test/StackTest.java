package test;


import structures.StackEmptyException;
import structures.StackP;

import java.util.EmptyStackException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import structures.StackP;

class StackTest {
	
	// Class under Test
	StackP<Integer> stack;
	StackP<Character> word;
	
	void setUp1() {
		stack = new StackP<>();
	}
	
	void setUp2() {
		word = new StackP<>();
	}

	@Test
	void orderMaintenanceTest() {
		Integer[] vector = randomArray(5000, 0, 60000);
		setUp1();
		for (Integer number : vector) {
			stack.push(number);
		}
		for(int i = vector.length-1; i >= 0; i--) {
			try {
				if (vector[i] != stack.pop()) {
					fail();
				}
			} catch (StackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	void emptyStackTest() throws StackEmptyException {
		Integer[] vector1 = randomArray(200, 0, 60000);
		Integer[] vector2 = randomArray(300, 0, 60000);
		setUp1();
		// proof with an new stack and 200 elements
		subEmpyTest(vector1);
		// proof with the same stack but with 300 elements
		subEmpyTest(vector2);
	}
	
//	@Test
//	void emptyExeptionInPopTest() {
//		setUp1();
//		assertThrows(EmptyStackException.class, () -> stack.pop());
//	}
//	
//	@Test
//	void emptyExeptionInTopTest() {
//		setUp1();
//		assertThrows(EmptyStackException.class, () -> stack.peek());	
//	}
	
	@Test
	void invertWordTest() throws StackEmptyException {
		setUp2();
		char[] word1 = "this is a word".toCharArray();
		char[] inverseword = "drow a si siht".toCharArray();
		char[] word2 = new char[word1.length];
		for (char c : word1) {
			word.push(c);
		}
		for (int i = 0; i < word2.length; i++) {
			word2[i] = word.pop();
		}
		assertArrayEquals(inverseword, word2);
	}
	
	void subEmpyTest(Integer[] vector) throws StackEmptyException {
		for (Integer number : vector) {
			stack.push(number);
		}
		if (stack.empty()) {
			fail();
		}
		for (int i = 0; i < vector.length; i++) {
			stack.pop();
		}
		if (!stack.empty()) {
			fail();
		}
	}
	
	static Integer[] randomArray(int size,int minNum, int maxNum) {
		Integer[] vector = new Integer[size];
		for(int i = 0; i < size; i++) {
			vector[i] = (int)(Math.random() * maxNum) + minNum;
		}
		return vector;
	}

}

