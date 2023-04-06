/**
 */
package dsl.impl;

import dsl.DslPackage;
import dsl.Mission;
import dsl.ProblemSpecification;
import dsl.Robot;
import dsl.TasksModel;
import dsl.WorldModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Problem Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.ProblemSpecificationImpl#getWorldModel <em>World Model</em>}</li>
 *   <li>{@link dsl.impl.ProblemSpecificationImpl#getRobotsModel <em>Robots Model</em>}</li>
 *   <li>{@link dsl.impl.ProblemSpecificationImpl#getTasksModel <em>Tasks Model</em>}</li>
 *   <li>{@link dsl.impl.ProblemSpecificationImpl#getMission <em>Mission</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProblemSpecificationImpl extends MinimalEObjectImpl.Container implements ProblemSpecification {
	/**
	 * The cached value of the '{@link #getWorldModel() <em>World Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorldModel()
	 * @generated
	 * @ordered
	 */
	protected EList<WorldModel> worldModel;

	/**
	 * The cached value of the '{@link #getRobotsModel() <em>Robots Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRobotsModel()
	 * @generated
	 * @ordered
	 */
	protected EList<Robot> robotsModel;

	/**
	 * The cached value of the '{@link #getTasksModel() <em>Tasks Model</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasksModel()
	 * @generated
	 * @ordered
	 */
	protected EList<TasksModel> tasksModel;

	/**
	 * The cached value of the '{@link #getMission() <em>Mission</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMission()
	 * @generated
	 * @ordered
	 */
	protected EList<Mission> mission;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProblemSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.PROBLEM_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorldModel> getWorldModel() {
		if (worldModel == null) {
			worldModel = new EObjectContainmentEList<WorldModel>(WorldModel.class, this, DslPackage.PROBLEM_SPECIFICATION__WORLD_MODEL);
		}
		return worldModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Robot> getRobotsModel() {
		if (robotsModel == null) {
			robotsModel = new EObjectContainmentEList<Robot>(Robot.class, this, DslPackage.PROBLEM_SPECIFICATION__ROBOTS_MODEL);
		}
		return robotsModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TasksModel> getTasksModel() {
		if (tasksModel == null) {
			tasksModel = new EObjectContainmentEList<TasksModel>(TasksModel.class, this, DslPackage.PROBLEM_SPECIFICATION__TASKS_MODEL);
		}
		return tasksModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mission> getMission() {
		if (mission == null) {
			mission = new EObjectContainmentEList<Mission>(Mission.class, this, DslPackage.PROBLEM_SPECIFICATION__MISSION);
		}
		return mission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslPackage.PROBLEM_SPECIFICATION__WORLD_MODEL:
				return ((InternalEList<?>)getWorldModel()).basicRemove(otherEnd, msgs);
			case DslPackage.PROBLEM_SPECIFICATION__ROBOTS_MODEL:
				return ((InternalEList<?>)getRobotsModel()).basicRemove(otherEnd, msgs);
			case DslPackage.PROBLEM_SPECIFICATION__TASKS_MODEL:
				return ((InternalEList<?>)getTasksModel()).basicRemove(otherEnd, msgs);
			case DslPackage.PROBLEM_SPECIFICATION__MISSION:
				return ((InternalEList<?>)getMission()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.PROBLEM_SPECIFICATION__WORLD_MODEL:
				return getWorldModel();
			case DslPackage.PROBLEM_SPECIFICATION__ROBOTS_MODEL:
				return getRobotsModel();
			case DslPackage.PROBLEM_SPECIFICATION__TASKS_MODEL:
				return getTasksModel();
			case DslPackage.PROBLEM_SPECIFICATION__MISSION:
				return getMission();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DslPackage.PROBLEM_SPECIFICATION__WORLD_MODEL:
				getWorldModel().clear();
				getWorldModel().addAll((Collection<? extends WorldModel>)newValue);
				return;
			case DslPackage.PROBLEM_SPECIFICATION__ROBOTS_MODEL:
				getRobotsModel().clear();
				getRobotsModel().addAll((Collection<? extends Robot>)newValue);
				return;
			case DslPackage.PROBLEM_SPECIFICATION__TASKS_MODEL:
				getTasksModel().clear();
				getTasksModel().addAll((Collection<? extends TasksModel>)newValue);
				return;
			case DslPackage.PROBLEM_SPECIFICATION__MISSION:
				getMission().clear();
				getMission().addAll((Collection<? extends Mission>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DslPackage.PROBLEM_SPECIFICATION__WORLD_MODEL:
				getWorldModel().clear();
				return;
			case DslPackage.PROBLEM_SPECIFICATION__ROBOTS_MODEL:
				getRobotsModel().clear();
				return;
			case DslPackage.PROBLEM_SPECIFICATION__TASKS_MODEL:
				getTasksModel().clear();
				return;
			case DslPackage.PROBLEM_SPECIFICATION__MISSION:
				getMission().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DslPackage.PROBLEM_SPECIFICATION__WORLD_MODEL:
				return worldModel != null && !worldModel.isEmpty();
			case DslPackage.PROBLEM_SPECIFICATION__ROBOTS_MODEL:
				return robotsModel != null && !robotsModel.isEmpty();
			case DslPackage.PROBLEM_SPECIFICATION__TASKS_MODEL:
				return tasksModel != null && !tasksModel.isEmpty();
			case DslPackage.PROBLEM_SPECIFICATION__MISSION:
				return mission != null && !mission.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProblemSpecificationImpl
