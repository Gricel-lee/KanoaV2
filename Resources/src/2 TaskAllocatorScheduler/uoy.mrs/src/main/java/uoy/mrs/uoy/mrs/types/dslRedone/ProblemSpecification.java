/**
 */
package uoy.mrs.uoy.mrs.types.dslRedone;

import java.util.List;

//import org.eclipse.emf.common.util.EList;

//import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.ProblemSpecification#getWorldModel <em>World Model</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.ProblemSpecification#getRobotsModel <em>Robots Model</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.ProblemSpecification#getTasksModel <em>Tasks Model</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.ProblemSpecification#getMission <em>Mission</em>}</li>
 * </ul>
 *
 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getProblemSpecification()
 * @model
 * @generated
 */
public interface ProblemSpecification{// extends Object {
	/**
	 * Returns the value of the '<em><b>World Model</b></em>' containment reference list.
	 * The list contents are of type {@link uoy.mrs.uoy.mrs.types.dslRedone.WorldModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>World Model</em>' containment reference list.
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getProblemSpecification_WorldModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	List<WorldModel> getWorldModel();

	/**
	 * Returns the value of the '<em><b>Robots Model</b></em>' containment reference list.
	 * The list contents are of type {@link uoy.mrs.uoy.mrs.types.dslRedone.Robot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Robots Model</em>' containment reference list.
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getProblemSpecification_RobotsModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	List<Robot> getRobotsModel();

	/**
	 * Returns the value of the '<em><b>Tasks Model</b></em>' containment reference list.
	 * The list contents are of type {@link uoy.mrs.uoy.mrs.types.dslRedone.TasksModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks Model</em>' containment reference list.
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getProblemSpecification_TasksModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	List<TasksModel> getTasksModel();

	/**
	 * Returns the value of the '<em><b>Mission</b></em>' containment reference list.
	 * The list contents are of type {@link uoy.mrs.uoy.mrs.types.dslRedone.Mission}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mission</em>' containment reference list.
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getProblemSpecification_Mission()
	 * @model containment="true" required="true"
	 * @generated
	 */
	List<Mission> getMission();

} // ProblemSpecification
