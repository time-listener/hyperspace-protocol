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
public class Tack 
	extends Time<Tack,Tick> {

	/**
	 * -7008477909865434076L
	 */
	private static final long serialVersionUID = -7008477909865434076L;

	Integer key;
	Character value;

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#getName()
	 */
	@Override
	@XmlElement
	public String getName() {
		return get().toString();
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getKey()
	 */
	@XmlElement
	public Integer getPositive() {
		return key != null ? key : !isFuture() ? get().getNegative() : null; 
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Par#setKey(java.lang.Object)
	 */
	public Integer setPositive(Integer key) {
		Integer oldKey = this.key;
		this.key = key; 
		return oldKey;
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#getValue()
	 */
	@XmlElement
	public Character getNegative() {
		return value != null ? value : !isFuture() ? get().getPositive() : null; 
	}
	/* (non-Javadoc)
	 * @see java.util.Map.Entry#setValue(java.lang.Object)
	 */
	public Character setNegative(Character value) {
		Character oldValue = this.value;
		this.value = value; 
		return oldValue;
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Inheritance#getChild()
	 */
	@Override
	@XmlElement
	public Tick get() {
		return super.get();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Inheritance#setChild(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public Tick set(Tick listener) {
		return super.set(listener);
	}
	
	public Tack() {
		super(Tack.class, Parity.YY);
		this.key = null;
		this.value = null;
	}
	public Tack(Class<Tick> antitype) {
		super(Tack.class, instance(antitype), Parity.YY);
		this.key = null;
		this.value = null;
	}
	public Tack(Integer key, Character value, Tack parent, Tick child) {
		super(Tack.class, parent, child);
		this.key = key;
		this.value = value;
	}
	public Tack(Class<Tick> antitype, Integer key, Character value, Tack parent) {
//		super(Tack.class, instance(antitype, value, key, parent.getValue()), parent);
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
			System.out.print(getName());
			Thread.sleep(getPositive().longValue());
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
	public TimeListener.Transmitter<Tack,Tick> matrix() {
		TimeListener.Transmitter<Tack,Tick> m;
		return (m = matrix) != null ? m : (matrix = new Screw());
	}
	
	/**
	 * @author joan
	 *
	 */
	protected class Screw extends Comparator {

		/**
		 * @param output
		 */
		public Screw() {
			super(new Tick(Tack.class));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#reproduce(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public int reproduce(Tack key, Tick value) {
			int cmp = super.reproduce(key, value);

			if(cmp < 0) {
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
	public int compare(Tick o1, Tick o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Tack o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
