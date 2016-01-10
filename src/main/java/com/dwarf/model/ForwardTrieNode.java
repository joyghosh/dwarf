package com.dwarf.model;

import com.dwarf.util.DNSCacheConfig;

/**
 * Trie Node implementation for forward DNS cache.
 * @author Joy Ghosh.
 * @version 1.0
 */
public class ForwardTrieNode extends TrieNode {

	private String ipAddr;
	private ForwardTrieNode[] children; 
	
	public ForwardTrieNode() {
		super();
		this.children = new ForwardTrieNode[DNSCacheConfig.MAX_URL_CHARACTERS];
	}
	
	/**
	 * return IP stored on this node.
	 * @return
	 */
	public String getIpAddr() {
		return ipAddr;
	}
	
	/**
	 * set IP address on this node.
	 * @param ipAddr
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	/**
	 * return all child nodes.
	 * @return
	 */
	public ForwardTrieNode[] getChildren() {
		return children;
	}
	
	/**
	 * return ith child node.
	 * @param i
	 * @return
	 */
	public ForwardTrieNode getChild(int i){
		
		if(i < children.length){
			return children[i];
		}	
		return null;
	}
	
	/**
	 * set ith child node.
	 * @param i
	 * @param node
	 */
	public void setChild(int i, ForwardTrieNode node){
		if(i < children.length){
			children[i] = node;
		}
	}
	
	/**
	 * check if ith node is initialized.
	 * @param i
	 * @return
	 */
	public boolean isValidChild(int i){
		if(i < children.length){
			if(children[i] != null)
				return true;
		}
		return false;
	}
}
