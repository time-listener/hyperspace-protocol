/**
 * 
 */
package org.xmlrobot.protocol;

import java.util.Collection;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.MassListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Congregation;
import org.xmlrobot.util.Imperative;
import org.xmlrobot.util.Instruction;
import org.xmlrobot.util.Commandment;

/**
 * @author joan
 *
 */
public class Hypermass<K,V> 
	extends Hyperdata<Positron<K,V>,Positron<V,K>>
		implements Positron<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3051092366423913620L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getKey()
	 */
	@Override
	@XmlTransient
	public K getPositive() {
		return getAndCast(Positron.POSITIVE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setKey(java.lang.Object)
	 */
	public K setPositive(K key) {
		return getAndSet(Positron.POSITIVE, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getValue()
	 */
	@Override
	@XmlTransient
	public V getNegative() {
		return getAndCast(Positron.NEGATIVE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setValue(java.lang.Object)
	 */
	@Override
	public V setNegative(V value) {
		return getAndSet(Positron.NEGATIVE, value);
	}	
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperbody#dna()
	 */
	@Override
	public Hypermass<K,V> dna() {
		return getAndCast(DNA);
	}
	
	/**
	 * {@link Hypermass} default class constructor.
	 * @throws Abort when something is wrong
	 */
	public Hypermass() {
		super();
		// inherit dna
		map = this;
		// update dna reference
		set(DNA, this);
	}
	/**
	 * {@link Hypermass} meta-constructor.
	 * @throws Abort when something is wrong
	 */
	public Hypermass(Hyperdata<Positron<K,V>,Positron<V,K>> dna) {
		super(dna);
		// update dna reference
		declareAndSet(DNA, this);
		// declare positive
		this.<K>declare(POSITIVE);
		// declare negative
		this.<V>declare(NEGATIVE);
	}
	/**
	 * {@link Hypermass} meta-constructor.
	 * @throws Abort when something is wrong
	 */
	public Hypermass(Hyperdata<Positron<K,V>,Positron<V,K>> dna, K key, V value) {
		this(dna);
		// inherit key
		set(Positron.POSITIVE, key);
		// inherit value
		set(Positron.NEGATIVE, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperdata#clone()
	 */
	@Override
	public Positron<K,V> clone() {
		return getKey().clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperbody#matrix()
	 */
	@Override
	public Positron.Transmuter<K,V> matrix() {
		return getKey().matrix();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#call(java.lang.Object)
	 */
	@Override
	public Graviton<K,V> acquireByPositive(MassListener sender, Mass<K> key) {
		return getKey().acquireByPositive(sender, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#callReversed(java.lang.Object)
	 */
	public Graviton<V,K> acquireByNegative(MassListener sender, Mass<V> value) {
		return getKey().acquireByNegative(sender, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsPositive(MassListener sender, Mass<K> key) {
		return getKey().containsPositive(sender, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsNegative(MassListener sender, Mass<V> value) {
		return getKey().containsNegative(sender, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void assignNegative(MassListener sender, Mass<K> key, Mass<V> value) {
		getKey().assignNegative(sender, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void assignPositive(MassListener sender, Mass<V> value, Mass<K> key) {
		getKey().assignPositive(sender, value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putValueIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void assignNegativeIfAbsent(MassListener sender, Mass<K> key, Mass<V> value) {
		getKey().assignNegativeIfAbsent(sender, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putKeyIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void assignPositiveIfAbsent(MassListener sender, Mass<V> value, Mass<K> key) {
		getKey().assignPositiveIfAbsent(sender, value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#removeByValue(java.lang.Object)
	 */
	@Override
	public void redeemNegative(MassListener sender, Mass<V> value) {
		getKey().redeemNegative(sender, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getValue(java.lang.Object)
	 */
	@Override
	public Mass<V> acquireNegative(MassListener sender, Mass<K> key) {
		return getKey().acquireNegative(sender, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getKey(java.lang.Object)
	 */
	@Override
	public Mass<K> acquirePositive(MassListener sender, Mass<V> value) {
		return getKey().acquirePositive(sender, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getValueOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Mass<V> acquireNegativeOrDefault(MassListener sender, Mass<K> key, Mass<V> defaultValue) {
		return getKey().acquireNegativeOrDefault(sender, key, defaultValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getKeyOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Mass<K> acquirePositiveOrDefault(MassListener sender, Mass<V> value, Mass<K> defaultKey) {
		return getKey().acquirePositiveOrDefault(sender, value, defaultKey);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#forEachKey(java.util.function.BiConsumer)
	 */
	@Override
	public void fromEachPositive(MassListener sender, Imperative<K,V> action) {
		getKey().fromEachPositive(sender, action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#forEachValue(java.util.function.BiConsumer)
	 */
	@Override
	public void fromEachNegative(MassListener sender, Imperative<V,K> action) {
		getKey().fromEachNegative(sender, action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceAllValues(java.util.function.BiFunction)
	 */
	@Override
	public void reassignAllNegatives(MassListener sender, Commandment<K,V> function) {
		getKey().reassignAllNegatives(sender, function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceAllKeys(java.util.function.BiFunction)
	 */
	@Override
	public void reassignAllPositives(MassListener sender, Commandment<V,K> function) {
		getKey().reassignAllPositives(sender, function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#removeByKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void redeemPositive(MassListener sender, Mass<K> key, Mass<V> value) {
		getKey().redeemPositive(sender, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#removeByValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void redeemNegative(MassListener sender, Mass<V> value, Mass<K> key) {
		getKey().redeemNegative(sender, value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void reassignNegative(MassListener sender, Mass<K> key, Mass<V> oldValue, Mass<V> newValue) {
		getKey().reassignNegative(sender, key, oldValue, newValue);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceKey(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void reassignPositive(MassListener sender, Mass<V> value, Mass<K> oldKey, Mass<K> newKey) {
		getKey().reassignPositive(sender, value, oldKey, newKey);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void reassignNegative(MassListener sender, Mass<K> key, Mass<V> value) {
		getKey().reassignNegative(sender, key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#replaceKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void reassignPositive(MassListener sender, Mass<V> value, Mass<K> key) {
		getKey().reassignPositive(sender, value, key);	
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#computeIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public void exploitNegativeIfAbsent(MassListener sender, Mass<K> key, Instruction<K,V> mappingFunction) {
		getKey().exploitNegativeIfAbsent(sender, key, mappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#computeInvertedIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public void exploitPositiveIfAbsent(MassListener sender, Mass<V> value, Instruction<V,K> mappingFunction) {
		getKey().exploitPositiveIfAbsent(sender, value, mappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public void exploitNegative(MassListener sender, Mass<K> key, Commandment<K,V> remappingFunction) {
		getKey().exploitNegative(sender, key, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#computeInverted(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public void exploitPositive(MassListener sender, Mass<V> value, Commandment<V,K> remappingFunction) {
		getKey().exploitPositive(sender, value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public void bindNegative(MassListener sender, Mass<K> key, Mass<V> value, Commandment<V,V> remappingFunction) {
		getKey().bindNegative(sender, key, value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#mergeInverted(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public void bindPositive(MassListener sender, Mass<V> value, Mass<K> key, Commandment<K,K> remappingFunction) {
		getKey().bindPositive(sender, value, key, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Par#keyVisor()
	 */
	@Override
	public Collection<K> positive() {
		return getKey().positive();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Par#valueVisor()
	 */
	@Override
	public Collection<V> negative() {
		return getKey().negative();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#processPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void processPositive(MassListener sender, Mass<V> event, Commandment<V,K> unificationFunction) {
		getKey().processPositive(sender, event, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#processPositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void processPositiveIfAbsent(MassListener sender, Mass<V> event, Instruction<V,K> positronFunction) {
		getKey().processPositiveIfAbsent(sender, event, positronFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#forEveryNegative(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forEveryNegative(MassListener sender, Imperative<V,K> event) {
		getKey().forEveryNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callByNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<V,K> callByNegative(MassListener sender, Mass<V> event) {
		return getKey().callByNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> callPositive(MassListener sender, Mass<V> event) {
		return getKey().callPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callPositiveOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> callPositiveOrDefault(MassListener sender, Mass<V> event, Mass<K> defaultAntievent) {
		return getKey().callPositiveOrDefault(sender, event, defaultAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#commitPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void unifyPositive(MassListener sender, Mass<V> event, Mass<K> antievent, Commandment<K,K> unificationFunction) {
		getKey().unifyPositive(sender, event, antievent, unificationFunction);;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#setPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setPositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getKey().setPositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#setPositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setPositiveIfAbsent(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getKey().setPositiveIfAbsent(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#releaseNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releaseNegative(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getKey().releaseNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void relocatePositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getKey().relocatePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void relocatePositive(MassListener sender, Mass<V> event,
			Mass<K> oldAntievent, Mass<K> newAntievent) {
		getKey().relocatePositive(sender, event, oldAntievent, newAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#processNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void processNegative(MassListener sender, Mass<K> event, Commandment<K,V> unificationFunction) {
		getKey().processNegative(sender, event, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#processNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void processNegativeIfAbsent(MassListener sender, Mass<K> event, Instruction<K,V> positronFunction) {
		getKey().processNegativeIfAbsent(sender, event, positronFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#forEveryPositive(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forEveryPositive(MassListener sender, Imperative<K,V> event) {
		getKey().forEveryPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callByPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<K, V> callByPositive(MassListener sender, Mass<K> event) {
		return getKey().callByPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> callNegative(MassListener sender, Mass<K> event) {
		return getKey().callNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callNegativeOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> callNegativeOrDefault(MassListener sender, Mass<K> event, Mass<V> defaultAntievent) {
		return getKey().callNegativeOrDefault(sender, event, defaultAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#commitNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void unifyNegative(MassListener sender, Mass<K> event, Mass<V> antievent, Commandment<V,V> unificationFunction) {
		getKey().unifyNegative(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#setNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getKey().setNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#setNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getKey().setNegativeIfAbsent(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#releasePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releasePositive(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getKey().releasePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangeAllNegatives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void relocateAllNegatives(MassListener sender, Commandment<K,V> event) {
		getKey().relocateAllNegatives(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void relocateNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getKey().relocateNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void relocateNegative(MassListener sender, Mass<K> event, Mass<V> oldAntievent, Mass<V> newAntievent) {
		getKey().relocateNegative(sender, event, oldAntievent, newAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#engageNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void engageNegative(MassListener sender, Mass<K> event, Mass<V> antievent, Commandment<V,V> unificationFunction) {
		getKey().engageNegative(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#engagePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void engagePositive(MassListener sender, Mass<V> event, Mass<K> antievent, Commandment<K,K> unificationFunction) {
		getKey().engagePositive(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forAllNegative(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forAllNegative(MassListener sender, Imperative<V,K> event) {
		getKey().forAllNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forAllPositive(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forAllPositive(MassListener sender, Imperative<K,V> event) {
		getKey().forAllPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitByNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<V,K> requestByNegative(MassListener sender, Mass<V> event) {
		return getKey().requestByNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitByPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<K,V> requestByPositive(MassListener sender, Mass<K> event) {
		return getKey().requestByPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#operateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void operateNegative(MassListener sender, Mass<K> event, Commandment<K,V> unificationFunction) {
		getKey().operateNegative(sender, event, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#operateNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void operateNegativeIfAbsent(MassListener sender, Mass<K> event, Instruction<K,V> positronFunction) {
		getKey().operateNegativeIfAbsent(sender, event, positronFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#operatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void operatePositive(MassListener sender, Mass<V> event, Commandment<V,K> unificationFunction) {
		getKey().operatePositive(sender, event, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#operatePositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void operatePositiveIfAbsent(MassListener sender, Mass<V> event, Instruction<V,K> positronFunction) {
		getKey().operatePositiveIfAbsent(sender, event, positronFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#redeemNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateNegative(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getKey().liberateNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#redeemPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberatePositive(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getKey().liberatePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restoreAllNegatives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void restoreAllNegatives(MassListener sender, Commandment<K, V> event) {
		getKey().restoreAllNegatives(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restoreAllPositives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void restoreAllPositives(MassListener sender, Commandment<V,K> unificationFunction) {
		getKey().restoreAllPositives(sender, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restoreNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void restoreNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getKey().restoreNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restoreNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void restoreNegative(MassListener sender, Mass<K> event, Mass<V> oldAntievent, Mass<V> newAntievent) {
		getKey().restoreNegative(sender, event, oldAntievent, newAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restorePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void restorePositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getKey().restorePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restorePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void restorePositive(MassListener sender, Mass<V> event, Mass<K> oldAntievent, Mass<K> newAntievent) {
		getKey().restorePositive(sender, event, oldAntievent, newAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#updateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updateNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getKey().updateNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#updateNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updateNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getKey().updateNegativeIfAbsent(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#updatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updatePositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getKey().updatePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#updatePositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updatePositiveIfAbsent(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getKey().updatePositiveIfAbsent(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#releasePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releasePositive(MassListener sender, Mass<K> event) {
		getKey().releasePositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#redeemPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void redeemPositive(MassListener sender, Mass<K> event) {
		getKey().redeemPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#hasPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean hasPositive(MassListener sender, Mass<K> event) {
		return getKey().hasPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#belongsPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean belongsPositive(MassListener sender, Mass<K> event) {
		return getKey().belongsPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#hasNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean hasNegative(MassListener sender, Mass<V> event) {
		return getKey().hasNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#belongsNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean belongsNegative(MassListener sender, Mass<V> event) {
		return getKey().belongsNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#releaseNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releaseNegative(MassListener sender, Mass<V> event) {
		getKey().releaseNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#redeemNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateNegative(MassListener sender, Mass<V> event) {
		getKey().liberateNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> requestNegative(MassListener sender, Mass<K> event) {
		return getKey().requestNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitNegativeOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> requestNegativeOrDefault(MassListener sender, Mass<K> event, Mass<V> defaultAntievent) {
		return getKey().requestNegativeOrDefault(sender, event, defaultAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> requestPositive(MassListener sender, Mass<V> event) {
		return getKey().requestPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitPositiveOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> requestPositiveOrDefault(MassListener sender, Mass<V> event, Mass<K> defaultAntievent) {
		return getKey().requestPositiveOrDefault(sender, event, defaultAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#liberatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberatePositive(MassListener sender, Mass<K> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#relocateAllPositives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void relocateAllPositives(MassListener sender,
			Commandment<V, K> unificationFunction) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#computeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void computeNegative(MassListener sender, Mass<K> event,
			Commandment<K, V> unificationFunction) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#computeNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void computeNegativeIfAbsent(MassListener sender, Mass<K> event,
			Instruction<K, V> positronFunction) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#computePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void computePositive(MassListener sender, Mass<V> event,
			Commandment<V, K> unificationFunction) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#computePositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void computePositiveIfAbsent(MassListener sender, Mass<V> event,
			Instruction<V, K> positronFunction) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forEachNegative(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forEachNegative(MassListener sender, Imperative<V, K> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forEachPositive(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forEachPositive(MassListener sender, Imperative<K, V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getByNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<V, K> getByNegative(MassListener sender, Mass<V> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getByPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<K, V> getByPositive(MassListener sender, Mass<K> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> getNegative(MassListener sender, Mass<K> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getNegativeOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> getNegativeOrDefault(MassListener sender, Mass<K> event,
			Mass<V> defaultAntievent) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> getPositive(MassListener sender, Mass<V> event) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getPositiveOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> getPositiveOrDefault(MassListener sender, Mass<V> event,
			Mass<K> defaultAntievent) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#mergeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void mergeNegative(MassListener sender, Mass<K> event,
			Mass<V> antievent, Commandment<V, V> unificationFunction) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#mergePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void mergePositive(MassListener sender, Mass<V> event,
			Mass<K> antievent, Commandment<K, K> unificationFunction) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setAllNegatives(org.xmlrobot.util.Congregation)
	 */
	@Override
	public void putAllNegatives(Congregation<Positron<K, V>> c) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setAllPositives(org.xmlrobot.util.Congregation)
	 */
	@Override
	public void putAllPositives(Congregation<Positron<V, K>> m) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putNegative(MassListener sender, Mass<K> event,
			Mass<V> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putNegativeIfAbsent(MassListener sender, Mass<K> event,
			Mass<V> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putPositive(MassListener sender, Mass<V> event,
			Mass<K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setPositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putPositiveIfAbsent(MassListener sender, Mass<V> event,
			Mass<K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#removeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeNegative(MassListener sender, Mass<V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#removePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removePositive(MassListener sender, Mass<K> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#removeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeNegative(MassListener sender, Mass<V> event,
			Mass<K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#removePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removePositive(MassListener sender, Mass<K> event,
			Mass<V> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replaceAllNegatives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void replaceAllNegatives(MassListener sender, Commandment<K, V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replaceAllPositives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void replaceAllPositives(MassListener sender,
			Commandment<V, K> unificationFunction) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replaceNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void replaceNegative(MassListener sender, Mass<K> event,
			Mass<V> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replaceNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void replaceNegative(MassListener sender, Mass<K> event,
			Mass<V> oldAntievent, Mass<V> newAntievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replacePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void replacePositive(MassListener sender, Mass<V> event,
			Mass<K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replacePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void replacePositive(MassListener sender, Mass<V> event,
			Mass<K> oldAntievent, Mass<K> newAntievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#holdsPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean holdsPositive(MassListener sender, Mass<K> event) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#holdsNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean holdsNegative(MassListener sender, Mass<V> event) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#updateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void updateNegative(MassListener sender, Graviton<K, V> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#updatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void updatePositive(MassListener sender, Graviton<V, K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#setNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void setNegative(MassListener sender, Graviton<K, V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#setPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void setPositive(MassListener sender, Graviton<V, K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#assignNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void assignNegative(MassListener sender, Graviton<K, V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#assignPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void assignPositive(MassListener sender, Graviton<V, K> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#putNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void putNegative(MassListener sender, Graviton<K, V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#putPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void putPositive(MassListener sender, Graviton<V, K> event) {
		// TODO Auto-generated method stub
		
	}
}