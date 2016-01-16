package com.dwarf.model;

/**
 * Generic DNS Trie node.
 * @author Joy Ghosh.
 * @version 1.0
 */
public abstract class TrieNode{
	
	protected boolean isLeaf;
	protected int level;
	protected String serverId;			//for horizontal partitioning.
	
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
	
	/**
	 * fetch the level of the node.
	 * @return
	 */
	public int getLevel(){
		return this.level;
	}
	
	/**
	 * set the level of the node.
	 * @param level
	 */
	public void setLevel(int level){
		this.level = level;
	}
	
	/**
	 * fetch server id for distributed look-up.
	 * @return the server id to look for next node.
	 */
	public String getServerId(){
		return this.serverId;
	}
	
	/**
	 * set the server id to look-up for this node.
	 * @param serverId
	 */
	public void setServerId(String serverId){
		this.serverId = serverId;
	}
}
