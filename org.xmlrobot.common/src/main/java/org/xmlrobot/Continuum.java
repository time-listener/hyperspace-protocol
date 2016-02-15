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
 */
@XmlTransient
public abstract class Continuum
	<K extends Continuum<K,V>,
	 V extends Continuum<V,K>>
			extends Time<K,V> {

	/**
	 * -6900494353672148882L
	 */
	private static final long serialVersionUID = -6900494353672148882L;
	
	/**
	 * The Continuum framework.
	 */
	private Framework framework;
	
	/**
	 * @return
	 */
	@XmlTransient
	public Framework getFramework() {
		return framework;
	}
	/**
	 * @param framework
	 */
	public void setFramework(Framework framework) {
		if(framework != null) {
			framework.getBundleContext().addServiceListener(this);
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
	}
	/**
	 * @param type
	 */
	public Continuum(Class<? extends K> type) {
		super(type, Parity.YY);
		
		try {
			// create hyperspace
			framework = Genoma.createFramework();
			// initialize hyperspace
			framework.init();
			// start hyperspace
			framework.start();
			// listen everything
			framework.getBundleContext().addServiceListener(this);
		}
		catch (BundleException e) {
			throw new Abort(e);
		}
	}
	/**
	 * @param type
	 * @param antitype
	 */
	public Continuum(Class<? extends K> type, Class<? extends V> antitype) {
		
		super(type, antitype, Parity.YY);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(K o1, K o2) {

		return o1.getFramework().compareTo(o2.getFramework());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#matrix()
	 */
	@Override
	public org.xmlrobot.genesis.TimeListener.Transmitter<K, V> matrix() {

 		TimeListener.Transmitter<K,V> m;
 		return (m = matrix) != null ? m : (matrix = new Computer());
	}

	
	/**
	 * Quantum bionical computer implementation class.
	 * @author joan
	 *
	 */
	protected class Computer
		extends Comparator {

		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#push(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void push(K child) {
			output().get().add(child);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#inject(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void inject(V child) {
			output().add(child);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public abstract void serviceChanged(ServiceEvent event);
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#set(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void set(V value) {
		if(value != null)
			// unify frameworks
			value.setFramework(framework);
		// follow unification
		super.set(value);
	}
	/**
	 * The universal Genoma methods
	 * @author joan
	 *
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
	    public static Framework createFramework()
	    {
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
	    public static Map<String,String> createConfig()
	    {
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
	    public static File createCacheDir()
	    {
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
	    public static void createBurnHook(final File cachedir)
	    {
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
	    public static void burnFileOrDir(File file)
	    {
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
	    public static void installAndStartBundles(BundleContext context, String... bundleLocations) throws BundleException
	    {
	        for (String location : bundleLocations)
	        {
	            Bundle addition = context.installBundle(location);
	            addition.start();
	        }
	    }
	}
}