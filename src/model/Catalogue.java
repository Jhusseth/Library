package model;

public class Catalogue<K,V> {
	
	
	private NodeCatalogue<K,V>[] nodes;

	private char stads;

    @SuppressWarnings("unchecked")
    public Catalogue(char stands,int size){
        nodes = new NodeCatalogue[size];
        this.stads=stands;
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

        for(NodeCatalogue<K,V> node = nodes[hash]; node != null; node = node.next){
            if((hash == node.hash) && key.equals(node.key)){
                V oldData = node.data;
                node.data = data;
                return oldData;
            }
        }


        NodeCatalogue<K,V> node = new NodeCatalogue<K,V>(key, data, nodes[hash], hash);
        nodes[hash] = node;

        return null;
    }

    
    public boolean remove(K key){
        int hash = getIndex(key);
        NodeCatalogue<K,V> previous = null;
        for(NodeCatalogue<K,V> node = nodes[hash]; node != null; node = node.next){
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

        for(NodeCatalogue<K,V> node = nodes[hash]; node != null; node = node.next){
            if(key.equals(node.key))
                return node.data;
        }
        return null;
    }
    
    public void resize(int size,char stands){
    	Catalogue<K, V> newtbl = new Catalogue<K, V>(stands,size);
        for(NodeCatalogue<K,V> node : nodes){
            for(; node != null; node = node.next){
                newtbl.insert(node.key, node.data);
                remove(node.key);
            }
        }
        nodes = newtbl.nodes;
    }

	public char getStads() {
		return stads;
	}

	public void setStads(char stads) {
		this.stads = stads;
	}

	public NodeCatalogue<K, V>[] getNodes() {
		return nodes;
	}

	public void setNodes(NodeCatalogue<K, V>[] nodes) {
		this.nodes = nodes;
	}
    

}
