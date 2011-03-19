package net.zj.hz.yk.concurrent;

import net.zj.hz.yk.classload.Main;

public class HashAlgorithms {
	/**  
	* 加法hash  
	* @param key 字符串  
	* @param prime 一个质数  
	* @return hash结果  
	*/  
	public static int additiveHash(String key, int prime)   
	{   
	   int hash, i;   
	   for (hash = key.length(), i = 0; i < key.length(); i++)   
	    hash += key.charAt(i);   
	   return (hash % prime);   
	}   
	
	
	public static void main(String[] args) {
		int v1=additiveHash("dddddd", 31);
		int v2=additiveHash("aaaaa", 31);
		int v3=additiveHash("cccc", 31);
		System.out.println("@@@@hash value="+v1+" ; "+v2+" ;"+v3);
	}
}
