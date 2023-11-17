/**
 */
package dsl.impl;

import dsl.Constraints;
import dsl.DslPackage;
import dsl.Mission;
import dsl.MissionTask;
import dsl.Objective;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.MissionImpl#getMissionTask <em>Mission Task</em>}</li>
 *   <li>{@link dsl.impl.MissionImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link dsl.impl.MissionImpl#getTime <em>Time</em>}</li>
 *   <li>{@link dsl.impl.MissionImpl#getNumAlloc <em>Num Alloc</em>}</li>
 *   <li>{@link dsl.impl.MissionImpl#getPopulation <em>Population</em>}</li>
 *   <li>{@link dsl.impl.MissionImpl#getEvaluations <em>Evaluations</em>}</li>
 *   <li>{@link dsl.impl.MissionImpl#getObj <em>Obj</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MissionImpl extends MinimalEObjectImpl.Container implements Mission {
	/**
	 * The cached value of the '{@link #getMissionTask() <em>Mission Task</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMissionTask()
	 * @generated
	 * @ordered
	 */
	protected EList<MissionTask> missionTask;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraints> constraints;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected int time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumAlloc() <em>Num Alloc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumAlloc()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_ALLOC_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumAlloc() <em>Num Alloc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumAlloc()
	 * @generated
	 * @ordered
	 */
	protected int numAlloc = NUM_ALLOC_EDEFAULT;

	/**
	 * The default value of the '{@link #getPopulation() <em>Population</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulation()
	 * @generated
	 * @ordered
	 */
	protected static final int POPULATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPopulation() <em>Population</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulation()
	 * @generated
	 * @ordered
	 */
	protected int population = POPULATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEvaluations() <em>Evaluations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluations()
	 * @generated
	 * @ordered
	 */
	protected static final int EVALUATIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEvaluations() <em>Evaluations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluations()
	 * @generated
	 * @ordered
	 */
	protected int evaluations = EVALUATIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getObj() <em>Obj</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj()
	 * @generated
	 * @ordered
	 */
	protected EList<Objective> obj;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.MISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MissionTask> getMissionTask() {
		if (missionTask == null) {
			missionTask = new EObjectContainmentEList<MissionTask>(MissionTask.class, this, DslPackage.MISSION__MISSION_TASK);
		}
		return missionTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraints> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Constraints>(Constraints.class, this, DslPackage.MISSION__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(int newTime) {
		int oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.MISSION__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumAlloc() {
		return numAlloc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumAlloc(int newNumAlloc) {
		int oldNumAlloc = numAlloc;
		numAlloc = newNumAlloc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.MISSION__NUM_ALLOC, oldNumAlloc, numAlloc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulation(int newPopulation) {
		int oldPopulation = population;
		population = newPopulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.MISSION__POPULATION, oldPopulation, population));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEvaluations() {
		return evaluations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluations(int newEvaluations) {
		int oldEvaluations = evaluations;
		evaluations = newEvaluations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.MISSION__EVALUATIONS, oldEvaluations, evaluations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Objective> getObj() {
		if (obj == null) {
			obj = new EDataTypeUniqueEList<Objective>(Objective.class, this, DslPackage.MISSION__OBJ);
		}
		return obj;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslPackage.MISSION__MISSION_TASK:
				return ((InternalEList<?>)getMissionTask()).basicRemove(otherEnd, msgs);
			case DslPackage.MISSION__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
			case DslPackage.MISSION__MISSION_TASK:
				return getMissionTask();
			case DslPackage.MISSION__CONSTRAINTS:
				return getConstraints();
			case DslPackage.MISSION__TIME:
				return getTime();
			case DslPackage.MISSION__NUM_ALLOC:
				return getNumAlloc();
			case DslPackage.MISSION__POPULATION:
				return getPopulation();
			case DslPackage.MISSION__EVALUATIONS:
				return getEvaluations();
			case DslPackage.MISSION__OBJ:
				return getObj();
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
			case DslPackage.MISSION__MISSION_TASK:
				getMissionTask().clear();
				getMissionTask().addAll((Collection<? extends MissionTask>)newValue);
				return;
			case DslPackage.MISSION__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraints>)newValue);
				return;
			case DslPackage.MISSION__TIME:
				setTime((Integer)newValue);
				return;
			case DslPackage.MISSION__NUM_ALLOC:
				setNumAlloc((Integer)newValue);
				return;
			case DslPackage.MISSION__POPULATION:
				setPopulation((Integer)newValue);
				return;
			case DslPackage.MISSION__EVALUATIONS:
				setEvaluations((Integer)newValue);
				return;
			case DslPackage.MISSION__OBJ:
				getObj().clear();
				getObj().addAll((Collection<? extends Objective>)newValue);
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
			case DslPackage.MISSION__MISSION_TASK:
				getMissionTask().clear();
				return;
			case DslPackage.MISSION__CONSTRAINTS:
				getConstraints().clear();
				return;
			case DslPackage.MISSION__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case DslPackage.MISSION__NUM_ALLOC:
				setNumAlloc(NUM_ALLOC_EDEFAULT);
				return;
			case DslPackage.MISSION__POPULATION:
				setPopulation(POPULATION_EDEFAULT);
				return;
			case DslPackage.MISSION__EVALUATIONS:
				setEvaluations(EVALUATIONS_EDEFAULT);
				return;
			case DslPackage.MISSION__OBJ:
				getObj().clear();
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
			case DslPackage.MISSION__MISSION_TASK:
				return missionTask != null && !missionTask.isEmpty();
			case DslPackage.MISSION__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case DslPackage.MISSION__TIME:
				return time != TIME_EDEFAULT;
			case DslPackage.MISSION__NUM_ALLOC:
				return numAlloc != NUM_ALLOC_EDEFAULT;
			case DslPackage.MISSION__POPULATION:
				return population != POPULATION_EDEFAULT;
			case DslPackage.MISSION__EVALUATIONS:
				return evaluations != EVALUATIONS_EDEFAULT;
			case DslPackage.MISSION__OBJ:
				return obj != null && !obj.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (time: ");
		result.append(time);
		result.append(", numAlloc: ");
		result.append(numAlloc);
		result.append(", population: ");
		result.append(population);
		result.append(", evaluations: ");
		result.append(evaluations);
		result.append(", obj: ");
		result.append(obj);
		result.append(')');
		return result.toString();
	}

} //MissionImpl
