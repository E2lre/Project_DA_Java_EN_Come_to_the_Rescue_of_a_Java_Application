package com.hemebiotech.analytics;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Map;
//import java.util.HashMap;
//import java.util.TreeMap;
import java.util.Comparator;

//https://www.journaldunet.fr/web-tech/developpement/1202393-comment-trier-une-map-par-valeurs-en-java/


public class ValueComparator implements Comparator<String> {
	
	private Map<String, Integer> base;
	
	public ValueComparator(Map<String, Integer> base) {
	this.base = base;
	}

	
	public int compare(String a, String b) {
		if (a.compareTo(b) >= 0) {
			return 1;
		} 
		else {
			return -1;
		}
	}
	public int compare2(String a, String b) {
		if (base.get(a) >= base.get(b)) {
			return -1;
		} 
		else {
			return 1;
		}
	}
}
