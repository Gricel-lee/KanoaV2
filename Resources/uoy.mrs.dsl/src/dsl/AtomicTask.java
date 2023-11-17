/**
 */
package dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.AtomicTask#getLoc <em>Loc</em>}</li>
 *   <li>{@link dsl.AtomicTask#getName <em>Name</em>}</li>
 *   <li>{@link dsl.AtomicTask#getRobots <em>Robots</em>}</li>
 *   <li>{@link dsl.AtomicTask#getRetry <em>Retry</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getAtomicTask()
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
	 * @see dsl.DslPackage#getAtomicTask_Loc()
	 * @model required="true"
	 * @generated
	 */
	Location getLoc();

	/**
	 * Sets the value of the '{@link dsl.AtomicTask#getLoc <em>Loc</em>}' reference.
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
	 * @see dsl.DslPackage#getAtomicTask_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link dsl.AtomicTask#getName <em>Name</em>}' attribute.
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
	 * @see dsl.DslPackage#getAtomicTask_Robots()
	 * @model
	 * @generated
	 */
	int getRobots();

	/**
	 * Sets the value of the '{@link dsl.AtomicTask#getRobots <em>Robots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Robots</em>' attribute.
	 * @see #getRobots()
	 * @generated
	 */
	void setRobots(int value);

	/**
	 * Returns the value of the '<em><b>Retry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry</em>' attribute.
	 * @see #setRetry(int)
	 * @see dsl.DslPackage#getAtomicTask_Retry()
	 * @model
	 * @generated
	 */
	int getRetry();

	/**
	 * Sets the value of the '{@link dsl.AtomicTask#getRetry <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry</em>' attribute.
	 * @see #getRetry()
	 * @generated
	 */
	void setRetry(int value);

} // AtomicTask
