package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class StackTest {
	
	// Class under Test
	Stack<Integer> stack;
	Stack<Character> word;
	
	void setUp1() {
		stack = new Stack<>();
	}
	
	void setUp2() {
		word = new Stack<>();
	}

	@Test
	void orderMaintenanceTest() {
		Integer[] vector = randomArray(5000, 0, 60000);
		setUp1();
		for (Integer number : vector) {
			stack.push(number);
		}
		for(int i = vector.length-1; i >= 0; i--) {
			if (vector[i] != stack.pop()) {
				fail();
			}
		}
	}
	
	@Test
	void emptyStackTest() {
		Integer[] vector1 = randomArray(200, 0, 60000);
		Integer[] vector2 = randomArray(300, 0, 60000);
		setUp1();
		// proof with an new stack and 200 elements
		subEmpyTest(vector1);
		// proof with the same stack but with 300 elements
		subEmpyTest(vector2);
	}
	
	@Test
	void emptyExeptionInPopTest() {
		setUp1();
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}
	
	@Test
	void emptyExeptionInTopTest() {
		setUp1();
		assertThrows(EmptyStackException.class, () -> stack.peek());	
	}
	
	@Test
	void invertWordTest() {
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
	
	void subEmpyTest(Integer[] vector) {
		for (Integer number : vector) {
			stack.push(number);
		}
		if (stack.isEmpty()) {
			fail();
		}
		for (int i = 0; i < vector.length; i++) {
			stack.pop();
		}
		if (!stack.isEmpty()) {
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

