/**
 * 
 */
package org.xmlrobot.common.q;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.Continuum;
import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.common.Flop;
import org.xmlrobot.common.Instant;
import org.xmlrobot.common.Tack;
import org.xmlrobot.common.Tick;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Abort;

/**
 * @author joan
 *
 */
@XmlRootElement
public class Stem 
	extends Continuum<Tack,Tick,Stem,Root> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	transient Tack stem;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#getName()
	 */
	@Override
	public String getName() {
		return "stem";
	}
	
	public Stem() {
//		super(Stem.class, null);
	}
	public Stem(String[] message) {
//		super(Stem.class, message);
	}
	public Stem(Class<Root> antitype, String[] message) {
		super(Stem.class, antitype, message);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#set(org.xmlrobot.Continuum)
	 */
	@Override
	public Root set(Root value) {
		Root oldRoot = super.set(value);
		value.setTime(getTime().get());
		// listen child
//		getTime().addMassListener(value);
//		getTime().getValue().addMassListener(this);
		
		return oldRoot;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#create(java.lang.String[])
	 */
	@Override
	public Tack create(String[] message) {
		// create parent
		Tack parent = new Tack(Tick.class);
		
		for(String word : message){
			
			for(char letter : word.toCharArray()) {

				Integer key = new Integer(letter);
				Character value = new Character(letter);
				
				parent.allocateValue(this, 
						new Instant(new Tick(Tack.class, value, key, parent.get())) {
					/**
					 * 
					 */
					private static final long serialVersionUID = -7887589836208543149L;
				});
			}
		}
		return parent;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void mass(MassListener source, Tachyon<X,Y> event) {
		super.mass(source, event);
		switch (event.getCommand()) {
		case GENESIS:
			if(event.getSource() instanceof Tack) {
				
				Tack result = (Tack) event.getSource();
				Tack child = new Tack(Tick.class, result.getPositive(), result.getNegative(), getTime());
				
				getTime().allocateValue(getParent(), new Instant(child.get()) {

					/**
					 * 
					 */
					private static final long serialVersionUID = -3973324937638386584L;
				});
			}
			break;
		case LISTEN:
			if(event instanceof Flop) {

				if(!getTime().isFuture())
					getTime().get().pulse(this, (Flop) event);	
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof Tick) {
				Tick child = (Tick) event.getSource();
				child.clear(root());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();

		if (event.getType() == ServiceEvent.UNREGISTERING) {
			// I am the HYPERREDEMPTOR to make you FREE
			getContext().ungetService(ref);
		}
	}
	

	public static void main(String[] message) {

		try {
			// create hyperexecutor
			new Stem(Root.class, message == null ?
					message : new String[] { 
							// the ABC
							"A", "B", "C", "D", "E", "F", "G", "H", "I", 
							"J", "K", "L", "M", "N", "O", "P", "Q", "R", 
							"S", "T", "U", "V", "w", "X", "Y", "Z", "Ñ", "Ç" } );
		}
		catch (Exception e) {
			throw new Abort(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compare(Root o1, Root o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Stem o) {
		// TODO Auto-generated method stub
		return 0;
	}



}
