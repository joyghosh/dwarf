package com.dwarf.cache;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dwarf.model.ForwardTrieNode;

public class ForwardDNSCacheTest {
	
	private IDNSCache<ForwardTrieNode> cache;
	
	@BeforeClass
	private void init(){
		cache = new ForwardDNSCache();
	}
	
	@Test(description="test insert forward dns lookup cache")
	public void testInsert(){
		
		String url = "home.com";
		String ipAddr = "127.0.0.1";
		ForwardTrieNode root = new ForwardTrieNode();
		
		cache.insert(root, url, ipAddr);
		Assert.assertEquals(cache.searchCache(root, url), url, "returned wrong result.");
	}
}
