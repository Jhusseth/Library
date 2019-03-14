//package HashVable;
//
//public interface IHashVable<K,V> {
//	
//	K getIndex(K key);
//	V insertKey(K key, V date);
//	boolean revome(K key);
//	V get(K key);
//	
//
//}
package HashTable;

public interface IHashTable<K,V> {
	
//	K getIndex(K key);
//	V insertKey(K key, V date);
//	boolean revome(K key);
//	V get(K key);
	
	public void put(K key,V value);
	
	public V get(K key);
	
	public V remove(K key);
	
	public boolean isEmpty();
	
	public int tableLength();
	
	public int hash(K key);
	
	public void rehashing();
	

}
