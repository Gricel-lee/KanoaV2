/**
 */
package uoy.mrs.uoy.mrs.types.dslRedone;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paths</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Paths#getLoc1 <em>Loc1</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Paths#getLoc2 <em>Loc2</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Paths#getDistance <em>Distance</em>}</li>
 * </ul>
 *
 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getPaths()
 * @model
 * @generated
 */
public interface Paths extends WorldModel {
	/**
	 * Returns the value of the '<em><b>Loc1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loc1</em>' reference.
	 * @see #setLoc1(Location)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getPaths_Loc1()
	 * @model required="true"
	 * @generated
	 */
	Location getLoc1();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.Paths#getLoc1 <em>Loc1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loc1</em>' reference.
	 * @see #getLoc1()
	 * @generated
	 */
	void setLoc1(Location value);

	/**
	 * Returns the value of the '<em><b>Loc2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loc2</em>' reference.
	 * @see #setLoc2(Location)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getPaths_Loc2()
	 * @model required="true"
	 * @generated
	 */
	Location getLoc2();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.Paths#getLoc2 <em>Loc2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loc2</em>' reference.
	 * @see #getLoc2()
	 * @generated
	 */
	void setLoc2(Location value);

	/**
	 * Returns the value of the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance</em>' attribute.
	 * @see #setDistance(double)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getPaths_Distance()
	 * @model required="true"
	 * @generated
	 */
	double getDistance();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.Paths#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' attribute.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(double value);

} // Paths
