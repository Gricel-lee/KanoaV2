/**
 */
package dsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Objective</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see dsl.DslPackage#getObjective()
 * @model
 * @generated
 */
public enum Objective implements Enumerator {
	/**
	 * The '<em><b>Min Idle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIN_IDLE_VALUE
	 * @generated
	 * @ordered
	 */
	MIN_IDLE(0, "minIdle", "minIdle"),

	/**
	 * The '<em><b>Min Travel</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIN_TRAVEL_VALUE
	 * @generated
	 * @ordered
	 */
	MIN_TRAVEL(1, "minTravel", "minTravel"),

	/**
	 * The '<em><b>Max Succ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_SUCC_VALUE
	 * @generated
	 * @ordered
	 */
	MAX_SUCC(2, "maxSucc", "maxSucc");

	/**
	 * The '<em><b>Min Idle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIN_IDLE
	 * @model name="minIdle"
	 * @generated
	 * @ordered
	 */
	public static final int MIN_IDLE_VALUE = 0;

	/**
	 * The '<em><b>Min Travel</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIN_TRAVEL
	 * @model name="minTravel"
	 * @generated
	 * @ordered
	 */
	public static final int MIN_TRAVEL_VALUE = 1;

	/**
	 * The '<em><b>Max Succ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_SUCC
	 * @model name="maxSucc"
	 * @generated
	 * @ordered
	 */
	public static final int MAX_SUCC_VALUE = 2;

	/**
	 * An array of all the '<em><b>Objective</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Objective[] VALUES_ARRAY =
		new Objective[] {
			MIN_IDLE,
			MIN_TRAVEL,
			MAX_SUCC,
		};

	/**
	 * A public read-only list of all the '<em><b>Objective</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Objective> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Objective</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Objective get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Objective result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objective</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Objective getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Objective result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objective</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Objective get(int value) {
		switch (value) {
			case MIN_IDLE_VALUE: return MIN_IDLE;
			case MIN_TRAVEL_VALUE: return MIN_TRAVEL;
			case MAX_SUCC_VALUE: return MAX_SUCC;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Objective(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Objective
