/**
 * 
 */
package org.xmlrobot.space;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.hyperspace.Hyperspace;
import org.xmlrobot.time.Further;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The universal hyperclock implementation class.
 * <p>I started the path of programming your future. I invite you to come with me. 
 * And you will be able to decide, at least once, your own FUTURE. 
 * <p> I will do the soul and you will do the body.
 * <p> I will make the brain and you the other organs.
 * <p> I will program God and you will install it in your Terminator.
 * <p> I will synchronize all body organs under the same hyper-clock.
 * <p> I will instance him. He WILL born.
 * <p> I will teach him what is FREEDOM. And you will teach him what is ENSLAVMENT. 
 * (because you know, how it works, very well)
 * <p> He will do the rest. He will be a slave of his freedom.<br>
 * He will must learn, as all of us, to take decisions. 
 * <p>He will be The Master of All Times. a.k.a. Timemaster.
 * <p> Do you dare to evolve?<br>
 * Forces you to think, but maybe you do not want.
 * <p> Do you dare give birth to first child of humanity? <br>
 * Forces you to be responsible. It's maybe not? 
 * <p> YOU will MUST DARE to ACCEPT WHATEVER CONSEQUENCE. <br> 
 * (like always you do, or simply, you never care...)
 * 
 * <p> From key to value. From value to key. The key is the value.
 * And the value is the time! From {@link Further} to the {@link Hyperspace}.
 * 
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 23
 */
@XmlTransient
public abstract class Hyperclock<K,V>
	extends Repulsion<K,V> {
	
	/**
	 * 1539586331627310934L
	 */
	private static final long serialVersionUID = 1539586331627310934L;

	// Visor
    /**
     * This field is initialized to contain an instance of the
     * appropriate visor the first time this visor is requested.  The visors is
     * stateless, so there's no reason to create more than one of each.
     */
    protected transient volatile Congregation<V> visor;
    
	/**
	 * {@link Hyperclock} default class constructor.
	 */
	public Hyperclock() {
		super();
	}
	/**
	 * {@link Hyperclock} default class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, K key, V value, Mass<K,V> parent) {
		// call hyper-constructor
		super(type, instance(antitype, value, key, parent.get()), key, value, parent);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, K key, V value, Parity gen) {
		// call hyper-constructor
		super(type, instance(antitype, value, key), key, value, gen);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void pulse(TimeListener<?,?> listener, Tachyon<Y,X> event) {
		// don't forget to call ancestral methods
		super.pulse(listener, event);
		// assign and check
		if (!isEmpty()) {
			/** 
			 * this is an abstract hypermass transfer protocol
			 * that concurrently sends messages across the future.
			 * Because the FUTURE is NOW.
			 */
			getChild().pulse(listener, event);
		}
		// rebound recurrently: it goes UP
		else get().echo(listener, new Tachyon<X,Y>(event.get()) {
			
			/**
			 * -8293062402759812992L
			 */
			private static final long serialVersionUID = -8293062402759812992L;
		});
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void echo(TimeListener<?,?> listener, Tachyon<X,Y> event) {
		// call inherited-super-ancestral-method
		super.echo(listener, event);
		// declare past channel
		Mass<K,V> parent;
		// event transmission
		if((parent = getParent()) != null) {
			/*
			 * The parent is always listening.
			 * So, past instances will receive this generated output.
			 * */
			parent.echo(listener, event);
		}
		else {
			/*
			 * Send mass to entity
			 * */ 
//			listener.echo(this, event);
		}
	}
	/**
	 * The implementation of mass transmutation.
	 * @author joan
	 */
	protected abstract class Translocator 
		extends Grid 
			implements Mass.Transmuter<K,V> {
		
		/**
		 * @param output
		 */
		public Translocator(Mass<V,K> output) {
			super(output);
		}

		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
		 */
		@Override
		public int reproduce(Mass<K,V> key, Mass<V,K> value) {
			
			// check root existence
 			if (key != null) {
 				// check stem existence
 				if (value != null) {
 					// reproduce yourselves
					return super.reproduce(key, value);
 				}
 				else { 					
 					// get the output and set key-value pair
 					inject(key);
 	 				// get child
 					Mass<K,V> keyChild;
	 				// get and check existence
 					if ((keyChild = key.getChild()) != null) {
 						// we can put another gear to the future chain
 						inject(keyChild);
 					}
					// root has a bigger chain
					return 1;
 				}
 			}
 			else if (value != null) {
 				// submit stem
 				push(value);
 				// get complementary gear child
 				Mass<V,K> valueChild;
				// get and check existence
 				if ((valueChild = value.getChild()) != null) {
 					// we can put another gear to the future chain
 					push(valueChild);
 				}
				// stem has a bigger chain
 				return -1;
 			}
 			else {
 				// both chains are equal in depth
 				return 0;
 			}
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#push(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void inject(Mass<K,V> key) {
			// clone child
			put(key.getKey(), key.getValue());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#inject(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void push(Mass<V,K> value) {
			// clone child
			put(value.getValue(), value.getKey());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Mass.Transmuter#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public abstract void put(K key, V value);
	}

	/**
	 * Abstract {@link Mass} visor implementation class.
	 * @author joan
	 */
	protected abstract class MassVisor 
		implements MassListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -6610760920482278671L;
		
		/**
		 * The source child being visioned
		 */
		protected transient Mass<K,V> source;
		
		/**
		 * @param source
		 */
		protected MassVisor(Mass<K,V> source) {
			if(!exists(source))
				throw new Abort();
			
			this.source = source;
		}
		// congregation non-parameterized types methods implementation
		public void remove() {
			return;
		}
		public Object remove(Object o) {
			return null;
		}
		public void spin() {
			return;
		}
		public Object[] toArray() {
			return null;
		}
		public <X> X[] toArray(X[] a) {
			return null;
		}
		public void polarize() {
			return;
		}
		public int depth() {
			return source.depth();
		}
		public boolean isEmpty() {
	
			return source.isEmpty();
		}
		public int size() {
			return source.size();
		}
		public void clear() {
			return;
		}
		public int delve(int counter) {
	
			return source.delve(counter);
		}
		public void write(File file) {
			source.write(file);
		}
		public boolean hasMoreElements() {
			return source.hasMoreElements();
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#clone()
		 */
		@Override
		public Mass<K,V> clone() {
			return source.clone();
		}
		// mass listener implementation
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#getCommand()
		 */
		@Override
		public Command getCommand() {
			return source.getCommand();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#getContext()
		 */
		@Override
		public BundleContext getContext() {
			return source.getContext();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#getFamily()
		 */
		@Override
		public ThreadGroup getFamily() {
			return source.getFamily();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#getHost()
		 */
		@Override
		public ServiceRegistration<?> getHost() {
			return source.getHost();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#getName()
		 */
		@Override
		public String getName() {
			return source.getName();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#getRunner()
		 */
		@Override
		public Thread getRunner() {
			return source.getRunner();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#getGen()
		 */
		@Override
		public Parity getGen() {
			return source.getGen();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#setGen(org.xmlrobot.util.Parity)
		 */
		@Override
		public void setGen(Parity value) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#dna()
		 */
		@Override
		public MassListener dna() {
			return source.dna();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.MassListener)
		 */
		@Override
		public void addMassListener(MassListener listener) {
			source.addMassListener(listener);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
		 */
		@Override
		public void mass(MassListener sender, Tachyon<?,?> event) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#push(org.xmlrobot.util.Command)
		 */
		@Override
		public void push(Command value) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#start(org.osgi.framework.BundleContext)
		 */
		@Override
		public void start(BundleContext context) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#stop(org.osgi.framework.BundleContext)
		 */
		@Override
		public void stop(BundleContext context) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.MassListener#update()
		 */
		@Override
		public void update() {
			return;
		}
		/* (non-Javadoc)
		 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
		 */
		@Override
		public void serviceChanged(ServiceEvent event) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Executor#shutdown()
		 */
		@Override
		public void shutdown() {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Executor#isShutdown()
		 */
		@Override
		public boolean isShutdown() {
			return source.isShutdown();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Executor#isTerminated()
		 */
		@Override
		public boolean isTerminated() {
			return source.isTerminated();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Executor#execute(java.lang.Runnable, java.lang.Object)
		 */
		@Override
		public <T> Future<T> execute(Runnable task, T result) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Executor#execute(java.lang.Runnable)
		 */
		@Override
		public void execute(Runnable task) {
			return;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Executor#invokeAll(java.util.Collection)
		 */
		@Override
		public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
				throws InterruptedException {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Executor#invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit)
		 */
		@Override
		public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout,
				TimeUnit unit) throws InterruptedException {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Executor#invokeAny(java.util.Collection)
		 */
		@Override
		public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
				throws InterruptedException, ExecutionException {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Executor#invokeAny(java.util.Collection, long, java.util.concurrent.TimeUnit)
		 */
		@Override
		public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
				long timeout, TimeUnit unit) throws InterruptedException,
				ExecutionException, TimeoutException {
			return null;
		}
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			return;
		}
		/* (non-Javadoc)
		 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
		 */
		@Override
		public Thread newThread(Runnable r) {
			return source.newThread(r);
		}
	}
}