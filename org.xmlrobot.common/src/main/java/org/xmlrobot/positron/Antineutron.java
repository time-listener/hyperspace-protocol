/**
 * 
 */
package org.xmlrobot.positron;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 */
@XmlTransient
public abstract class Antineutron<K,V>
	extends Positron<K,V> {

	/**
	 * -96707186309422778L
	 */
	private static final long serialVersionUID = -96707186309422778L;
	
	/**
	 * {@link Antineutron} default class constructor.
	 */
	public Antineutron() {
		super();
	}
	/**
	 * {@link Antineutron} class constructor.
	 * @param type the type
	 */
	public Antineutron(Class<? extends Positron<K,V>> type) {
		super(type);
	}
	/**
	 * {@link Antineutron} class constructor.
	 * @param type the type
	 * @param key the key
	 * @param value the value
	 */
	public Antineutron(Class<? extends Positron<K,V>> type, 
			K key, V value) {
		super(type, key, value);
	}
	/**
	 * @param type the type
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 */
	public Antineutron(Class<? extends Positron<K,V>> type, 
			K key, V value, Positron<K,V> parent) {
		super(type, key, value, parent);		
	}
	/**
	 * {@link Antineutron} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 */
	public Antineutron(Class<? extends Positron<K,V>> type,	Class<? extends Positron<V,K>> antitype) {
		super(type, antitype);
	}
	/**
	 * {@link Antineutron} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param key the key
	 * @param value the value
	 */
	public Antineutron(Class<? extends Positron<K,V>> type,	Class<? extends Positron<V,K>> antitype, 
			K key, V value) {
		super(type, antitype, key, value);
	}
	/**
	 * {@link Antineutron} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 */
	public Antineutron(Class<? extends Positron<K,V>> type,	Class<? extends Positron<V,K>> antitype, 
		K key, V value, Positron<K,V> parent) {
		super(type, antitype, key, value, parent);		
	}
}
