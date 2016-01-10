package com.dwarf.model;

//Trie node.
public abstract class TrieNode{
	
	protected boolean isLeaf;
	
	protected TrieNode(){
		this.isLeaf = false;
	}
	
	public boolean isLeaf() {
		return isLeaf;
	}
	
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}
