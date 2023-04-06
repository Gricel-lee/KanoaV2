/**
 */
package dsl.impl;

import dsl.AtomicTask;
import dsl.Closest;
import dsl.CompoundTask;
import dsl.DslPackage;
import dsl.MissionTask;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Closest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.ClosestImpl#getAt <em>At</em>}</li>
 *   <li>{@link dsl.impl.ClosestImpl#getCt <em>Ct</em>}</li>
 *   <li>{@link dsl.impl.ClosestImpl#getMt <em>Mt</em>}</li>
 *   <li>{@link dsl.impl.ClosestImpl#getAll <em>All</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClosestImpl extends ConstraintsImpl implements Closest {
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
	 * The default value of the '{@link #getAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAll()
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_EDEFAULT = "all";

	/**
	 * The cached value of the '{@link #getAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAll()
	 * @generated
	 * @ordered
	 */
	protected String all = ALL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClosestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.CLOSEST;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.CLOSEST__AT, oldAt, at));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CLOSEST__AT, oldAt, at));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.CLOSEST__CT, oldCt, ct));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CLOSEST__CT, oldCt, ct));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.CLOSEST__MT, oldMt, mt));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CLOSEST__MT, oldMt, mt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAll() {
		return all;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAll(String newAll) {
		String oldAll = all;
		all = newAll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CLOSEST__ALL, oldAll, all));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.CLOSEST__AT:
				if (resolve) return getAt();
				return basicGetAt();
			case DslPackage.CLOSEST__CT:
				if (resolve) return getCt();
				return basicGetCt();
			case DslPackage.CLOSEST__MT:
				if (resolve) return getMt();
				return basicGetMt();
			case DslPackage.CLOSEST__ALL:
				return getAll();
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
			case DslPackage.CLOSEST__AT:
				setAt((AtomicTask)newValue);
				return;
			case DslPackage.CLOSEST__CT:
				setCt((CompoundTask)newValue);
				return;
			case DslPackage.CLOSEST__MT:
				setMt((MissionTask)newValue);
				return;
			case DslPackage.CLOSEST__ALL:
				setAll((String)newValue);
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
			case DslPackage.CLOSEST__AT:
				setAt((AtomicTask)null);
				return;
			case DslPackage.CLOSEST__CT:
				setCt((CompoundTask)null);
				return;
			case DslPackage.CLOSEST__MT:
				setMt((MissionTask)null);
				return;
			case DslPackage.CLOSEST__ALL:
				setAll(ALL_EDEFAULT);
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
			case DslPackage.CLOSEST__AT:
				return at != null;
			case DslPackage.CLOSEST__CT:
				return ct != null;
			case DslPackage.CLOSEST__MT:
				return mt != null;
			case DslPackage.CLOSEST__ALL:
				return ALL_EDEFAULT == null ? all != null : !ALL_EDEFAULT.equals(all);
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
		result.append(" (all: ");
		result.append(all);
		result.append(')');
		return result.toString();
	}

} //ClosestImpl
