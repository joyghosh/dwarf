package com.dwarf.util;

public class DNSCacheUtil {

	//return the index of a child for a given character c.
	public static int getIPIndex(char c){
		return ((c == '.') ? 10 : (c-'0'));
	}
	
	//find the character for a given child index.
	public static char getIPCharFromIndex(int index){
		return (char) ((index == 10) ? '.' : (index + '0'));
	}
	
	public static int getURLIndex(char c){
		return ((c == '.') ? 26 : (c-'a'));
	}
	
	public static char getURLCharFromIndex(int index){
		return (char) ((index == 26) ? '.' : (index + 'a'));
	}
}
