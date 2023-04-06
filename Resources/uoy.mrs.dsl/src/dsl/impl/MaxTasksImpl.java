/**
 */
package dsl.impl;

import dsl.DslPackage;
import dsl.MaxTasks;
import dsl.Robot;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Max Tasks</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.MaxTasksImpl#getRobot <em>Robot</em>}</li>
 *   <li>{@link dsl.impl.MaxTasksImpl#getAll <em>All</em>}</li>
 *   <li>{@link dsl.impl.MaxTasksImpl#getNum <em>Num</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MaxTasksImpl extends ConstraintsImpl implements MaxTasks {
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
	 * The default value of the '{@link #getNum() <em>Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNum()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNum() <em>Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNum()
	 * @generated
	 * @ordered
	 */
	protected int num = NUM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaxTasksImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.MAX_TASKS;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.MAX_TASKS__ROBOT, oldRobot, robot));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.MAX_TASKS__ROBOT, oldRobot, robot));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.MAX_TASKS__ALL, oldAll, all));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNum() {
		return num;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNum(int newNum) {
		int oldNum = num;
		num = newNum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.MAX_TASKS__NUM, oldNum, num));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.MAX_TASKS__ROBOT:
				if (resolve) return getRobot();
				return basicGetRobot();
			case DslPackage.MAX_TASKS__ALL:
				return getAll();
			case DslPackage.MAX_TASKS__NUM:
				return getNum();
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
			case DslPackage.MAX_TASKS__ROBOT:
				setRobot((Robot)newValue);
				return;
			case DslPackage.MAX_TASKS__ALL:
				setAll((String)newValue);
				return;
			case DslPackage.MAX_TASKS__NUM:
				setNum((Integer)newValue);
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
			case DslPackage.MAX_TASKS__ROBOT:
				setRobot((Robot)null);
				return;
			case DslPackage.MAX_TASKS__ALL:
				setAll(ALL_EDEFAULT);
				return;
			case DslPackage.MAX_TASKS__NUM:
				setNum(NUM_EDEFAULT);
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
			case DslPackage.MAX_TASKS__ROBOT:
				return robot != null;
			case DslPackage.MAX_TASKS__ALL:
				return ALL_EDEFAULT == null ? all != null : !ALL_EDEFAULT.equals(all);
			case DslPackage.MAX_TASKS__NUM:
				return num != NUM_EDEFAULT;
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
		result.append(", num: ");
		result.append(num);
		result.append(')');
		return result.toString();
	}

} //MaxTasksImpl
