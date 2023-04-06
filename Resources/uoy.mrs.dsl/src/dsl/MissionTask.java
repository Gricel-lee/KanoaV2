/**
 */
package dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mission Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.MissionTask#getAt <em>At</em>}</li>
 *   <li>{@link dsl.MissionTask#getCt <em>Ct</em>}</li>
 *   <li>{@link dsl.MissionTask#getLoc <em>Loc</em>}</li>
 *   <li>{@link dsl.MissionTask#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getMissionTask()
 * @model
 * @generated
 */
public interface MissionTask extends EObject {
	/**
	 * Returns the value of the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At</em>' reference.
	 * @see #setAt(AtomicTask)
	 * @see dsl.DslPackage#getMissionTask_At()
	 * @model
	 * @generated
	 */
	AtomicTask getAt();

	/**
	 * Sets the value of the '{@link dsl.MissionTask#getAt <em>At</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At</em>' reference.
	 * @see #getAt()
	 * @generated
	 */
	void setAt(AtomicTask value);

	/**
	 * Returns the value of the '<em><b>Ct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ct</em>' reference.
	 * @see #setCt(CompoundTask)
	 * @see dsl.DslPackage#getMissionTask_Ct()
	 * @model
	 * @generated
	 */
	CompoundTask getCt();

	/**
	 * Sets the value of the '{@link dsl.MissionTask#getCt <em>Ct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ct</em>' reference.
	 * @see #getCt()
	 * @generated
	 */
	void setCt(CompoundTask value);

	/**
	 * Returns the value of the '<em><b>Loc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loc</em>' reference.
	 * @see #setLoc(Location)
	 * @see dsl.DslPackage#getMissionTask_Loc()
	 * @model
	 * @generated
	 */
	Location getLoc();

	/**
	 * Sets the value of the '{@link dsl.MissionTask#getLoc <em>Loc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loc</em>' reference.
	 * @see #getLoc()
	 * @generated
	 */
	void setLoc(Location value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see dsl.DslPackage#getMissionTask_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link dsl.MissionTask#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MissionTask
