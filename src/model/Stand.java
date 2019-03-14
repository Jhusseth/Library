package model;

import java.util.Queue;

import HashTable.HashTable;

public class Stand {
	
	private char referent;
	private HashTable<Integer,Queue<Book>> hashtable;
	
	public char getReferent() {
		return referent;
	}
	
	public Stand(char referent) {
		this.referent = referent;
		this.hashtable = null;
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
