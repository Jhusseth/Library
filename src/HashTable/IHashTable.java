package HashTable;

public interface IHashTable<K,V> {
	
	K getIndex(K key);
	V insertKey(K key, V date);
	boolean revome(K key);
	V get(K key);
	

}
