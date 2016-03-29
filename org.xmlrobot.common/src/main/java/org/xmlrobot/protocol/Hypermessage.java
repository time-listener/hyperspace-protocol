/**
 * 
 */
package org.xmlrobot.protocol;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.MassListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.horizon.Meta;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.util.Congregation;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Hypermessage<K,V>
	extends Hyperdata<Metatext<K,V>, Metatext<V,K>>
		implements Metatext<K,V> {

	/**
	 * 5220624774655306046L
	 */
	private static final long serialVersionUID = 5220624774655306046L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#getFrom()
	 */
	@Override
	@XmlTransient
	public K getFrom() {
		return getAndCast(FROM);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#setFrom(java.lang.Object)
	 */
	@Override
	public K setFrom(K key) {
		return getAndSet(FROM, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaFuture#getTo()
	 */
	@Override
	@XmlTransient
	public V getTo() {
		return getAndCast(TO);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaFuture#setTo(java.lang.Object)
	 */
	@Override
	public V setTo(V value) {
		return getAndSet(TO, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#fromArray()
	 */
	@Override
	public K[] fromArray() {
		return getAndCast(FROM_ARRAY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#fromArray(java.lang.Object[])
	 */
	@Override
	public void fromArray(K[] array) {
		set(FROM_ARRAY, array);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperheader#toArray()
	 */
	@Override
	public V[] toArray() {
		return getAndCast(TO_ARRAY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaFuture#toArray(java.lang.Object[])
	 */
	@Override
	public void toArray(V[] array) {
		set(TO_ARRAY, array);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#getFromArraySize()
	 */
	@Override
	public AtomicInteger span() {
		return getAndCast(SPAN);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperdata#dna()
	 */
	@Override
	public Hypermessage<K,V> dna() {
		return getAndCast(DNA);
	}
	
	/**
	 * 
	 */
	public Hypermessage() {
		super();
	}
	/**
	 * 
	 */
	public Hypermessage(Hyperdata<Metatext<K,V>,Metatext<V,K>> data) {
		super(data);
		// update dna reference
		declareAndSet(DNA, this);
		// declare from reference
		this.<K>declare(FROM);
		// declare to reference
		this.<V>declare(TO);
	}
	/**
	 * 
	 */
	public Hypermessage(Hyperdata<Metatext<K,V>,Metatext<V,K>> data, Class<K[]> fromType, K from, V to) {
		this(data);
		// inherit key
		set(FROM, from);
		// inherit value
		set(TO, to);
		// initialize from array
		this.<K[]>declareAndSet(FROM_ARRAY,
				fromType.cast(Array.newInstance(fromType.getComponentType(), 10)));
		// declare and set from array size
		this.<AtomicInteger>declareAndSet(SPAN, new AtomicInteger(0));
	}
	/**
	 * 
	 */
	public Hypermessage(Hyperdata<Metatext<K,V>,Metatext<V,K>> data, Class<K[]> fromType, Metatext<V,K> value, K from, V to) {
		this(data, fromType, from, to);
		// put to array from value's from array
		put(TO_ARRAY, value.dna().get(FROM_ARRAY));
		// put value's to array from from array
		value.dna().put(TO_ARRAY, get(FROM_ARRAY));
	}
	/**
	 * @param data
	 * @param from
	 * @param to
	 */
	public Hypermessage(Hyperdata<Metatext<K,V>,Metatext<V,K>> data, K from, V to) {
		this(data);
		// inherit key
		set(FROM, from);
		// inherit value
		set(TO, to);
		// inherit from array from root
		put(FROM_ARRAY, getRoot().dna().get(FROM_ARRAY));
		// inherit to array from root
		put(TO_ARRAY, getRoot().dna().get(TO_ARRAY));
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperdata#clone()
	 */
	@Override
	public Metatext<K,V> clone() {
		return getKey().clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Hypertext#head()
	 */
	@Override
	public Collection<K> head() {
		return getKey().head();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Hypertext#body()
	 */
	@Override
	public Collection<V> body() {
		return getKey().body();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Hypertext#matrix()
	 */
	@Override
	public org.xmlrobot.metatext.Metatext.Translocator<K,V> matrix() {
		return getKey().matrix();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#hasFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean hasFrom(MassListener sender, Mass<K> event) {
		return getKey().hasFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#hasTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean hasTo(MassListener sender, Mass<V> event) {
		return getKey().hasTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#appendFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void putFrom(MassListener sender, Meta<K,V> event) {
		getKey().putFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#appendTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void putTo(MassListener sender, Meta<V,K> event) {
		getKey().putTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void redeemFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		getKey().redeemFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void redeemTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		getKey().redeemTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#callFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public Mass<K> callFrom(MassListener sender, AtomicInteger N) {
		return getKey().callFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#callTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public Mass<V> callTo(MassListener sender, AtomicInteger N) {
		return getKey().callTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#orderOfFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger orderOfFrom(MassListener sender, Mass<K> event) {
		return getKey().orderOfFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#orderOfTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger orderOfTo(MassListener sender, Mass<V> event) {
		return getKey().orderOfTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#putFrom(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K,V> putFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		return getKey().putFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#putTo(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V,K> putTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		return getKey().putTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemFrom(MassListener sender, AtomicInteger N) {
		getKey().redeemFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemTo(MassListener sender, AtomicInteger N) {
		getKey().redeemTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#subchainFrom(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<K> subchainFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
		return getKey().subchainFrom(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#subchainTo(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<V> subchainTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
		return getKey().subchainTo(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#getFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public Mass<V> acquireTo(MassListener sender, AtomicInteger N) {
		return getKey().acquireTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#getTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public Mass<K> acquireFrom(MassListener sender, AtomicInteger N) {
		return getKey().acquireFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#containsFrom(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean holdsTo(MassListener sender, Mass<V> event) {
		return getKey().holdsTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#containsTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean holdsFrom(MassListener sender, Mass<K> event) {
		return getKey().holdsFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#indexOfFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger pointerOfTo(MassListener sender, Mass<V> event) {
		return getKey().pointerOfTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#indexOfTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger pointerOfFrom(MassListener sender, Mass<K> event) {
		return getKey().pointerOfFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#setFrom(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K,V> assignFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		return getKey().assignFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#setTo(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V,K> assignTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		return getKey().assignTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#addFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void assignTo(MassListener sender, Meta<V,K> event) {
		getKey().assignTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#addTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void assignFrom(MassListener sender, Meta<K,V> event) {
		getKey().assignFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void releaseTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		getKey().releaseTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseTo(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void releaseFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		getKey().releaseFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseFrom(MassListener sender, AtomicInteger N) {
		getKey().releaseFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseTo(MassListener sender, AtomicInteger N) {
		getKey().releaseTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#subsequenceFrom(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<V> subsequenceTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
		return getKey().subsequenceTo(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#subsequenceTo(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<K> subsequenceFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
		return getKey().subsequenceFrom(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#callTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> callTo(MassListener sender, Mass<K> event) {
		return getKey().callTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#callFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> callFrom(MassListener sender, Mass<V> event) {
		return getKey().callFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#getFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> acquireFrom(MassListener sender, Mass<V> event) {
		return getKey().acquireFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#getTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> acquireTo(MassListener sender, Mass<K> event) {
		return getKey().acquireTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#visitTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<V> requestTo(MassListener sender, AtomicInteger N) {
		return getKey().requestTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#visitFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<K> requestFrom(MassListener sender, AtomicInteger N) {
		return getKey().requestFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#visitFrom(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> requestFrom(MassListener sender, Mass<V> event) {
		return getKey().requestFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#visitTo(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> requestTo(MassListener sender, Mass<K> event) {
		return getKey().requestTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#belongsFrom(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean belongsTo(MassListener sender, Mass<V> event) {
		return getKey().belongsTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#belongsTo(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean belongsFrom(MassListener sender, Mass<K> event) {
		return getKey().belongsFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#positionOfTo(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger positionOfTo(MassListener sender, Mass<V> event) {
		return getKey().positionOfTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#positionOfFrom(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger positionOfFrom(MassListener sender, Mass<K> event) {
		return getKey().positionOfFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#updateFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K,V> updateFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		return getKey().updateFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#updateTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V,K> updateTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		return getKey().updateTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#allocateTo(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void updateTo(MassListener sender, Meta<V,K> event) {
		getKey().updateTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#allocateFrom(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void updateFrom(MassListener sender, Meta<K,V> event) {
		getKey().updateFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#redeemTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		getKey().liberateTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#redeemFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		getKey().liberateFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#redeemFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateFrom(MassListener sender, AtomicInteger N) {
		getKey().liberateFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#redeemTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateTo(MassListener sender, AtomicInteger N) {
		getKey().liberateTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#substringFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<K> substringFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
		return getKey().substringFrom(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#substringTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<V> substringTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
		return getKey().substringTo(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#getTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<V> getTo(MassListener sender, AtomicInteger N) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#getFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<K> getFrom(MassListener sender, AtomicInteger N) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#getFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> getFrom(MassListener sender, Mass<V> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#getTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> getTo(MassListener sender, Mass<K> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#containsTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean containsTo(MassListener sender, Mass<V> event) {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#containsFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean containsFrom(MassListener sender, Mass<K> event) {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#indexOfTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger indexOfTo(MassListener sender, Mass<V> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#indexOfFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger indexOfFrom(MassListener sender, Mass<K> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#lastIndexOfFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger lastIndexOfFrom(MassListener sender, Mass<V> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#lastIndexOfTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger lastIndexOfTo(MassListener sender, Mass<K> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K,V> setFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V,K> setTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#addTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void setTo(MassListener sender, Meta<V,K> event) {
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#addFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void setFrom(MassListener sender, Meta<K,V> event) {
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeFrom(MassListener sender, AtomicInteger N) {
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeTo(MassListener sender, AtomicInteger N) {
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#excerpt(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Congregation<K> excerpt(MassListener sender,	AtomicInteger beginIndex, AtomicInteger endIndex) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#excerptFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<K> excerptFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#excerptTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<V> excerptTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#updateTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updateFrom(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#updateFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updateTo(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#putFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putTo(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#putTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putFrom(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setTo(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setFrom(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#assignTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void assignFrom(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#assignFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void assignTo(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// TODO Auto-generated method stub
		
	}
}