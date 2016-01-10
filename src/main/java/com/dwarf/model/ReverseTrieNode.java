package com.dwarf.model;

import com.dwarf.util.DNSCacheConfig;

/**
 * Trie Node implementation for reverse DNS cache.
 * @author Joy Ghosh.
 * @version 1.0
 */
public class ReverseTrieNode extends TrieNode {

	private String url;
	private ReverseTrieNode[] children;
	
	public ReverseTrieNode() {
		super();
		this.children = new ReverseTrieNode[DNSCacheConfig.MAX_URL_CHARACTERS];
	}
	
	/**
	 * return url stored on this node.
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * set url on this node.
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * return all child nodes.
	 * @return
	 */
	public ReverseTrieNode[] getChildren() {
		return children;
	}
	
	/**
	 * return ith child node.
	 * @param i
	 * @return
	 */
	public ReverseTrieNode getChild(int i){
		
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
	public void setChild(int i, ReverseTrieNode node){
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
