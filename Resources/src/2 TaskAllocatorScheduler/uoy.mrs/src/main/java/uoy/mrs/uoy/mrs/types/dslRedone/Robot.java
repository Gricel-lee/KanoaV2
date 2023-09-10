/**
 */
package uoy.mrs.uoy.mrs.types.dslRedone;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Robot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Robot#getInitLoc <em>Init Loc</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Robot#getVelocity <em>Velocity</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Robot#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Robot#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getRobot()
 * @model
 * @generated
 */
public interface Robot {
	/**
	 * Returns the value of the '<em><b>Init Loc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Loc</em>' reference.
	 * @see #setInitLoc(Location)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getRobot_InitLoc()
	 * @model required="true"
	 * @generated
	 */
	Location getInitLoc();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.Robot#getInitLoc <em>Init Loc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Loc</em>' reference.
	 * @see #getInitLoc()
	 * @generated
	 */
	void setInitLoc(Location value);

	/**
	 * Returns the value of the '<em><b>Velocity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Velocity</em>' attribute.
	 * @see #setVelocity(double)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getRobot_Velocity()
	 * @model required="true"
	 * @generated
	 */
	double getVelocity();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.Robot#getVelocity <em>Velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Velocity</em>' attribute.
	 * @see #getVelocity()
	 * @generated
	 */
	void setVelocity(double value);

	/**
	 * Returns the value of the '<em><b>Capabilities</b></em>' containment reference list.
	 * The list contents are of type {@link uoy.mrs.uoy.mrs.types.dslRedone.Capability}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capabilities</em>' containment reference list.
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getRobot_Capabilities()
	 * @model containment="true" required="true"
	 * @generated
	 */
	List<Capability> getCapabilities();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getRobot_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.Robot#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Robot
