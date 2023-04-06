/**
 */
package dsl.tests;

import dsl.CompTaskAllLoc;
import dsl.DslFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Comp Task All Loc</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompTaskAllLocTest extends ConstraintsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CompTaskAllLocTest.class);
	}

	/**
	 * Constructs a new Comp Task All Loc test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompTaskAllLocTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Comp Task All Loc test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CompTaskAllLoc getFixture() {
		return (CompTaskAllLoc)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DslFactory.eINSTANCE.createCompTaskAllLoc());
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

} //CompTaskAllLocTest
