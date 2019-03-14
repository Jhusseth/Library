package model;

import HashTable.HashTable;
import Queue.Queue;

public class Stand {
	
	private char referent;
	private HashTable<ISBN,Queue<Book>> hashtable;
	
	public char getReferent() {
		return referent;
	}
	
	public Stand(char referent, int size) {
		this.referent = referent;
		hashtable = new HashTable<ISBN, Queue<Book>>(size) ;
	}
	public void setReferent(char referent) {
		this.referent = referent;
	}
	public HashTable<ISBN, Queue<Book>> getHastable() {
		return hashtable;
	}
	public void setHastable(HashTable<ISBN, Queue<Book>> hashtable) {
		this.hashtable = hashtable;
	}
	

}
