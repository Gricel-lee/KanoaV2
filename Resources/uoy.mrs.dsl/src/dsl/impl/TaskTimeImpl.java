/**
 */
package dsl.impl;

import dsl.AtomicTask;
import dsl.CompoundTask;
import dsl.DslPackage;
import dsl.MissionTask;
import dsl.StartEnd;
import dsl.TaskTime;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.TaskTimeImpl#getAt <em>At</em>}</li>
 *   <li>{@link dsl.impl.TaskTimeImpl#getCt <em>Ct</em>}</li>
 *   <li>{@link dsl.impl.TaskTimeImpl#getMt <em>Mt</em>}</li>
 *   <li>{@link dsl.impl.TaskTimeImpl#getStartEnd <em>Start End</em>}</li>
 *   <li>{@link dsl.impl.TaskTimeImpl#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaskTimeImpl extends ConstraintsImpl implements TaskTime {
	/**
	 * The cached value of the '{@link #getAt() <em>At</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAt()
	 * @generated
	 * @ordered
	 */
	protected AtomicTask at;

	/**
	 * The cached value of the '{@link #getCt() <em>Ct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCt()
	 * @generated
	 * @ordered
	 */
	protected CompoundTask ct;

	/**
	 * The cached value of the '{@link #getMt() <em>Mt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMt()
	 * @generated
	 * @ordered
	 */
	protected MissionTask mt;

	/**
	 * The default value of the '{@link #getStartEnd() <em>Start End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartEnd()
	 * @generated
	 * @ordered
	 */
	protected static final StartEnd START_END_EDEFAULT = StartEnd.END;

	/**
	 * The cached value of the '{@link #getStartEnd() <em>Start End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartEnd()
	 * @generated
	 * @ordered
	 */
	protected StartEnd startEnd = START_END_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final double TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected double time = TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.TASK_TIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicTask getAt() {
		if (at != null && at.eIsProxy()) {
			InternalEObject oldAt = (InternalEObject)at;
			at = (AtomicTask)eResolveProxy(oldAt);
			if (at != oldAt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.TASK_TIME__AT, oldAt, at));
			}
		}
		return at;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicTask basicGetAt() {
		return at;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAt(AtomicTask newAt) {
		AtomicTask oldAt = at;
		at = newAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TASK_TIME__AT, oldAt, at));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundTask getCt() {
		if (ct != null && ct.eIsProxy()) {
			InternalEObject oldCt = (InternalEObject)ct;
			ct = (CompoundTask)eResolveProxy(oldCt);
			if (ct != oldCt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.TASK_TIME__CT, oldCt, ct));
			}
		}
		return ct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundTask basicGetCt() {
		return ct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCt(CompoundTask newCt) {
		CompoundTask oldCt = ct;
		ct = newCt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TASK_TIME__CT, oldCt, ct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MissionTask getMt() {
		if (mt != null && mt.eIsProxy()) {
			InternalEObject oldMt = (InternalEObject)mt;
			mt = (MissionTask)eResolveProxy(oldMt);
			if (mt != oldMt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.TASK_TIME__MT, oldMt, mt));
			}
		}
		return mt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MissionTask basicGetMt() {
		return mt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMt(MissionTask newMt) {
		MissionTask oldMt = mt;
		mt = newMt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TASK_TIME__MT, oldMt, mt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartEnd getStartEnd() {
		return startEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartEnd(StartEnd newStartEnd) {
		StartEnd oldStartEnd = startEnd;
		startEnd = newStartEnd == null ? START_END_EDEFAULT : newStartEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TASK_TIME__START_END, oldStartEnd, startEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(double newTime) {
		double oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TASK_TIME__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.TASK_TIME__AT:
				if (resolve) return getAt();
				return basicGetAt();
			case DslPackage.TASK_TIME__CT:
				if (resolve) return getCt();
				return basicGetCt();
			case DslPackage.TASK_TIME__MT:
				if (resolve) return getMt();
				return basicGetMt();
			case DslPackage.TASK_TIME__START_END:
				return getStartEnd();
			case DslPackage.TASK_TIME__TIME:
				return getTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DslPackage.TASK_TIME__AT:
				setAt((AtomicTask)newValue);
				return;
			case DslPackage.TASK_TIME__CT:
				setCt((CompoundTask)newValue);
				return;
			case DslPackage.TASK_TIME__MT:
				setMt((MissionTask)newValue);
				return;
			case DslPackage.TASK_TIME__START_END:
				setStartEnd((StartEnd)newValue);
				return;
			case DslPackage.TASK_TIME__TIME:
				setTime((Double)newValue);
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
			case DslPackage.TASK_TIME__AT:
				setAt((AtomicTask)null);
				return;
			case DslPackage.TASK_TIME__CT:
				setCt((CompoundTask)null);
				return;
			case DslPackage.TASK_TIME__MT:
				setMt((MissionTask)null);
				return;
			case DslPackage.TASK_TIME__START_END:
				setStartEnd(START_END_EDEFAULT);
				return;
			case DslPackage.TASK_TIME__TIME:
				setTime(TIME_EDEFAULT);
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
			case DslPackage.TASK_TIME__AT:
				return at != null;
			case DslPackage.TASK_TIME__CT:
				return ct != null;
			case DslPackage.TASK_TIME__MT:
				return mt != null;
			case DslPackage.TASK_TIME__START_END:
				return startEnd != START_END_EDEFAULT;
			case DslPackage.TASK_TIME__TIME:
				return time != TIME_EDEFAULT;
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
		result.append(" (startEnd: ");
		result.append(startEnd);
		result.append(", time: ");
		result.append(time);
		result.append(')');
		return result.toString();
	}

} //TaskTimeImpl
