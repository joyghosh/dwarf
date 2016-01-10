package com.dwarf.cache;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dwarf.model.ReverseTrieNode;

public class ReverseDNSCacheTest {
	
	private IDNSCache<ReverseTrieNode> cache;
	private ReverseTrieNode root;
	
	@BeforeClass
	private void init(){
		cache = new ReverseDNSCache();
		root = new ReverseTrieNode();
	}
	
	@Test(description="test insert feature for reverse dns look-up cache")
	public void testInsert(){
		
		//insert mapping for home network.
		String url1 = "home.com";
		String ipAddr1 = "127.0.0.1";
		
		cache.insert(root, ipAddr1, url1);
		Assert.assertEquals(cache.searchCache(root, ipAddr1),url1,"returned wrong result.");
		
		//insert mapping for lounge network.
		String url2 = "lounge.com";
		String ipAddr2 = "127.0.1.1";
		
		cache.insert(root, ipAddr2, url2);
		Assert.assertEquals(cache.searchCache(root, ipAddr2),url2,"returned wrong result.");
	}
	
	@Test(description="test search feature of reverse dns cache")
	public void testSearch(){
		//search for invalid ipAddr.
		Assert.assertNull(cache.searchCache(root, "192.1.1.1"), 
				"expected null, returned something else instead.");
		
		//search for valid ipAddr.
		Assert.assertNotNull(cache.searchCache(root, "127.0.1.1"), 
				"expected valid url object, returned null instead.");
		Assert.assertEquals(cache.searchCache(root, "127.0.0.1"), "home.com", "returned incorrect value.");
	}
}
