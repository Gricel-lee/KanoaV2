/**
 */
package dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.CompoundTask#getName <em>Name</em>}</li>
 *   <li>{@link dsl.CompoundTask#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link dsl.CompoundTask#isConsecutive <em>Consecutive</em>}</li>
 *   <li>{@link dsl.CompoundTask#getCanDoTask <em>Can Do Task</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getCompoundTask()
 * @model
 * @generated
 */
public interface CompoundTask extends TasksModel {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see dsl.DslPackage#getCompoundTask_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link dsl.CompoundTask#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered</em>' attribute.
	 * @see #setOrdered(boolean)
	 * @see dsl.DslPackage#getCompoundTask_Ordered()
	 * @model required="true"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * Sets the value of the '{@link dsl.CompoundTask#isOrdered <em>Ordered</em>}' attribute.
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
	 * @see dsl.DslPackage#getCompoundTask_Consecutive()
	 * @model required="true"
	 * @generated
	 */
	boolean isConsecutive();

	/**
	 * Sets the value of the '{@link dsl.CompoundTask#isConsecutive <em>Consecutive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consecutive</em>' attribute.
	 * @see #isConsecutive()
	 * @generated
	 */
	void setConsecutive(boolean value);

	/**
	 * Returns the value of the '<em><b>Can Do Task</b></em>' reference list.
	 * The list contents are of type {@link dsl.TasksModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Do Task</em>' reference list.
	 * @see dsl.DslPackage#getCompoundTask_CanDoTask()
	 * @model
	 * @generated
	 */
	EList<TasksModel> getCanDoTask();

} // CompoundTask
