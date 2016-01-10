package com.dwarf.cache;

/**
 * Generic DNS cache interface.
 * @author Joy Ghosh.
 * @param <T> for reverse or forward cache node.
 * @version 1.0
 */
public interface IDNSCache<T> {
	
	void insert(T root, String param1, String param2);
	String searchCache(T root, String param);
}
