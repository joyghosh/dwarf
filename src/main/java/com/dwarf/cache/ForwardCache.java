package com.dwarf.cache;

import java.io.Serializable;

import com.dwarf.model.ForwardTrieNode;

public class ForwardCache implements IDNSCache<ForwardTrieNode>, Serializable {

	private static final long serialVersionUID = 4216513259316570304L;

	@Override
	public void insert(ForwardTrieNode root, String url, String ipAddr) {
		
	}

	@Override
	public String searchCache(ForwardTrieNode root, String url) {
		return null;
	}
}
