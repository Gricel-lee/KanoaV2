/**
 */
package dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.ProblemSpecification#getWorldModel <em>World Model</em>}</li>
 *   <li>{@link dsl.ProblemSpecification#getRobotsModel <em>Robots Model</em>}</li>
 *   <li>{@link dsl.ProblemSpecification#getTasksModel <em>Tasks Model</em>}</li>
 *   <li>{@link dsl.ProblemSpecification#getMission <em>Mission</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getProblemSpecification()
 * @model
 * @generated
 */
public interface ProblemSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>World Model</b></em>' containment reference list.
	 * The list contents are of type {@link dsl.WorldModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>World Model</em>' containment reference list.
	 * @see dsl.DslPackage#getProblemSpecification_WorldModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<WorldModel> getWorldModel();

	/**
	 * Returns the value of the '<em><b>Robots Model</b></em>' containment reference list.
	 * The list contents are of type {@link dsl.Robot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Robots Model</em>' containment reference list.
	 * @see dsl.DslPackage#getProblemSpecification_RobotsModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Robot> getRobotsModel();

	/**
	 * Returns the value of the '<em><b>Tasks Model</b></em>' containment reference list.
	 * The list contents are of type {@link dsl.TasksModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks Model</em>' containment reference list.
	 * @see dsl.DslPackage#getProblemSpecification_TasksModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TasksModel> getTasksModel();

	/**
	 * Returns the value of the '<em><b>Mission</b></em>' containment reference list.
	 * The list contents are of type {@link dsl.Mission}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mission</em>' containment reference list.
	 * @see dsl.DslPackage#getProblemSpecification_Mission()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Mission> getMission();

} // ProblemSpecification
