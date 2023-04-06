/**
 */
package dsl.impl;

import dsl.AtomicTask;
import dsl.Capability;
import dsl.DslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.CapabilityImpl#getAt <em>At</em>}</li>
 *   <li>{@link dsl.impl.CapabilityImpl#getTime <em>Time</em>}</li>
 *   <li>{@link dsl.impl.CapabilityImpl#getSuccess <em>Success</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CapabilityImpl extends MinimalEObjectImpl.Container implements Capability {
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
	 * The default value of the '{@link #getSuccess() <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccess()
	 * @generated
	 * @ordered
	 */
	protected static final double SUCCESS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSuccess() <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccess()
	 * @generated
	 * @ordered
	 */
	protected double success = SUCCESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CapabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.CAPABILITY;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.CAPABILITY__AT, oldAt, at));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CAPABILITY__AT, oldAt, at));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CAPABILITY__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSuccess() {
		return success;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuccess(double newSuccess) {
		double oldSuccess = success;
		success = newSuccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CAPABILITY__SUCCESS, oldSuccess, success));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.CAPABILITY__AT:
				if (resolve) return getAt();
				return basicGetAt();
			case DslPackage.CAPABILITY__TIME:
				return getTime();
			case DslPackage.CAPABILITY__SUCCESS:
				return getSuccess();
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
			case DslPackage.CAPABILITY__AT:
				setAt((AtomicTask)newValue);
				return;
			case DslPackage.CAPABILITY__TIME:
				setTime((Double)newValue);
				return;
			case DslPackage.CAPABILITY__SUCCESS:
				setSuccess((Double)newValue);
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
			case DslPackage.CAPABILITY__AT:
				setAt((AtomicTask)null);
				return;
			case DslPackage.CAPABILITY__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case DslPackage.CAPABILITY__SUCCESS:
				setSuccess(SUCCESS_EDEFAULT);
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
			case DslPackage.CAPABILITY__AT:
				return at != null;
			case DslPackage.CAPABILITY__TIME:
				return time != TIME_EDEFAULT;
			case DslPackage.CAPABILITY__SUCCESS:
				return success != SUCCESS_EDEFAULT;
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
		result.append(", success: ");
		result.append(success);
		result.append(')');
		return result.toString();
	}

} //CapabilityImpl
