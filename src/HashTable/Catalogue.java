
package HashTable ;

import java.util.ArrayList;
import java.util.List;

public class Catalogue<K, T> implements IHashTable<K, T> {
	
	private static final int INITIAL_SIZE = 100;
	private static final double GROWTH_FACTOR = 0.5;
	
	private double alpha;
	private List<HashNode<T, K>>[] array;
	private int numberOfElements;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Catalogue() {
		array = (List<HashNode<T, K>>[]) new List[INITIAL_SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public Catalogue(int size) {
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
	
//	@Override
//	public K getIndex(K key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public T insertKey(K key, T date) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean revome(K key) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}

//package HashTable;
//
//import model.NodeCatalogue;
//
//public class Catalogue<K,V> implements IHashTable<K, V> {
//	
//	
//	private NodeCatalogue<K,V>[] nodes;
//
//	private char stads;
//
//    @SuppressWarnings("unchecked")
//    public Catalogue(char stands,int size){
//        nodes = new NodeCatalogue[size];
//        this.stads=stands;
//    }
//
//    private int getIndex(K key){
//        int hash = key.hashCode() % nodes.length;
//        if(hash < 0){
//            hash += nodes.length;
//        }
//        return hash;
//    }
//    
//    public V insert(K key, V data){
//        int hash = getIndex(key);
//
//        for(NodeCatalogue<K,V> node = nodes[hash]; node != null; node = node.next){
//            if((hash == node.hash) && key.equals(node.key)){
//                V oldData = node.data;
//                node.data = data;
//                return oldData;
//            }
//        }
//
//
//        NodeCatalogue<K,V> node = new NodeCatalogue<K,V>(key, data, nodes[hash], hash);
//        nodes[hash] = node;
//
//        return null;
//    }
//
//    
//    public boolean remove(K key){
//        int hash = getIndex(key);
//        NodeCatalogue<K,V> previous = null;
//        for(NodeCatalogue<K,V> node = nodes[hash]; node != null; node = node.next){
//            if((hash == node.hash) && key.equals(node.key)){
//                if(previous != null){
//                    previous.next = node.next;
//                }else{
//                    nodes[hash] = node.next;
//                }
//                return true;
//            }
//            previous = node;    
//        }
//        return false;
//    }
//
//    public V get(K key){
//        int hash = getIndex(key);
//
//        for(NodeCatalogue<K,V> node = nodes[hash]; node != null; node = node.next){
//            if(key.equals(node.key))
//                return node.data;
//        }
//        return null;
//    }
//    
//    public void resize(int size,char stands){
//    	Catalogue<K, V> newtbl = new Catalogue<K, V>(stands,size);
//        for(NodeCatalogue<K,V> node : nodes){
//            for(; node != null; node = node.next){
//                newtbl.insert(node.key, node.data);
//                remove(node.key);
//            }
//        }
//        nodes = newtbl.nodes;
//    }
//
//	public char getStads() {
//		return stads;
//	}
//
//	public void setStads(char stads) {
//		this.stads = stads;
//	}
//
//	public NodeCatalogue<K, V>[] getNodes() {
//		return nodes;
//	}
//
//	public void setNodes(NodeCatalogue<K, V>[] nodes) {
//		this.nodes = nodes;
//	}
//    

//}
