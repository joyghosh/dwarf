package com.dwarf.model;

import com.dwarf.util.DNSCacheConfig;

public class TrieForwardNode extends TrieNode {

	private String ipAddr;
	
	protected TrieForwardNode() {
		super(DNSCacheConfig.MAX_IP_CHARACTERS);
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
}
