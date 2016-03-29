/**
 * 
 */
package org.xmlrobot.horizon;

import java.util.Collection;

import org.xmlrobot.MassListener;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.protocol.Hypermass;
import org.xmlrobot.util.Congregation;
import org.xmlrobot.util.Imperative;
import org.xmlrobot.util.Instruction;
import org.xmlrobot.util.Commandment;


/**
 * @author joan
 *
 */
public abstract class Graviton<K,V> 
	extends Tachyon<Positron<K,V>,Positron<V,K>> 
		implements Positron<K,V> {

	/**
	 * -8990955813673415221L
	 */
	private static final long serialVersionUID = -8990955813673415221L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#getPositive()
	 */
	@Override
	public K getPositive() {
		return getSource().getPositive();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#setPositive(java.lang.Object)
	 */
	@Override
	public K setPositive(K key) {
		return getSource().setPositive(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#getNegative()
	 */
	@Override
	public V getNegative() {
		return getSource().getNegative();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#setNegative(java.lang.Object)
	 */
	@Override
	public V setNegative(V value) {
		return getSource().setNegative(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.Tachyon#dna()
	 */
	@Override
	public Hypermass<K,V> dna() {
		return getSource().dna();
	}
	
	/**
	 * {@link Graviton} default class constructor.
	 * @param source {@link Positron} the source triggering this event
	 */
	public Graviton(Positron<K,V> source) {
		super(source);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.Tachyon#getSource()
	 */
	@Override
	public synchronized Positron<K,V> getSource() {
		return (Positron<K,V>) super.getSource();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.Tachyon#clone()
	 */
	@Override
	public Positron<K,V> clone() {
		return (Positron<K,V>) super.clone();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#getByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Graviton<K,V> acquireByPositive(MassListener sender, Mass<K> event) {
		return getSource().acquireByPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#getByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Graviton<V,K> acquireByNegative(MassListener sender, Mass<V> event) {
		return getSource().acquireByNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#containsPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public boolean containsPositive(MassListener sender, Mass<K> event) {
		return getSource().containsPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#containsNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public boolean containsNegative(MassListener sender, Mass<V> event) {
		return getSource().containsNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#putNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void assignNegative(MassListener sender, Mass<K> event, Mass<V> value) {
		getSource().assignNegative(sender, event, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#putPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void assignPositive(MassListener sender, Mass<V> event, Mass<K> key) {
		getSource().assignPositive(sender, event, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#putNegativeIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void assignNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> value) {
		getSource().assignNegativeIfAbsent(sender, event, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#putPositiveIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void assignPositiveIfAbsent(MassListener sender, Mass<V> event, Mass<K> key) {
		getSource().assignPositiveIfAbsent(sender, event, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#removeByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void redeemNegative(MassListener sender, Mass<V> event) {
		getSource().redeemNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#getNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Mass<V> acquireNegative(MassListener sender, Mass<K> event) {
		return getSource().acquireNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#getPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Mass<K> acquirePositive(MassListener sender, Mass<V> event) {
		return getSource().acquirePositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#getNegativeOrDefault(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Mass<V> acquireNegativeOrDefault(MassListener sender, Mass<K> positive, Mass<V> defaultNegative) {
		return getSource().acquireNegativeOrDefault(sender, positive, defaultNegative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#getPositiveOrDefault(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Mass<K> acquirePositiveOrDefault(MassListener sender, Mass<V> negative, Mass<K> defaultPositive) {
		return getSource().acquirePositiveOrDefault(sender, negative, defaultPositive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#forEachPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void fromEachPositive(MassListener sender, Imperative<K,V> action) {
		getSource().fromEachPositive(sender, action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#forEachNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void fromEachNegative(MassListener sender, Imperative<V,K> action) {
		getSource().fromEachNegative(sender, action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#replaceAllNegatives(org.xmlrobot.genesis.MassListener, org.xmlrobot.util.Proposition)
	 */
	@Override
	public void reassignAllNegatives(MassListener sender, Commandment<K,V> function) {
		getSource().reassignAllNegatives(sender, function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#replaceAllPositives(org.xmlrobot.genesis.MassListener, org.xmlrobot.util.Proposition)
	 */
	@Override
	public void reassignAllPositives(MassListener sender, Commandment<V,K> function) {
		getSource().reassignAllPositives(sender, function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#removeByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void redeemPositive(MassListener sender, Mass<K> positive, Mass<V> negative) {
		getSource().redeemPositive(sender, positive, negative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#removeByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void redeemNegative(MassListener sender, Mass<V> negative, Mass<K> positive) {
		getSource().redeemNegative(sender, negative, positive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#replaceNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void reassignNegative(MassListener sender, Mass<K> positive, Mass<V> oldNegative, Mass<V> newNegative) {
		getSource().reassignNegative(sender, positive, oldNegative, newNegative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#replacePositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void reassignPositive(MassListener sender, Mass<V> negative, Mass<K> oldPositive, Mass<K> newPositive) {
		getSource().reassignPositive(sender, negative, oldPositive, newPositive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#replaceNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void reassignNegative(MassListener sender, Mass<K> positive, Mass<V> negative) {
		getSource().reassignNegative(sender, positive, negative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#replacePositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public void reassignPositive(MassListener sender, Mass<V> negative, Mass<K> positive) {
		getSource().reassignPositive(sender, negative, positive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#computeNegativeIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void exploitNegativeIfAbsent(MassListener sender, Mass<K> key, Instruction<K,V> mappingFunction) {
		getSource().exploitNegativeIfAbsent(sender, key, mappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#computePositiveIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void exploitPositiveIfAbsent(MassListener sender, Mass<V> value, Instruction<V,K> mappingFunction) {
		getSource().exploitPositiveIfAbsent(sender, value, mappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#computeNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.util.Proposition)
	 */
	@Override
	public void exploitNegative(MassListener sender, Mass<K> key, Commandment<K,V> remappingFunction) {
		getSource().exploitNegative(sender, key, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#computePositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.util.Proposition)
	 */
	@Override
	public void exploitPositive(MassListener sender, Mass<V> value, Commandment<V,K> remappingFunction) {
		getSource().exploitPositive(sender, value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#mergeNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson, org.xmlrobot.util.Proposition)
	 */
	@Override
	public void bindNegative(MassListener sender, Mass<K> key, Mass<V> value, Commandment<V,V> remappingFunction) {
		getSource().bindNegative(sender, key, value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#mergePositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson, org.xmlrobot.util.Proposition)
	 */
	@Override
	public void bindPositive(MassListener sender, Mass<V> value, Mass<K> key, Commandment<K,K> remappingFunction) {
		getSource().bindPositive(sender, value, key, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.Tachyon#matrix()
	 */
	@Override
	public Positron.Transmuter<K,V> matrix() {
		return getSource().matrix();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#positive()
	 */
	@Override
	public Collection<K> positive() {
		return getSource().positive();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#negative()
	 */
	@Override
	public Collection<V> negative() {
		return getSource().negative();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#processPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void processPositive(MassListener sender, Mass<V> event, Commandment<V,K> unificationFunction) {
		getSource().processPositive(sender, event, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#processPositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void processPositiveIfAbsent(MassListener sender, Mass<V> event, Instruction<V,K> positronFunction) {
		getSource().processPositiveIfAbsent(sender, event, positronFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#forEveryNegative(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forEveryNegative(MassListener sender, Imperative<V, K> event) {
		getSource().forEveryNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callByNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<V,K> callByNegative(MassListener sender, Mass<V> event) {
		return getSource().callByNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> callPositive(MassListener sender, Mass<V> event) {
		return getSource().callPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callPositiveOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> callPositiveOrDefault(MassListener sender, Mass<V> event, Mass<K> defaultAntievent) {
		return getSource().callPositiveOrDefault(sender, event, defaultAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#commitPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void unifyPositive(MassListener sender, Mass<V> event, Mass<K> antievent, Commandment<K,K> unificationFunction) {
		getSource().unifyPositive(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#setPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setPositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getSource().setPositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#setPositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setPositiveIfAbsent(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getSource().setPositiveIfAbsent(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#releaseNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releaseNegative(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getSource().releaseNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void relocatePositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getSource().relocatePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void relocatePositive(MassListener sender, Mass<V> event, Mass<K> oldAntievent, Mass<K> newAntievent) {
		getSource().relocatePositive(sender, event, oldAntievent, newAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#processNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void processNegative(MassListener sender, Mass<K> event, Commandment<K,V> unificationFunction) {
		getSource().processNegative(sender, event, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#processNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void processNegativeIfAbsent(MassListener sender, Mass<K> event, Instruction<K,V> positronFunction) {
		getSource().processNegativeIfAbsent(sender, event, positronFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#forEveryPositive(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forEveryPositive(MassListener sender, Imperative<K, V> event) {
		getSource().forEveryPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callByPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<K,V> callByPositive(MassListener sender, Mass<K> event) {
		return getSource().callByPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> callNegative(MassListener sender, Mass<K> event) {
		return getSource().callNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#callNegativeOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> callNegativeOrDefault(MassListener sender, Mass<K> event, Mass<V> defaultAntievent) {
		return getSource().callNegativeOrDefault(sender, event, defaultAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#commitNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void unifyNegative(MassListener sender, Mass<K> event, Mass<V> antievent, Commandment<V,V> unificationFunction) {
		getSource().unifyNegative(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#setNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getSource().setNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#setNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getSource().setNegativeIfAbsent(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#releasePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releasePositive(MassListener sender, Mass<K> event,
			Mass<V> antievent) {
		getSource().releasePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangeAllNegatives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void relocateAllNegatives(MassListener sender, Commandment<K,V> event) {
		relocateAllNegatives(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void relocateNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getSource().relocateNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#exchangeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void relocateNegative(MassListener sender, Mass<K> event,
			Mass<V> oldAntievent, Mass<V> newAntievent) {
		getSource().relocateNegative(sender, event, oldAntievent, newAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#applyNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void engageNegative(MassListener sender, Mass<K> event, Mass<V> antievent, Commandment<V, V> unificationFunction) {
		getSource().engageNegative(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#applyPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void engagePositive(MassListener sender, Mass<V> event, Mass<K> antievent, Commandment<K, K> unificationFunction) {
		getSource().engagePositive(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forAllNegative(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forAllNegative(MassListener sender, Imperative<V, K> event) {
		getSource().forAllNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forAllPositive(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forAllPositive(MassListener sender, Imperative<K, V> event) {
		getSource().forAllPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#inquireByNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<V,K> requestByNegative(MassListener sender, Mass<V> event) {
		return getSource().requestByNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#inquireByPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<K,V> requestByPositive(MassListener sender, Mass<K> event) {
		return getSource().requestByPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#operateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void operateNegative(MassListener sender, Mass<K> event, Commandment<K,V> unificationFunction) {
		getSource().operateNegative(sender, event, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#operateNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void operateNegativeIfAbsent(MassListener sender, Mass<K> event, Instruction<K,V> positronFunction) {
		getSource().operateNegativeIfAbsent(sender, event, positronFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#operatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void operatePositive(MassListener sender, Mass<V> event, Commandment<V,K> unificationFunction) {
		getSource().operatePositive(sender, event, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#operatePositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void operatePositiveIfAbsent(MassListener sender, Mass<V> event, Instruction<V,K> positronFunction) {
		getSource().operatePositiveIfAbsent(sender, event, positronFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#redeemNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateNegative(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getSource().liberateNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#redeemPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberatePositive(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getSource().liberatePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restoreAllNegatives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void restoreAllNegatives(MassListener sender, Commandment<K, V> event) {
		getSource().restoreAllNegatives(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restoreAllPositives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void restoreAllPositives(MassListener sender, Commandment<V,K> unificationFunction) {
		getSource().restoreAllPositives(sender, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restoreNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void restoreNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getSource().restoreNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restoreNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void restoreNegative(MassListener sender, Mass<K> event, Mass<V> oldAntievent, Mass<V> newAntievent) {
		getSource().restoreNegative(sender, event, oldAntievent, newAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restorePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void restorePositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getSource().restorePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#restorePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void restorePositive(MassListener sender, Mass<V> event,
			Mass<K> oldAntievent, Mass<K> newAntievent) {
		getSource().restorePositive(sender, event, oldAntievent, newAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#updateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updateNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getSource().updateNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#updateNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updateNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getSource().updateNegativeIfAbsent(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#updatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updatePositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getSource().updatePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#updatePositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updatePositiveIfAbsent(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getSource().updatePositiveIfAbsent(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#releasePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releasePositive(MassListener sender, Mass<K> event) {
		getSource().releasePositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#redeemPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void redeemPositive(MassListener sender, Mass<K> event) {
		getSource().redeemPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#hasPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean hasPositive(MassListener sender, Mass<K> event) {
		return getSource().hasPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#belongsPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean belongsPositive(MassListener sender, Mass<K> event) {
		return getSource().belongsPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#hasNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean hasNegative(MassListener sender, Mass<V> event) {
		return getSource().hasNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#belongsNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean belongsNegative(MassListener sender, Mass<V> event) {
		return getSource().belongsNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#releaseNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void releaseNegative(MassListener sender, Mass<V> event) {
		getSource().releaseNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#redeemNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateNegative(MassListener sender, Mass<V> event) {
		getSource().liberateNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> requestNegative(MassListener sender, Mass<K> event) {
		return getSource().requestNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitNegativeOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> requestNegativeOrDefault(MassListener sender, Mass<K> event, Mass<V> defaultAntievent) {
		return getSource().requestNegativeOrDefault(sender, event, defaultAntievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> requestPositive(MassListener sender, Mass<V> event) {
		return getSource().requestPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#visitPositiveOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> requestPositiveOrDefault(MassListener sender, Mass<V> event, Mass<K> defaultAntievent) {
		return getSource().requestPositiveOrDefault(sender, event, defaultAntievent);
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
	public void updateNegative(MassListener sender, Graviton<K,V> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#setNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void setNegative(MassListener sender, Graviton<K,V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#putNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void putNegative(MassListener sender, Graviton<K,V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#putPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void putPositive(MassListener sender, Graviton<V,K> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#updatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void updatePositive(MassListener sender, Graviton<V,K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#setPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void setPositive(MassListener sender, Graviton<V,K> antievent) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#assignNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void assignNegative(MassListener sender, Graviton<K,V> event) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#assignPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void assignPositive(MassListener sender, Graviton<V,K> event) {
		// TODO Auto-generated method stub
		
	}
}