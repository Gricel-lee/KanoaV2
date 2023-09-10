/**
 */
package uoy.mrs.uoy.mrs.types.dslRedone;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>XY</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getXY()
 * @model
 * @generated
 */
public enum XY implements Enumeration {
	/**
	 * The '<em><b>X</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #X_VALUE
	 * @generated
	 * @ordered
	 */
	X(0, "x", "x"),

	/**
	 * The '<em><b>Y</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Y_VALUE
	 * @generated
	 * @ordered
	 */
	Y(1, "y", "y");

	/**
	 * The '<em><b>X</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #X
	 * @model name="x"
	 * @generated
	 * @ordered
	 */
	public static final int X_VALUE = 0;

	/**
	 * The '<em><b>Y</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Y
	 * @model name="y"
	 * @generated
	 * @ordered
	 */
	public static final int Y_VALUE = 1;

	/**
	 * An array of all the '<em><b>XY</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final XY[] VALUES_ARRAY =
		new XY[] {
			X,
			Y,
		};

	/**
	 * A public read-only list of all the '<em><b>XY</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<XY> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>XY</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static XY get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			XY result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>XY</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static XY getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			XY result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>XY</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static XY get(int value) {
		switch (value) {
			case X_VALUE: return X;
			case Y_VALUE: return Y;
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
	private XY(int value, String name, String literal) {
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

	@Override
	public boolean hasMoreElements() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object nextElement() {
		// TODO Auto-generated method stub
		return null;
	}
	
} //XY
