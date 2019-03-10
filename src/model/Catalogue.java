package model;

public class Catalogue<K,V> {
	
	
	private HashNode<K,V>[] nodes;

    @SuppressWarnings("unchecked")
    public Catalogue(int size){
        nodes = new HashNode[size];
    }

    private int getIndex(K key){
        int hash = key.hashCode() % nodes.length;
        if(hash < 0){
            hash += nodes.length;
        }
        return hash;
    }
    
    public V insert(K key, V data){
        int hash = getIndex(key);

        // Lets check if same key already exists and if so lets update it with the new value
        for(HashNode<K,V> node = nodes[hash]; node != null; node = node.next){
            if((hash == node.hash) && key.equals(node.key)){
                V oldData = node.data;
                node.data = data;
                return oldData;
            }
        }

        // Lets add the new hash node created below to the start of linked list at nodes[hash] position
        HashNode<K,V> node = new HashNode<K,V>(key, data, nodes[hash], hash);
        nodes[hash] = node;

        return null;
    }

    
    public boolean remove(K key){
        int hash = getIndex(key);
        HashNode<K,V> previous = null;
        for(HashNode<K,V> node = nodes[hash]; node != null; node = node.next){
            if((hash == node.hash) && key.equals(node.key)){
                if(previous != null){
                    previous.next = node.next;
                }else{
                    nodes[hash] = node.next;
                }
                return true;
            }
            previous = node;    
        }
        return false;
    }

    public V get(K key){
        int hash = getIndex(key);

        for(HashNode<K,V> node = nodes[hash]; node != null; node = node.next){
            if(key.equals(node.key))
                return node.data;
        }
        return null;
    }
    
    public void resize(int size){
    	Catalogue<K, V> newtbl = new Catalogue<K, V>(size);
        for(HashNode<K,V> node : nodes){
            for(; node != null; node = node.next){
                newtbl.insert(node.key, node.data);
                remove(node.key);
            }
        }
        nodes = newtbl.nodes;
    }

	public HashNode<K, V>[] getNodes() {
		return nodes;
	}

	public void setNodes(HashNode<K, V>[] nodes) {
		this.nodes = nodes;
	}
    

}
