/**
 * 
 */
package org.xmlrobot.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.TimeListener;
import org.xmlrobot.time.Time;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Tick 
	extends Time<Tick,Tack> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1092138440838422399L;
	
	Character key; 
	Integer value;

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	@XmlElement
	public String getName() {
		return getParent().toString();
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getKey()
	 */
	@XmlElement
	public Character getPositive() {
		return key != null ? key : !isFuture() ? get().getNegative() : null; 
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Par#setKey(java.lang.Object)
	 */
	public Character setPositive(Character key) {
		Character oldKey = this.key;
		this.key = key; 
		return oldKey;
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getValue()
	 */
	@XmlElement
	public Integer getNegative() {
		return value != null ? value : !isFuture() ? get().getPositive() : null; 
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#setValue(java.lang.Object)
	 */
	public Integer setNegative(Integer value) {
		Integer oldValue = this.value;
		this.value = value; 
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Inheritance#getChild()
	 */
	@Override
	@XmlElement
	public Tack get() {
		return super.get();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Inheritance#setChild(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tack set(Tack listener) {
		return super.set(listener);
	}
	
	public Tick() {
		super(Tick.class, Parity.YY);
		this.key = null;
		this.value = null;
	}
	public Tick(Character key, Integer value, Tick parent, Tack child) {
		super(Tick.class, parent, child);
		this.key = key;
		this.value = value;
	}
	public Tick(Class<Tack> antitype) {
		super(Tick.class, instance(antitype), Parity.YY);
		this.key = null;
		this.value = null;
	}
	public Tick(Class<Tack> antitype, Character key, Integer value, Tick parent) {
//		super(Tick.class, instance(antitype, value, key, parent.getValue()), parent);
		this.key = key;
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Metaphysical#run()
	 */
	@Override
	public void run() {
		System.out.print(getName());
		super.run();
		try {
			Thread.sleep(getNegative().longValue());
		}
		catch (InterruptedException e) {
			setCommand(Command.INTERRUPTED);
		}
		finally {
			setCommand(Command.TRANSFER);
		}
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		return;
	}


	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#matrix()
	 */
	@Override
	public org.xmlrobot.TimeListener.Transmitter<Tick,Tack> matrix() {
		TimeListener.Transmitter<Tick,Tack> m;
		return (m = matrix) != null ? m : (matrix = new ScrewNut());
	}
	
	/**
	 * @author joan
	 *
	 */
	public class ScrewNut extends Comparator {
		
		/**
		 * 
		 */
		public ScrewNut() {
			super(new Tack(Tick.class));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#reproduce(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public int reproduce(Tick key, Tack value) {

			int cmp = super.reproduce(key, value);
			if(cmp > 0) {
				output.setPositive(value.getPositive());
				output.setNegative(value.getNegative());
				return -1;
			}
			else if(cmp == 0) {
				output.setPositive(key.getNegative());
				output.setNegative(key.getPositive());
				// twin output par
				push(value);
				return 0;
			}
			else {
				output.setPositive(key.getNegative());
				output.setNegative(key.getPositive());
				return 1;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Tack o1, Tack o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Tick o) {
		// TODO Auto-generated method stub
		return 0;
	}
}