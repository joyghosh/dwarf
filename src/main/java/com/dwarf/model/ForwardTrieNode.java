package com.dwarf.model;

import com.dwarf.util.DNSCacheConfig;

public class ForwardTrieNode extends TrieNode {

	private String ipAddr;
	
	protected ForwardTrieNode() {
		super(DNSCacheConfig.MAX_IP_CHARACTERS);
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
}
