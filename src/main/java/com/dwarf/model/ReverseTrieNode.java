package com.dwarf.model;

import com.dwarf.util.DNSCacheConfig;

public class ReverseTrieNode extends TrieNode {

	private String url;
	private ReverseTrieNode[] children;
	
	public ReverseTrieNode() {
		super();
		this.children = new ReverseTrieNode[DNSCacheConfig.MAX_URL_CHARACTERS];
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ReverseTrieNode[] getChildren() {
		return children;
	}
	
	public ReverseTrieNode getChild(int i){
		
		if(i < children.length){
			return children[i];
		}	
		return null;
	}
	
	public void setChild(int i, ReverseTrieNode node){
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
