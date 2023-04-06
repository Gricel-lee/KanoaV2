/**
 */
package dsl.impl;

import dsl.DslPackage;
import dsl.LowerGreater;
import dsl.Robot;
import dsl.SpaceXYRobot;
import dsl.XY;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Space XY Robot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dsl.impl.SpaceXYRobotImpl#getCoordinate <em>Coordinate</em>}</li>
 *   <li>{@link dsl.impl.SpaceXYRobotImpl#getLowerGreater <em>Lower Greater</em>}</li>
 *   <li>{@link dsl.impl.SpaceXYRobotImpl#getVal <em>Val</em>}</li>
 *   <li>{@link dsl.impl.SpaceXYRobotImpl#getRobot <em>Robot</em>}</li>
 *   <li>{@link dsl.impl.SpaceXYRobotImpl#getAllrobots <em>Allrobots</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpaceXYRobotImpl extends ConstraintsImpl implements SpaceXYRobot {
	/**
	 * The default value of the '{@link #getCoordinate() <em>Coordinate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinate()
	 * @generated
	 * @ordered
	 */
	protected static final XY COORDINATE_EDEFAULT = XY.X;

	/**
	 * The cached value of the '{@link #getCoordinate() <em>Coordinate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinate()
	 * @generated
	 * @ordered
	 */
	protected XY coordinate = COORDINATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowerGreater() <em>Lower Greater</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerGreater()
	 * @generated
	 * @ordered
	 */
	protected static final LowerGreater LOWER_GREATER_EDEFAULT = LowerGreater.LOWER;

	/**
	 * The cached value of the '{@link #getLowerGreater() <em>Lower Greater</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerGreater()
	 * @generated
	 * @ordered
	 */
	protected LowerGreater lowerGreater = LOWER_GREATER_EDEFAULT;

	/**
	 * The default value of the '{@link #getVal() <em>Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVal()
	 * @generated
	 * @ordered
	 */
	protected static final double VAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVal() <em>Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVal()
	 * @generated
	 * @ordered
	 */
	protected double val = VAL_EDEFAULT;

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
	 * The default value of the '{@link #getAllrobots() <em>Allrobots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllrobots()
	 * @generated
	 * @ordered
	 */
	protected static final String ALLROBOTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAllrobots() <em>Allrobots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllrobots()
	 * @generated
	 * @ordered
	 */
	protected String allrobots = ALLROBOTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpaceXYRobotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslPackage.Literals.SPACE_XY_ROBOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XY getCoordinate() {
		return coordinate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoordinate(XY newCoordinate) {
		XY oldCoordinate = coordinate;
		coordinate = newCoordinate == null ? COORDINATE_EDEFAULT : newCoordinate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SPACE_XY_ROBOT__COORDINATE, oldCoordinate, coordinate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LowerGreater getLowerGreater() {
		return lowerGreater;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerGreater(LowerGreater newLowerGreater) {
		LowerGreater oldLowerGreater = lowerGreater;
		lowerGreater = newLowerGreater == null ? LOWER_GREATER_EDEFAULT : newLowerGreater;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SPACE_XY_ROBOT__LOWER_GREATER, oldLowerGreater, lowerGreater));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVal() {
		return val;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVal(double newVal) {
		double oldVal = val;
		val = newVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SPACE_XY_ROBOT__VAL, oldVal, val));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.SPACE_XY_ROBOT__ROBOT, oldRobot, robot));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SPACE_XY_ROBOT__ROBOT, oldRobot, robot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAllrobots() {
		return allrobots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllrobots(String newAllrobots) {
		String oldAllrobots = allrobots;
		allrobots = newAllrobots;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SPACE_XY_ROBOT__ALLROBOTS, oldAllrobots, allrobots));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DslPackage.SPACE_XY_ROBOT__COORDINATE:
				return getCoordinate();
			case DslPackage.SPACE_XY_ROBOT__LOWER_GREATER:
				return getLowerGreater();
			case DslPackage.SPACE_XY_ROBOT__VAL:
				return getVal();
			case DslPackage.SPACE_XY_ROBOT__ROBOT:
				if (resolve) return getRobot();
				return basicGetRobot();
			case DslPackage.SPACE_XY_ROBOT__ALLROBOTS:
				return getAllrobots();
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
			case DslPackage.SPACE_XY_ROBOT__COORDINATE:
				setCoordinate((XY)newValue);
				return;
			case DslPackage.SPACE_XY_ROBOT__LOWER_GREATER:
				setLowerGreater((LowerGreater)newValue);
				return;
			case DslPackage.SPACE_XY_ROBOT__VAL:
				setVal((Double)newValue);
				return;
			case DslPackage.SPACE_XY_ROBOT__ROBOT:
				setRobot((Robot)newValue);
				return;
			case DslPackage.SPACE_XY_ROBOT__ALLROBOTS:
				setAllrobots((String)newValue);
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
			case DslPackage.SPACE_XY_ROBOT__COORDINATE:
				setCoordinate(COORDINATE_EDEFAULT);
				return;
			case DslPackage.SPACE_XY_ROBOT__LOWER_GREATER:
				setLowerGreater(LOWER_GREATER_EDEFAULT);
				return;
			case DslPackage.SPACE_XY_ROBOT__VAL:
				setVal(VAL_EDEFAULT);
				return;
			case DslPackage.SPACE_XY_ROBOT__ROBOT:
				setRobot((Robot)null);
				return;
			case DslPackage.SPACE_XY_ROBOT__ALLROBOTS:
				setAllrobots(ALLROBOTS_EDEFAULT);
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
			case DslPackage.SPACE_XY_ROBOT__COORDINATE:
				return coordinate != COORDINATE_EDEFAULT;
			case DslPackage.SPACE_XY_ROBOT__LOWER_GREATER:
				return lowerGreater != LOWER_GREATER_EDEFAULT;
			case DslPackage.SPACE_XY_ROBOT__VAL:
				return val != VAL_EDEFAULT;
			case DslPackage.SPACE_XY_ROBOT__ROBOT:
				return robot != null;
			case DslPackage.SPACE_XY_ROBOT__ALLROBOTS:
				return ALLROBOTS_EDEFAULT == null ? allrobots != null : !ALLROBOTS_EDEFAULT.equals(allrobots);
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
		result.append(" (coordinate: ");
		result.append(coordinate);
		result.append(", lowerGreater: ");
		result.append(lowerGreater);
		result.append(", val: ");
		result.append(val);
		result.append(", allrobots: ");
		result.append(allrobots);
		result.append(')');
		return result.toString();
	}

} //SpaceXYRobotImpl
