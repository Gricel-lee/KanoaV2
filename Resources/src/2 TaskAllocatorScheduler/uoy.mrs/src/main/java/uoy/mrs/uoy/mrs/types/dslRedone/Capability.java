/**
 */
package uoy.mrs.uoy.mrs.types.dslRedone;

//import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Capability#getAt <em>At</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Capability#getTime <em>Time</em>}</li>
 *   <li>{@link uoy.mrs.uoy.mrs.types.dslRedone.Capability#getSuccess <em>Success</em>}</li>
 * </ul>
 *
 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCapability()
 * @model
 * @generated
 */
public interface Capability{// extends EObject {
	/**
	 * Returns the value of the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At</em>' reference.
	 * @see #setAt(AtomicTask)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCapability_At()
	 * @model required="true"
	 * @generated
	 */
	AtomicTask getAt();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.Capability#getAt <em>At</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At</em>' reference.
	 * @see #getAt()
	 * @generated
	 */
	void setAt(AtomicTask value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(double)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCapability_Time()
	 * @model required="true"
	 * @generated
	 */
	double getTime();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.Capability#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(double value);

	/**
	 * Returns the value of the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Success</em>' attribute.
	 * @see #setSuccess(double)
	 * @see uoy.mrs.uoy.mrs.types.dsl.DslPackage#getCapability_Success()
	 * @model required="true"
	 * @generated
	 */
	double getSuccess();

	/**
	 * Sets the value of the '{@link uoy.mrs.uoy.mrs.types.dslRedone.Capability#getSuccess <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success</em>' attribute.
	 * @see #getSuccess()
	 * @generated
	 */
	void setSuccess(double value);

} // Capability
