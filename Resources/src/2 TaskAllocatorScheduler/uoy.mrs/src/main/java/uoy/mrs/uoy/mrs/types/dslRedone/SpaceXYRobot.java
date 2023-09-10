/**
 */
package uoy.mrs.uoy.mrs.types.dslRedone;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Space XY Robot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getCoordinate <em>Coordinate</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getLowerGreater <em>Lower Greater</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getVal <em>Val</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getRobot <em>Robot</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getAllrobots <em>Allrobots</em>}</li>
 * </ul>
 *
 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getSpaceXYRobot()
 * @model
 * @generated
 */
public interface SpaceXYRobot extends Constraints {
	/**
	 * Returns the value of the '<em><b>Coordinate</b></em>' attribute.
	 * The literals are from the enumeration {@link uoy.mrs.uoy.mrs.types.dslRedone.XY}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinate</em>' attribute.
	 * @see uoy.mrs.uoy.mrs.types.dslRedone.XY
	 * @see #setCoordinate(XY)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getSpaceXYRobot_Coordinate()
	 * @model required="true"
	 * @generated
	 */
	XY getCoordinate();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getCoordinate <em>Coordinate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coordinate</em>' attribute.
	 * @see uoy.mrs.uoy.mrs.types.dslRedone.XY
	 * @see #getCoordinate()
	 * @generated
	 */
	void setCoordinate(XY value);

	/**
	 * Returns the value of the '<em><b>Lower Greater</b></em>' attribute.
	 * The literals are from the enumeration {@link uoy.mrs.uoy.mrs.types.dslRedone.LowerGreater}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Greater</em>' attribute.
	 * @see uoy.mrs.uoy.mrs.types.dslRedone.LowerGreater
	 * @see #setLowerGreater(LowerGreater)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getSpaceXYRobot_LowerGreater()
	 * @model required="true"
	 * @generated
	 */
	LowerGreater getLowerGreater();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getLowerGreater <em>Lower Greater</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Greater</em>' attribute.
	 * @see uoy.mrs.uoy.mrs.types.dslRedone.LowerGreater
	 * @see #getLowerGreater()
	 * @generated
	 */
	void setLowerGreater(LowerGreater value);

	/**
	 * Returns the value of the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Val</em>' attribute.
	 * @see #setVal(double)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getSpaceXYRobot_Val()
	 * @model required="true"
	 * @generated
	 */
	double getVal();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getVal <em>Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Val</em>' attribute.
	 * @see #getVal()
	 * @generated
	 */
	void setVal(double value);

	/**
	 * Returns the value of the '<em><b>Robot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Robot</em>' reference.
	 * @see #setRobot(Robot)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getSpaceXYRobot_Robot()
	 * @model
	 * @generated
	 */
	Robot getRobot();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getRobot <em>Robot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Robot</em>' reference.
	 * @see #getRobot()
	 * @generated
	 */
	void setRobot(Robot value);

	/**
	 * Returns the value of the '<em><b>Allrobots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allrobots</em>' attribute.
	 * @see #setAllrobots(String)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getSpaceXYRobot_Allrobots()
	 * @model
	 * @generated
	 */
	String getAllrobots();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.SpaceXYRobot#getAllrobots <em>Allrobots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allrobots</em>' attribute.
	 * @see #getAllrobots()
	 * @generated
	 */
	void setAllrobots(String value);

} // SpaceXYRobot
