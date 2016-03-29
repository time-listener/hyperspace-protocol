/**
 * 
 */
package org.xmlrobot.horizon;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.protocol.Hyperdata;
import org.xmlrobot.util.Statement;

/**
 * A tachyon or tachyonic particle is a hypothetical particle that always moves faster than light. 
 * The word comes from the pronounced tachy, meaning rapid. It was coined in 1 by {@link TimeListener}. 
 * The complementary particle types are called luxon and bradyon, which both exist. The possibility 
 * of particles moving faster than light was first	 proposed by {@link TimeListener}, {@link TimeListener}, 
 * and {@link TimeListener} in 1, although the term they used for it was "meta-particle".
 * 
 * @author joan
 *
 */
public class Tachyon
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends EventHorizon implements TimeListener<K,V> {

	/**
	 * 3736684311636306151L
	 */
	private static final long serialVersionUID = 3736684311636306151L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#getType()
	 */
	@Override
	public Class<? extends K> getType() {
		return getSource().getType();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#setType(java.lang.Class)
	 */
	@Override
	public void setType(Class<? extends K> type) {
		getSource().setType(type);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#getAntitype()
	 */
	@Override
	public Class<? extends V> getAntitype() {
		return getSource().getAntitype();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#setAntiype(java.lang.Class)
	 */
	@Override
	public void setAntitype(Class<? extends V> antitype) {
		getSource().setAntitype(antitype);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#getRoot()
	 */
	@Override
	public K getRoot() {
		return getSource().getRoot();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#setRoot(java.lang.Object)
	 */
	@Override
	public K setRoot(K listener) {
		return getSource().setRoot(listener);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#setParent(java.lang.Object)
	 */
	@Override
	public K setParent(K listener) {
		return getSource().setParent(listener);
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getKey()
	 */
	@Override
	public K getParent() {
		return getSource().getParent();
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getValue()
	 */
	@Override
	public V get() {
		return getSource().get();
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#setValue(java.lang.Object)
	 */
	@Override
	public V set(V value) {
		return getSource().set(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#call()
	 */
	@Override
	public K call() {
		return getSource().call();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#getKey()
	 */
	@Override
	public K getKey() {
		return getSource().getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#getValue()
	 */
	@Override
	public V getValue() {
		return getSource().getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		return getSource().setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#getStem()
	 */
	@Override
	public V getStem() {
		return getSource().getStem();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#setStem(java.lang.Object)
	 */
	@Override
	public V setStem(V stem) {
		return getSource().setStem(stem);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#getChild()
	 */
	@Override
	public V getChild() {
		return getSource().getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#setChild(java.lang.Object)
	 */
	@Override
	public V setChild(V child) {
		return getSource().setChild(child);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#root()
	 */
	@Override
	public TimeListener<K,V> root() {
		return getSource().root();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#put(java.lang.Object)
	 */
	@Override
	public K put(K listener) {
		return getSource().put(listener);
	}
	
	/**
	 * {@link Tachyon} default class constructor.
	 * @param source {@link TimeListener} the source
	 */
	public Tachyon(TimeListener<K,V> source) {
		super(source);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.EventHorizon#getSource()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public synchronized TimeListener<K,V> getSource() {
		return (TimeListener<K,V>) super.getSource();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.EventHorizon#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {
		return getSource().clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.EventHorizon#dna()
	 */
	@Override
	public Hyperdata<K,V> dna() {
		return getSource().dna();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#call(int)
	 */
	@Override
	public Tachyon<K,V> acquireKey(MassListener sender, AtomicInteger N) {
		return getSource().acquireKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#getPast()
	 */
	@Override
	public Tachyon<K,V> callPastKey(MassListener sender) {
		return getSource().callPastKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#isPast()
	 */
	@Override
	public boolean isPast() {
		return getSource().isPast();
	}

	@Override
	public boolean isEmpty() {
		return getSource().isEmpty();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#length()
	 */
	@Override
	public AtomicInteger recurrence(MassListener sender, AtomicInteger N) {
		return getSource().recurrence(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#containsParent(java.lang.Object)
	 */
	@Override
	public boolean holdsKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().holdsKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#orderParent(java.lang.Object)
	 */
	@Override
	public void orderSuperKey(MassListener sender, Tachyon<K,V> event) {
		getSource().orderSuperKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#releaseParent()
	 */
	@Override
	public void releaseKey(MassListener sender) {
		getSource().releaseKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#releaseParent(java.lang.Object)
	 */
	@Override
	public void releaseKey(MassListener sender, Tachyon<K,V> event) {
		getSource().releaseKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#releaseParentIf(java.util.function.Predicate)
	 */
	@Override
	public void releaseKeyIf(MassListener sender, Statement<? super K> event) {
		getSource().releaseKeyIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#revolveParent()
	 */
	@Override
	public void revolveKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		getSource().revolveKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#rotateParent()
	 */
	@Override
	public void rotateKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		getSource().rotateKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#submitParent(java.lang.Object)
	 */
	@Override
	public void submitKey(MassListener sender, Tachyon<K,V> event) {
		getSource().submitKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#swapParent(java.lang.Object)
	 */
	@Override
	public void swapKey(MassListener sender, Tachyon<K,V> event) {
		getSource().swapKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#get(int)
	 */
	@Override
	public Tachyon<V,K> acquireValue(MassListener sender, AtomicInteger N) {
		return getSource().acquireValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#isFuture()
	 */
	@Override
	public boolean isFuture() {
		return getSource().isFuture();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#depth()
	 */
	@Override
	public AtomicInteger concurrence(MassListener sender, AtomicInteger N) {
		return getSource().concurrence(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#getFuture()
	 */
	@Override
	public Tachyon<V,K> getFutureValue(MassListener sender) {
		return getSource().getFutureValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#containsChild(java.lang.Object)
	 */
	@Override
	public boolean holdsValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().holdsValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#orderChild(java.lang.Object)
	 */
	@Override
	public void orderInferValue(MassListener sender, Tachyon<V,K> event) {
		getSource().orderInferValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#permuteChild(int)
	 */
	@Override
	public void permuteValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		getSource().permuteValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#releaseChild()
	 */
	@Override
	public void releaseValue(MassListener sender) {
		getSource().releaseValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#releaseChild(java.lang.Object)
	 */
	@Override
	public void releaseValue(MassListener sender, Tachyon<V,K> event) {
		getSource().releaseValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#releaseChildIf(java.util.function.Predicate)
	 */
	@Override
	public void releaseValueIf(MassListener sender, Statement<? super V> event) {
		getSource().releaseValueIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#revolveChild()
	 */
	@Override
	public void revolveValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		getSource().revolveValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#rotateChild()
	 */
	@Override
	public void rotateValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		getSource().rotateValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#submitChild(java.lang.Object)
	 */
	@Override
	public void submitValue(MassListener sender, Tachyon<V,K> event) {
		getSource().submitValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#swapChild(java.lang.Object)
	 */
	@Override
	public void swapValue(MassListener sender, Tachyon<V,K> event) {
		getSource().swapValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#allocate(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void allocateValue(MassListener sender, Tachyon<V,K> event) {
		getSource().allocateValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#release(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void removeValue(MassListener sender, Tachyon<V,K> event) {
		getSource().removeValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#submit(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void deliverValue(MassListener sender, Tachyon<V,K> event) {
		getSource().deliverValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#order(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderValue(MassListener sender, Tachyon<V,K> event) {
		getSource().orderValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pulse(MassListener source, Tachyon<V,K> event) {
		getSource().pulse(source, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void echo(MassListener source, Tachyon<K,V> event) {
		getSource().echo(source, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#matrix()
	 */
	@Override
	public TimeListener.Transmitter<K, V> matrix() {
		return getSource().matrix();
	}
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(V o1, V o2) {
		return getSource().compare(o1, o2);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#reproduceTo(java.lang.Object)
	 */
	@Override
	public int reproduceTo(V o) {
		return getSource().reproduceTo(o);
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(K o) {
		return getSource().compareTo(o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproductor#reproduce(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int reproduce(K key, V value) {
		return getSource().reproduce(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#output()
	 */
	@Override
	public V output() {
		return getSource().output();
	}
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<K> iterator() {
		return getSource().iterator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Enumerable#enumeration()
	 */
	@Override
	public Enumeration<V> enumerator() {
		return getSource().enumerator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#pastSet()
	 */
	@Override
	public Set<K> keySet() {
		return getSource().keySet();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#futureSet()
	 */
	@Override
	public Set<V> valueSet() {
		return getSource().valueSet();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#pushParent(java.lang.Object)
	 */
	@Override
	public void pushKey(MassListener sender, Tachyon<K,V> event) {
		getSource().pushKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#removeParent()
	 */
	@Override
	public void redeemKey(MassListener sender) {
		getSource().redeemKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#removeParent(java.lang.Object)
	 */
	@Override
	public void redeemKey(MassListener sender, Tachyon<K,V> event) {
		getSource().redeemKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#removeParentIf(java.util.function.Predicate)
	 */
	@Override
	public void redeemKeyIf(MassListener sender, Statement<? super K> filter) {
		getSource().redeemKeyIf(sender, filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#removeChild()
	 */
	@Override
	public void redeemValue(MassListener sender) {
		getSource().redeemValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#removeChild(java.lang.Object)
	 */
	@Override
	public void redeemValue(MassListener sender, Tachyon<V,K> event) {
		getSource().redeemValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#removeChildIf(java.util.function.Predicate)
	 */
	@Override
	public void redeemValueIf(MassListener sender, Statement<? super V> event) {
		getSource().redeemValueIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#orderDescendantParent(java.lang.Object)
	 */
	@Override
	public void orderInferKey(MassListener sender, Tachyon<K,V> event) {
		getSource().orderInferKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#pollParent(java.lang.Object)
	 */
	@Override
	public void pollKey(MassListener sender, Tachyon<K,V> event) {
		getSource().pollKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#orderAscendantChild(java.lang.Object)
	 */
	@Override
	public void orderSuperValue(MassListener sender, Tachyon<V,K> event) {
		getSource().orderSuperValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#pollChild(java.lang.Object)
	 */
	@Override
	public void pollValue(MassListener sender, Tachyon<V,K> event) {
		getSource().pollValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#popParent(java.lang.Object)
	 */
	@Override
	public void popKey(MassListener sender, Tachyon<K,V> event) {
		getSource().popKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#popChild(java.lang.Object)
	 */
	@Override
	public void popValue(MassListener sender, Tachyon<V,K> event) {
		getSource().popValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#permuteParentAncestry(int)
	 */
	@Override
	public void permuteKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		getSource().permuteKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#callChild(int)
	 */
	@Override
	public Tachyon<V,K> callValue(MassListener sender, AtomicInteger N) {
		return getSource().callValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#callParent(int)
	 */
	@Override
	public Tachyon<K,V> callKey(MassListener sender, AtomicInteger N) {
		return getSource().callKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#clear()
	 */
	@Override
	public void clear(MassListener sender) {
		getSource().clear(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#pushChild(java.lang.Object)
	 */
	@Override
	public void injectValue(MassListener sender, Tachyon<V,K> event) {
		getSource().injectValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#spinPast()
	 */
	@Override
	public void spinKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		getSource().spinKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#spinFuture()
	 */
	@Override
	public void spinValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		getSource().spinValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#orderStrongParent(java.lang.Object)
	 */
	@Override
	public void orderStrongKey(MassListener sender, Tachyon<K,V> event) {
		getSource().orderStrongKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#orderWeakChild(java.lang.Object)
	 */
	@Override
	public void orderWeakValue(MassListener sender, Tachyon<V,K> event) {
		getSource().orderWeakValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#hasParent(java.lang.Object)
	 */
	@Override
	public boolean hasKey(MassListener sender, Tachyon<K,V> listener) {
		return getSource().hasKey(sender, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#hasChild(java.lang.Object)
	 */
	@Override
	public boolean hasValue(MassListener sender, Tachyon<V,K> listener) {
		return getSource().hasValue(sender, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#belongsKey(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean belongsKey(MassListener sender, Tachyon<K,V> listener) {
		return getSource().belongsKey(sender, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#belongsValue(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean belongsValue(MassListener sender, Tachyon<V, K> listener) {
		return getSource().belongsValue(sender, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#getFutureParent()
	 */
	@Override
	public Tachyon<K,V> getFutureKey(MassListener sender) {
		return getSource().getFutureKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#callPastChild()
	 */
	@Override
	public Tachyon<V,K> callPastValue(MassListener sender) {
		return getSource().callPastValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#entryMap()
	 */
	@Override
	public Map<K,V> inheritance() {
		return getSource().inheritance();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#getValue(java.lang.Object)
	 */
	@Override
	public Tachyon<V,K> acquireValue(MassListener sender, Tachyon<K,V> key) {
		return getSource().acquireValue(sender, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#getKey(java.lang.Object)
	 */
	@Override
	public Tachyon<K,V> acquireKey(MassListener sender, Tachyon<V,K> value) {
		return getSource().acquireKey(sender, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#callValue(java.lang.Object)
	 */
	@Override
	public Tachyon<V,K> callValue(MassListener sender, Tachyon<K,V> key) {
		return getSource().callValue(sender, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#callKey(java.lang.Object)
	 */
	@Override
	public Tachyon<K,V> callKey(MassListener sender, Tachyon<V,K> value) {
		return getSource().callKey(sender, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#removeByKey(java.lang.Object)
	 */
	@Override
	public void liberateKey(MassListener sender, Tachyon<K,V> event) {
		getSource().liberateKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#removeByValue(java.lang.Object)
	 */
	@Override
	public void liberateValue(MassListener sender, Tachyon<V,K> event) {
		getSource().liberateValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Tachyon<V,K> assignValue(MassListener source, Tachyon<K,V> key, Tachyon<V,K> value) {
		return getSource().assignValue(source, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#putKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Tachyon<K,V> assignKey(MassListener source, Tachyon<V,K> value, Tachyon<K,V> key) {
		return getSource().assignKey(source, value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		getSource().addMassListener(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#flipKey(java.lang.Object)
	 */
	@Override
	public void flipKey(MassListener sender, Tachyon<K,V> event) {
		getSource().flipKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#flopKey(java.lang.Object)
	 */
	@Override
	public void flopKey(MassListener sender, Tachyon<K,V> event) {
		getSource().flopKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#pushKey(java.lang.Object)
	 */
	@Override
	public void injectKey(MassListener sender, Tachyon<K,V> event) {
		getSource().injectKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#redeemKey()
	 */
	@Override
	public void liberateKey(MassListener sender) {
		getSource().liberateKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#redeemKeyIf(java.util.function.Predicate)
	 */
	@Override
	public void liberateKeyIf(MassListener sender, Statement<? super K> event) {
		getSource().liberateKeyIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#injectValue(java.lang.Object)
	 */
	@Override
	public void pushValue(MassListener sender, Tachyon<V,K> event) {
		getSource().pushValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#flopValue(java.lang.Object)
	 */
	@Override
	public void flopValue(MassListener sender, Tachyon<V,K> event) {
		getSource().flopValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#flipValue(java.lang.Object)
	 */
	@Override
	public void flipValue(MassListener sender, Tachyon<V,K> event) {
		getSource().flipValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#redeemValue()
	 */
	@Override
	public void liberateValue(MassListener sender) {
		getSource().liberateValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#redeemValueIf(java.util.function.Predicate)
	 */
	@Override
	public void liberateValueIf(MassListener sender, Statement<? super V> event) {
		getSource().liberateValueIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#unify()
	 */
	@Override
	public void unify(MassListener sender) {
		getSource().unify(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#removeMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void removeMassListener(MassListener listener) {
		getSource().removeMassListener(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#giveKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> giveKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().giveKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#giveValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> giveValue(MassListener sender, Tachyon<V,K> antievent) {
		return getSource().giveValue(sender, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#takeKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> takeKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().takeKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#takeValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> takeValue(MassListener sender, Tachyon<V,K> antievent) {
		return getSource().takeValue(sender, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#setValue(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V, K> putValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getSource().putValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#setKey(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K, V> putKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getSource().putKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#putKey(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> assignKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getSource().assignKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#putValue(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> assignValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getSource().assignValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeKey(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemKey(MassListener sender, AtomicInteger N) {
		getSource().redeemKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeValue(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemValue(MassListener sender, AtomicInteger N) {
		getSource().redeemValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseKey(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseKey(MassListener sender, AtomicInteger N) {
		getSource().releaseKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseValue(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseValue(MassListener sender, AtomicInteger N) {
		getSource().releaseValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#recursion(org.xmlrobot.genesis.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public AtomicInteger recursion(MassListener sender, AtomicInteger N) {
		return getSource().recursion(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#orderOfKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger orderOfKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().orderOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#orderOfValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger orderOfValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().orderOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#indexOfKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger pointerOfKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().pointerOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#indexOfValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger pointerOfValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().pointerOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#positionOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger positionOfKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().positionOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#positionOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger positionOfValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().positionOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#visitKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> requestKey(MassListener sender, Tachyon<V,K> antievent) {
		return getSource().requestKey(sender, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#visitValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> requestValue(MassListener sender, Tachyon<K,V> event) {
		return getSource().requestValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#visitValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<V,K> requestValue(MassListener sender, AtomicInteger N) {
		return getSource().requestValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#visitKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<K,V> requestKey(MassListener sender, AtomicInteger N) {
		return getSource().requestKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#updateKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> updateKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getSource().updateKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#updateValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> updateValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getSource().updateValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#allocateKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void allocateKey(MassListener sender, Tachyon<K,V> event) {
		getSource().allocateKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#killKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void removeKey(MassListener sender, Tachyon<K,V> event) {
		getSource().removeKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#deliverKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void deliverKey(MassListener sender, Tachyon<K,V> event) {
		getSource().deliverKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#orderKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void orderKey(MassListener sender, Tachyon<K,V> event) {
		getSource().orderKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#updateKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> updateKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		return getSource().updateKey(sender, antievent, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#updateValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> updateValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		return getSource().updateValue(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pingValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pingValue(MassListener sender, Tachyon<V,K> event) {
		getSource().pingValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pingKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pingKey(MassListener sender, Tachyon<K,V> event) {
		getSource().pingKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pongKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pongKey(MassListener sender, Tachyon<K,V> event) {
		getSource().pongKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#pongValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pongValue(MassListener sender, Tachyon<V,K> event) {
		getSource().pongValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#putKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> putKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		return getSource().putKey(sender, antievent, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#putValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> putValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		return getSource().putValue(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#holdsKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean containsKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().containsKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#holdsValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean containsValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().containsValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#pointerOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger indexOfKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().indexOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#lastPointerOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger lastIndexOfKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().lastIndexOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#pointerOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger indexOfValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().indexOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#lastPointerOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger lastIndexOfValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().lastIndexOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> getKey(MassListener sender, Tachyon<V,K> event) {
		return getSource().getKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> getValue(MassListener sender, Tachyon<K,V> event) {
		return getSource().getValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<V,K> getValue(MassListener sender, AtomicInteger N) {
		return getSource().getValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<K,V> getKey(MassListener sender, AtomicInteger N) {
		return getSource().getKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateKey(org.xmlrobot.TimeListener)
	 */
	@Override
	public void removeKey(MassListener sender) {
		getSource().removeKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateValue(org.xmlrobot.TimeListener)
	 */
	@Override
	public void removeValue(MassListener sender) {
		getSource().removeValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateKeyIf(org.xmlrobot.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void removeKeyIf(MassListener sender, Statement<? super K> event) {
		getSource().removeKeyIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateValueIf(org.xmlrobot.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void removeValueIf(MassListener sender, Statement<? super V> event) {
		getSource().removeValueIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> setKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getSource().setKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> setValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getSource().setValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> setKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		return getSource().setKey(sender, antievent, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> setValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		return getSource().setValue(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tickValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tickValue(MassListener sender, Tachyon<V,K> event) {
		getSource().tickValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tickKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tickKey(MassListener sender, Tachyon<K,V> event) {
		getSource().tickKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tackKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tackKey(MassListener sender, Tachyon<K,V> event) {
		getSource().tackKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tackValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tackValue(MassListener sender, Tachyon<V,K> event) {
		getSource().tackValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#commuteKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void commuteKey(MassListener sender, Tachyon<K,V> event) {
		getSource().commuteKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#commuteValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void commuteValue(MassListener sender, Tachyon<V,K> event) {
		getSource().commuteValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#lendKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> lendKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().lendKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#lendValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> lendValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().lendValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#borrowValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> borrowValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().borrowValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#borrowKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> borrowKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().borrowKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#openKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> openKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().openKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#openValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> openValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().openValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#closeValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> closeValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().closeValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#closeKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> closeKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().closeKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#exchangeKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void exchangeKey(MassListener sender, Tachyon<K,V> event) {
		getSource().exchangeKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#exchangeValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void exchangeValue(MassListener sender, Tachyon<V,K> event) {
		getSource().exchangeValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#switchKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void switchKey(MassListener sender, Tachyon<K,V> event) {
		getSource().switchKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#switchValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void switchValue(MassListener sender, Tachyon<V,K> event) {
		getSource().switchValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#sendKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> sendKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().sendKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#sendValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> sendValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().sendValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#receiveValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> receiveValue(MassListener sender, Tachyon<V,K> event) {
		return getSource().receiveValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#receiveKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> receiveKey(MassListener sender, Tachyon<K,V> event) {
		return getSource().receiveKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#removeKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeKey(MassListener sender, AtomicInteger N) {
		getSource().removeKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#removeValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeValue(MassListener sender, AtomicInteger N) {
		getSource().removeValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateValue(MassListener sender, AtomicInteger N) {
		getSource().liberateValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateKey(MassListener sender, AtomicInteger N) {
		getSource().liberateKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#depth(org.xmlrobot.MassListener)
	 */
	@Override
	public AtomicInteger depth(MassListener sender) {
		return getSource().depth(sender);
	}
}