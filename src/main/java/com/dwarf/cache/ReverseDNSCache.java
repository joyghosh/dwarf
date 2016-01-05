package com.dwarf.cache;

import java.io.Serializable;

import com.dwarf.model.ReverseTrieNode;
import com.dwarf.util.DNSCacheUtil;

public class ReverseDNSCache implements IDNSCache<ReverseTrieNode>, Serializable {
	
	private static final long serialVersionUID = 221602003068049447L;

	@Override
	public void insert(ReverseTrieNode root, String ipAddr, String url) {
		
		ReverseTrieNode pointer = root;
		
		for(int level = 0; level < ipAddr.length(); level++){
			int index = DNSCacheUtil.getIPIndex(ipAddr.charAt(level));
			
			if(pointer.getChildren()[index] == null){
				pointer.getChildren()[index] = new ReverseTrieNode();
			}
			
			pointer = (ReverseTrieNode) pointer.getChildren()[index];
		}
		
		//Last node processing for mapping.
		pointer.setLeaf(true);
		pointer.setUrl(url);
	}

	@Override
	public String searchCache(ReverseTrieNode root, String ipAddr) {
		
		ReverseTrieNode pointer = root;
		
		for(int level = 0;level < ipAddr.length(); level++){	
			
			//get the ip char to index mapping.
			int index = DNSCacheUtil.getIPIndex(ipAddr.charAt(level));
			
			//no such mapping found. return null.
			if(pointer.getChildren()[index] == null)
				return null;
			
			//move to next child node.
			pointer = (ReverseTrieNode) pointer.getChildren()[index];
		}
		
		//if the last node is reached and is valid node then return the url.
		if(pointer!=null && pointer.isLeaf())
			return pointer.getUrl();
		
		return null;
	}
}
