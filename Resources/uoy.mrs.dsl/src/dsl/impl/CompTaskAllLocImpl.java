/**
 */
package dsl.impl;

import dsl.CompTaskAllLoc;
import dsl.CompoundTask;
import dsl.DslPackage;
import dsl.Location;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Comp Task All Loc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.CompTaskAllLocImpl#getCt <em>Ct</em>}</li>
 *   <li>{@link dsl.impl.CompTaskAllLocImpl#getLoc <em>Loc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompTaskAllLocImpl extends ConstraintsImpl implements CompTaskAllLoc {
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
	 * The cached value of the '{@link #getLoc() <em>Loc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoc()
	 * @generated
	 * @ordered
	 */
	protected Location loc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompTaskAllLocImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.COMP_TASK_ALL_LOC;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.COMP_TASK_ALL_LOC__CT, oldCt, ct));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMP_TASK_ALL_LOC__CT, oldCt, ct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLoc() {
		if (loc != null && loc.eIsProxy()) {
			InternalEObject oldLoc = (InternalEObject)loc;
			loc = (Location)eResolveProxy(oldLoc);
			if (loc != oldLoc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.COMP_TASK_ALL_LOC__LOC, oldLoc, loc));
			}
		}
		return loc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location basicGetLoc() {
		return loc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoc(Location newLoc) {
		Location oldLoc = loc;
		loc = newLoc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.COMP_TASK_ALL_LOC__LOC, oldLoc, loc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.COMP_TASK_ALL_LOC__CT:
				if (resolve) return getCt();
				return basicGetCt();
			case DslPackage.COMP_TASK_ALL_LOC__LOC:
				if (resolve) return getLoc();
				return basicGetLoc();
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
			case DslPackage.COMP_TASK_ALL_LOC__CT:
				setCt((CompoundTask)newValue);
				return;
			case DslPackage.COMP_TASK_ALL_LOC__LOC:
				setLoc((Location)newValue);
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
			case DslPackage.COMP_TASK_ALL_LOC__CT:
				setCt((CompoundTask)null);
				return;
			case DslPackage.COMP_TASK_ALL_LOC__LOC:
				setLoc((Location)null);
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
			case DslPackage.COMP_TASK_ALL_LOC__CT:
				return ct != null;
			case DslPackage.COMP_TASK_ALL_LOC__LOC:
				return loc != null;
		}
		return super.eIsSet(featureID);
	}

} //CompTaskAllLocImpl
