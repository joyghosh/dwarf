package com.dwarf.model;

import com.dwarf.util.DNSCacheConfig;

public class ForwardTrieNode extends TrieNode {

	private String ipAddr;
	private ForwardTrieNode[] children; 
	
	public ForwardTrieNode() {
		super();
		this.children = new ForwardTrieNode[DNSCacheConfig.MAX_URL_CHARACTERS];
//		for(int i=0; i<DNSCacheConfig.MAX_URL_CHARACTERS; i++)
//			children[i] = null;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	public ForwardTrieNode[] getChildren() {
		return children;
	}
	
	public ForwardTrieNode getChild(int i){
		
		if(i < children.length){
			return children[i];
		}	
		return null;
	}
	
	public void setChild(int i, ForwardTrieNode node){
		if(i < children.length){
			children[i] = node;
		}
	}
	
	public boolean isValidChild(int i){
		if(i < children.length){
			if(children[i] != null)
				return true;
		}
		return false;
	}
}
