
package HashTable ;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K, T> implements IHashTable<K, T> {
	
	private static final int INITIAL_SIZE = 100;
	private static final double GROWTH_FACTOR = 0.5;
	
	private double alpha;
	private List<HashNode<T, K>>[] array;
	private int numberOfElements;
	
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public HashTable() {
		array = (List<HashNode<T, K>>[]) new List[INITIAL_SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		array = (List<HashNode<T, K>>[]) new List[size];
	}

	@Override
	public void put(K key, T value) {
		if (array[hash(key)] == null) {
			array[hash(key)] = new ArrayList<HashNode<T, K>>();
			array[hash(key)].add(new HashNode<T, K>(value, key));
		} else {
			List<HashNode<T, K>> slot = array[hash(key)];
			for (int i = 0; i < slot.size(); i++) {
				if (slot.get(i).getKey().equals(key)){
					slot.remove(i);
				}
			}
			array[hash(key)].add(new HashNode<T, K>(value, key));
		}
		numberOfElements++;
		alpha = numberOfElements/array.length;
		if (alpha > 0.7) {
			rehashing();
		}
	}

	@Override
	public T get(K key) {
		T value = null;
		List<HashNode<T, K>> list = array[hash(key)];
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getKey().equals(key)) {
					value = list.get(i).getData();
				}
			}
		}
		return value;
	}

	@Override
	public T remove(K key) {
		T value = null;
		int index = -1;
		List<HashNode<T, K>> list = array[hash(key)];
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getKey().equals(key)) {
					value = list.get(i).getData();
					index = i;
					numberOfElements--;
					alpha = numberOfElements/array.length;
				}
			}
		}
		if (index != -1) {
			array[hash(key)].remove(index);
		}
		return value;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	@Override
	public int tableLength() {
		return numberOfElements;
	}

	public int hash(K key) {
		return Math.abs(key.hashCode() % array.length);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void rehashing() {
		List<HashNode<T, K>>[] temp = array.clone();
		array = (List<HashNode<T, K>>[]) new List[(int) (array.length * (1 + GROWTH_FACTOR) )];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				for (int j = 0; j < temp[i].size(); j++) {
					put(temp[i].get(j).getKey(), temp[i].get(j).getData());
				}
			}
		}
	}
	
	public int getArrayLength() {
		return array.length;
	}

}


