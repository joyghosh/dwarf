package com.dwarf.model;

/**
 * Generic DNS Trie node.
 * @author Joy Ghosh.
 * @version 1.0
 */
public abstract class TrieNode{
	
	protected boolean isLeaf;
	
	protected TrieNode(){
		this.isLeaf = false;
	}
	
	/**
	 * check whether this node is leaf.
	 * @return
	 */
	public boolean isLeaf() {
		return isLeaf;
	}
	
	/**
	 * set this node as leaf node.
	 * @param isLeaf
	 */
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}
