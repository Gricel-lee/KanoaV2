/**
 */
package dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dsl.TaskTime#getAt <em>At</em>}</li>
 *   <li>{@link dsl.TaskTime#getCt <em>Ct</em>}</li>
 *   <li>{@link dsl.TaskTime#getMt <em>Mt</em>}</li>
 *   <li>{@link dsl.TaskTime#getStartEnd <em>Start End</em>}</li>
 *   <li>{@link dsl.TaskTime#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @see dsl.DslPackage#getTaskTime()
 * @model
 * @generated
 */
public interface TaskTime extends Constraints {
	/**
	 * Returns the value of the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At</em>' reference.
	 * @see #setAt(AtomicTask)
	 * @see dsl.DslPackage#getTaskTime_At()
	 * @model
	 * @generated
	 */
	AtomicTask getAt();

	/**
	 * Sets the value of the '{@link dsl.TaskTime#getAt <em>At</em>}' reference.
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
	 * @see dsl.DslPackage#getTaskTime_Ct()
	 * @model
	 * @generated
	 */
	CompoundTask getCt();

	/**
	 * Sets the value of the '{@link dsl.TaskTime#getCt <em>Ct</em>}' reference.
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
	 * @see dsl.DslPackage#getTaskTime_Mt()
	 * @model
	 * @generated
	 */
	MissionTask getMt();

	/**
	 * Sets the value of the '{@link dsl.TaskTime#getMt <em>Mt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mt</em>' reference.
	 * @see #getMt()
	 * @generated
	 */
	void setMt(MissionTask value);

	/**
	 * Returns the value of the '<em><b>Start End</b></em>' attribute.
	 * The literals are from the enumeration {@link dsl.StartEnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start End</em>' attribute.
	 * @see dsl.StartEnd
	 * @see #setStartEnd(StartEnd)
	 * @see dsl.DslPackage#getTaskTime_StartEnd()
	 * @model required="true"
	 * @generated
	 */
	StartEnd getStartEnd();

	/**
	 * Sets the value of the '{@link dsl.TaskTime#getStartEnd <em>Start End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start End</em>' attribute.
	 * @see dsl.StartEnd
	 * @see #getStartEnd()
	 * @generated
	 */
	void setStartEnd(StartEnd value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(double)
	 * @see dsl.DslPackage#getTaskTime_Time()
	 * @model required="true"
	 * @generated
	 */
	double getTime();

	/**
	 * Sets the value of the '{@link dsl.TaskTime#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(double value);

} // TaskTime
