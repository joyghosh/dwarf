package com.dwarf.util;

/**
 * Repository for DNS cache utility methods.
 * @author Joy Ghosh.
 * @version 1.0
 */
public class DNSCacheUtil {

	/**
	 * index of a child for a given IP character
	 * @param c IP character
	 * @return index
	 */
	public static int getIPIndex(char c){
		return ((c == '.') ? 10 : (c-'0'));
	}
	
	/**
	 * Character mapping for a given child index.
	 * @param index of child IP
	 * @return corresponding IP character.
	 */
	public static char getIPCharFromIndex(int index){
		return (char) ((index == 10) ? '.' : (index + '0'));
	}
	
	/**
	 * index of a child for a given URL character
	 * @param c URL character.
	 * @return index
	 */
	public static int getURLIndex(char c){
		return ((c == '.') ? 26 : (c-'a'));
	}
	
	/**
	 * Character mapping for a given child index.
	 * @param index of child URL
	 * @return corresponding URL character.
	 */
	public static char getURLCharFromIndex(int index){
		return (char) ((index == 26) ? '.' : (index + 'a'));
	}
}
