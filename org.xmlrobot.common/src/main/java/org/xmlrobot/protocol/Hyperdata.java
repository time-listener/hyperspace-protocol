/**
 * 
 */
package org.xmlrobot.protocol;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;
import org.xmlrobot.util.Statement;

/**
 * @author joan
 *
 */
public class Hyperdata
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Hyperheader
			implements TimeListener<K,V> {

	/**
	 * -6553995417644392629L
	 */
	private static final long serialVersionUID = -6553995417644392629L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#root()
	 */
	@Override
	public TimeListener<K,V> root() {
		return getKey().root();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#getKey()
	 */
	@Override
	public K getKey() {
		return getAndCast(KEY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#getValue()
	 */
	@Override
	public V getValue() {
		return getAndCast(VALUE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		return getAndSet(VALUE, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#call()
	 */
	@Override
	public K getParent() {
		return getAndCast(PARENT);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#setParent(java.lang.Object)
	 */
	@Override
	public K setParent(K listener) {
		return getAndSet(PARENT, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#getChild()
	 */
	@Override
	public V getChild() {
		return getAndCast(CHILD);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#setChild(java.lang.Object)
	 */
	@Override
	public V setChild(V child) {
		return getAndSet(CHILD, child);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public K call() {
		return getAndCast(PAST);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#put(java.lang.Object)
	 */
	@Override
	public K put(K listener) {
		return getAndSet(PAST, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#get()
	 */
	@Override
	public V get() {
		return getAndCast(FUTURE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#set(java.lang.Object)
	 */
	@Override
	public V set(V listener) {
		return getAndSet(FUTURE, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#getType()
	 */
	@Override
	public Class<? extends K> getType() {
		return getAndCast(TYPE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#setType(java.lang.Class)
	 */
	@Override
	public void setType(Class<? extends K> type) {
		set(TYPE, type);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#getRoot()
	 */
	@Override
	public K getRoot() {
		return getAndCast(ROOT);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#setRoot(java.lang.Object)
	 */
	@Override
	public K setRoot(K listener) {
		return getAndSet(ROOT, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#getStem()
	 */
	@Override
	public V getStem() {
		return getAndCast(STEM);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#setStem(java.lang.Object)
	 */
	@Override
	public V setStem(V listener) {
		return getAndSet(STEM, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#getAntitype()
	 */
	@Override
	public Class<? extends V> getAntitype() {
		return getAndCast(ANTITYPE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#setAntiype(java.lang.Class)
	 */
	@Override
	public void setAntitype(Class<? extends V> antitype) {
		set(ANTITYPE, antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#dna()
	 */
	@Override
	public Hyperdata<K,V> dna() {
		return getAndCast(DNA);
	}
	
	/**
	 * 
	 * {@link Hyperdata} default class constructor.
	 */
	public Hyperdata() {
		this(Parity.YY);
	}
	/**
	 * {@link Hyperdata} class constructor.
	 * @param gen is the gender
	 */
	public Hyperdata(Parity gen) {
		// create message header
		super(new Hyperheader(gen));
		// declare dna
		declareAndSet(DNA, this);
		// declare type
		this.<Class<? extends K>>declare(TYPE);
		// declare antitype
		this.<Class<? extends V>>declare(ANTITYPE);
		// declare value
		this.<V>declare(VALUE);
		// declare key
		this.<K>declare(KEY);
		// declare root
		this.<K>declare(ROOT);
		// declare stem
		this.<V>declare(STEM);
		// declare child
		this.<V>declare(CHILD);
		// declare parent
		this.<K>declare(PARENT);
		// declare past
		this.<V>declare(PAST);
		// declare future
		this.<K>declare(FUTURE);
	}
	/**
	 * {@link Hyperdata} class constructor.
	 * @param type is the class
	 * @param key is the value
	 * @param gen is the parity
	 */
	public Hyperdata(Class<? extends K> type, K key, Parity gen) {
		this(gen);
		// inherit key
		set(KEY, key);
		// inherit type
		set(TYPE, type);
	}
	/**
	 * {@link Hyperdata} unification class constructor.
	 * @param type is the class
	 * @param key is the value
	 * @param gen is the parity
	 */
	public Hyperdata(Class<? extends K> type, Class<? extends V> antitype, K key, V value, Parity gen) {
		this(type, key, gen);
		// inherit value
		set(VALUE, value);
		// inherit antitype
		set(ANTITYPE, antitype);
	}
	/**
	 * {@link Hyperdata} unification class constructor.
	 * @param type is the class
	 * @param key is the value
	 * @param gen is the parity
	 */
	public Hyperdata(Class<? extends K> type, K key, K root, V stem, Parity gen) {
		this(type, key, root.getGen());
		// inherit value
		set(ROOT, root);
		// inherit antitype
		set(STEM, stem);
	}
	/**
	 * {@link Hyperdata} unification class constructor.
	 * @param type is the class
	 * @param key is the value
	 * @param gen is the parity
	 */
	public Hyperdata(Class<? extends K> type, Class<? extends V> antitype, K key, V value, K root, V stem, Parity gen) {
		this(type, antitype, key, value, gen);
		// inherit value
		set(ROOT, root);
		// inherit antitype
		set(STEM, stem);
	}
	/**
	 * {@link Hyperdata} unification class constructor.
	 * @param type is the class
	 * @param key is the value
	 * @param gen is the parity
	 */
	public Hyperdata(Class<? extends K> type, K key, K parent, V child) {
		this(type, key, parent.getGen());
		// inherit value
		set(PARENT, parent);
		// inherit antitype
		set(CHILD, child);
		// inherit value
		set(ROOT, parent.getRoot());
		// inherit antitype
		set(STEM, child.getRoot());
	}
	/**
	 * {@link Hyperdata} unification class constructor.
	 * @param type is the class
	 * @param key is the value
	 * @param gen is the parity
	 */
	public Hyperdata(Class<? extends K> type, Class<? extends V> antitype, K key, V value, K parent, V child) {
		this(type, antitype, key, value, parent.getGen());
		// inherit value
		set(PARENT, parent);
		// inherit antitype
		set(CHILD, child);
		// inherit value
		set(ROOT, parent.getRoot());
		// inherit antitype
		set(STEM, child.getRoot());
	}
	/**
	 * @param data
	 */
	protected Hyperdata(Hyperdata<K,V> data) {
		super(data);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {
		return getKey().clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperheader#clear(org.xmlrobot.MassListener)
	 */
	@Override
	public void clear(MassListener sender) {
		getKey().clear(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#getKey(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<K,V> acquireKey(MassListener sender, AtomicInteger N) {
		return getKey().acquireKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#callPastKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tachyon<K,V> callPastKey(MassListener sender) {
		return getKey().callPastKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#isPast()
	 */
	@Override
	public boolean isPast() {
		return getKey().isPast();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperheader#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return getKey().isEmpty();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#recurrence(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public AtomicInteger recurrence(MassListener sender, AtomicInteger N) {
		return getKey().recurrence(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#containsKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean holdsKey(MassListener sender, Tachyon<K,V> listener) {
		return getKey().holdsKey(sender, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#orderSuperKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderSuperKey(MassListener sender, Tachyon<K,V> event) {
		getKey().orderSuperKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void releaseKey(MassListener sender) {
		getKey().releaseKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void releaseKey(MassListener sender, Tachyon<K,V> event) {
		getKey().releaseKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseKeyIf(org.xmlrobot.genesis.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void releaseKeyIf(MassListener sender, Statement<? super K> filter) {
		getKey().releaseKeyIf(sender, filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#revolveKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void revolveKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		getKey().revolveKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#rotateKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void rotateKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		getKey().rotateKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#submitKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void submitKey(MassListener sender, Tachyon<K,V> event) {
		getKey().submitKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#swapKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void swapKey(MassListener sender, Tachyon<K,V> event) {
		getKey().swapKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#getValue(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<V,K> acquireValue(MassListener sender, AtomicInteger N) {
		return getKey().acquireValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#isFuture()
	 */
	@Override
	public boolean isFuture() {
		return getKey().isFuture();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#concurrence(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public AtomicInteger concurrence(MassListener sender, AtomicInteger N) {
		return getKey().concurrence(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#getFutureValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tachyon<V,K> getFutureValue(MassListener sender) {
		return getKey().getFutureValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#containsValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean holdsValue(MassListener sender, Tachyon<V,K> listener) {
		return getKey().holdsValue(sender, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#orderInferValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderInferValue(MassListener sender, Tachyon<V,K> event) {
		getKey().orderInferValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#permuteValueOffspring(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void permuteValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		getKey().permuteValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void releaseValue(MassListener sender) {
		getKey().releaseValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void releaseValue(MassListener sender, Tachyon<V,K> event) {
		getKey().releaseValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseValueIf(org.xmlrobot.genesis.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void releaseValueIf(MassListener sender, Statement<? super V> filter) {
		getKey().releaseValueIf(sender, filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#revolveValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void revolveValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		getKey().revolveValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#rotateValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void rotateValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		getKey().rotateValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#submitValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void submitValue(MassListener sender, Tachyon<V,K> event) {
		getKey().submitValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#swapValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void swapValue(MassListener sender, Tachyon<V,K> event) {
		getKey().swapValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#allocate(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void allocateValue(MassListener sender, Tachyon<V,K> event) {
		getKey().allocateValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#release(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void removeValue(MassListener sender, Tachyon<V,K> event) {
		getKey().removeValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#push(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void deliverValue(MassListener sender, Tachyon<V,K> event) {
		getKey().deliverValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#order(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderValue(MassListener sender, Tachyon<V,K> event) {
		getKey().orderValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pulse(MassListener sender, Tachyon<V,K> event) {
		getKey().pulse(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void echo(MassListener source, Tachyon<K,V> event) {
		getKey().echo(source, event);
	}
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(V o1, V o2) {
		return getKey().compare(o1, o2);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#reproduceTo(java.lang.Object)
	 */
	@Override
	public int reproduceTo(V o) {
		return getKey().reproduceTo(o);
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(K o) {
		return getKey().compareTo(o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproductor#reproduce(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int reproduce(K key, V value) {
		return getKey().reproduce(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#matrix()
	 */
	@Override
	public TimeListener.Transmitter<K,V> matrix() {
		return getKey().matrix();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproductor#output()
	 */
	@Override
	public V output() {
		return getKey().output();
	}
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<K> iterator() {
		return getKey().iterator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Enumerable#enumerator()
	 */
	@Override
	public Enumeration<V> enumerator() {
		return getKey().enumerator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#keySet()
	 */
	@Override
	public Set<K> keySet() {
		return getKey().keySet();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#valueSet()
	 */
	@Override
	public Set<V> valueSet() {
		return getKey().valueSet();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#injectKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pushKey(MassListener sender, Tachyon<K,V> event) {
		getKey().pushKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void redeemKey(MassListener sender) {
		getKey().redeemKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void redeemKey(MassListener sender, Tachyon<K,V> event) {
		getKey().redeemKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeKeyIf(org.xmlrobot.genesis.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void redeemKeyIf(MassListener sender, Statement<? super K> filter) {
		getKey().redeemKeyIf(sender, filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void redeemValue(MassListener sender) {
		getKey().redeemValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void redeemValue(MassListener sender, Tachyon<V,K> event) {
		getKey().redeemValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeValueIf(org.xmlrobot.genesis.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void redeemValueIf(MassListener sender, Statement<? super V> filter) {
		getKey().redeemValueIf(sender, filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#orderInferKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderInferKey(MassListener sender, Tachyon<K,V> event) {
		getKey().orderInferKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#pollKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pollKey(MassListener sender, Tachyon<K,V> event) {
		getKey().pollKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#orderSuperValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderSuperValue(MassListener sender, Tachyon<V,K> event) {
		getKey().orderSuperValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#pollValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pollValue(MassListener sender, Tachyon<V,K> event) {
		getKey().pollValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#popKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void popKey(MassListener sender, Tachyon<K,V> event) {
		getKey().popKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#popValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void popValue(MassListener sender, Tachyon<V,K> event) {
		getKey().popValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#permuteKeyAncestry(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void permuteKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		getKey().permuteKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#callValue(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<V,K> callValue(MassListener sender, AtomicInteger N) {
		return getKey().callValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#callKey(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<K,V> callKey(MassListener sender, AtomicInteger N) {
		return getKey().callKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pushValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void injectValue(MassListener sender, Tachyon<V,K> event) {
		getKey().injectValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#spinKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void spinKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		getKey().spinKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#spinValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void spinValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		getKey().spinValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#orderStrongKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderStrongKey(MassListener sender, Tachyon<K,V> event) {
		getKey().orderStrongKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#orderWeakValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderWeakValue(MassListener sender, Tachyon<V,K> event) {
		getKey().orderWeakValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#hasKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean hasKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().hasKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#hasValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean hasValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().hasValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#getFutureKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tachyon<K,V> getFutureKey(MassListener sender) {
		return getKey().getFutureKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#callPastValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tachyon<V,K> callPastValue(MassListener sender) {
		return getKey().callPastValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#inheritance()
	 */
	@Override
	public Map<K,V> inheritance() {
		return getKey().inheritance();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#getValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> acquireValue(MassListener sender, Tachyon<K,V> event) {
		return getKey().acquireValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#getKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> acquireKey(MassListener sender, Tachyon<V,K> event) {
		return getKey().acquireKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#callValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> callValue(MassListener sender, Tachyon<K,V> event) {
		return getKey().callValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#callKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> callKey(MassListener sender, Tachyon<V,K> event) {
		return getKey().callKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void liberateKey(MassListener sender, Tachyon<K,V> event) {
		getKey().liberateKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void liberateValue(MassListener sender, Tachyon<V,K> event) {
		getKey().liberateValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#putValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> assignValue(MassListener sender, Tachyon<K,V> key, Tachyon<V,K> value) {
		return getKey().assignValue(sender, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#putKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> assignKey(MassListener sender, Tachyon<V,K> value, Tachyon<K,V> key) {
		return getKey().assignKey(sender, value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperheader#addMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		getKey().addMassListener(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperheader#removeMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void removeMassListener(MassListener listener) {
		getKey().removeMassListener(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#flipKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void flipKey(MassListener sender, Tachyon<K,V> event) {
		getKey().flipKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#flopKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void flopKey(MassListener sender, Tachyon<K,V> event) {
		getKey().flopKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pushKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void injectKey(MassListener sender, Tachyon<K,V> event) {
		getKey().injectKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void liberateKey(MassListener sender) {
		getKey().liberateKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemKeyIf(org.xmlrobot.genesis.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void liberateKeyIf(MassListener sender, Statement<? super K> filter) {
		getKey().liberateKeyIf(sender, filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#injectValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pushValue(MassListener sender, Tachyon<V,K> event) {
		getKey().pushValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#flopValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void flopValue(MassListener sender, Tachyon<V,K> event) {
		getKey().flopValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#flipValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void flipValue(MassListener sender, Tachyon<V,K> event) {
		getKey().flipValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void liberateValue(MassListener sender) {
		getKey().liberateValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemValueIf(org.xmlrobot.genesis.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void liberateValueIf(MassListener sender, Statement<? super V> event) {
		getKey().liberateValueIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperheader#unify()
	 */
	@Override
	public void unify(MassListener sender) {
		getKey().unify(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#belongsKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean belongsKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().belongsKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#belongsValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean belongsValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().belongsValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#giveKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> giveKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().giveKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#giveValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> giveValue(MassListener sender, Tachyon<V,K> antievent) {
		return getKey().giveValue(sender, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#takeKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> takeKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().takeKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#takeValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> takeValue(MassListener sender, Tachyon<V,K> antievent) {
		return getKey().takeValue(sender, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#setValue(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> putValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getKey().putValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#setKey(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> putKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getKey().putKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#putKey(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> assignKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getKey().assignKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#putValue(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> assignValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getKey().assignValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeKey(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void redeemKey(MassListener sender, AtomicInteger N) {
		getKey().redeemKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeValue(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void redeemValue(MassListener sender, AtomicInteger N) {
		getKey().redeemValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseKey(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void releaseKey(MassListener sender, AtomicInteger N) {
		getKey().releaseKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseValue(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void releaseValue(MassListener sender, AtomicInteger N) {
		getKey().releaseValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#recursion(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public AtomicInteger recursion(MassListener sender, AtomicInteger N) {
		return getKey().recursion(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#orderOfKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger orderOfKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().orderOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#orderOfValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger orderOfValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().orderOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#indexOfKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger pointerOfKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().pointerOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#indexOfValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger pointerOfValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().pointerOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#positionOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger positionOfKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().positionOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#positionOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger positionOfValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().positionOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#visitKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> requestKey(MassListener sender, Tachyon<V,K> antievent) {
		return getKey().requestKey(sender, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#visitValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> requestValue(MassListener sender, Tachyon<K,V> event) {
		return getKey().requestValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#visitValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<V,K> requestValue(MassListener sender, AtomicInteger N) {
		return getKey().requestValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#visitKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<K,V> requestKey(MassListener sender, AtomicInteger N) {
		return getKey().requestKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#updateKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> updateKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getKey().updateKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#updateValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> updateValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getKey().updateValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#allocateKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void allocateKey(MassListener sender, Tachyon<K,V> event) {
		getKey().allocateKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#killKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void removeKey(MassListener sender, Tachyon<K,V> event) {
		getKey().removeKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#deliverKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void deliverKey(MassListener sender, Tachyon<K,V> event) {
		getKey().deliverKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#orderKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderKey(MassListener sender, Tachyon<K,V> event) {
		getKey().orderKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#updateKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> updateKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		return getKey().updateKey(sender, antievent, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#updateValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> updateValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		return getKey().updateValue(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pingValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pingValue(MassListener sender, Tachyon<V,K> event) {
		getKey().pingValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pingKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pingKey(MassListener sender, Tachyon<K,V> event) {
		getKey().pingKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pongKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pongKey(MassListener sender, Tachyon<K,V> event) {
		getKey().pongKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pongValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pongValue(MassListener sender, Tachyon<V,K> event) {
		getKey().pongValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#putKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> putKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		return getKey().putKey(sender, antievent, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#putValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> putValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		return getKey().putValue(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#holdsKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean containsKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().containsKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#holdsValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean containsValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().containsValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#pointerOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger indexOfKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().indexOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#lastPointerOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger lastIndexOfKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().lastIndexOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#pointerOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger indexOfValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().indexOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#lastPointerOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger lastIndexOfValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().lastIndexOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> getKey(MassListener sender, Tachyon<V,K> event) {
		return getKey().getKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> getValue(MassListener sender, Tachyon<K,V> event) {
		return getKey().getValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<V,K> getValue(MassListener sender, AtomicInteger N) {
		return getKey().getValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<K,V> getKey(MassListener sender, AtomicInteger N) {
		return getKey().getKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateKey(org.xmlrobot.TimeListener)
	 */
	@Override
	public void removeKey(MassListener sender) {
		getKey().removeKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateValue(org.xmlrobot.TimeListener)
	 */
	@Override
	public void removeValue(MassListener sender) {
		getKey().removeValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateKeyIf(org.xmlrobot.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void removeKeyIf(MassListener sender, Statement<? super K> event) {
		getKey().removeKeyIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateValueIf(org.xmlrobot.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void removeValueIf(MassListener sender, Statement<? super V> event) {
		getKey().removeValueIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> setKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getKey().setKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> setValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getKey().setValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> setKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		return getKey().setKey(sender, antievent, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> setValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		return getKey().setValue(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tickValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tickValue(MassListener sender, Tachyon<V,K> event) {
		getKey().tickValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tickKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tickKey(MassListener sender, Tachyon<K,V> event) {
		getKey().tickKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tackKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tackKey(MassListener sender, Tachyon<K,V> event) {
		getKey().tackKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tackValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tackValue(MassListener sender, Tachyon<V,K> event) {
		getKey().tackValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#commuteKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void commuteKey(MassListener sender, Tachyon<K,V> event) {
		getKey().commuteKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#commuteValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void commuteValue(MassListener sender, Tachyon<V,K> event) {
		getKey().commuteValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#lendKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> lendKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().lendKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#lendValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> lendValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().lendValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#borrowValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> borrowValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().borrowValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#borrowKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> borrowKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().borrowKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#openKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> openKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().openKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#openValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> openValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().openValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#closeValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> closeValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().closeValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#closeKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> closeKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().closeKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#exchangeKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void exchangeKey(MassListener sender, Tachyon<K,V> event) {
		getKey().exchangeKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#exchangeValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void exchangeValue(MassListener sender, Tachyon<V,K> event) {
		getKey().exchangeValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#switchKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void switchKey(MassListener sender, Tachyon<K,V> event) {
		getKey().switchKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#switchValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void switchValue(MassListener sender, Tachyon<V,K> event) {
		getKey().switchValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#sendKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> sendKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().sendKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#sendValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> sendValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().sendValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#receiveValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> receiveValue(MassListener sender, Tachyon<V,K> event) {
		return getKey().receiveValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#receiveKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> receiveKey(MassListener sender, Tachyon<K,V> event) {
		return getKey().receiveKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateValue(MassListener sender, AtomicInteger N) {
		getKey().liberateValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateKey(MassListener sender, AtomicInteger N) {
		getKey().liberateKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#removeKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeKey(MassListener sender, AtomicInteger N) {
		getKey().removeKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#removeValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeValue(MassListener sender, AtomicInteger N) {
		getKey().removeValue(sender, N);
	}
}