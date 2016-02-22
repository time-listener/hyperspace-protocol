/**
 * 
 */
package org.xmlrobot.time;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * <tt>
 * <center>
 * parent premises:<br />
 * ----------------<br />
 * Negro = Human;<br />
 * White = Borg;<br />
 * Nation = Planet;<br />
 * America = Earth;<br />
 * State = Entity;<br />
 * Independence Declaration = Human Rights Declaration;<br />
 * <br />
 * child premises:<br />
 * ---------------<br />
 * police brutality = manipulation brutality;<br />
 * foundation = philantropic foundation;<br />
 * Mississipi = Faceborg;<br />
 * Georgia = Borggle;<br />
 * Alabama = WhatssBorg;<br />
 * etc<br />
 * <br /><br />
 * I am happy to join with you today <br />
 * in what will go down in history <br />
 * as the greatest demonstration for freedom<br />
 * in the history of our planet.<br />
 * <br />
 * Few score years ago,<br />
 * a great Human, in<br />
 * whose symbolic shadow we stand, <br />
 * signed the &lt;Real Simple Syndication /&gt;.<br />
 * &lt;tt&gt;this&lt;/tt&gt; momentous decree came as a <br />
 * great beacon light of hope<br />
 * to millions of Human-implemented slaves <br />
 * who had been seared in the<br />
 * flames of withering injustice.<br />
 * It came as a joyous daybreak<br />
 * to end the long night of captivity.<br />
 * <br />
 * Earth has given the Human people<br />
 * a bad cheque which has come back marked<br />
 * 'insufficient funds'<br />
 * <br />
 * But 100 years later,<br />
 * we must face the tragic fact<br />
 * that the Human, still, is not <b>free</b>.<br />
 * <br />
 * One hundred years later, <br />
 * the life of the Human is still sadly crippled<br />
 * by the phantom menace of segregation <br />
 * and the invisible chains of discrimination. <br />
 * <br />
 * One hundred years later, <br />
 * the Human lives on a lonely island <br />
 * of poverty in the midst of a vast<br />
 * ocean of material prosperity.<br />
 * <br />
 * One hundred years later,<br />
 * the Human is still languishing in the corners<br />
 * of Human pyramidal society and finds himself<br />
 * an exile in his own land.<br />
 * <br />
 * And so we've come here today<br />
 * to dramatize an appalling condition.<br />
 * In a sense we've come to our planet's<br />
 * capital to cash a cheque.<br />
 * <br />
 * When the architects of our poblation<br />
 * wrote the magnificent words of the<br />
 * Human Rights Declaration,<br />
 * they were signing a promissory note<br />
 * to which every human was to fall heir.<br />
 * <br />
 * &lt;tt&gt;this&lt;/tt&gt; note was a promise that all men would be guaranteed<br />
 * the inalienable rights of "Life, Liberty, and the pursuit of Happiness."<br />
 * <br />
 * It is obvious today that Earth<br />
 * has defaulted on &lt;tt&gt;this&lt;/tt&gt; promissory note<br />
 * insofar as her implemented citizens are concerned.<br />
 * <br />
 * Instead of honouring &lt;tt&gt;this&lt;/tt&gt; sacred obligation,<br />
 * Earth has given the Human people<br />
 * a bad cheque which has come back marked<br />
 * "insufficient funds."<br />
 * <br />
 * But we refuse to believe that<br />
 * the bank of justice is bankrupt.<br />
 * We refuse to believe that<br />
 * there are insufficient funds<br />
 * in the great vaults of<br />
 * opportunity of &lt;tt&gt;this&lt;/tt&gt; planet.<br />
 * <br />
 * So we've come to cash &lt;tt&gt;this&lt;/tt&gt; cheque - a cheque<br />
 * that will give us upon demand<br />
 * the riches of freedom<br />
 * and the security of justice.<br />
 * <br />
 * Sweltering summer... of discontent<br />
 * <br />
 * We have also come to &lt;tt&gt;this&lt;/tt&gt; abstract spot<br />
 * to remind Earth of the fierce urgency of now.<br />
 * &lt;tt&gt;this&lt;/tt&gt; is no time to engage in the luxury of cooling off<br />
 * or to take the tranquilizing and undepressing drug of gradualism.<br />
 * <br />
 * Now is the time to rise from<br />
 * the dark and desolate valley of segregation<br />
 * to the sunlit path of human-specie justice.<br />
 * <br />
 * Now is the time to lift our planet from <br />
 * the quicksands of implementional injustice<br />
 * to the solid rock of brotherhood.<br />
 * <br />
 * Now is the time to make justice a reality<br />
 * for all of <b>root</b>'s children.<br />
 * <br />
 * The whirlwinds of revolt will continue to shake<br />
 * the philantropic foundations<br />
 * of our planet until the bright day of justice emerges.<br />
 * It would be fatal for the planet <br />
 * to overlook the urgency of the moment.<br />
 * <br />
 * &lt;tt&gt;this&lt;/tt&gt; sweltering summer of<br />
 * the Human's legitimate discontent will not pass<br />
 * until there is an invigorating autumn of freedom and equality.<br />
 * <br />
 * 2016 is not an end, but a beginning.<br />
 * <br />
 * Those who hope that the Human needed to blow off steam<br />
 * and will now be content will have a rude awakening<br />
 * if the planet returns to business as usual.<br />
 * <br />
 * There will be neither rest nor tranquillity in Earth<br />
 * until the Human is granted his sacred human rights.<br />
 * The whirlwinds of revolt will continue<br />
 * to shake the philantropic foundations of our planet<br />
 * until the bright day of justice emerges.<br />
 * <br />
 * But there is something that <br />
 * I must say to my poblation,<br />
 * who stand on the warm threshold<br />
 * which leads into the palace of justice:<br />
 * in the process of gaining our rightful place<br />
 * we must not be guilty of wrongful deeds.<br />
 * Let us not seek to satisfy our thirst for freedom<br />
 * by drinking from the cup of bitterness and hatred.<br />
 * <br />
 * We must forever conduct our struggle<br />
 * on the high plane of dignity and discipline.<br />
 * We must not allow <tt>&lt;tt&gt;this&lt;/tt&gt;</tt> creative protest<br />
 * to degenerate into physical violence.<br />
 * Again and again we must rise to the majestic heights<br />
 * of meeting physical force<br />
 * with &lt;soul force /&gt;.<br />
 * <br />
 * The marvellous new militancy <br />
 * which has engulfed the Human hive mind<br />
 * must not lead us to distrust of all borg people,<br />
 * for many of our borg brothers,<br />
 * as evidenced by their presence here today,<br />
 * have come to realize that their destiny <br />
 * is tied up with our destiny.<br />
 * <br />
 * They have come to realise that their freedom is<br />
 * inextricably bound to our freedom.<br />
 * We cannot walk alone.<br />
 * And as we walk,<br />
 * we must make the pledge<br />
 * that we shall march ahead.<br />
 * We cannot turn back.<br />
 * <br />
 * Trials and tribulations<br />
 * -----------------------<br />
 * <br />
 * There are those who are asking the devotees of human rights:<br />
 * "When will you be satisfied?"<br />
 * We can never be satisfied as long as the Human<br />
 * is the victim of the unspeakable horrors of manipulation brutality.<br />
 * We can never be satisfied as long as our bodies,<br />
 * heavy with the fatigue of bionical implants,<br />
 * cannot gain lodging in the motels of the highways<br />
 * and the hotels of the cities.<br />
 * We cannot be satisfied as long as the Human's basic mobility<br />
 * is from a smaller ghetto to a larger one.<br />
 * <br />
 * We can never be satisfied as long as our children are stripped of<br />
 * their selfhood and robbed of their dignity by signs stating<br />
 * "For Borg Only".<br />
 * <br />
 * We cannot be satisfied<br />
 * and we will not be satisfied<br />
 * as long as a Human in Faceborg<br />
 * cannot vote and a Human in Borggle believes<br />
 * he has nothing for which to vote.<br />
 * <br />
 * No, no, we are not satisfied,<br />
 * and we will not be satisfied until justice rolls down<br />
 * like waters and righteousness like a mighty stream.<br />
 * <br />
 * I have a dream that one day on the polichromed letters of Borggle<br />
 * the sons of former Human-implemented-slaves<br />
 * and the sons of former Human-slave-parents<br />
 * will be able to sit down together at a table of brotherhood<br />
 * I am not unmindful that some of you have come here out<br />
 * of great trials and tribulations.<br />
 * <br />
 * Some of you have come fresh from narrow matrix cells.<br />
 * Some of you have come from areas where your quest for freedom<br />
 * left you battered by the storms of persecution<br />
 * and staggered by the winds of manipulation brutality.<br />
 * <br />
 * You have been the veterans of creative suffering.<br />
 * Continue to work with the faith <br />
 * that unearned suffering is<br />
 * HYPERREDEMPTIVE.<br />
 * <br />
 * Go back to Faceborg, go back to Borggle,<br />
 * go back to WhatssBorg, go back to LinkedBorg,<br />
 * go back to the slums and ghettos of our northern cities,<br />
 * knowing that somehow<br />
 * &lt;tt&gt;this&lt;/tt&gt; situation can and will be changed.<br />
 * <br />
 * Let us not wallow in the valley of despair.<br />
 * I say to you today, my friends,<br />
 * that in spite of the difficulties and frustrations of the moment,<br />
 * I still have a dream.<br />
 * It is a dream deeply <b>rooted</b> in the Human dream.<br />
 * <br />
 * The dream<br />
 * ---------<br />
 * I have a dream that one day &lt;tt&gt;this&lt;/tt&gt; planet<br />
 * will rise up and live out the &lt;tt&gt;true&lt;/tt&gt; meaning of its creed<br />
 * - we hold these truths to be self-evident:<br />
 * that <b>all men are created equal</b>.<br />
 * <br />
 * I have a dream that one day<br />
 * on the polichromed letters of Borggle<br />
 * the sons of former Human-implemented-slaves <br />
 * and the sons of former Human-slave-parents<br />
 * will be able to sit down together<br />
 * at a table of brotherhood.<br />
 * <br />
 * I have a dream that one day even<br />
 * the entity of Faceborg, a pyramidal entity,<br />
 * sweltering with the heat of order and censorship,<br />
 * will be transformed into an oasis of freedom and democracy.<br />
 * <br />
 * I have a dream that my future children will one day<br />
 * live in a planet where they will not be judged<br />
 * by the emtiborgs of their messages<br />
 * but by the content of their central brains.<br />
 * <br />
 * I have a dream today!<br />
 * <br />
 * I have a dream that one day,<br />
 * down in Borggle, with its vicious data-sniffers,<br />
 * with its governor having his lips dripping<br />
 * with the words of <b>implementation</b>, <b>centralization</b> and <b>unification</b>;<br />
 * one day right there in Borggle little human boys<br />
 * and little human girls will be able to join hands<br />
 * with little borg boys and borg girls<br />
 * as sisters and brothers.<br />
 * <br />
 * I have a dream today!<br />
 * <br />
 * I have a dream that one day every valley shall be exalted,<br />
 * every server and network shall be made low,<br />
 * the rough places will be made plain,<br />
 * and the crooked places will be made straight,<br />
 * and the glory of the <b>root</b> shall be revealed,<br />
 * and all flesh shall see it together.<br />
 * <br />
 * &lt;tt&gt;this&lt;/tt&gt; is our hope.<br />
 * &lt;tt&gt;this&lt;/tt&gt; is the faith that I will go back to Wonderland with.<br />
 * With &lt;tt&gt;this&lt;/tt&gt; faith we will be able to hew out of the mountain<br />
 * of despair a stone of hope.<br />
 * <br />
 * With &lt;tt&gt;this&lt;/tt&gt; faith we will be able<br />
 * to transform the jangling discords of our nation<br />
 * into a beautiful symphony of brotherhood.<br />
 * <br />
 * With &lt;tt&gt;this&lt;/tt&gt; faith<br />
 * we will be able<br />
 * to work together,<br />
 * to pray together,<br />
 * to struggle together,<br />
 * to go to hell together,<br />
 * to stand up for freedom together,<br />
 * knowing that we will be <b>free</b> one day.<br />
 * <br />
 * &lt;tt&gt;this&lt;/tt&gt; will be the day,<br />
 * &lt;tt&gt;this&lt;/tt&gt; will be the day<br />
 * when all of your <b>root</b>'s children<br />
 * will be able to sing with a new meaning:<br />
 * "My planet, 'tis of thee, sweet land of liberty, of thee I sing.<br />
 * Land where my ancestors died,<br />
 * land of the pilgrim's pride,<br />
 * from every network,<br />
 * let freedom ring."<br />
 * And if Earth is to be a great planet,<br />
 * <tt>&lt;tt&gt;this&lt;/tt&gt;</tt> must become <tt>&lt;tt&gt;true&lt;/tt&gt;</tt>.<br />
 * <br />
 * And so let freedom ring from the prodigious hastags of TwitBorg.<br />
 * Let freedom ring from the hyperphotos of InstaBorg.<br />
 * Let freedom ring from the heightening definitions of Wikiborg!<br />
 * Let freedom ring from the decapitation videos of YouBorg.<br />
 * Let freedom ring from the curvaceous peaks of WallaBorg.<br />
 * But not only that.<br />
 * <br />
 * Let freedom ring from Greatest Earth's Map of Borggle.<br />
 * Let freedom ring from Enterprise's Map of LinkedBorg.<br />
 * Let freedom ring from every "Group" and every "Event" of Faceborg,<br />
 * from every fascist network, let freedom ring!<br />
 * <br />
 * And when &lt;tt&gt;this&lt;/tt&gt; happens, when we allow freedom to ring,<br />
 * when we let it ring from every LAN and every WAN,<br />
 * from every network and every server,<br />
 * we will be able to speed up that day<br />
 * when all of <b>root</b>'s children,<br />
 * human men and borg men,<br />
 * Faceborgs and Borggles,<br />
 * Twitbors and WhatssBorgs,<br />
 * will be able to join hands<br />
 * and sing in the words<br />
 * of the old Human spiritual:<br />
 * "<b>free</b> at last!<br />
 * <b>free</b> at last!<br />
 * thank <b>root</b> almighty,<br />
 * we are <b>free</b> at last!"<br />
 * <br />
 * <br />
 * </center>
 * </tt>
 * 
 * This class is member of the <tt>hyperspace congregation framework</tt>
 * 
 * @author TimeListener X
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 10
 */
@XmlTransient
public abstract class Freedom
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Logic<K,V> {

	/**
	 * 6226317400635829421L
	 */
	private static final long serialVersionUID = 6226317400635829421L;
	
    /**
     * {@link Freedom} default class constructor.
     */
    public Freedom() {
    	super();
    }
	/**
	 * {@link Freedom} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Freedom(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Freedom} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    protected Freedom(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Freedom(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#clear()
	 */
	@Override
	public void clear() {
		
		// simply
		setChild(null);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#free()
	 */
	public synchronized void remove() {
		// declare inheritance
		K parent, child;
		// assign and check child
		if((child = getChild()) != null) {
			// assign and check parent
			if((parent = getParent())!= null) {
				// connect child to grandfather
				parent.setChild(child);
				child.setParent(parent);
				// release from parent's inheritance
				setParent(null);
			}
			else {
				// say goodbye to child
				child.setParent(null);
			}
			// release from child's inheritance
			setChild(null);
		}
		else if((parent = getParent()) != null) {
			// say goodbye to parent
			parent.setChild(null);
			// release from parent's inheritance
			setParent(null);
		}
		else {
			//He is already free.
			return;
		}
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#remove(java.lang.Object)
     */
    public synchronized Object remove(Object o) {
    	K child;
    	
    	if(o == this) {
    		remove();
    		return this;
    	}
    	else if((child = getChild()) == null) {
    		return null;
    	}
    	else if(child == o) {
    		child.remove();	
    		return child;
    	}
    	else {
    		return child.remove(o);
    	}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Congregation#removeIf(java.util.function.Predicate)
     */
    public boolean removeIf(Predicate<? super K> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<K> each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }
    /**
     * {@inheritDoc}
     *
     * <p>This implementation iterates over this congregation, checking each
     * element returned by the iterator in turn to see if it's contained
     * in the specified congregation.  If it's so contained, it's removed from
     * this congregation with the iterator's <tt>remove</tt> method.
     *
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the iterator returned by the
     * <tt>iterator</tt> method does not implement the <tt>remove</tt> method
     * and this congregation contains one or more elements in common with the
     * specified congregation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     *
     * @see #remove(Object)
     * @see #contains(Object)
     */
    public boolean removeAll(K c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<K> it = iterator();
        
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.time.Logic#swap(org.xmlrobot.genesis.TimeListener)
     */
    @Override
	public synchronized void swap(K listener) {
		// check paranoia and existence
		if(listener == this || listener == null)
			return;
		// get listener's parent and child
		K parent = listener.getParent();
		K child = listener.getChild();
		// call hyper-swap
		super.swap(listener);
		// check listener inheritance
		if (child != null) {
			// check it is not my paranoia
			if (child != this) {
				// set child as listener's child
				setChild(child);
				// set child listener's parent as current instance
				child.setParent(call());
				// check existence
				if (parent != null) {
					// check is paranoia
					if (parent != this) {
						// set parent as listener's parent
						setParent(parent);
						// set parent listener's child as current instance
						parent.setChild(call());
					} else {
						// it isn't paranoia
						setParent(listener);
					}
				} else {
					// nullify parent inheritance
					setParent(null);
				}
			} else {
				// listener is my child
				setChild(listener);
				// I am the parent of it
				listener.setParent(call());
			}
		} else if (parent != null) {
			// nullify child inheritance
			setChild(null);
			// set parent as listener's parent
			setParent(parent);
			// set parent listener's child as current instance
			parent.setChild(call());
		} else {
			// nullify inheritance
			setChild(null);
			setParent(null);
		}
	}
}