/**
 * 
 */
package org.xmlrobot.horizon;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.protocol.Hypermessage;
import org.xmlrobot.util.Congregation;

/**
 * @author joan
 *
 */
public class Meta<K,V> 
	extends Tachyon<Metatext<K,V>,Metatext<V,K>> 
		implements Metatext<K,V> {

	/**
	 * -45389927418810160L
	 */
	private static final long serialVersionUID = -45389927418810160L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#getFrom()
	 */
	@Override
	public K getFrom() {
		return getSource().getFrom();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#setFrom(java.lang.Object)
	 */
	@Override
	public K setFrom(K key) {
		return getSource().setFrom(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#getTo()
	 */
	@Override
	public V getTo() {
		return getSource().getTo();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#setTo(java.lang.Object)
	 */
	@Override
	public V setTo(V value) {
		return getSource().setTo(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaFuture#getToArray()
	 */
	@Override
	public V[] toArray() {
		return getSource().toArray();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaFuture#setToArray(java.lang.Object[])
	 */
	@Override
	public void toArray(V[] array) {
		getSource().toArray(array);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#getFromArray()
	 */
	@Override
	public K[] fromArray() {
		return getSource().fromArray();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#setFromArray(java.lang.Object[])
	 */
	@Override
	public void fromArray(K[] array) {
		getSource().fromArray(array);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Metatext#size()
	 */
	@Override
	public AtomicInteger span() {
		return getSource().span();
	}
	
	/**
	 * 
	 */
	public Meta(Metatext<K,V> source) {
		super(source);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.Tachyon#getSource()
	 */
	@Override
	public synchronized Metatext<K,V> getSource() {
		return (Metatext<K,V>) super.getSource();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.Tachyon#clone()
	 */
	@Override
	public Metatext<K,V> clone() {
		return (Metatext<K,V>) super.clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#dna()
	 */
	@Override
	public Hypermessage<K,V> dna() {
		return getSource().dna();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#head()
	 */
	@Override
	public Collection<K> head() {
		return getSource().head();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#body()
	 */
	@Override
	public Collection<V> body() {
		return getSource().body();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#matrix()
	 */
	@Override
	public Metatext.Translocator<K, V> matrix() {
		return getSource().matrix();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#callFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public Mass<K> callFrom(MassListener sender, AtomicInteger N) {
		return getSource().callFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#callTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public Mass<V> callTo(MassListener sender, AtomicInteger N) {
		return getSource().callTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#putFrom(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K,V> putFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		return getSource().putFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#putTo(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V,K> putTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		return getSource().putTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#appendFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void putFrom(MassListener sender, Meta<K,V> event) {
		getSource().putFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#appendTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void putTo(MassListener sender, Meta<V, K> event) {
		getSource().putTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemFrom(MassListener sender, AtomicInteger N) {
		getSource().redeemFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemTo(MassListener sender, AtomicInteger N) {
		getSource().redeemTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#subchainFrom(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<K> subchainFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
		return getSource().subchainFrom(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#subchainTo(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<V> subchainTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
		return getSource().subchainTo(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#getFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public Mass<V> acquireTo(MassListener sender, AtomicInteger N) {
		return getSource().acquireTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#getTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public Mass<K> acquireFrom(MassListener sender, AtomicInteger N) {
		return getSource().acquireFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#setFrom(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K,V> assignFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		return getSource().assignFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#setTo(org.xmlrobot.genesis.TimeListener, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V,K> assignTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		return getSource().assignTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#addFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void assignTo(MassListener sender, Meta<V,K> event) {
		getSource().assignTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#addTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void assignFrom(MassListener sender, Meta<K,V> event) {
		getSource().assignFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseFrom(MassListener sender, AtomicInteger N) {
		getSource().releaseFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseTo(MassListener sender, AtomicInteger N) {
		getSource().releaseTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#subsequenceFrom(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<V> subsequenceTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
		return getSource().subsequenceTo(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#subsequenceTo(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<K> subsequenceFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
		return getSource().subsequenceFrom(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#hasFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean hasFrom(MassListener sender, Mass<K> event) {
		return getSource().hasFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#hasTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean hasTo(MassListener sender, Mass<V> event) {
		return getSource().hasTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#orderOfFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger orderOfFrom(MassListener sender, Mass<K> event) {
		return getSource().orderOfFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#orderOfTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger orderOfTo(MassListener sender, Mass<V> event) {
		return getSource().orderOfTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void redeemFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		getSource().redeemFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void redeemTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		getSource().redeemTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#containsFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean holdsTo(MassListener sender, Mass<V> event) {
		return getSource().holdsTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#containsTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean holdsFrom(MassListener sender, Mass<K> event) {
		return getSource().holdsFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#indexOfFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger pointerOfTo(MassListener sender, Mass<V> event) {
		return getSource().pointerOfTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#indexOfTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger pointerOfFrom(MassListener sender, Mass<K> event) {
		return getSource().pointerOfFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releaseTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		getSource().releaseTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releaseFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		getSource().releaseFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#callTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> callTo(MassListener sender, Mass<K> event) {
		return getSource().callTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#callFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> callFrom(MassListener sender, Mass<V> event) {
		return getSource().callFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#getFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> acquireFrom(MassListener sender, Mass<V> event) {
		return getSource().acquireFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#getTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> acquireTo(MassListener sender, Mass<K> event) {
		return getSource().acquireTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#visitTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<V> requestTo(MassListener sender, AtomicInteger N) {
		return getSource().requestTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#visitFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<K> requestFrom(MassListener sender, AtomicInteger N) {
		return getSource().requestFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#visitFrom(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> requestFrom(MassListener sender, Mass<V> event) {
		return getSource().requestFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#visitTo(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> requestTo(MassListener sender, Mass<K> event) {
		return getSource().requestTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#belongsFrom(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean belongsTo(MassListener sender, Mass<V> event) {
		return getSource().belongsTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#belongsTo(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean belongsFrom(MassListener sender, Mass<K> event) {
		return getSource().belongsFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#positionOfTo(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger positionOfTo(MassListener sender, Mass<V> event) {
		return getSource().positionOfTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#positionOfFrom(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger positionOfFrom(MassListener sender, Mass<K> event) {
		return getSource().positionOfFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#updateFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K,V> updateFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		return getSource().updateFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#updateTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V,K> updateTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		return getSource().updateTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#allocateTo(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void updateTo(MassListener sender, Meta<V,K> event) {
		getSource().updateTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#allocateFrom(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void updateFrom(MassListener sender, Meta<K,V> event) {
		getSource().updateFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#redeemTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		getSource().liberateTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#redeemFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		getSource().liberateFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#redeemFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateFrom(MassListener sender, AtomicInteger N) {
		getSource().liberateFrom(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#redeemTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateTo(MassListener sender, AtomicInteger N) {
		getSource().liberateTo(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#substringFrom(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<K> substringFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
		return getSource().subchainFrom(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#substringTo(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<V> substringTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
		return getSource().substringTo(sender, beginIndex, endIndex, event);
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
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#indexOfTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger indexOfTo(MassListener sender, Mass<V> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#indexOfFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger indexOfFrom(MassListener sender, Mass<K> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#lastIndexOfFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger lastIndexOfFrom(MassListener sender, Mass<V> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#lastIndexOfTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger lastIndexOfTo(MassListener sender, Mass<K> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K, V> setFrom(MassListener sender, AtomicInteger N,
			Meta<K, V> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V, K> setTo(MassListener sender, AtomicInteger N,
			Meta<V, K> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#addTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void setTo(MassListener sender, Meta<V, K> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#addFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void setFrom(MassListener sender, Meta<K, V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeFrom(MassListener sender, AtomicInteger N) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeTo(MassListener sender, AtomicInteger N) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#excerpt(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Congregation<K> excerpt(MassListener sender,
			AtomicInteger beginIndex, AtomicInteger endIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#excerptFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<K> excerptFrom(MassListener sender,
			AtomicInteger beginIndex, AtomicInteger endIndex,
			Congregation<K> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#excerptTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<V> excerptTo(MassListener sender,
			AtomicInteger beginIndex, AtomicInteger endIndex,
			Congregation<V> event) {
		// TODO Auto-generated method stub
		return null;
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
	 * @see org.xmlrobot.metatext.MetaConcurrence#assignFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void assignFrom(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#assignTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void assignTo(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// TODO Auto-generated method stub
		
	}
}