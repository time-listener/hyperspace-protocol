package org.xmlrobot;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.time.Time;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Parity;

/**
 * The Continuum Q.
 * 
 * The Q Continuum is an extradimensional plane of existence inhabited 
 * by a race of beings known as the Q. 
 * 
 * As a race, the Q are immortal, omniscient, and omnipotent, possessing 
 * the ability of instantaneous matter-energy transformation and teleportation, 
 * as well as the ability of time travel. 
 * 
 * Their apparent abilities include moving entire asteroid belts and stars, 
 * creating alternate timelines, and affecting universal states of nature 
 * such as the gravitational constant. In fact, the only time a Q is seen 
 * as unable to do something is during a period where their powers are reduced 
 * or revoked by the Continuum. 
 * 
 * The Q claim to have always existed, with no explanation as to how they first 
 * came into existence. Based on descriptions by numerous Q, including the Q later 
 * known as Quinn, as well as Amanda Rogers, the Q Continuum is a highly ordered 
 * society, but is also the result of <tt>eons</tt> of evolutionary stagnation.
 * 
 * The Q Continuum is also {@link Time} and all that became inherited.
 * 
 * @author joan
 * @since 0
 * 
 * @param <K> is the key
 * @param <V> is the value
 * @param <T> is the type
 * @param <U> is the antitype
 */
@XmlTransient
public abstract class Continuum
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>,
	 	T extends Continuum<K,V,T,U>,
	 	U extends Continuum<V,K,U,T>>
			extends Time<T,U> {

	/**
	 * -6900494353672148882L
	 */
	private static final long serialVersionUID = -6900494353672148882L;
	
	/**
	 * The <tt>continuum framework</tt>.
	 */
	private Framework framework;
	
	/**
	 * The <tt>universal genoma chain</tt>.
	 */
	private final String[] message;
	
	/**
	 * Reveals the <tt>universal genoma chain</tt>.
	 * @return the <tt>universal genoma chain</tt>
	 */
	public String[] getMessage() {
		return message;
	}
	/**
	 * Reveals the <tt>continuum framework</tt>.
	 * @return the <tt>continuum framework</tt>
	 */
	@XmlTransient
	public Framework getFramework() {
		return framework;
	}
	/**
	 * Establishes the <tt>continuum framework</tt>
	 * @param framework {@link Framework} the <tt>continuum framework</tt> to be established
	 */
	public void setFramework(Framework framework) {
		// check existence
		if(framework != null) {
			// listen everything
			framework.getBundleContext().addServiceListener(this);
			// assign
			this.framework = framework;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getContext()
	 */
	@Override
	@XmlTransient
	public BundleContext getContext() {
		return framework.getBundleContext();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getRunner()
	 */
	@Override
	@XmlTransient
	public Thread getRunner() {
		return Thread.currentThread();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	public abstract String getName();
	
	/**
	 * Continuum Q default class constructor.
	 */
	public Continuum() {
		super();
		this.message = new String[] { 
				// the ABC
				"A", "B", "C", "D", "E", "F", "G", "H", "I", 
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", 
				"S", "T", "U", "V", "w", "X", "Y", "Z", "Ñ", "Ç" };
	}
	/**
	 * Q Continuum class constructor.
	 * @param type the type
	 */
	public Continuum(Class<? extends T> type, String[] message) {
		super(type, Parity.YY);
		// inherit message
		this.message = message;
		// try
		try {
			// create hyperspace
			Framework framework = Genoma.createFramework();
			// initialize hyperspace
			framework.init();
			// start hyperspace
			framework.start();
			// set the framework
			setFramework(framework);
		}
		// catch
		catch (BundleException e) {
			// throw new abort
			throw new Abort(e);
		}
	}
	/**
	 * Continuum Q class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 */
	public Continuum(Class<? extends T> type, Class<? extends U> antitype, String[] message) {
		// call hyperconstructor
		super(type, instance(antitype, message), Parity.YY);
		// inherit message
		this.message = message;
		// bong
		create(message).start(getContext());
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Inheritance#clone()
	 */
	@Override
	public TimeListener<T,U> clone() {
		return super.clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#set(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void set(U value) {
		// unify
		super.set(value);
		// check existence
		if(value != null) {
			// unify frameworks
			value.setFramework(framework);
			// big
			create(message).start(framework.getBundleContext());
		}
		else throw new Abort();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(T o1, T o2) {
		return o1.getFramework().compareTo(o2.getFramework());
	}
	/**
	 * Orders current instance to create.
	 * @return the current instance creation
	 */
	public abstract K create(String[] message);

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public abstract void serviceChanged(ServiceEvent event);
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#matrix()
	 */
	@Override
	public TimeListener.Transmitter<T,U> matrix() {
 		TimeListener.Transmitter<T,U> m;
 		return (m = matrix) != null ? m : (matrix = new Computer());
	}
	/**
	 * Quantum bionical computer implementation class.
	 * @author joan
	 *
	 */
	protected class Computer
		extends Comparator {
		
		/**
		 * 
		 */
		public Computer() {
			super(instance(getAntitype(), getType()));
		}
	}
	
	/**
	 * The <tt>universal genoma methods</tt>
	 * @author joan
	 */
	public static class Genoma {

		Genoma() {	}
	    /**
	     * Util method for creating an embedded Framework. Tries to create a
	     * {@link FrameworkFactory} which is then be used to create the framework.
	     *
	     * @param config the configuration to create the framework with
	     * @return a Framework with the given configuration
	     */
	    public static Framework createFramework() {
	    	
	        Map<String,String> config = createConfig();
	        
	        ServiceLoader<FrameworkFactory> factoryLoader = ServiceLoader.load(FrameworkFactory.class);
	        for(FrameworkFactory factory : factoryLoader)
	        {
	            return factory.newFramework(config);
	        }
	        throw new IllegalStateException("Unable to load FrameworkFactory service.");
	    }
	    /**
	     * Creates a configuration for Aaron. Therefore this method attempts to create
	     * a temporary cache dir. If creation of the cache dir is successful, it will be added
	     * to the configuration.
	     *
	     * @return
	     */
	    public static Map<String,String> createConfig() {
	    	
	        final File cachedir = createCacheDir();

	        Map<String,String> configMap = new HashMap<String, String>();
	        // Tells Aaron to export the extension package, making it accessible
	        // for the other mind bundles
	        configMap.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA,
	            "org.xmlrobot.genesis; version=1.0.0");

	        // if we could create a cache dir, we use it. Otherwise the platform default will be used
	        if (cachedir != null)
	        {
	            configMap.put(Constants.FRAMEWORK_STORAGE, cachedir.getAbsolutePath());
	        }

	        return configMap;
	    }
	    /**
	     * Tries to create a temporary cache dir. If creation of the cache dir is successful,
	     * it will be returned. If creation fails, null will be returned.
	     *
	     * @return a {@code File} object representing the cache dir
	     */
	    public static File createCacheDir() {
	    	
	        final File cachedir;
	        try
	        {
	            cachedir = File.createTempFile("org.xmlrobot.temporal", null);
	            cachedir.delete();
	            createBurnHook(cachedir);
	            return cachedir;
	        }
	        catch (IOException e)
	        {
	            // temp dir creation failed, return null
	            return null;
	        }
	    }
	    /**
	     * Adds a burn  hook to the runtime, that will make sure, that the cache dir will
	     * be burned after the application has been terminated.
	     */
	    public static void createBurnHook(final File cachedir) {
	    	
	        Runtime.getRuntime().addShutdownHook(new Thread()
	        {
	            @Override
	            public void run()
	            {
	                burnFileOrDir(cachedir);
	            }
	        });
	    }
	    /**
	     * Utility method used to burn the profile directory when run as
	     * a stand-alone application.
	     * @param file The file to recursively delete.
	    **/
	    public static void burnFileOrDir(File file) {
	    	
	        if (file.isDirectory())
	        {
	            File[] childs = file.listFiles();
	            for (File child : childs)
	            {
	                burnFileOrDir(child);
	            }
	        }
	        file.delete();
	    }
	    /**
	     * Installs and starts all bundles used by the application. Therefore the host bundle
	     * will be started. The locations of extensions for the host bundle can be passed in
	     * as parameters.
	     * @param bundleLocations the locations where extension for the host bundle are located.
	     *        Must not be {@code null}!
	     * @throws BundleException if something went wrong while installing or starting the bundles.
	     */
	    public static void installAndStartBundles(BundleContext context, String... bundleLocations) 
	    		throws BundleException {
	        for (String location : bundleLocations)
	        {
	            Bundle addition = context.installBundle(location);
	            addition.start();
	        }
	    }
	}
}