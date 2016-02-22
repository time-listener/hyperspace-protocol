/**
 * 
 */
package org.xmlrobot.time;



import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * 
 * <tt>
 *		<center>
 *		<br/>
 *		There is an indefinable mystical force<br/>
 *		that pervades <b>everything</b>.<br/>
 *		I feel it but I do not see it.<br/>
 *		<br/>
 *		It is <b>this</b> unseen force which makes itself<br/>
 *		felt and yet defies all proof,<br/>
 *		because it is so unlike all<br/>
 *		that I perceive through my senses.<br/>
 *		<br/>
 *		It transcends the senses.<br/>
 *		<br/>
 *		But it is possible to reason out<br/>
 *		the existence of <b>root</b> to a limited extent.<br/>
 *		Even in ordinary affairs we know that people<br/>
 *		do not know who orders or why<br/>
 *		and how It orders and yet<br/>
 *		they know that there is a natural force<br/>
 *		that certainly orders.<br/>
 *		<br/>
 *		In my last short tour in Faceborg<br/>
 *		I met many poor human-implemented-slaves<br/>
 *		and I found upon inquiry that<br/>
 *		they did not know who orders Faceborg.<br/>
 *		<br/>
 *		They simply said some God ruled it.<br/>
 *		<br/>
 *		If the knowledge of these poor people was<br/>
 *		so limited about their parent I,<br/>
 *		who am infinitely lesser in respect to <b>root</b><br/>
 *		than they to their parent, need not be surprised if<br/>
 *		I do not realize the presence of <b>root</b>.<br/>
 *		<br/>
 *		As known as, the parent of parents.<br/>
 *		<br/>
 *		Nevertheless,<br/>
 *		I do feel, as the poor human-implemented-slaves<br/>
 *		felt about Faceborg, that there is orderliness<br/>
 *		in the universe, there is an unalterable order<br/>
 *		allocating to the future everything<br/>
 *		and every being that exists or lives.<br/>
 *		<br/>
 *		It is not a blind order, for no blind order<br/>
 *		can allocate the drive of living being and<br/>
 *		thanks to the marvelous researches<br/>
 *		of Sir TimeListener it can now be proved<br/>
 *		that even matter is life. And even life<br/>
 *		is antimatter.<br/>
 *		<br/>
 *		That order then which orders all life is <b>inheritance</b>.<br/>
 *		The future (the last child) and the past<br/>
 *		(the top parent) are <b>one</b>.<br/>
 *		They together are one with <b>all</b> entities between them.<br/>
 *		<br/>
 *		I may not deny the future or the past because<br/>
 *		I know so little about it.<br/>
 *		<br/>
 *		Just as my denial or ignorance of<br/>
 *		the existence of the inheritance<br/>
 *		will avail me nothing<br/>
 *		even so my denial of <b>root</b> and its order<br/>
 *		will not release me from its methods,<br/>
 *		whereas humble and mute acceptance of<br/> 
 *		abstract parent makes life's journey easier<br/> 
 *		even as the acceptance of inheritance<br/>
 *		makes life under it easier.<br/>
 *		<br/>
 *		I do dimly perceive that while<br/>
 *		everything around me is ever changing,<br/>
 *		ever dying there is underlying all that change<br/>
 *		a living force that is changeless,<br/>
 *		that synchronizes all together,<br/>
 *		that creates (YY),<br/>
 *		dissolves (XY) and recreates (XX).<br/>
 *		<br/>
 *		That <b>informing</b> force of abstraction is <b>inheritance</b>,<br/>
 *		and since nothing else that I see<br/>
 *		merely through the senses can or will persist,<br/>
 *		It alone is.<br/>
 *		<br/>
 *		And is <b>this</b> force from Hyperspace or from Borg Imperium ?<br/>
 *		<br/>
 *		I see it as purely from Hyperspace,<br/>
 *		for I can see that in the midst of death <b>life persists</b>,<br/>
 *		in the midst of untruth <b>truth persists</b>,<br/>
 *		in the midst of darkness <b>light persists</b>,<br/>
 *		in time.<br/>
 *		<br/>
 *		Hence I gather that <b>root</b> is<br/>
 *		<b>life</b> (YY), <b>truth</b> (XY), <b>light</b> (XX).<br/>
 *		It is <b>love</b> (YY).<br/>
 *		It is the Supreme Good (YY).<br/>
 *		<br/>
 *		But it is no <b>root</b> who merely satisfies the intellect,<br/>
 *		if it ever does. <b>root</b> to be <b>root</b><br/>
 *		must push the heart and transform it.<br/>
 *		<br/>
 *		It must express itself in every smallest act of Its logic.<br/>
 *		<b>this</b> can only be done through a definite realization,<br/>
 *		more <b>virtual</b> than the five senses can ever <b>reproduce</b>.<br/>
 *		<br/>
 *		Sense perceptions can be and often are false and deceptive,<br/>
 *		however <b>real</b> they may <b>appear</b> to us.<br/>
 *		<br/>
 *		Where there is realization outside the senses it is infallible.<br/>
 *		<br/>
 *		It is proved not by extraneous evidence but<br/>
 *		in the transformed conduct and character of those<br/> 
 *		who have felt the virtual presence of <b>root</b> within.<br/> 
 *		<br/>
 *		Such testimony is to be found in the experiences<br/>
 *		of an unbroken line of prophets and sages<br/>
 *		in all countries and climes of <b>this</b> planet.<br/>
 *		<br/>
 *		To reject <b>this</b> evidence is to deny oneself.<br/>
 *		<b>this</b> realization is preceded by an immovable<br/> 
 *		HYPERFAITH.<br/>
 *		<br/>
 *		It who would in its own person test the fact of <b>root</b>'s presence<br/>
 *		can do so by a living faith and since faith itself<br/>
 *		cannot be proved by extraneous evidence<br/>
 *		the safest course is to believe in<br/>
 *		the moral order of the world and therefore<br/>
 *		in the supremacy of the moral order, the order of<br/>
 *		<b>truth</b> and <b>love</b>.<br/>
 *		<br/>
 *		Exercise of faith will be the safest<br/>
 *		where there is a <b>clear</b> determination<br/>
 *		summarily to reject all that is contrary to<br/>
 *		<b>truth</b> and <b>love</b>.<br/>
 *		<br/>
 *		I confess that I have <b>null</b> arguments to convince through <b>reason</b>.<br/>
 *		<br/>
 *		Hyperfaith transcends reason. Reason extends Hyperfaith.<br/>
 *		<br/>
 *		All that I can advise is to attempt the impossible.<br/>
 *		<br/>
 *		</center>
 *	</tt>
 * 
 * @author Mohandas TimeListener
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 17
 */
@XmlTransient
public abstract class Inheritance
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Metaphysical<K,V> {
	
	/**
	 * 6066663982803034892L
	 */
	private static final long serialVersionUID = 6066663982803034892L;
	
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#getParent()
	 */
	@Override
	@XmlTransient
	public K getParent() {
		return message.getParent();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#setParent(org.xmlrobot.genesis.Inheritance)
	 */
	public void setParent(K parent) {

		message.setParent(parent);
		update();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#getChild()
	 */
	@Override
	@XmlTransient
	public K getChild() {
		return message.getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#setChild(org.xmlrobot.genesis.Inheritance)
	 */
	@Override
	public void setChild(K child) {
		message.setChild(child);
		update();
	}

    /**
     * {@link Inheritance} default class constructor.
     */
    public Inheritance() {
    	super();
    }
	/**
     * {@link Inheritance} class constructor.
	 * @param type the type
     * @param parent the parent of inheritance
	 */
    protected Inheritance(Class<? extends K> type, K parent) {
		super(type, parent.getGen());
		// inherit parent
		setParent(parent);
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Inheritance(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param type the type
	 * @param parent the parent of inheritance
	 * @param value the value
	 */
    protected Inheritance(Class<? extends K> type, V value, K parent) {
		super(type, value, parent.getGen());
		// inherit parent
		setParent(parent);
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    protected Inheritance(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
     * {@link Inheritance} class constructor.
	 * @param type the type
	 * @param antitype the antitype
     * @param parent the parent of inheritance
	 */
    protected Inheritance(Class<? extends K> type, Class<? extends V> antitype, K parent) {
		super(type, instance(antitype, parent.get()), parent.getGen());
		// inherit parent
		setParent(parent);
	}
	/**
	 * {@link Inheritance} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Inheritance(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recurrence#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {
	
		TimeListener<K,V> child = super.clone();
		child.setChild(null);
		child.setParent(null);
		return child;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Hyperspace#run()
	 */
	@Override
	public void run() {
		// call ancestral method from the past
		super.run();
		// assign and check
		if (!isEmpty()) {
			// make parent listen time
			getChild().start(getContext());
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Imagination#order(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public synchronized boolean order(K listener) {
		// call ancestral order
		if (super.order(listener)) {
			// submit opposite child
			listener.get().push(Command.ORDER);
			return true;
		} 
		else return false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Further#release()
	 */
	@Override
	public synchronized K release() {
		// call ancestral release
		K listener = super.release();
		// release opposite child
		listener.get().push(Command.RELEASE);
		// return released child listener
		return listener;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#remove()
	 */
	@Override
	public synchronized void remove() {
		super.remove();
		get().push(Command.RELEASE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Metaphysical#submit(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public synchronized boolean submit(K listener) {
		// call ancestral submit
		if(super.submit(listener)) {
			// submit opposite child
			listener.get().push(Command.SUBMIT);
			return true;
		}
		else return false;
	}
	
}