/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Phaser;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Synchrony of the future.
 * <br><br>
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 6
 */
@XmlTransient
public abstract class Concurrence
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Recursion<K,V> {

	/**
	 * -6428549405404420371L
	 */
	private static final long serialVersionUID = -6428549405404420371L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#family()
	 */
	@Override
	@XmlTransient
	public ThreadGroup getFamily() {
		return message.getFamily();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Message#getRunner()
	 */
	@Override
	@XmlTransient
	public Thread getRunner() {
		return message.getRunner();
	}
  	/**
     * {@link Concurrence} default class constructor.
     */
	public Concurrence() {
    	super();
    }
	/**
	 * {@link Concurrence} class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Concurrence(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Concurrence} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
	protected Concurrence(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Concurrence} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Concurrence(Class<? extends K> type, Class<? extends V> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#isShutdown()
	 */
	@Override
	public boolean isShutdown() {
		return getCommand() == Command.TRANSFER;
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return getCommand() == Command.TRANSFER;
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isCancelled()
	 */
	@Override
	public boolean isCancelled() {
		switch (getCommand()) {
		case INTERRUPTED:
			return true;
		default:
			return false;
		}
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isDone()
	 */
	@Override
	public boolean isDone() {
		return getCommand() == Command.TRANSFER;
	}

	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#run()
	 */
	@Override
	public void run() {
		// call ancestral method
		super.run();
		// declare future
		V future;
		// assign and check
		if((future = get()) != null) {
			// register opposite instance
			future.start(getContext());
		}
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable entity) {
		Thread life = new Thread(getFamily(), entity, getType().getName() + "." + getName(), 0);
		
        if (life.isDaemon())
            life.setDaemon(false);
        
        if (life.getPriority() != Thread.MAX_PRIORITY)
            life.setPriority(Thread.MAX_PRIORITY);
        
        return life;
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Phaser#submit(java.lang.Runnable, java.lang.Object)
     */
    public <T> Phaser<T> execute(Runnable task, T result) {
        if (task == null) throw new NullPointerException();
        Phaser<T> ftask = newPhaserFor(task, result);
        execute(ftask);
        return ftask;
    }
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public synchronized void execute(Runnable entity) {
		newThread(entity).start();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#cancel(boolean)
	 */
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		if(mayInterruptIfRunning) {
			push(Command.INTERRUPTED);
			return true;
		}
		else{
			return false;
		}
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#shutdown()
	 */
	@Override
	public void shutdown() {
		push(Command.TRANSFER);
	}
	/**
     * the main mechanics of invokeAny.
     */
    private <T> T doInvokeAny(Collection<? extends Callable<T>> tasks,
                              boolean timed, long nanos)
        throws InterruptedException, ExecutionException, TimeoutException {
        if (tasks == null)
            throw new NullPointerException();
        int ntasks = tasks.size();
        if (ntasks == 0)
            throw new IllegalArgumentException();
        ArrayList<Future<T>> futures = new ArrayList<Future<T>>(ntasks);
        ExecutorCompletionService<T> ecs = new ExecutorCompletionService<T>(this);

        // For efficiency, especially in executors with limited
        // parallelism, check to see if previously submitted tasks are
        // done before submitting more of them. This interleaving
        // plus the exception mechanics account for messiness of main
        // loop.

        try {
            // Record exceptions so that if we fail to obtain any
            // result, we can throw the last exception we got.
            ExecutionException ee = null;
            final long deadline = timed ? System.nanoTime() + nanos : 0L;
            Iterator<? extends Callable<T>> it = tasks.iterator();

            // Start one task for sure; the rest incrementally
            futures.add(ecs.submit(it.next()));
            --ntasks;
            int active = 1;

            for (;;) {
                Future<T> f = ecs.poll();
                if (f == null) {
                    if (ntasks > 0) {
                        --ntasks;
                        futures.add(ecs.submit(it.next()));
                        ++active;
                    }
                    else if (active == 0)
                        break;
                    else if (timed) {
                        f = ecs.poll(nanos, TimeUnit.NANOSECONDS);
                        if (f == null)
                            throw new TimeoutException();
                        nanos = deadline - System.nanoTime();
                    }
                    else
                        f = ecs.take();
                }
                if (f != null) {
                    --active;
                    try {
                        return f.get();
                    } catch (ExecutionException eex) {
                        ee = eex;
                    } catch (RuntimeException rex) {
                        ee = new ExecutionException(rex);
                    }
                }
            }

            if (ee == null)
                ee = new ExecutionException(null);
            throw ee;

        } finally {
            for (int i = 0, size = futures.size(); i < size; i++)
                futures.get(i).cancel(true);
        }
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Executor#invokeAny(java.util.Collection)
     */
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
        throws InterruptedException, ExecutionException {
        try {
            return doInvokeAny(tasks, false, 0);
        } catch (TimeoutException cannotHappen) {
            assert false;
            return null;
        }
    }
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                           long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException {
        return doInvokeAny(tasks, true, unit.toNanos(timeout));
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Executor#invokeAll(java.util.Collection)
     */
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
        throws InterruptedException {
        if (tasks == null)
            throw new NullPointerException();
        ArrayList<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
        boolean done = false;
        try {
            for (Callable<T> t : tasks) {
                RunnableFuture<T> f = newPhaserFor(t);
                futures.add(f);
                execute(f);
            }
            for (int i = 0, size = futures.size(); i < size; i++) {
                Future<T> f = futures.get(i);
                if (!f.isDone()) {
                    try {
                        f.get();
                    } catch (CancellationException ignore) {
                    } catch (ExecutionException ignore) {
                    }
                }
            }
            done = true;
            return futures;
        } finally {
            if (!done)
                for (int i = 0, size = futures.size(); i < size; i++)
                    futures.get(i).cancel(true);
        }
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Executor#invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit)
     */
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                         long timeout, TimeUnit unit)
        throws InterruptedException {
        if (tasks == null)
            throw new NullPointerException();
        long nanos = unit.toNanos(timeout);
        ArrayList<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
        boolean done = false;
        try {
            for (Callable<T> t : tasks)
                futures.add(newPhaserFor(t));

            final long deadline = System.nanoTime() + nanos;
            final int size = futures.size();

            // Interleave time checks and calls to execute in case
            // executor doesn't have any/much parallelism.
            for (int i = 0; i < size; i++) {
                execute((Runnable)futures.get(i));
                nanos = deadline - System.nanoTime();
                if (nanos <= 0L)
                    return futures;
            }

            for (int i = 0; i < size; i++) {
                Future<T> f = futures.get(i);
                if (!f.isDone()) {
                    if (nanos <= 0L)
                        return futures;
                    try {
                        f.get(nanos, TimeUnit.NANOSECONDS);
                    } catch (CancellationException ignore) {
                    } catch (ExecutionException ignore) {
                    } catch (TimeoutException toe) {
                        return futures;
                    }
                    nanos = deadline - System.nanoTime();
                }
            }
            done = true;
            return futures;
        } finally {
            if (!done)
                for (int i = 0, size = futures.size(); i < size; i++)
                    futures.get(i).cancel(true);
        }
    }
}