/**
 */
package dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Closest</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.Closest#getAt <em>At</em>}</li>
 *   <li>{@link dsl.Closest#getCt <em>Ct</em>}</li>
 *   <li>{@link dsl.Closest#getMt <em>Mt</em>}</li>
 *   <li>{@link dsl.Closest#getAll <em>All</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getClosest()
 * @model
 * @generated
 */
public interface Closest extends Constraints {
	/**
	 * Returns the value of the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At</em>' reference.
	 * @see #setAt(AtomicTask)
	 * @see dsl.DslPackage#getClosest_At()
	 * @model
	 * @generated
	 */
	AtomicTask getAt();

	/**
	 * Sets the value of the '{@link dsl.Closest#getAt <em>At</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At</em>' reference.
	 * @see #getAt()
	 * @generated
	 */
	void setAt(AtomicTask value);

	/**
	 * Returns the value of the '<em><b>Ct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ct</em>' reference.
	 * @see #setCt(CompoundTask)
	 * @see dsl.DslPackage#getClosest_Ct()
	 * @model
	 * @generated
	 */
	CompoundTask getCt();

	/**
	 * Sets the value of the '{@link dsl.Closest#getCt <em>Ct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ct</em>' reference.
	 * @see #getCt()
	 * @generated
	 */
	void setCt(CompoundTask value);

	/**
	 * Returns the value of the '<em><b>Mt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mt</em>' reference.
	 * @see #setMt(MissionTask)
	 * @see dsl.DslPackage#getClosest_Mt()
	 * @model
	 * @generated
	 */
	MissionTask getMt();

	/**
	 * Sets the value of the '{@link dsl.Closest#getMt <em>Mt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mt</em>' reference.
	 * @see #getMt()
	 * @generated
	 */
	void setMt(MissionTask value);

	/**
	 * Returns the value of the '<em><b>All</b></em>' attribute.
	 * The default value is <code>"all"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All</em>' attribute.
	 * @see #setAll(String)
	 * @see dsl.DslPackage#getClosest_All()
	 * @model default="all"
	 * @generated
	 */
	String getAll();

	/**
	 * Sets the value of the '{@link dsl.Closest#getAll <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All</em>' attribute.
	 * @see #getAll()
	 * @generated
	 */
	void setAll(String value);

} // Closest
