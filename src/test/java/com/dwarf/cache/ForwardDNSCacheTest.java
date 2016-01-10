package com.dwarf.cache;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dwarf.model.ForwardTrieNode;

public class ForwardDNSCacheTest {
	
	private IDNSCache<ForwardTrieNode> cache;
	private ForwardTrieNode root;
	
	@BeforeClass
	private void init(){
		cache = new ForwardDNSCache();
		root = new ForwardTrieNode();
	}
	
	@Test(description="test insert feature for forward dns lookup cache.")
	public void testInsert(){
		
		//insert mapping for home network.
		String url1 = "home.com";
		String ipAddr1 = "127.0.0.1";
		
		cache.insert(root, url1, ipAddr1);
		Assert.assertEquals(cache.searchCache(root, url1), ipAddr1, "returned wrong result.");
		
		//insert mapping for lounge.
		String url2 = "lounge.com";
		String ipAddr2 = "127.0.1.1";
		
		cache.insert(root, url2, ipAddr2);
		Assert.assertEquals(cache.searchCache(root, url2), ipAddr2, "returned wrong result.");
	}
	
	@Test(description="test search feature of forward dns cache.")
	public void testSearch(){
		//search for invalid url.
		Assert.assertNull(cache.searchCache(root, "inavlidurl.com"), 
				"expected null, returned something else instead.");
	}
}
