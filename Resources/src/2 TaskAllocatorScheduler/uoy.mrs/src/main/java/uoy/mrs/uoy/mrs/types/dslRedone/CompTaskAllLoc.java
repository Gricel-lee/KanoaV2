/**
 */
package uoy.mrs.uoy.mrs.types.dslRedone;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comp Task All Loc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.CompTaskAllLoc#getCt <em>Ct</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.CompTaskAllLoc#getLoc <em>Loc</em>}</li>
 * </ul>
 *
 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCompTaskAllLoc()
 * @model
 * @generated
 */
public interface CompTaskAllLoc extends Constraints {
	/**
	 * Returns the value of the '<em><b>Ct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ct</em>' reference.
	 * @see #setCt(CompoundTask)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCompTaskAllLoc_Ct()
	 * @model required="true"
	 * @generated
	 */
	CompoundTask getCt();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.CompTaskAllLoc#getCt <em>Ct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ct</em>' reference.
	 * @see #getCt()
	 * @generated
	 */
	void setCt(CompoundTask value);

	/**
	 * Returns the value of the '<em><b>Loc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loc</em>' reference.
	 * @see #setLoc(Location)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCompTaskAllLoc_Loc()
	 * @model
	 * @generated
	 */
	Location getLoc();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.CompTaskAllLoc#getLoc <em>Loc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loc</em>' reference.
	 * @see #getLoc()
	 * @generated
	 */
	void setLoc(Location value);

} // CompTaskAllLoc
