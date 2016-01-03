package com.dwarf.model;

//Trie node.
public abstract class TrieNode{
	
	protected boolean isLeaf;
	protected TrieNode[] children;
	
	protected TrieNode(int size){
		this.isLeaf = false;
		this.children = new TrieNode[size];
	}
	
	public boolean isLeaf() {
		return isLeaf;
	}
	
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public TrieNode[] getChildren() {
		return children;
	}
	
	public void setChildren(TrieNode[] children) {
		this.children = children;
	}
}
