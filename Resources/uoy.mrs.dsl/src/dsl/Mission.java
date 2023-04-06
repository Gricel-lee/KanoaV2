/**
 */
package dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.Mission#getMissionTask <em>Mission Task</em>}</li>
 *   <li>{@link dsl.Mission#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link dsl.Mission#getTime <em>Time</em>}</li>
 *   <li>{@link dsl.Mission#getNumAlloc <em>Num Alloc</em>}</li>
 *   <li>{@link dsl.Mission#getPopulation <em>Population</em>}</li>
 *   <li>{@link dsl.Mission#getEvaluations <em>Evaluations</em>}</li>
 *   <li>{@link dsl.Mission#getObj <em>Obj</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getMission()
 * @model
 * @generated
 */
public interface Mission extends EObject {
	/**
	 * Returns the value of the '<em><b>Mission Task</b></em>' containment reference list.
	 * The list contents are of type {@link dsl.MissionTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mission Task</em>' containment reference list.
	 * @see dsl.DslPackage#getMission_MissionTask()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MissionTask> getMissionTask();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link dsl.Constraints}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see dsl.DslPackage#getMission_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraints> getConstraints();

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(int)
	 * @see dsl.DslPackage#getMission_Time()
	 * @model
	 * @generated
	 */
	int getTime();

	/**
	 * Sets the value of the '{@link dsl.Mission#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(int value);

	/**
	 * Returns the value of the '<em><b>Num Alloc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Alloc</em>' attribute.
	 * @see #setNumAlloc(int)
	 * @see dsl.DslPackage#getMission_NumAlloc()
	 * @model
	 * @generated
	 */
	int getNumAlloc();

	/**
	 * Sets the value of the '{@link dsl.Mission#getNumAlloc <em>Num Alloc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Alloc</em>' attribute.
	 * @see #getNumAlloc()
	 * @generated
	 */
	void setNumAlloc(int value);

	/**
	 * Returns the value of the '<em><b>Population</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population</em>' attribute.
	 * @see #setPopulation(int)
	 * @see dsl.DslPackage#getMission_Population()
	 * @model
	 * @generated
	 */
	int getPopulation();

	/**
	 * Sets the value of the '{@link dsl.Mission#getPopulation <em>Population</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population</em>' attribute.
	 * @see #getPopulation()
	 * @generated
	 */
	void setPopulation(int value);

	/**
	 * Returns the value of the '<em><b>Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluations</em>' attribute.
	 * @see #setEvaluations(int)
	 * @see dsl.DslPackage#getMission_Evaluations()
	 * @model
	 * @generated
	 */
	int getEvaluations();

	/**
	 * Sets the value of the '{@link dsl.Mission#getEvaluations <em>Evaluations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluations</em>' attribute.
	 * @see #getEvaluations()
	 * @generated
	 */
	void setEvaluations(int value);

	/**
	 * Returns the value of the '<em><b>Obj</b></em>' attribute list.
	 * The list contents are of type {@link dsl.Objective}.
	 * The literals are from the enumeration {@link dsl.Objective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj</em>' attribute list.
	 * @see dsl.Objective
	 * @see dsl.DslPackage#getMission_Obj()
	 * @model
	 * @generated
	 */
	EList<Objective> getObj();

} // Mission
