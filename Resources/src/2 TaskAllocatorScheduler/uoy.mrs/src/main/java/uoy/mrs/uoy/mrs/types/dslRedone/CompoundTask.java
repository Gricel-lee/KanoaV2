/**
 */
package uoy.mrs.uoy.mrs.types.dslRedone;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.CompoundTask#getLoc <em>Loc</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.CompoundTask#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.CompoundTask#isConsecutive <em>Consecutive</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.CompoundTask#getCanDoTask <em>Can Do Task</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.CompoundTask#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCompoundTask()
 * @model
 * @generated
 */
public interface CompoundTask extends TasksModel {
	/**
	 * Returns the value of the '<em><b>Loc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loc</em>' reference.
	 * @see #setLoc(Location)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCompoundTask_Loc()
	 * @model
	 * @generated
	 */
	Location getLoc();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.CompoundTask#getLoc <em>Loc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loc</em>' reference.
	 * @see #getLoc()
	 * @generated
	 */
	void setLoc(Location value);

	/**
	 * Returns the value of the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered</em>' attribute.
	 * @see #setOrdered(boolean)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCompoundTask_Ordered()
	 * @model required="true"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.CompoundTask#isOrdered <em>Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordered</em>' attribute.
	 * @see #isOrdered()
	 * @generated
	 */
	void setOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Consecutive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consecutive</em>' attribute.
	 * @see #setConsecutive(boolean)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCompoundTask_Consecutive()
	 * @model required="true"
	 * @generated
	 */
	boolean isConsecutive();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.CompoundTask#isConsecutive <em>Consecutive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consecutive</em>' attribute.
	 * @see #isConsecutive()
	 * @generated
	 */
	void setConsecutive(boolean value);

	/**
	 * Returns the value of the '<em><b>Can Do Task</b></em>' reference list.
	 * The list contents are of type {@link uoy.mrs.uoy.mrs.types.dslRedone.TasksModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Do Task</em>' reference list.
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCompoundTask_CanDoTask()
	 * @model
	 * @generated
	 */
	List<TasksModel> getCanDoTask();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCompoundTask_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.CompoundTask#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // CompoundTask
