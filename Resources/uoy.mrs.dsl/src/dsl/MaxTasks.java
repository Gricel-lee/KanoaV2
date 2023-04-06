/**
 */
package dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Max Tasks</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.MaxTasks#getRobot <em>Robot</em>}</li>
 *   <li>{@link dsl.MaxTasks#getAll <em>All</em>}</li>
 *   <li>{@link dsl.MaxTasks#getNum <em>Num</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getMaxTasks()
 * @model
 * @generated
 */
public interface MaxTasks extends Constraints {
	/**
	 * Returns the value of the '<em><b>Robot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Robot</em>' reference.
	 * @see #setRobot(Robot)
	 * @see dsl.DslPackage#getMaxTasks_Robot()
	 * @model
	 * @generated
	 */
	Robot getRobot();

	/**
	 * Sets the value of the '{@link dsl.MaxTasks#getRobot <em>Robot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Robot</em>' reference.
	 * @see #getRobot()
	 * @generated
	 */
	void setRobot(Robot value);

	/**
	 * Returns the value of the '<em><b>All</b></em>' attribute.
	 * The default value is <code>"all"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All</em>' attribute.
	 * @see #setAll(String)
	 * @see dsl.DslPackage#getMaxTasks_All()
	 * @model default="all"
	 * @generated
	 */
	String getAll();

	/**
	 * Sets the value of the '{@link dsl.MaxTasks#getAll <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All</em>' attribute.
	 * @see #getAll()
	 * @generated
	 */
	void setAll(String value);

	/**
	 * Returns the value of the '<em><b>Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num</em>' attribute.
	 * @see #setNum(int)
	 * @see dsl.DslPackage#getMaxTasks_Num()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getNum();

	/**
	 * Sets the value of the '{@link dsl.MaxTasks#getNum <em>Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num</em>' attribute.
	 * @see #getNum()
	 * @generated
	 */
	void setNum(int value);

} // MaxTasks
