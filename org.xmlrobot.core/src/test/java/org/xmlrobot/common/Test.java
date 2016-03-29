/**
 * 
 */
package org.xmlrobot.common;

/**
 * @author joan
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] message) {

		message = new String[] { 
				// the BCD
				"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
				"U", "V", "W", "X", "Y", "Z", "Ç", "Ñ" };
		
		// create parent
		Tick parent = new Tick(Tack.class);
		
		for(String word : message){
			
			for(char letter : word.toCharArray()) {
				
				Character key = new Character(letter);
				Integer value = new Integer(letter);
				
				parent.allocateValue(parent,
						new Flop(
								new Tack(Tick.class, value, key, parent.get())) {
					/**
					 * 
					 */
					private static final long serialVersionUID = -7887589836208543149L;
				});
			}
		}
//		Tack future =parent.getFuture(); 
//		future.spinPast();
//		parent.setChild(future.getPast());
		
		System.out.print(parent);
		System.out.print(parent.depth(parent));
	}
}
