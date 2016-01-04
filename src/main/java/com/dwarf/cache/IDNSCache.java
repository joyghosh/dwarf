package com.dwarf.cache;


public interface IDNSCache<T> {
	
	void insert(T root, String param1, String param2);
	String searchCache(T root, String param);
}
