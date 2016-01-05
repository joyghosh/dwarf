package com.dwarf.model;

import com.dwarf.util.DNSCacheConfig;

public class ReverseTrieNode extends TrieNode {

	private String url;
	
	public ReverseTrieNode() {
		super(DNSCacheConfig.MAX_URL_CHARACTERS);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
