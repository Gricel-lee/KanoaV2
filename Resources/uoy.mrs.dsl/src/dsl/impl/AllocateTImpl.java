/**
 */
package dsl.impl;

import dsl.AllocateT;
import dsl.AtomicTask;
import dsl.CompoundTask;
import dsl.DslPackage;
import dsl.MissionTask;
import dsl.Robot;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocate T</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.AllocateTImpl#getAt <em>At</em>}</li>
 *   <li>{@link dsl.impl.AllocateTImpl#getCt <em>Ct</em>}</li>
 *   <li>{@link dsl.impl.AllocateTImpl#getMt <em>Mt</em>}</li>
 *   <li>{@link dsl.impl.AllocateTImpl#getRobot <em>Robot</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AllocateTImpl extends ConstraintsImpl implements AllocateT {
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
	 * The cached value of the '{@link #getRobot() <em>Robot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRobot()
	 * @generated
	 * @ordered
	 */
	protected Robot robot;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocateTImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.ALLOCATE_T;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.ALLOCATE_T__AT, oldAt, at));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.ALLOCATE_T__AT, oldAt, at));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.ALLOCATE_T__CT, oldCt, ct));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.ALLOCATE_T__CT, oldCt, ct));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.ALLOCATE_T__MT, oldMt, mt));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.ALLOCATE_T__MT, oldMt, mt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Robot getRobot() {
		if (robot != null && robot.eIsProxy()) {
			InternalEObject oldRobot = (InternalEObject)robot;
			robot = (Robot)eResolveProxy(oldRobot);
			if (robot != oldRobot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.ALLOCATE_T__ROBOT, oldRobot, robot));
			}
		}
		return robot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Robot basicGetRobot() {
		return robot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRobot(Robot newRobot) {
		Robot oldRobot = robot;
		robot = newRobot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.ALLOCATE_T__ROBOT, oldRobot, robot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.ALLOCATE_T__AT:
				if (resolve) return getAt();
				return basicGetAt();
			case DslPackage.ALLOCATE_T__CT:
				if (resolve) return getCt();
				return basicGetCt();
			case DslPackage.ALLOCATE_T__MT:
				if (resolve) return getMt();
				return basicGetMt();
			case DslPackage.ALLOCATE_T__ROBOT:
				if (resolve) return getRobot();
				return basicGetRobot();
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
			case DslPackage.ALLOCATE_T__AT:
				setAt((AtomicTask)newValue);
				return;
			case DslPackage.ALLOCATE_T__CT:
				setCt((CompoundTask)newValue);
				return;
			case DslPackage.ALLOCATE_T__MT:
				setMt((MissionTask)newValue);
				return;
			case DslPackage.ALLOCATE_T__ROBOT:
				setRobot((Robot)newValue);
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
			case DslPackage.ALLOCATE_T__AT:
				setAt((AtomicTask)null);
				return;
			case DslPackage.ALLOCATE_T__CT:
				setCt((CompoundTask)null);
				return;
			case DslPackage.ALLOCATE_T__MT:
				setMt((MissionTask)null);
				return;
			case DslPackage.ALLOCATE_T__ROBOT:
				setRobot((Robot)null);
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
			case DslPackage.ALLOCATE_T__AT:
				return at != null;
			case DslPackage.ALLOCATE_T__CT:
				return ct != null;
			case DslPackage.ALLOCATE_T__MT:
				return mt != null;
			case DslPackage.ALLOCATE_T__ROBOT:
				return robot != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocateTImpl
