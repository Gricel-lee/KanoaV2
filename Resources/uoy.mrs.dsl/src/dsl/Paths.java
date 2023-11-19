/**
 */
package dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paths</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.Paths#getLoc1 <em>Loc1</em>}</li>
 *   <li>{@link dsl.Paths#getLoc2 <em>Loc2</em>}</li>
 *   <li>{@link dsl.Paths#getDistance <em>Distance</em>}</li>
 *   <li>{@link dsl.Paths#getSuccess <em>Success</em>}</li>
 *   <li>{@link dsl.Paths#getTypeDistance <em>Type Distance</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getPaths()
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
	 * @see dsl.DslPackage#getPaths_Loc1()
	 * @model required="true"
	 * @generated
	 */
	Location getLoc1();

	/**
	 * Sets the value of the '{@link dsl.Paths#getLoc1 <em>Loc1</em>}' reference.
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
	 * @see dsl.DslPackage#getPaths_Loc2()
	 * @model required="true"
	 * @generated
	 */
	Location getLoc2();

	/**
	 * Sets the value of the '{@link dsl.Paths#getLoc2 <em>Loc2</em>}' reference.
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
	 * @see dsl.DslPackage#getPaths_Distance()
	 * @model required="true"
	 * @generated
	 */
	double getDistance();

	/**
	 * Sets the value of the '{@link dsl.Paths#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' attribute.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(double value);

	/**
	 * Returns the value of the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Success</em>' attribute.
	 * @see #setSuccess(double)
	 * @see dsl.DslPackage#getPaths_Success()
	 * @model required="true"
	 * @generated
	 */
	double getSuccess();

	/**
	 * Sets the value of the '{@link dsl.Paths#getSuccess <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success</em>' attribute.
	 * @see #getSuccess()
	 * @generated
	 */
	void setSuccess(double value);

	/**
	 * Returns the value of the '<em><b>Type Distance</b></em>' attribute.
	 * The default value is <code>"Euclidean"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Distance</em>' attribute.
	 * @see dsl.DslPackage#getPaths_TypeDistance()
	 * @model default="Euclidean" changeable="false"
	 * @generated
	 */
	String getTypeDistance();

} // Paths
