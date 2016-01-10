package com.dwarf.cache;

import java.io.Serializable;

import com.dwarf.model.ReverseTrieNode;
import com.dwarf.util.DNSCacheUtil;

/**
 * Reverse DNS look-up cache implementation.
 * @author Joy Ghosh.
 * @version 1.0
 */
public class ReverseDNSCache implements IDNSCache<ReverseTrieNode>, Serializable {
	
	private static final long serialVersionUID = 221602003068049447L;
	
	/**
	 * Insert IP address to URL mapping.
	 * @param ipAddr IP address as key.
	 * @param url URL as value.
	 */
	@Override
	public void insert(ReverseTrieNode root, String ipAddr, String url) {
		
		ReverseTrieNode pointer = root;
		
		for(int level = 0; level < ipAddr.length(); level++){
			
			int index = DNSCacheUtil.getIPIndex(ipAddr.charAt(level));
			if(!pointer.isValidChild(index)){
				pointer.setChild(index, new ReverseTrieNode());
			}
			
			pointer = pointer.getChild(index);
		}
		
		//Last node processing for mapping.
		pointer.setLeaf(true);
		pointer.setUrl(url);
	}
	
	/**
	 * Look-up for a valid IP to URL mapping.
	 * @param root Root node of the cache.
	 * @param ipAddr IP address which needs to be looked up.
	 * @return valid URL if mapping exists, else null.
	 */
	@Override
	public String searchCache(ReverseTrieNode root, String ipAddr) {
		
		ReverseTrieNode pointer = root;
		
		for(int level = 0;level < ipAddr.length(); level++){	
			
			//get the ip char to index mapping.
			int index = DNSCacheUtil.getIPIndex(ipAddr.charAt(level));
			
			//no such mapping found. return null.
			if(!pointer.isValidChild(index))
				return null;
			
			//move to next child node.
			pointer = pointer.getChild(index);
		}
		
		//if the last node is reached and is valid node then return the url.
		if(pointer!=null && pointer.isLeaf())
			return pointer.getUrl();
		
		return null;
	}
}
