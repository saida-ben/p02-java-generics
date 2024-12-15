package org.mql.java.generics;

import java.util.Iterator;

// Interface représentant un contrat pour une liste générique
public interface List<T> {

    public void add(T e);
    public T remove(int index);
    public T get(int index);
    public int size();
    public void set(int index, T e);
    public boolean contains(T e);
    public void clear();
    public int indexOf(T e);
    public void reverse();
    public T removeFirst();
    public T removeLast();
    public Object[] toArray();
    public boolean isEmpty();
    public int sizeRecursive();
    public void addAll(List<T> other);
	public Iterator<T> iterator();
}
