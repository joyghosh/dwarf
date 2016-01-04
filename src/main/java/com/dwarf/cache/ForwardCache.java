package com.dwarf.cache;

import java.io.Serializable;

import com.dwarf.model.TrieNode;

public class ForwardCache implements IDNSCache, Serializable {

	private static final long serialVersionUID = 4216513259316570304L;

	@Override
	public void insert(TrieNode root, String url, String ipAddr) {
		
	}

	@Override
	public String searchCache(TrieNode root, String url) {
		return null;
	}
}
