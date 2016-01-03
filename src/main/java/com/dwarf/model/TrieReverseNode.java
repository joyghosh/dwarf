package com.dwarf.model;

import com.dwarf.util.DNSCacheConfig;

public class TrieReverseNode extends TrieNode {

	private String url;
	
	protected TrieReverseNode() {
		super(DNSCacheConfig.MAX_URL_CHARACTERS);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
