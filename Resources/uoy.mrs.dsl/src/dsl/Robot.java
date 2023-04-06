/**
 */
package dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Robot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.Robot#getInitLoc <em>Init Loc</em>}</li>
 *   <li>{@link dsl.Robot#getVelocity <em>Velocity</em>}</li>
 *   <li>{@link dsl.Robot#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link dsl.Robot#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getRobot()
 * @model
 * @generated
 */
public interface Robot extends EObject {
	/**
	 * Returns the value of the '<em><b>Init Loc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Loc</em>' reference.
	 * @see #setInitLoc(Location)
	 * @see dsl.DslPackage#getRobot_InitLoc()
	 * @model required="true"
	 * @generated
	 */
	Location getInitLoc();

	/**
	 * Sets the value of the '{@link dsl.Robot#getInitLoc <em>Init Loc</em>}' reference.
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
	 * @see dsl.DslPackage#getRobot_Velocity()
	 * @model required="true"
	 * @generated
	 */
	double getVelocity();

	/**
	 * Sets the value of the '{@link dsl.Robot#getVelocity <em>Velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Velocity</em>' attribute.
	 * @see #getVelocity()
	 * @generated
	 */
	void setVelocity(double value);

	/**
	 * Returns the value of the '<em><b>Capabilities</b></em>' containment reference list.
	 * The list contents are of type {@link dsl.Capability}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capabilities</em>' containment reference list.
	 * @see dsl.DslPackage#getRobot_Capabilities()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Capability> getCapabilities();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see dsl.DslPackage#getRobot_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link dsl.Robot#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Robot
