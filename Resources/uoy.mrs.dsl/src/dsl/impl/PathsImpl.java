/**
 */
package dsl.impl;

import dsl.DslPackage;
import dsl.Location;
import dsl.Paths;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Paths</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.PathsImpl#getLoc1 <em>Loc1</em>}</li>
 *   <li>{@link dsl.impl.PathsImpl#getLoc2 <em>Loc2</em>}</li>
 *   <li>{@link dsl.impl.PathsImpl#getDistance <em>Distance</em>}</li>
 *   <li>{@link dsl.impl.PathsImpl#getSuccess <em>Success</em>}</li>
 *   <li>{@link dsl.impl.PathsImpl#getTypeDistance <em>Type Distance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PathsImpl extends WorldModelImpl implements Paths {
	/**
	 * The cached value of the '{@link #getLoc1() <em>Loc1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoc1()
	 * @generated
	 * @ordered
	 */
	protected Location loc1;

	/**
	 * The cached value of the '{@link #getLoc2() <em>Loc2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoc2()
	 * @generated
	 * @ordered
	 */
	protected Location loc2;

	/**
	 * The default value of the '{@link #getDistance() <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistance()
	 * @generated
	 * @ordered
	 */
	protected static final double DISTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDistance() <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistance()
	 * @generated
	 * @ordered
	 */
	protected double distance = DISTANCE_EDEFAULT;

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
	 * The default value of the '{@link #getTypeDistance() <em>Type Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeDistance()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_DISTANCE_EDEFAULT = "Euclidean";

	/**
	 * The cached value of the '{@link #getTypeDistance() <em>Type Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeDistance()
	 * @generated
	 * @ordered
	 */
	protected String typeDistance = TYPE_DISTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.PATHS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLoc1() {
		if (loc1 != null && loc1.eIsProxy()) {
			InternalEObject oldLoc1 = (InternalEObject)loc1;
			loc1 = (Location)eResolveProxy(oldLoc1);
			if (loc1 != oldLoc1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.PATHS__LOC1, oldLoc1, loc1));
			}
		}
		return loc1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location basicGetLoc1() {
		return loc1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoc1(Location newLoc1) {
		Location oldLoc1 = loc1;
		loc1 = newLoc1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PATHS__LOC1, oldLoc1, loc1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLoc2() {
		if (loc2 != null && loc2.eIsProxy()) {
			InternalEObject oldLoc2 = (InternalEObject)loc2;
			loc2 = (Location)eResolveProxy(oldLoc2);
			if (loc2 != oldLoc2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.PATHS__LOC2, oldLoc2, loc2));
			}
		}
		return loc2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location basicGetLoc2() {
		return loc2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoc2(Location newLoc2) {
		Location oldLoc2 = loc2;
		loc2 = newLoc2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PATHS__LOC2, oldLoc2, loc2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistance(double newDistance) {
		double oldDistance = distance;
		distance = newDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PATHS__DISTANCE, oldDistance, distance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.PATHS__SUCCESS, oldSuccess, success));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeDistance() {
		return typeDistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.PATHS__LOC1:
				if (resolve) return getLoc1();
				return basicGetLoc1();
			case DslPackage.PATHS__LOC2:
				if (resolve) return getLoc2();
				return basicGetLoc2();
			case DslPackage.PATHS__DISTANCE:
				return getDistance();
			case DslPackage.PATHS__SUCCESS:
				return getSuccess();
			case DslPackage.PATHS__TYPE_DISTANCE:
				return getTypeDistance();
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
			case DslPackage.PATHS__LOC1:
				setLoc1((Location)newValue);
				return;
			case DslPackage.PATHS__LOC2:
				setLoc2((Location)newValue);
				return;
			case DslPackage.PATHS__DISTANCE:
				setDistance((Double)newValue);
				return;
			case DslPackage.PATHS__SUCCESS:
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
			case DslPackage.PATHS__LOC1:
				setLoc1((Location)null);
				return;
			case DslPackage.PATHS__LOC2:
				setLoc2((Location)null);
				return;
			case DslPackage.PATHS__DISTANCE:
				setDistance(DISTANCE_EDEFAULT);
				return;
			case DslPackage.PATHS__SUCCESS:
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
			case DslPackage.PATHS__LOC1:
				return loc1 != null;
			case DslPackage.PATHS__LOC2:
				return loc2 != null;
			case DslPackage.PATHS__DISTANCE:
				return distance != DISTANCE_EDEFAULT;
			case DslPackage.PATHS__SUCCESS:
				return success != SUCCESS_EDEFAULT;
			case DslPackage.PATHS__TYPE_DISTANCE:
				return TYPE_DISTANCE_EDEFAULT == null ? typeDistance != null : !TYPE_DISTANCE_EDEFAULT.equals(typeDistance);
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
		result.append(" (distance: ");
		result.append(distance);
		result.append(", success: ");
		result.append(success);
		result.append(", typeDistance: ");
		result.append(typeDistance);
		result.append(')');
		return result.toString();
	}

} //PathsImpl
