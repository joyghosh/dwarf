package com.dwarf.cache;

import java.io.Serializable;

import com.dwarf.model.ForwardTrieNode;
import com.dwarf.util.DNSCacheUtil;

public class ForwardDNSCache implements IDNSCache<ForwardTrieNode>, Serializable {

	private static final long serialVersionUID = 4216513259316570304L;

	@Override
	public void insert(ForwardTrieNode root, String url, String ipAddr) {
		
		ForwardTrieNode pointer = root;
		for(int level=0;level<url.length();level++){
			
			int index = DNSCacheUtil.getURLIndex(url.charAt(level));
			if(!pointer.isValidChild(index)){
				pointer.setChild(index, new ForwardTrieNode());
			}
			pointer = pointer.getChild(index);
		}
	
		pointer.setLeaf(true);
		pointer.setIpAddr(ipAddr);
	}

	@Override
	public String searchCache(ForwardTrieNode root, String url) {
		
		ForwardTrieNode pointer = root;
		
		for(int level=0;level<url.length();level++){
			
			int index = DNSCacheUtil.getURLIndex(url.charAt(level));
			
			if(!pointer.isValidChild(index))
				return null;
			
			pointer = pointer.getChild(index);
		}
		
		if(pointer!=null && pointer.isLeaf())
			return pointer.getIpAddr();
		
		return null;
	}
}
