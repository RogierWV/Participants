package io.snynx.participants;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List and ListModel implementation to be a singleton for static access in MainForm while also serving as model for its display
 */
public class Storage implements List<Participation>, ListModel<Object> {
    private static Storage instance;
    private final ArrayList<Participation> list;
    private final ArrayList<ListDataListener> listeners;
    private Storage() {
        list = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    /**
     * Save internal storage to the specified file
     * @param path the path to the file save to
     */
    public void save(String path) {
        try {
            FileOutputStream s = new FileOutputStream(path);
            ObjectOutputStream enc = new ObjectOutputStream(s);
            enc.writeObject(list);
            enc.close();
        } catch (Exception e) {
            Throwable throwable = e;
            do {
                System.err.println(throwable.getMessage());
            } while((throwable = throwable.getCause()) != null);
        }
    }

    /**
     * Load specified file into internal storage
     * @param path the path to the file to load
     */
    @SuppressWarnings("unchecked") // cannot be checked and work correctly as far as I can tell, therefore ignore the warning
    public void load(String path) {
        try {
            FileInputStream s = new FileInputStream(path);
            ObjectInputStream enc = new ObjectInputStream(s);
            list.addAll((ArrayList<Participation>) enc.readObject());
            enc.close();
        } catch (Exception e) {
            Throwable throwable = e;
            do {
                System.err.println(throwable.getMessage());
            } while((throwable = throwable.getCause()) != null);
        }
    }

    public void sort() {
        list.sort(Comparator.comparingInt(p -> p.h()*60 + p.m()));
        notifyListeners();
    }

    // notify all listeners
    private void notifyListeners() {
        ListDataEvent le = new ListDataEvent(list,
                ListDataEvent.CONTENTS_CHANGED, 0, getSize());
        for (ListDataListener listener : listeners) {
            listener.contentsChanged(le);
        }
    }

    @Override
    public boolean add(Participation o) {
        try{
            if(o.checkConstraints()) {
                for (Participation p: list)
                    if(p.h() == o.h() && p.m() == o.m()) throw new IllegalArgumentException("Time slot already used by " + p.name() + "!");
                boolean ret = list.add(o);
                notifyListeners();
                return ret;
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid entry!", e);
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        boolean ret = list.remove(o);
        notifyListeners();
        return ret;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Participation> c) {
        boolean ret = list.addAll(c);
        notifyListeners();
        return ret;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Participation> c) {
        boolean ret = list.addAll(index, c);
        notifyListeners();
        return ret;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean ret = list.removeAll(c);
        notifyListeners();
        return ret;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
        notifyListeners();
    }

    @Override
    public Participation get(int index) {
        return list.get(index);
    }

    @Override
    public Participation set(int index, Participation element) {
        Participation ret = list.set(index, element);
        notifyListeners();
        return ret;
    }

    @Override
    public void add(int index, Participation element) {
        list.add(index, element);
        notifyListeners();
    }

    @Override
    public Participation remove(int index) {
        Participation ret = list.remove(index);
        notifyListeners();
        return ret;
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

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listeners.add(l);
    }
}