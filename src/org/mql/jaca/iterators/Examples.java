package org.mql.jaca.iterators;

import java.util.Iterator;
import java.util.LinkedList;

public class Examples {

	public Examples() {
		exp01();
	}
	
	// composent iterable
	void exp01() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 20; i++) {
			list.add(i);
		}
//		list.add(1);
//		list.add(2);
//		list.add(3);
		Iterator<Integer> iterator = list.iterator();
		System.out.println(iterator.getClass().getName());

		while (iterator.hasNext()) {
			int element = iterator.next();
			System.out.println(element);
		}
	}

	void exp02() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 20; i++) {
			list.add(i);
		}
        for(Integer element : list) {
        	System.out.println(element);
        }
	}
	

	public static void main(String[] args) {
	  new Examples();	
	}
	
	//iterator avec vector est de gaspillage  les list sont des structures iterables 
}
