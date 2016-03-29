/**
 * 
 */
package org.xmlrobot;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.genesis.PastCallable;
import org.xmlrobot.genesis.RunnableFuture;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.protocol.Hyperdata;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The original time-traveler message implementation class.
 * 
 * <p>Hypergenesis (YY) > Power (XY) | Love (XX)
 * 
 * <p>From key to value, from value to key. Key is the value 
 * and value is the time. From further to the hyperspace.
 * 
 * <p><tt>this</tt> class is just another member of the 
 * <tt>hyperspace congregation framework</tt>
 * 
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 1
 */
public abstract class Hypergenesis
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Random 
			implements TimeListener<K,V> {

	/**
	 * -3239215811760910575L
	 */
	private static final long serialVersionUID = -3239215811760910575L;

	/**
	 * The time-traveler message.
	 */
	protected volatile Hyperdata<K,V> data;
	
	/**
	 * Wonderland: the matrix of the {@link Hypergenesis}.
	 */
	protected transient volatile TimeListener.Transmitter<K,V> matrix;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#command()
	 */
	@Override
	@XmlElement
	public Command getCommand() {
		return data.getCommand();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#setCommand(org.xmlrobot.util.Command)
	 */
	@Override
	public void setCommand(Command cmd) {
		// set command header
		data.setCommand(cmd);	 
		// stream entity's properties before nothing
		update();
		// submit abstract command into the hyperspace
		push(newFlop());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getGen()
	 */
	@Override
	@XmlElement
	public Parity getGen() {
		return data.getGen();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#setGen(org.xmlrobot.util.Parity)
	 */
	@Override
	public void setGen(Parity value) {
		data.setGen(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getRunner()
	 */
	@Override
	public Thread getRunner() {
		return data.getRunner();
	}
	/* (non-Javadoc)
	 * @see orgxmlrobot.genesis.MassListener#getFamily()
	 */
	@Override
	public ThreadGroup getFamily() {
		return data.getFamily();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#host()
	 */
	@Override
	@XmlTransient
	public ServiceRegistration<?> getHost() {
		return data.getHost();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getContext()
	 */
	@Override
	@XmlTransient
	public BundleContext getContext() {
		return data.getContext();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getName()
	 */
	@Override
	public abstract String getName();
	
	/**
	 * {@link Hypergenesis} default class constructor.<br>
	 * To implement life, you MUST obey and do the following assignments:<br>
	 * 1.- instance stem<br>
	 * 2.- set this key / value value<br>
	 * 3.- set this type / value antitype<br>
	 * 4.- set this value / value key<br>
	 * 5.- set this antitype / value type<br>
	 * 6.- set this parity / opposite parity<br>
	 * 7.- set this root and stem / set value root and stem
	 */
	public Hypergenesis() {
		super();
		// instance dna
		data = new Hyperdata<K,V>(Parity.YY);
	}
	/**
	 * {@link Hypergenesis} class constructor.
	 * @param type the type
     * @param gen {@link Parity} the inherited gender
	 */
	protected Hypergenesis(Class<? extends K> type, Parity gen) {
		super();
		// instance dna
		data = new Hyperdata<K,V>(type, type.cast(this), gen);
	}	
	/**
	 * {@link Hypergenesis} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
	protected Hypergenesis(Class<? extends K> type, Class<? extends V> antitype, V value, Parity gen) {
		super();
		// instance dna
		data = new Hyperdata<K,V>(type, antitype, type.cast(this), value, gen);
		// the unification of nothing
		value.setAntitype(type);
		// the unification of everything
		value.setValue(getKey());
	}
	/**
	 * {@link Hypergenesis} class constructor.
	 * @param type the type
     * @param gen {@link Parity} the inherited gender
	 */
	protected Hypergenesis(Class<? extends K> type, K parent, V child) {
		super();
		// instance dna
		data = new Hyperdata<K,V>(type, type.cast(this), parent, child);
	}
	/**
	 * {@link Hypergenesis} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
	protected Hypergenesis(Class<? extends K> type, Class<? extends V> antitype, V value, K parent, V child) {
		super();
		// instance dna
		data = new Hyperdata<K,V>(type, antitype, type.cast(this), value, parent, child);
		// the unification of nothing
		value.setAntitype(type);
		// the unification of everything
		value.setValue(getKey());
	}
	/**
	 * {@link Hypergenesis} class constructor.
	 * @param type the type
     * @param gen {@link Parity} the inherited gender
	 */
	protected Hypergenesis(Class<? extends K> type, K root, V stem, Parity gen) {
		super();
		// instance dna
		data = new Hyperdata<K,V>(type, type.cast(this), root, stem, gen);
	}
	/**
	 * {@link Hypergenesis} class constructor.
	 * @param type the type
     * @param gen {@link Parity} the inherited gender
	 */
	protected Hypergenesis(Class<? extends K> type, Class<? extends V> antitype, V value, K root, V stem, Parity gen) {
		super();
		// instance dna
		data = new Hyperdata<K,V>(type, antitype, type.cast(this), value, root, stem, gen);
		// the unification of nothing
		value.setAntitype(type);
		// the unification of everything
		value.setValue(getKey());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {

		try {
			@SuppressWarnings("unchecked")
			Hypergenesis<K,V> key = (Hypergenesis<K,V>) super.clone();
			key.data = new Hyperdata<K,V>(getType(), getType().cast(key), getGen());
			return key;
		}
		catch (ClassCastException | CloneNotSupportedException e) {

			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#dna()
	 */
	@Override
	public Hyperdata<K,V> dna() {
		return data.dna();
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// run data
		data.run();
    	// push into hyperspace
    	setCommand(Command.LISTEN);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) {
		if(context == null)
			throw new Abort(this);
		//God-mode ON
		context.addServiceListener(this);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) {
		if(context == null)
			throw new Abort(this);
		// stop listening
		context.removeServiceListener(this);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#pulse(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void pulse(MassListener source, Tachyon<V,K> event) {
		// wonderland nullification
		matrix = null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#echo(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void echo(MassListener source, Tachyon<K,V> event) {
		// wonderland nullification
		matrix = null;
	}
	/**
	 * Pushes {@link Tachyon} into hyperspace.
	 * @param event {@link Tachyon} the tachyon being transmitted
	 */
	protected abstract void push(Tachyon<V,K> event);
	/**
	 * Creates new tachyon with K as key type
	 * @return the new created tachyon
	 */
	protected Tachyon<K,V> newInstant() {
		
		return new Tachyon<K,V>(getKey()) {

			/**
			 * 8925843685879233963L
			 */
			private static final long serialVersionUID = 8925843685879233963L;

		};
	}
	/**
	 * Creates new tachyon with V as key type
	 * @return the new created tachyon
	 */
	protected Tachyon<V,K> newFlop() {
		
		return new Tachyon<V,K>(getValue()) {

			/**
			 * 9159210142290266038L
			 */
			private static final long serialVersionUID = 9159210142290266038L;
		};
	}
	protected AtomicInteger newAtomicInteger(AtomicInteger N) {
		return new AtomicInteger(super.nextInt(N.get()));
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#matrix()
	 */
	@Override
	public abstract TimeListener.Transmitter<K,V> matrix();
	
	/**
	 * {@link Hypergenesis} comparator implementation class.
	 * It does a new {@link RunnableFuture} for this {@link PastCallable}.
	 * As its name suggests, this implementation just makes a comparison.
	 * @author joan
	 */
	protected class Comparator
		implements TimeListener.Transmitter<K,V> {

		/**
		 * The generated output.
		 */
		protected transient volatile V output;
		
		/**
		 * {@link Comparator} default class constructor
		 */
		public Comparator() {
		}
		
		/**
		 * {@link Comparator} default class constructor
		 */
		public Comparator(V output) {
 			// inherit output
			this.output = output;
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Reproductor#reproduce(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int reproduce(K key, V value) {
			// consecrate comparison and get computation result
			int cmp = compare(key.getValue(), value);
			// switch comparison result by commuting by parity
			if (key.getGen().equals(Parity.XY) ? cmp < 0 : cmp > 0) {
				// send root to the future
				inject(key);
				// get and check existence
				if (!value.isFuture()) {
					// declare stem's child
					K keyFuture = value.get();
					// send stem's child to the future
					inject(keyFuture);
					// get root's child
					if (!key.isFuture()) {
						// declare root child
						V valueFuture = key.get();
						// call recursion and append result
						cmp += reproduce(valueFuture.get(), keyFuture.get());
					}
				} else {
					// get and check existence
					if (!key.isFuture()) {
						// so, we fill the chain as much as possible.
						push(key.get());
					}
				}
			} else if (cmp == 0) {
				// submit both messages
				inject(key);
				push(value);
				// call recursion and accumulate computation result
				cmp += reproduce(value.get(), key.get());
			} else {
				// send stem to the future
				push(value);
				// get and check existence
				if (!key.isFuture()) {
					// declare root's child
					V valueFuture = key.get();
					// send root's child to the future
					push(valueFuture);
					// declare stem's child
					K keyFuture = value.get();
					// get and check existence
					if (!value.isFuture()) {
						// call recursion and accumulate result
						cmp += reproduce(valueFuture.get(), keyFuture.get());
					}
				} else {
					K keyFuture = value.get();
					// get and check existence
					if (!value.isFuture()) {
						// so, evolve a little bit.
						inject(keyFuture);
					}
				}
			}
			// return computation result
			return cmp;
		}
		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(V o1, V o2) {
			return o1.compareTo(o2);
		}
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(K o) {
			return output.compareTo(o.get());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.TimeListener.Transmitter#inject(java.lang.Object)
		 */
		@Override
		public void inject(K past) {
			// submit event into hyperspace
			output.allocateValue(getParent(), new Tachyon<K,V>(past){

				/**
				 * 1690914198034545297L
				 */
				private static final long serialVersionUID = 1690914198034545297L;
			});
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.TimeListener.Transmitter#push(java.lang.Object)
		 */
		@Override
		public void push(V value) {
			// submit event into hyperspace
			output.allocateValue(output, new Tachyon<K,V>(value.getValue()) {

				/**
				 * 6909938942655393473L
				 */
				private static final long serialVersionUID = 6909938942655393473L;
			});
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Reproducible#output()
		 */
		@Override
		public V output() {
			return output;
		}
		/* (non-Javadoc)
		 * @see java.util.Map.Entry#getKey()
		 */
		@Override
		public K getKey() {
			return output.getValue();
		}
		/* (non-Javadoc)
		 * @see java.util.Map.Entry#getValue()
		 */
		@Override
		public V getValue() {
			return output.getKey();
		}
		/* (non-Javadoc)
		 * @see java.util.Map.Entry#setValue(java.lang.Object)
		 */
		@Override
		public V setValue(V value) {
			return null;
		}
	}

	/**
	 * Hypergear implementation class.
	 * Past iterators are faster than future iterators.
	 * @author joan
	 * @param <T> the element type
	 * @param <U> the element antitype
	 */
	protected abstract class Hypergear
		<T extends TimeListener<T,U>,U extends TimeListener<U,T>>  {

		/**
		 * The current pinion.
		 */
		protected transient T current;
		
		/**
		 * The next pinion.
		 */
		protected transient T next;
		
		/**
		 * {@link Hypergear} default class constructor,
		 * @param entity the spinning entity
		 */
		protected Hypergear(T entity) {
    		current = next = entity;
		}

		/**
		 * @return to the past
		 */
		protected T forward() {
    		T k = next;

    		if (k == null) {
    			if (current == null) {
    				throw new NoSuchElementException();
    			}
    		} 
    		else {
    			current = k;
    			next = k.getValue().get();
    		}
    		return k;
		}
		/**
		 * @return to the future
		 */
		protected T backward() {

    		T k = next;

    		if (k == null) {
    			if (current == null) {
    				throw new NoSuchElementException();
    			}
    		} 
    		else {
    			current = k;
    			next = k.getParent();
    		}
    		return k;
		}
		/**
		 * @return if we are the limit
		 */
		public boolean hasNext() {
    		return next != null;
		}
		/**
		 * @return if we are the limit
		 */
		public boolean hasMoreElements() {
    		return next != null;
		}
	}
	/**
	 * Check input object's existence.
	 * @param objects the objects to be checked
	 * @return <tt>true</tt> if all objects exists 
	 */
	protected static boolean exists(Object... objects) {
		
		for(Object obj : objects)
			if (obj == null)
				return false;
		return true;
	}
	/**
	 * {@link TimeListener} instantiation method #0.
	 * @param type the instantiated type
	 * @return the new X instance
	 */
	protected static <X> X instance(Class<X> type) {
		
		if (!exists(type))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor().newInstance();
		}
		catch(ClassCastException | 
				InstantiationException | 
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException | 
				NoSuchMethodException | 
			SecurityException e) {
			
			throw new Abort(e, null);
		}
	}
	/**
	 * {@link TimeListener} instantiation method #1.
	 * @param type the instantiated type
	 * @param arg the argument
	 * @return the new X instance
	 */
	protected static <X,Y> X instance(Class<X> type, Y arg) {
		
		if (!exists(type, arg))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor(arg.getClass()).
					newInstance(arg);
		}
		catch(ClassCastException | 
				InstantiationException | 
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException | 
				NoSuchMethodException | 
			SecurityException e) {
			
			throw new Abort(e);
		}
	}
	/**
	 * {@link TimeListener} instantiation method #2.
	 * @param type the instantiated type
	 * @param arg0 the argument #0
	 * @param arg1 the argument #1
	 * @return the new X instance
	 */
	protected static <X,Y,Z> X instance(Class<X> type, Y arg0, Z arg1) {
		
		if (!exists(type, arg0, arg1))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor(
					arg0.getClass(), arg1.getClass()).
							newInstance(arg0, arg1);
		}
		catch(ClassCastException | 
				InstantiationException | 
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException | 
				NoSuchMethodException | 
			SecurityException e) {
			
			throw new Abort(e);
		}
	}
	/**
	 * {@link TimeListener} instantiation method #3.
	 * @param type the instantiated type
	 * @param arg0 the argument #0
	 * @param arg1 the argument #1
	 * @param arg2 the argument #2
	 * @return the new X instance
	 */
	protected static <X,Y,Z,U> X instance(Class<X> type, Y arg0, Z arg1, U arg2) {
		
		if (!exists(type, arg0, arg1, arg2))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor
					(arg0.getClass(), arg1.getClass(), arg2.getClass()).
									newInstance(arg0, arg1, arg2);
		}
		catch(ClassCastException |
				InstantiationException |
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException |
				NoSuchMethodException |
			SecurityException e) {
			
			throw new Abort(e);
		}
	}
	/**
	 * {@link TimeListener} instantiation method #4.
	 * @param type the instantiated type
	 * @param arg0 the argument #0
	 * @param arg1 the argument #1
	 * @param parent the argument #2
	 * @param child the argument #3
	 * @return the new X instance
	 */
	protected static <X,Y,Z,U,V> X instance(Class<X> type, Y arg0, Z arg1, U parent, V child) {
		
		if (!exists(type, arg0, arg1, parent, child))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor
					(arg0.getClass(), arg1.getClass(), parent.getClass(), child.getClass()).
									newInstance(arg0, arg1, parent, child);
		}
		catch(ClassCastException |
				InstantiationException |
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException |
				NoSuchMethodException |
			SecurityException e) {
			
			throw new Abort(e);
		}
	}
	/**
	 * {@link TimeListener} instantiation method #5.
	 * @param type the instantiated type
	 * @param arg0 the argument #0
	 * @param arg1 the argument #1
	 * @param arg2 the argument #2
	 * @param arg3 the argument #3
	 * @return the new X instance
	 */
	protected static <X,Y,Z,U,V,W> X instance(Class<X> type, Y arg0, Z arg1, U arg2, V arg3, W arg4) {
		
		if (!exists(type, arg0, arg1, arg2, arg3, arg4))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor
					(arg0.getClass(), arg1.getClass(), arg2.getClass(), arg3.getClass(), arg4.getClass()).
									newInstance(arg0, arg1, arg2, arg3, arg4);
		}
		catch(ClassCastException |
				InstantiationException |
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException |
				NoSuchMethodException |
			SecurityException e) {
			
			throw new Abort(e);
		}
	}
	/**
	 * {@link TimeListener} instantiation method #5.
	 * @param type the instantiated type
	 * @param arg0 the argument #0
	 * @param arg1 the argument #1
	 * @param arg2 the argument #2
	 * @param arg3 the argument #3
	 * @return the new X instance
	 */
	protected static <X,Y,Z,U,V,W> X instance(Class<X> type, Y arg0, Z arg1, U arg2, V arg3, W arg4, Parity gen) {
		
		if (!exists(type, arg0, arg1, arg2, arg3, arg4))
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor
					(arg0.getClass(), arg1.getClass(), arg2.getClass(), arg3.getClass(), arg4.getClass(), Parity.class).
									newInstance(arg0, arg1, arg2, arg3, arg4, gen);
		}
		catch(ClassCastException |
				InstantiationException |
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException |
				NoSuchMethodException |
			SecurityException e) {
			
			throw new Abort(e);
		}
	}
	/**
	 * Returns a string representation of a {@link Character} array.
	 * @param array the {@link Character} array to be parsed
	 * @return a string representation of a {@link Character} array
	 */
	protected static String characterArrayToString(Character[] array) {
		StringBuilder builder = new StringBuilder();
		for(Character letter : array){
			builder.append(letter);
		}
		return builder.toString();
	}
	/**
	 * De-serializes to Object from given file
     * @param fileName the file name
	 * @return the de-serialized object
	 * @throws IOException when something is wrong
	 * @throws ClassNotFoundException when something is wrong
	 */
	protected static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
    /**
     * Serializes the given object and save it to file
     * @param obj the given object
     * @param fileName the file name
     * @throws IOException when something is wrong
     */
    protected static void serialize(Object obj, String fileName)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        fos.close();
    }
}