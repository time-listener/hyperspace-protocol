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
public class Root 
	extends Continuum<Tick,Tack,Root,Stem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4729574459407378347L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#getName()
	 */
	@Override
	public String getName() {
		return "root";
	}
	
	public Root() {
//		super(Root.class, null);
	}
	public Root(String[] message) {
//		super(Root.class, message);
	}
	public Root(Class<Stem> antitype, String[] message) {
		super(Root.class, antitype, message);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#set(org.xmlrobot.Continuum)
	 */
	@Override
	public Stem set(Stem value) {
	
		Stem oldStem = super.set(value);
		value.setTime(getTime().get());
		// listen child
//		getTime().addMassListener(value);
//		getTime().getValue().addMassListener(this);
		
		return oldStem;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Continuum#create(java.lang.String[])
	 */
	@Override
	public Tick create(String[] message) {
		
		// create parent
		Tick time = new Tick(Tack.class);
		
		for(String word : message){
			
			for(char letter : word.toCharArray()) {
				
				Character key = new Character(letter);
				Integer value = new Integer(letter*100);
				
				time.allocateValue(getParent(), new Flop(new Tack(Tick.class, value, key, time.get())) {
					/**
					 * s
					 */
					private static final long serialVersionUID = -7887589836208543149L;
				});
			}
		}
		return time;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#mass(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> void mass(MassListener source, Tachyon<X,Y> event) {
		super.mass(source, event);
		switch (event.getCommand()) {
		case GENESIS:
			if(event.get() instanceof Tick) {

				Tick result = (Tick) event.getSource();
				Tick child = new Tick(Tack.class, result.getPositive(), result.getNegative(), getTime()); 
				if(result.getParent() != null && result.get() != null) {
					getTime().orderValue(getParent(), new Flop(child.get()) {

						/**
						 * 
						 */
						private static final long serialVersionUID = -3973324937638386584L;
					});	
				}
				child.start(getContext());
			}
			break;
		case LISTEN:
			if(event.get() instanceof Tack) {

				if(!getTime().isFuture())
				getTime().get().pulse(this, (Instant) event);	
			}
			break;
		case TRANSFER:
			if(event.get() instanceof Tack) {
				Tack child = (Tack) event.getSource();
				child.clear(root());
				child.stop(getContext());
				child.start(getContext());
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
		// switch command: all your needs are my orders.
		if (event.getType() == ServiceEvent.REGISTERED) {
			// declare child
			Object child;
			// get entity
			if ((child = ref.getProperty(TimeListener.KEY)) != null) {
				// execute all times
				execute((Runnable) child);
			}
		}
	}

	public static void main(String[] message) {

		try {
			// create hyperexecutor
			new Root(Stem.class, message == null ?
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
	public int compare(Stem o1, Stem o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Root o) {
		// TODO Auto-generated method stub
		return 0;
	}




}
