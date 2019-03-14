package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;

import org.junit.jupiter.api.Test;

class HashTest {
	
	Hashtable<String, Integer> h1;
	Hashtable<Integer, Integer> h2;
	
	void setUp1() {
		h1 = new Hashtable<String, Integer>();
		String keys[] = {"k1","k2","k3","k4","k2"};
		Integer[] values = {1,2,3,4,5};
		for (int i = 0; i < keys.length; i++) {
			h1.put(keys[i],values[i]);
		}
	}
	
	void setUp2() {
		h2 = new Hashtable<>(1<<50);
	}

	@Test
	void putTest() {
		setUp1();	
		if(h1.get("k2") != 5) {
			fail();
		}
	}
	
	@Test
	void removeTest() {
		setUp1();
		assertNull(h1.get("that not exist"));
	}
	
	@Test
	void generalTest() {
		setUp2();
		Integer[] vector = StackTest.randomArray(1<<50, -1<<50, 1<<50);
		assertTrue(h2.isEmpty());
		for (Integer number : vector) {
			h2.put(number, number);
		}
		assertFalse(h2.isEmpty());
		for (int i = 0; i < vector.length; i++) {
			if ((int)h2.get(vector[i]) != (int)vector[i]) {
				System.out.println(h2.get(vector[i]) + " " + vector[i]);
				fail();
			}
		}
		for (Integer number : vector) {
			h2.remove(number);
		}
		assertTrue(h2.isEmpty());
	}

}
