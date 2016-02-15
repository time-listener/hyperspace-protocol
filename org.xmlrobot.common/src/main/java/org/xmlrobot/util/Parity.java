/**
 * 
 */
package org.xmlrobot.util;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * The gender types. 
 * <br>
 * @author joan
 *
 */
@XmlType(name = "gender")
@XmlEnum(String.class)
public enum Parity {

	/*
	 * ScrewNut
	 * */
	@XmlEnumValue(value = "XX")
	XX("XX", "screwNut", 1),
	/*
	 * Screw
	 * */
	@XmlEnumValue(value = "XY")
	XY("XY", "screw", -1),
	/*
	 * ScrewDriver
	 * */
	@XmlEnumValue(value = "YY")
	YY("YY", "screwDriver", 0);
	
	private final String value;
	private final int code;
	
	public final String getValue()
	{
		return this.value;
	}
	
	private final String name;
	
	public final String getName()
	{
		return name;
	}
	public final int getCode()
	{
		return code;
	}
	
	private Parity(String value, String name, int code)
	{
		this.value = value;
		this.name = name;
		this.code = code;
		this.value.intern();// QUESTION: Need we bother here?
	}
	/**
	 * Returns the natural opposite parity of input gender
	 * @param parity {@link Parity} the gender
	 * @return the opposite gender
	 */
	public static Parity opposite(Parity parity)
	{
		switch (parity) {
		case XX:
			return XY;
		case XY:
			return XX;
		default:
			return YY;
		}
	}
	/**
	 * Translates integer to gender
	 * @param code the integer to translate
	 * @return the translated gender
	 */
	public static Parity translate(int code)
	{
		if(code > 0)
			return XY;
		else if(code < 0)
			return XX;
		else
			return YY;
	}
	/**
	 * Translates boolean to gender
	 * @param bool the boolean to translate
	 * @return the translated gender
	 */
	public static Parity translate(boolean bool){
		
		return bool ? XY : XX;
	}
	/**
	 * Translates string to gender
	 * @param code {@link String} the string to translate
	 * @return the translated gender
	 */
	public static Parity translate(String value)
	{
		Parity result = null;
		Parity[] vals = Parity.values();
		
		for(Parity gender : vals)
		{
			if(gender.getValue() == value)
			{
				result = gender;
			}
		}
		return result;
	}
}
