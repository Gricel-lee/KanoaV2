/**
 */
package dsl.impl;

import dsl.DslPackage;
import dsl.RateSucc;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rate Succ</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.RateSuccImpl#getRateSucc <em>Rate Succ</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RateSuccImpl extends ConstraintsImpl implements RateSucc {
	/**
	 * The default value of the '{@link #getRateSucc() <em>Rate Succ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRateSucc()
	 * @generated
	 * @ordered
	 */
	protected static final double RATE_SUCC_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRateSucc() <em>Rate Succ</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRateSucc()
	 * @generated
	 * @ordered
	 */
	protected double rateSucc = RATE_SUCC_EDEFAULT;

	/**
	 * This is true if the Rate Succ attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean rateSuccESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RateSuccImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.RATE_SUCC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRateSucc() {
		return rateSucc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRateSucc(double newRateSucc) {
		double oldRateSucc = rateSucc;
		rateSucc = newRateSucc;
		boolean oldRateSuccESet = rateSuccESet;
		rateSuccESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.RATE_SUCC__RATE_SUCC, oldRateSucc, rateSucc, !oldRateSuccESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRateSucc() {
		double oldRateSucc = rateSucc;
		boolean oldRateSuccESet = rateSuccESet;
		rateSucc = RATE_SUCC_EDEFAULT;
		rateSuccESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, DslPackage.RATE_SUCC__RATE_SUCC, oldRateSucc, RATE_SUCC_EDEFAULT, oldRateSuccESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRateSucc() {
		return rateSuccESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.RATE_SUCC__RATE_SUCC:
				return getRateSucc();
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
			case DslPackage.RATE_SUCC__RATE_SUCC:
				setRateSucc((Double)newValue);
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
			case DslPackage.RATE_SUCC__RATE_SUCC:
				unsetRateSucc();
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
			case DslPackage.RATE_SUCC__RATE_SUCC:
				return isSetRateSucc();
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
		result.append(" (rateSucc: ");
		if (rateSuccESet) result.append(rateSucc); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //RateSuccImpl
