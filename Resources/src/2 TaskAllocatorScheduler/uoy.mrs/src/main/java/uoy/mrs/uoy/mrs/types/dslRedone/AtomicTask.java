/**
 */
package uoy.mrs.uoy.mrs.types.dslRedone;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.AtomicTask#getLoc <em>Loc</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.AtomicTask#getName <em>Name</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.AtomicTask#getRobots <em>Robots</em>}</li>
 * </ul>
 *
 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getAtomicTask()
 * @model
 * @generated
 */
public interface AtomicTask extends TasksModel {
	/**
	 * Returns the value of the '<em><b>Loc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loc</em>' reference.
	 * @see #setLoc(Location)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getAtomicTask_Loc()
	 * @model required="true"
	 * @generated
	 */
	Location getLoc();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.AtomicTask#getLoc <em>Loc</em>}' reference.
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
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getAtomicTask_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.AtomicTask#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Robots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Robots</em>' attribute.
	 * @see #setRobots(int)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getAtomicTask_Robots()
	 * @model
	 * @generated
	 */
	int getRobots();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.AtomicTask#getRobots <em>Robots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Robots</em>' attribute.
	 * @see #getRobots()
	 * @generated
	 */
	void setRobots(int value);

} // AtomicTask
