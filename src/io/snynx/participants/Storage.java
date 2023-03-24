package io.snynx.participants;

import java.util.*;

public class Storage implements List<Participation> {
    private static Storage instance;
    private final ArrayList<Participation> list;
    private Storage() {
        list = new ArrayList<>();
    }

    @Override
    public boolean add(Participation o) {
        try{
            if(o.checkConstraints()) return list.add(o);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid entry!", e);
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Participation> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Participation> c) {
        return list.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Participation get(int index) {
        return list.get(index);
    }

    @Override
    public Participation set(int index, Participation element) {
        return list.set(index, element);
    }

    @Override
    public void add(int index, Participation element) {
        list.add(index, element);
    }

    @Override
    public Participation remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<Participation> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<Participation> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<Participation> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    public static Storage getInstance() {
        if(instance == null) instance = new Storage();
        return instance;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<Participation> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }
}
