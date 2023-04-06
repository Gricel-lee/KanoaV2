/**
 */
package dsl.tests;

import dsl.DslFactory;
import dsl.SpaceXYRobot;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Space XY Robot</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpaceXYRobotTest extends ConstraintsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpaceXYRobotTest.class);
	}

	/**
	 * Constructs a new Space XY Robot test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpaceXYRobotTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Space XY Robot test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SpaceXYRobot getFixture() {
		return (SpaceXYRobot)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DslFactory.eINSTANCE.createSpaceXYRobot());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //SpaceXYRobotTest
