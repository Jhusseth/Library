package model;

import HashTable.HashTable;
import Queue.Queue;

public class Stand {
	
	private char referent;
	private HashTable<Integer,Queue<Book>> hashtable;
	
	public char getReferent() {
		return referent;
	}
	
	public Stand(char referent, int size) {
		this.referent = referent;
		hashtable = new HashTable<Integer, Queue<Book>>(size) ;
	}
	public void setReferent(char referent) {
		this.referent = referent;
	}
	public HashTable<Integer, Queue<Book>> getHastable() {
		return hashtable;
	}
	public void setHastable(HashTable<Integer, Queue<Book>> hashtable) {
		this.hashtable = hashtable;
	}
	

}
