package model;

public class NodeCatalogue<K,V> {
	
        final K key;
        V data;
        NodeCatalogue<K,V> next;
        final int hash;

        public NodeCatalogue(K k, V v, NodeCatalogue<K,V> n, int h){
            key = k;
            data = v;
            next = n;
            hash = h;
        }

		public V getData() {
			return data;
		}

		public void setData(V data) {
			this.data = data;
		}

		public NodeCatalogue<K, V> getNext() {
			return next;
		}

		public void setNext(NodeCatalogue<K, V> next) {
			this.next = next;
		}

		public K getKey() {
			return key;
		}

		public int getHash() {
			return hash;
		}
}

//    public static void main(String[] args) {
//
//        Hashtbl<String, Integer> tbl = new Hashtbl<String, Integer>(5);
//
//        tbl.insert("one", 1);
//        tbl.insert("three", 3);
//        tbl.insert("nineteen", 19);
//        tbl.insert("fifteen", 15);
//        tbl.insert("six", 6);
//
//        System.out.println("Afterrt");
//
//        System.out.println("three+tbl.get("three        System.out.println("six+tbl.get("six
//        /*tbl.remove("three");
//
//        System.out.println(tbl.get("three/
//
//        tbl.resize(8);
//
//        System.out.println("Afterze");
//
//        System.out.println("three+tbl.get("three        System.out.println("six+tbl.get("six
//        tbl.insert("hundred", 100);
//
//        System.out.println("hundred+tbl.get("hundred
//    }
//
//}
//}
