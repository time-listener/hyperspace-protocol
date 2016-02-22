/**
 * 
 */
package org.xmlrobot.space;

import java.util.Iterator;
import java.util.function.Predicate;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * Space: the final frontier. These are the 
 * voyages of the starship Enterprise. Its five-year mission: to 
 * explore strange new worlds, to seek out new life and new 
 * civilizations, to boldly go where no man has gone before.
 * <br><br>
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 26
 */
@XmlTransient
public abstract class Space<K,V> 
	extends Contraction<K,V> {
	
	/**
	 * 3626502374824683675L
	 */
	private static final long serialVersionUID = 3626502374824683675L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getKey()
	 */
	@Override
	@XmlTransient
	public K getKey() {
		return mass.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setKey(java.lang.Object)
	 */
	@Override
	public K setKey(K key) {
		K oldKey = mass.setKey(key);
		mass.update();
		return oldKey;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getValue()
	 */
	@Override
	@XmlTransient
	public V getValue() {
		return mass.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		V oldValue = mass.setValue(value);
		mass.update();
		return oldValue;
	}
	
	/**
	 * {@link Space} default class constructor.
	 */
	public Space() {
		super();
	}
	/**
	 * {@link Space} default class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param gen {@link Parity} the gender
	 */
	public Space(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	public Space(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	public Space(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	public Space(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	public Space(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	public Space(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen) {
		// call constructor
		super(type, antitype, key, value, gen);
	}

 	// visor implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Mass#keyVisor()
 	 */
 	@Override
 	public Congregation<K> keyVisor() {
 		Congregation<K> keys;
 		return (keys = keyVisor) == null ? (keyVisor = new KeyVisor(this)) : keys;
 	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Mass#valueVisor()
 	 */
 	@Override
 	public Congregation<V> valueVisor() {
 		Congregation<V> values;
 		return (values = valueVisor) == null ? (valueVisor = new ValueVisor(this)) : values;
 	}
 	
	/**
	 * Key visor implementation class.
	 * @author joan
	 *
	 */
	protected class KeyVisor
		extends MassVisor
			implements Congregation<K> {

		/**
		 * 
		 */
		private static final long serialVersionUID = -4478951415985337237L;
	
		/**
		 * @param source
		 */
		public KeyVisor(Mass<K,V> source) {
			super(source);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.PastCallable#call()
		 */
		@Override
		public K call() {
			return source.getKey();
		}
		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(K o1, K o2) {
			return 0;
		}
		/* (non-Javadoc)
		 * @see java.util.Enumeration#nextElement()
		 */
		@Override
		public K nextElement() {
			return source.nextElement().getKey();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#add(java.lang.Object)
		 */
		@Override
		public boolean add(K e) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#addAll(java.lang.Object)
		 */
		@Override
		public boolean addAll(K c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#call(int)
		 */
		@Override
		public K call(int N) {
			return source.call(N).getKey();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#collect(org.xmlrobot.genesis.Congregation)
		 */
		@Override
		public Congregation<K> collect(Congregation<K> entities) {
			return source.collectKeys(entities);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(K c) {
			if(source.isEmpty())
				return false;
			Iterator<K> keys = new KeyIterator(source);
			K key = keys.next();
			do {
				if(key == c) {
					return true;
				}
			}
			while(keys.hasNext() && (key = keys.next()) != null);
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#containsAll(java.lang.Object)
		 */
		@Override
		public boolean containsAll(K c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getRoot()
		 */
		@Override
		public K getRoot() {
			return source.getRoot().getKey();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#setRoot(java.lang.Object)
		 */
		@Override
		public void setRoot(K root) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getChild()
		 */
		@Override
		public K getChild() {
			return source.getChild().getKey();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getFuture()
		 */
		@Override
		public K getFuture() {
			return source.getFuture().getKey();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getParent()
		 */
		@Override
		public K getParent() {
			return source.getParent().getKey();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getPast()
		 */
		@Override
		public K getPast() {
			return source.getPast().getKey();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#iterator()
		 */
		@Override
		public Iterator<K> iterator() {
			return new KeyIterator(source);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#order(java.lang.Object)
		 */
		@Override
		public boolean order(K listener) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#orderAt(java.lang.Object, int)
		 */
		@Override
		public void orderAt(K listener, int index) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#orderInfer(java.lang.Object)
		 */
		@Override
		public K orderInfer(K listener) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#orderSuper(java.lang.Object)
		 */
		@Override
		public K orderSuper(K listener) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#permute(int)
		 */
		@Override
		public K permute(int N) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#polarize(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void polarize(K parent, K child) {		
			return;	
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#release()
		 */
		@Override
		public K release() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#releaseChild()
		 */
		@Override
		public K releaseChild() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#releaseParent()
		 */
		@Override
		public K releaseParent() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#removeAll(java.lang.Object)
		 */
		@Override
		public boolean removeAll(K c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#removeIf(java.util.function.Predicate)
		 */
		@Override
		public boolean removeIf(Predicate<? super K> filter) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#retainAll(java.lang.Object)
		 */
		@Override
		public boolean retainAll(K c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#revolve()
		 */
		@Override
		public K revolve() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#rotate()
		 */
		@Override
		public K rotate() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#setChild(java.lang.Object)
		 */
		@Override
		public void setChild(K listener) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#setParent(java.lang.Object)
		 */
		@Override
		public void setParent(K listener) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#submit(java.lang.Object)
		 */
		@Override
		public boolean submit(K entity) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#submitAll(java.lang.Object)
		 */
		@Override
		public boolean submitAll(K c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#submitChild(java.lang.Object)
		 */
		@Override
		public K submitChild(K listener) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#submitParent(java.lang.Object)
		 */
		@Override
		public K submitParent(K listener) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#swap(java.lang.Object)
		 */
		@Override
		public void swap(K listener) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
		 */
		@Override
		public <X extends TimeListener<X,Y>, Y extends TimeListener<Y,X>> 
			void pulse(TimeListener<?,?> sender, Tachyon<Y,X> event) {
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
		 */
		@Override
		public <X extends TimeListener<X,Y>, Y extends TimeListener<Y,X>> 
			void echo(TimeListener<?,?> sender, Tachyon<X,Y> event) {
		}	
	}
	/**
	 * Value visor implementation class.
	 * @author joan
	 *
	 */
	protected class ValueVisor
		extends MassVisor
			implements Congregation<V> {

		/**
		 * 
		 */
		private static final long serialVersionUID = -4478951415985337237L;
	
		/**
		 * @param source
		 */
		public ValueVisor(Mass<K,V> source) {
			super(source);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.PastCallable#call()
		 */
		@Override
		public V call() {
			return source.getValue();
		}
		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(V o1, V o2) {
			return 0;
		}
		/* (non-Javadoc)
		 * @see java.util.Enumeration#nextElement()
		 */
		@Override
		public V nextElement() {
			return source.nextElement().getValue();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#add(java.lang.Object)
		 */
		@Override
		public boolean add(V e) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#addAll(java.lang.Object)
		 */
		@Override
		public boolean addAll(V c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#call(int)
		 */
		@Override
		public V call(int N) {
			return source.call(N).getValue();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#collect(org.xmlrobot.genesis.Congregation)
		 */
		@Override
		public Congregation<V> collect(Congregation<V> entities) {
			return source.collectValues(entities);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(V c) {
			if(source.isEmpty())
				return false;
			Iterator<V> values = new ValueIterator(source);
			V value = values.next();
			do {
				if(value == c) {
					return true;
				}
			}
			while(values.hasNext() && (value = values.next()) != null);
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#containsAll(java.lang.Object)
		 */
		@Override
		public boolean containsAll(V c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#delve(int)
		 */
		@Override
		public int delve(int counter) {
	
			return source.delve(counter);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#depth()
		 */
		@Override
		public int depth() {
			return source.depth();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getRoot()
		 */
		@Override
		public V getRoot() {
			return source.getRoot().getValue();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#setRoot(java.lang.Object)
		 */
		@Override
		public void setRoot(V root) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getChild()
		 */
		@Override
		public V getChild() {
			return source.getChild().getValue();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getFuture()
		 */
		@Override
		public V getFuture() {
			return source.getFuture().getValue();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getParent()
		 */
		@Override
		public V getParent() {
			return source.getParent().getValue();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#getPast()
		 */
		@Override
		public V getPast() {
			return source.getPast().getValue();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#iterator()
		 */
		@Override
		public Iterator<V> iterator() {
			return new ValueIterator(source);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#order(java.lang.Object)
		 */
		@Override
		public boolean order(V listener) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#orderAt(java.lang.Object, int)
		 */
		@Override
		public void orderAt(V listener, int index) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#orderInfer(java.lang.Object)
		 */
		@Override
		public V orderInfer(V listener) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#orderSuper(java.lang.Object)
		 */
		@Override
		public V orderSuper(V listener) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#permute(int)
		 */
		@Override
		public V permute(int N) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#polarize(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void polarize(V parent, V child) {		
			return;	
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#release()
		 */
		@Override
		public V release() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#releaseChild()
		 */
		@Override
		public V releaseChild() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#releaseParent()
		 */
		@Override
		public V releaseParent() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#removeAll(java.lang.Object)
		 */
		@Override
		public boolean removeAll(V c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#removeIf(java.util.function.Predicate)
		 */
		@Override
		public boolean removeIf(Predicate<? super V> filter) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#retainAll(java.lang.Object)
		 */
		@Override
		public boolean retainAll(V c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#revolve()
		 */
		@Override
		public V revolve() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#rotate()
		 */
		@Override
		public V rotate() {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#setChild(java.lang.Object)
		 */
		@Override
		public void setChild(V listener) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#setParent(java.lang.Object)
		 */
		@Override
		public void setParent(V listener) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#submit(java.lang.Object)
		 */
		@Override
		public boolean submit(V entity) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#submitAll(java.lang.Object)
		 */
		@Override
		public boolean submitAll(V c) {
			return false;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#submitChild(java.lang.Object)
		 */
		@Override
		public V submitChild(V listener) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#submitParent(java.lang.Object)
		 */
		@Override
		public V submitParent(V listener) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Congregation#swap(java.lang.Object)
		 */
		@Override
		public void swap(V listener) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
		 */
		@Override
		public <X extends TimeListener<X, Y>,Y extends TimeListener<Y, X>> 
			void pulse(TimeListener<?,?> sender, Tachyon<Y, X> event) {
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
		 */
		@Override
		public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> void echo(
				TimeListener<?,?> sender, Tachyon<X,Y> event) {
		}	
	}
}