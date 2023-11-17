/**
 */
package dsl.impl;

import dsl.CompoundTask;
import dsl.DslPackage;
import dsl.TasksModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.CompoundTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link dsl.impl.CompoundTaskImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link dsl.impl.CompoundTaskImpl#isConsecutive <em>Consecutive</em>}</li>
 *   <li>{@link dsl.impl.CompoundTaskImpl#getCanDoTask <em>Can Do Task</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompoundTaskImpl extends TasksModelImpl implements CompoundTask {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean ordered = ORDERED_EDEFAULT;

	/**
	 * The default value of the '{@link #isConsecutive() <em>Consecutive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConsecutive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSECUTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConsecutive() <em>Consecutive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConsecutive()
	 * @generated
	 * @ordered
	 */
	protected boolean consecutive = CONSECUTIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCanDoTask() <em>Can Do Task</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCanDoTask()
	 * @generated
	 * @ordered
	 */
	protected EList<TasksModel> canDoTask;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.COMPOUND_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMPOUND_TASK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdered() {
		return ordered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrdered(boolean newOrdered) {
		boolean oldOrdered = ordered;
		ordered = newOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMPOUND_TASK__ORDERED, oldOrdered, ordered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConsecutive() {
		return consecutive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsecutive(boolean newConsecutive) {
		boolean oldConsecutive = consecutive;
		consecutive = newConsecutive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMPOUND_TASK__CONSECUTIVE, oldConsecutive, consecutive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TasksModel> getCanDoTask() {
		if (canDoTask == null) {
			canDoTask = new EObjectResolvingEList<TasksModel>(TasksModel.class, this, DslPackage.COMPOUND_TASK__CAN_DO_TASK);
		}
		return canDoTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.COMPOUND_TASK__NAME:
				return getName();
			case DslPackage.COMPOUND_TASK__ORDERED:
				return isOrdered();
			case DslPackage.COMPOUND_TASK__CONSECUTIVE:
				return isConsecutive();
			case DslPackage.COMPOUND_TASK__CAN_DO_TASK:
				return getCanDoTask();
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
			case DslPackage.COMPOUND_TASK__NAME:
				setName((String)newValue);
				return;
			case DslPackage.COMPOUND_TASK__ORDERED:
				setOrdered((Boolean)newValue);
				return;
			case DslPackage.COMPOUND_TASK__CONSECUTIVE:
				setConsecutive((Boolean)newValue);
				return;
			case DslPackage.COMPOUND_TASK__CAN_DO_TASK:
				getCanDoTask().clear();
				getCanDoTask().addAll((Collection<? extends TasksModel>)newValue);
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
			case DslPackage.COMPOUND_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DslPackage.COMPOUND_TASK__ORDERED:
				setOrdered(ORDERED_EDEFAULT);
				return;
			case DslPackage.COMPOUND_TASK__CONSECUTIVE:
				setConsecutive(CONSECUTIVE_EDEFAULT);
				return;
			case DslPackage.COMPOUND_TASK__CAN_DO_TASK:
				getCanDoTask().clear();
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
			case DslPackage.COMPOUND_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DslPackage.COMPOUND_TASK__ORDERED:
				return ordered != ORDERED_EDEFAULT;
			case DslPackage.COMPOUND_TASK__CONSECUTIVE:
				return consecutive != CONSECUTIVE_EDEFAULT;
			case DslPackage.COMPOUND_TASK__CAN_DO_TASK:
				return canDoTask != null && !canDoTask.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", ordered: ");
		result.append(ordered);
		result.append(", consecutive: ");
		result.append(consecutive);
		result.append(')');
		return result.toString();
	}

} //CompoundTaskImpl
