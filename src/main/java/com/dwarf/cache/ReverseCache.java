package com.dwarf.cache;

import java.io.Serializable;

import com.dwarf.model.ReverseTrieNode;
import com.dwarf.util.DNSCacheUtil;

public class ReverseCache implements IDNSCache<ReverseTrieNode>, Serializable {
	
	private static final long serialVersionUID = 221602003068049447L;

	@Override
	public void insert(ReverseTrieNode root, String ipAddr, String url) {
		
		ReverseTrieNode pointer = root;
		
		for(int level = 0; level < ipAddr.length(); level++){
			int index = DNSCacheUtil.getIPIndex(ipAddr.charAt(level));
			
		}
	}

	@Override
	public String searchCache(ReverseTrieNode root, String ipAddr) {
		
		return null;
	}
}
