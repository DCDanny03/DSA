package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;


import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * An unordered link-based map is an unordered (meaning keys are not used to
 * order entries) linked-memory representation of the Map abstract data type.
 * This link-based map delegates to an existing doubly-linked positional list.
 * To help self-organizing entries to improve efficiency of lookUps, the
 * unordered link-based map implements the move-to-front heuristic: each time an
 * entry is accessed, it is shifted to the front of the internal list.
 * 
 * @author Dr. King
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class UnorderedLinkedMap<K, V> extends AbstractMap<K, V> {

	/** Positional List Map */
    private PositionalList<Entry<K, V>> list;
    
    /**
     * Unordered Linked Map Constructor
     */
    public UnorderedLinkedMap() {
        this.list = new PositionalLinkedList<Entry<K, V>>();
    }
    
    private Position<Entry<K, V>> lookUp(K key)
    {
        //int n = list.size();
        Position<Entry<K, V>> current = list.first();
        while(current != null) { //stop before last element
        	if (current.getElement().getKey().equals(key)) {
        		return current;
        	}
        	current = list.after(current);
        }
    	return null; //if Key was not found
        
    }

    @Override
    public V get(K key) {
        Position<Entry<K, V>> p = lookUp(key);
        //moveToFront(p);
        if (p == null){
        	return null;
        }
        moveToFront(p);
        return p.getElement().getValue();
    }
    
    private void moveToFront(Position<Entry<K, V>> position) {
        list.addFirst(position.getElement());
        list.remove(position);
        
    }

    /**
     * if the key already exists in the map, 
     * update the entry with the given key to have the new value. 
     * To facilitate efficient lookUps, apply the move-to-front heuristic on the 
     * updated entry, then return the original value that was replaced. 
     * Otherwise, if the key does not already exist, insert the new key-value pair 
     * at the front of the list (to help facilitate efficient lookUps).
     */
    @Override
    public V put(K key, V value) {
        Position<Entry<K, V>> p = lookUp(key);
        MapEntry<K, V> add = new MapEntry<K, V>(key, value);
        if(p == null) {
        	list.addFirst(add);
        	return null;
        } else {
        	
        	moveToFront(p);
        	V ret = list.first().getElement().getValue();
        	//list.remove(p);
        	((MapEntry<K, V>) p.getElement()).setValue(value);
        	//moveToFront(p);
        	return ret;
        	
        }
    }
    
    @Override
    public V remove(K key) {
       Position<Entry<K, V>> p = lookUp(key);
       if(p == null) {
    	   return null;
       } else {
    	   //moveToFront(p);
    	   //V ret = list.first().getElement().getValue();
    	   V ret = p.getElement().getValue();
    	   list.remove(p);
    	   return ret;
       }
       
    }
    
    @Override
    public int size() {
        return list.size();
    }
    
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        EntryCollection collection = new EntryCollection();
        for(Entry<K, V> entry : list) {
            collection.add(entry);
        }
        return collection;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UnorderedLinkedMap[");
        Iterator<Entry<K, V>> it = list.iterator();
        while(it.hasNext()) {
            sb.append(it.next().getKey());
            if(it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
}
