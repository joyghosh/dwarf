package com.dwarf.cache;

import java.io.Serializable;

import com.dwarf.model.ForwardTrieNode;
import com.dwarf.util.DNSCacheUtil;

/**
 * Forward DNS look-up cache implementation.
 * @author Joy Ghosh.
 * @version 1.0
 */
public class ForwardDNSCache implements IDNSCache<ForwardTrieNode>, Serializable {

	private static final long serialVersionUID = 4216513259316570304L;
	
	/**
	 * Insert URL to IP address mapping.
	 * @param url URL as key.
	 * @param ipAddr IP address as value.
	 */
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
	
	/**
	 * Look-up for a valid URL to IP mapping.
	 * @param root Root node of the cache.
	 * @param url URL which needs to be looked up.
	 * @return valid IP address if mapping exists, else null.
	 */
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
