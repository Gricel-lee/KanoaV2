/**
 */
package dsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dsl.DslFactory
 * @model kind="package"
 * @generated
 */
public interface DslPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dsl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/dsl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dsl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DslPackage eINSTANCE = dsl.impl.DslPackageImpl.init();

	/**
	 * The meta object id for the '{@link dsl.impl.ProblemSpecificationImpl <em>Problem Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.ProblemSpecificationImpl
	 * @see dsl.impl.DslPackageImpl#getProblemSpecification()
	 * @generated
	 */
	int PROBLEM_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>World Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPECIFICATION__WORLD_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Robots Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPECIFICATION__ROBOTS_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Tasks Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPECIFICATION__TASKS_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Mission</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPECIFICATION__MISSION = 3;

	/**
	 * The feature id for the '<em><b>Add Auto Distances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPECIFICATION__ADD_AUTO_DISTANCES = 4;

	/**
	 * The number of structural features of the '<em>Problem Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPECIFICATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Problem Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dsl.impl.WorldModelImpl <em>World Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.WorldModelImpl
	 * @see dsl.impl.DslPackageImpl#getWorldModel()
	 * @generated
	 */
	int WORLD_MODEL = 1;

	/**
	 * The number of structural features of the '<em>World Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_MODEL_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>World Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dsl.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.LocationImpl
	 * @see dsl.impl.DslPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__NAME = WORLD_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__X = WORLD_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__Y = WORLD_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__DESCRIPTION = WORLD_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = WORLD_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_OPERATION_COUNT = WORLD_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.impl.PathsImpl <em>Paths</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.PathsImpl
	 * @see dsl.impl.DslPackageImpl#getPaths()
	 * @generated
	 */
	int PATHS = 3;

	/**
	 * The feature id for the '<em><b>Loc1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS__LOC1 = WORLD_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Loc2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS__LOC2 = WORLD_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS__DISTANCE = WORLD_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS__SUCCESS = WORLD_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS__TYPE_DISTANCE = WORLD_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Paths</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS_FEATURE_COUNT = WORLD_MODEL_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Paths</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATHS_OPERATION_COUNT = WORLD_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.impl.RobotImpl <em>Robot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.RobotImpl
	 * @see dsl.impl.DslPackageImpl#getRobot()
	 * @generated
	 */
	int ROBOT = 4;

	/**
	 * The feature id for the '<em><b>Init Loc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__INIT_LOC = 0;

	/**
	 * The feature id for the '<em><b>Velocity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__VELOCITY = 1;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__CAPABILITIES = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__NAME = 3;

	/**
	 * The number of structural features of the '<em>Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dsl.impl.CapabilityImpl <em>Capability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.CapabilityImpl
	 * @see dsl.impl.DslPackageImpl#getCapability()
	 * @generated
	 */
	int CAPABILITY = 5;

	/**
	 * The feature id for the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__AT = 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__TIME = 1;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__SUCCESS = 2;

	/**
	 * The number of structural features of the '<em>Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dsl.impl.TasksModelImpl <em>Tasks Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.TasksModelImpl
	 * @see dsl.impl.DslPackageImpl#getTasksModel()
	 * @generated
	 */
	int TASKS_MODEL = 6;

	/**
	 * The number of structural features of the '<em>Tasks Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKS_MODEL_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Tasks Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKS_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dsl.impl.AtomicTaskImpl <em>Atomic Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.AtomicTaskImpl
	 * @see dsl.impl.DslPackageImpl#getAtomicTask()
	 * @generated
	 */
	int ATOMIC_TASK = 7;

	/**
	 * The feature id for the '<em><b>Loc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_TASK__LOC = TASKS_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_TASK__NAME = TASKS_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Robots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_TASK__ROBOTS = TASKS_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Retry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_TASK__RETRY = TASKS_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Atomic Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_TASK_FEATURE_COUNT = TASKS_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Atomic Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_TASK_OPERATION_COUNT = TASKS_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.impl.CompoundTaskImpl <em>Compound Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.CompoundTaskImpl
	 * @see dsl.impl.DslPackageImpl#getCompoundTask()
	 * @generated
	 */
	int COMPOUND_TASK = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TASK__NAME = TASKS_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TASK__ORDERED = TASKS_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Consecutive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TASK__CONSECUTIVE = TASKS_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Can Do Task</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TASK__CAN_DO_TASK = TASKS_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Compound Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TASK_FEATURE_COUNT = TASKS_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Compound Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_TASK_OPERATION_COUNT = TASKS_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.impl.MissionImpl <em>Mission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.MissionImpl
	 * @see dsl.impl.DslPackageImpl#getMission()
	 * @generated
	 */
	int MISSION = 9;

	/**
	 * The feature id for the '<em><b>Mission Task</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__MISSION_TASK = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__CONSTRAINTS = 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__TIME = 2;

	/**
	 * The feature id for the '<em><b>Num Alloc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__NUM_ALLOC = 3;

	/**
	 * The feature id for the '<em><b>Population</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__POPULATION = 4;

	/**
	 * The feature id for the '<em><b>Evaluations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__EVALUATIONS = 5;

	/**
	 * The feature id for the '<em><b>Obj</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__OBJ = 6;

	/**
	 * The number of structural features of the '<em>Mission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Mission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dsl.impl.MissionTaskImpl <em>Mission Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.MissionTaskImpl
	 * @see dsl.impl.DslPackageImpl#getMissionTask()
	 * @generated
	 */
	int MISSION_TASK = 10;

	/**
	 * The feature id for the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TASK__AT = 0;

	/**
	 * The feature id for the '<em><b>Ct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TASK__CT = 1;

	/**
	 * The feature id for the '<em><b>Loc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TASK__LOC = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TASK__NAME = 3;

	/**
	 * The number of structural features of the '<em>Mission Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TASK_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Mission Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_TASK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dsl.impl.ConstraintsImpl <em>Constraints</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.ConstraintsImpl
	 * @see dsl.impl.DslPackageImpl#getConstraints()
	 * @generated
	 */
	int CONSTRAINTS = 11;

	/**
	 * The number of structural features of the '<em>Constraints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Constraints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dsl.impl.RateSuccImpl <em>Rate Succ</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.RateSuccImpl
	 * @see dsl.impl.DslPackageImpl#getRateSucc()
	 * @generated
	 */
	int RATE_SUCC = 12;

	/**
	 * The feature id for the '<em><b>Rate Succ</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATE_SUCC__RATE_SUCC = CONSTRAINTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rate Succ</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATE_SUCC_FEATURE_COUNT = CONSTRAINTS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rate Succ</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATE_SUCC_OPERATION_COUNT = CONSTRAINTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.impl.SpaceXYRobotImpl <em>Space XY Robot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.SpaceXYRobotImpl
	 * @see dsl.impl.DslPackageImpl#getSpaceXYRobot()
	 * @generated
	 */
	int SPACE_XY_ROBOT = 13;

	/**
	 * The feature id for the '<em><b>Coordinate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_XY_ROBOT__COORDINATE = CONSTRAINTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Greater</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_XY_ROBOT__LOWER_GREATER = CONSTRAINTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_XY_ROBOT__VAL = CONSTRAINTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Robot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_XY_ROBOT__ROBOT = CONSTRAINTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Allrobots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_XY_ROBOT__ALLROBOTS = CONSTRAINTS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Space XY Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_XY_ROBOT_FEATURE_COUNT = CONSTRAINTS_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Space XY Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_XY_ROBOT_OPERATION_COUNT = CONSTRAINTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.impl.TaskTimeImpl <em>Task Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.TaskTimeImpl
	 * @see dsl.impl.DslPackageImpl#getTaskTime()
	 * @generated
	 */
	int TASK_TIME = 14;

	/**
	 * The feature id for the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TIME__AT = CONSTRAINTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TIME__CT = CONSTRAINTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TIME__MT = CONSTRAINTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Start End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TIME__START_END = CONSTRAINTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TIME__TIME = CONSTRAINTS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Task Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TIME_FEATURE_COUNT = CONSTRAINTS_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Task Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TIME_OPERATION_COUNT = CONSTRAINTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.impl.AllocateTImpl <em>Allocate T</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.AllocateTImpl
	 * @see dsl.impl.DslPackageImpl#getAllocateT()
	 * @generated
	 */
	int ALLOCATE_T = 15;

	/**
	 * The feature id for the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_T__AT = CONSTRAINTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_T__CT = CONSTRAINTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_T__MT = CONSTRAINTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Robot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_T__ROBOT = CONSTRAINTS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Allocate T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_T_FEATURE_COUNT = CONSTRAINTS_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Allocate T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_T_OPERATION_COUNT = CONSTRAINTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.impl.ClosestImpl <em>Closest</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.ClosestImpl
	 * @see dsl.impl.DslPackageImpl#getClosest()
	 * @generated
	 */
	int CLOSEST = 16;

	/**
	 * The feature id for the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEST__AT = CONSTRAINTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEST__CT = CONSTRAINTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEST__MT = CONSTRAINTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEST__ALL = CONSTRAINTS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Closest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEST_FEATURE_COUNT = CONSTRAINTS_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Closest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEST_OPERATION_COUNT = CONSTRAINTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.impl.MaxTasksImpl <em>Max Tasks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.impl.MaxTasksImpl
	 * @see dsl.impl.DslPackageImpl#getMaxTasks()
	 * @generated
	 */
	int MAX_TASKS = 17;

	/**
	 * The feature id for the '<em><b>Robot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_TASKS__ROBOT = CONSTRAINTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_TASKS__ALL = CONSTRAINTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_TASKS__NUM = CONSTRAINTS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Max Tasks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_TASKS_FEATURE_COUNT = CONSTRAINTS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Max Tasks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_TASKS_OPERATION_COUNT = CONSTRAINTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dsl.Objective <em>Objective</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.Objective
	 * @see dsl.impl.DslPackageImpl#getObjective()
	 * @generated
	 */
	int OBJECTIVE = 18;

	/**
	 * The meta object id for the '{@link dsl.XY <em>XY</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.XY
	 * @see dsl.impl.DslPackageImpl#getXY()
	 * @generated
	 */
	int XY = 19;

	/**
	 * The meta object id for the '{@link dsl.LowerGreater <em>Lower Greater</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.LowerGreater
	 * @see dsl.impl.DslPackageImpl#getLowerGreater()
	 * @generated
	 */
	int LOWER_GREATER = 20;

	/**
	 * The meta object id for the '{@link dsl.StartEnd <em>Start End</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dsl.StartEnd
	 * @see dsl.impl.DslPackageImpl#getStartEnd()
	 * @generated
	 */
	int START_END = 21;


	/**
	 * Returns the meta object for class '{@link dsl.ProblemSpecification <em>Problem Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem Specification</em>'.
	 * @see dsl.ProblemSpecification
	 * @generated
	 */
	EClass getProblemSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link dsl.ProblemSpecification#getWorldModel <em>World Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>World Model</em>'.
	 * @see dsl.ProblemSpecification#getWorldModel()
	 * @see #getProblemSpecification()
	 * @generated
	 */
	EReference getProblemSpecification_WorldModel();

	/**
	 * Returns the meta object for the containment reference list '{@link dsl.ProblemSpecification#getRobotsModel <em>Robots Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Robots Model</em>'.
	 * @see dsl.ProblemSpecification#getRobotsModel()
	 * @see #getProblemSpecification()
	 * @generated
	 */
	EReference getProblemSpecification_RobotsModel();

	/**
	 * Returns the meta object for the containment reference list '{@link dsl.ProblemSpecification#getTasksModel <em>Tasks Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks Model</em>'.
	 * @see dsl.ProblemSpecification#getTasksModel()
	 * @see #getProblemSpecification()
	 * @generated
	 */
	EReference getProblemSpecification_TasksModel();

	/**
	 * Returns the meta object for the containment reference list '{@link dsl.ProblemSpecification#getMission <em>Mission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mission</em>'.
	 * @see dsl.ProblemSpecification#getMission()
	 * @see #getProblemSpecification()
	 * @generated
	 */
	EReference getProblemSpecification_Mission();

	/**
	 * Returns the meta object for the attribute '{@link dsl.ProblemSpecification#getAddAutoDistances <em>Add Auto Distances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Auto Distances</em>'.
	 * @see dsl.ProblemSpecification#getAddAutoDistances()
	 * @see #getProblemSpecification()
	 * @generated
	 */
	EAttribute getProblemSpecification_AddAutoDistances();

	/**
	 * Returns the meta object for class '{@link dsl.WorldModel <em>World Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>World Model</em>'.
	 * @see dsl.WorldModel
	 * @generated
	 */
	EClass getWorldModel();

	/**
	 * Returns the meta object for class '{@link dsl.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see dsl.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Location#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dsl.Location#getName()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Name();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Location#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see dsl.Location#getX()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_X();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Location#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see dsl.Location#getY()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Y();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Location#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see dsl.Location#getDescription()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Description();

	/**
	 * Returns the meta object for class '{@link dsl.Paths <em>Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paths</em>'.
	 * @see dsl.Paths
	 * @generated
	 */
	EClass getPaths();

	/**
	 * Returns the meta object for the reference '{@link dsl.Paths#getLoc1 <em>Loc1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loc1</em>'.
	 * @see dsl.Paths#getLoc1()
	 * @see #getPaths()
	 * @generated
	 */
	EReference getPaths_Loc1();

	/**
	 * Returns the meta object for the reference '{@link dsl.Paths#getLoc2 <em>Loc2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loc2</em>'.
	 * @see dsl.Paths#getLoc2()
	 * @see #getPaths()
	 * @generated
	 */
	EReference getPaths_Loc2();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Paths#getDistance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance</em>'.
	 * @see dsl.Paths#getDistance()
	 * @see #getPaths()
	 * @generated
	 */
	EAttribute getPaths_Distance();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Paths#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see dsl.Paths#getSuccess()
	 * @see #getPaths()
	 * @generated
	 */
	EAttribute getPaths_Success();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Paths#getTypeDistance <em>Type Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Distance</em>'.
	 * @see dsl.Paths#getTypeDistance()
	 * @see #getPaths()
	 * @generated
	 */
	EAttribute getPaths_TypeDistance();

	/**
	 * Returns the meta object for class '{@link dsl.Robot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Robot</em>'.
	 * @see dsl.Robot
	 * @generated
	 */
	EClass getRobot();

	/**
	 * Returns the meta object for the reference '{@link dsl.Robot#getInitLoc <em>Init Loc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Init Loc</em>'.
	 * @see dsl.Robot#getInitLoc()
	 * @see #getRobot()
	 * @generated
	 */
	EReference getRobot_InitLoc();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Robot#getVelocity <em>Velocity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Velocity</em>'.
	 * @see dsl.Robot#getVelocity()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Velocity();

	/**
	 * Returns the meta object for the containment reference list '{@link dsl.Robot#getCapabilities <em>Capabilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Capabilities</em>'.
	 * @see dsl.Robot#getCapabilities()
	 * @see #getRobot()
	 * @generated
	 */
	EReference getRobot_Capabilities();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Robot#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dsl.Robot#getName()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Name();

	/**
	 * Returns the meta object for class '{@link dsl.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capability</em>'.
	 * @see dsl.Capability
	 * @generated
	 */
	EClass getCapability();

	/**
	 * Returns the meta object for the reference '{@link dsl.Capability#getAt <em>At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>At</em>'.
	 * @see dsl.Capability#getAt()
	 * @see #getCapability()
	 * @generated
	 */
	EReference getCapability_At();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Capability#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see dsl.Capability#getTime()
	 * @see #getCapability()
	 * @generated
	 */
	EAttribute getCapability_Time();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Capability#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see dsl.Capability#getSuccess()
	 * @see #getCapability()
	 * @generated
	 */
	EAttribute getCapability_Success();

	/**
	 * Returns the meta object for class '{@link dsl.TasksModel <em>Tasks Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tasks Model</em>'.
	 * @see dsl.TasksModel
	 * @generated
	 */
	EClass getTasksModel();

	/**
	 * Returns the meta object for class '{@link dsl.AtomicTask <em>Atomic Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Task</em>'.
	 * @see dsl.AtomicTask
	 * @generated
	 */
	EClass getAtomicTask();

	/**
	 * Returns the meta object for the reference '{@link dsl.AtomicTask#getLoc <em>Loc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loc</em>'.
	 * @see dsl.AtomicTask#getLoc()
	 * @see #getAtomicTask()
	 * @generated
	 */
	EReference getAtomicTask_Loc();

	/**
	 * Returns the meta object for the attribute '{@link dsl.AtomicTask#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dsl.AtomicTask#getName()
	 * @see #getAtomicTask()
	 * @generated
	 */
	EAttribute getAtomicTask_Name();

	/**
	 * Returns the meta object for the attribute '{@link dsl.AtomicTask#getRobots <em>Robots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Robots</em>'.
	 * @see dsl.AtomicTask#getRobots()
	 * @see #getAtomicTask()
	 * @generated
	 */
	EAttribute getAtomicTask_Robots();

	/**
	 * Returns the meta object for the attribute '{@link dsl.AtomicTask#getRetry <em>Retry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Retry</em>'.
	 * @see dsl.AtomicTask#getRetry()
	 * @see #getAtomicTask()
	 * @generated
	 */
	EAttribute getAtomicTask_Retry();

	/**
	 * Returns the meta object for class '{@link dsl.CompoundTask <em>Compound Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Task</em>'.
	 * @see dsl.CompoundTask
	 * @generated
	 */
	EClass getCompoundTask();

	/**
	 * Returns the meta object for the attribute '{@link dsl.CompoundTask#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dsl.CompoundTask#getName()
	 * @see #getCompoundTask()
	 * @generated
	 */
	EAttribute getCompoundTask_Name();

	/**
	 * Returns the meta object for the attribute '{@link dsl.CompoundTask#isOrdered <em>Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordered</em>'.
	 * @see dsl.CompoundTask#isOrdered()
	 * @see #getCompoundTask()
	 * @generated
	 */
	EAttribute getCompoundTask_Ordered();

	/**
	 * Returns the meta object for the attribute '{@link dsl.CompoundTask#isConsecutive <em>Consecutive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consecutive</em>'.
	 * @see dsl.CompoundTask#isConsecutive()
	 * @see #getCompoundTask()
	 * @generated
	 */
	EAttribute getCompoundTask_Consecutive();

	/**
	 * Returns the meta object for the reference list '{@link dsl.CompoundTask#getCanDoTask <em>Can Do Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Can Do Task</em>'.
	 * @see dsl.CompoundTask#getCanDoTask()
	 * @see #getCompoundTask()
	 * @generated
	 */
	EReference getCompoundTask_CanDoTask();

	/**
	 * Returns the meta object for class '{@link dsl.Mission <em>Mission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mission</em>'.
	 * @see dsl.Mission
	 * @generated
	 */
	EClass getMission();

	/**
	 * Returns the meta object for the containment reference list '{@link dsl.Mission#getMissionTask <em>Mission Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mission Task</em>'.
	 * @see dsl.Mission#getMissionTask()
	 * @see #getMission()
	 * @generated
	 */
	EReference getMission_MissionTask();

	/**
	 * Returns the meta object for the containment reference list '{@link dsl.Mission#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see dsl.Mission#getConstraints()
	 * @see #getMission()
	 * @generated
	 */
	EReference getMission_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Mission#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see dsl.Mission#getTime()
	 * @see #getMission()
	 * @generated
	 */
	EAttribute getMission_Time();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Mission#getNumAlloc <em>Num Alloc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Alloc</em>'.
	 * @see dsl.Mission#getNumAlloc()
	 * @see #getMission()
	 * @generated
	 */
	EAttribute getMission_NumAlloc();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Mission#getPopulation <em>Population</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population</em>'.
	 * @see dsl.Mission#getPopulation()
	 * @see #getMission()
	 * @generated
	 */
	EAttribute getMission_Population();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Mission#getEvaluations <em>Evaluations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Evaluations</em>'.
	 * @see dsl.Mission#getEvaluations()
	 * @see #getMission()
	 * @generated
	 */
	EAttribute getMission_Evaluations();

	/**
	 * Returns the meta object for the attribute list '{@link dsl.Mission#getObj <em>Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Obj</em>'.
	 * @see dsl.Mission#getObj()
	 * @see #getMission()
	 * @generated
	 */
	EAttribute getMission_Obj();

	/**
	 * Returns the meta object for class '{@link dsl.MissionTask <em>Mission Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mission Task</em>'.
	 * @see dsl.MissionTask
	 * @generated
	 */
	EClass getMissionTask();

	/**
	 * Returns the meta object for the reference '{@link dsl.MissionTask#getAt <em>At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>At</em>'.
	 * @see dsl.MissionTask#getAt()
	 * @see #getMissionTask()
	 * @generated
	 */
	EReference getMissionTask_At();

	/**
	 * Returns the meta object for the reference '{@link dsl.MissionTask#getCt <em>Ct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ct</em>'.
	 * @see dsl.MissionTask#getCt()
	 * @see #getMissionTask()
	 * @generated
	 */
	EReference getMissionTask_Ct();

	/**
	 * Returns the meta object for the reference '{@link dsl.MissionTask#getLoc <em>Loc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loc</em>'.
	 * @see dsl.MissionTask#getLoc()
	 * @see #getMissionTask()
	 * @generated
	 */
	EReference getMissionTask_Loc();

	/**
	 * Returns the meta object for the attribute '{@link dsl.MissionTask#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dsl.MissionTask#getName()
	 * @see #getMissionTask()
	 * @generated
	 */
	EAttribute getMissionTask_Name();

	/**
	 * Returns the meta object for class '{@link dsl.Constraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraints</em>'.
	 * @see dsl.Constraints
	 * @generated
	 */
	EClass getConstraints();

	/**
	 * Returns the meta object for class '{@link dsl.RateSucc <em>Rate Succ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rate Succ</em>'.
	 * @see dsl.RateSucc
	 * @generated
	 */
	EClass getRateSucc();

	/**
	 * Returns the meta object for the attribute '{@link dsl.RateSucc#getRateSucc <em>Rate Succ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate Succ</em>'.
	 * @see dsl.RateSucc#getRateSucc()
	 * @see #getRateSucc()
	 * @generated
	 */
	EAttribute getRateSucc_RateSucc();

	/**
	 * Returns the meta object for class '{@link dsl.SpaceXYRobot <em>Space XY Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Space XY Robot</em>'.
	 * @see dsl.SpaceXYRobot
	 * @generated
	 */
	EClass getSpaceXYRobot();

	/**
	 * Returns the meta object for the attribute '{@link dsl.SpaceXYRobot#getCoordinate <em>Coordinate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coordinate</em>'.
	 * @see dsl.SpaceXYRobot#getCoordinate()
	 * @see #getSpaceXYRobot()
	 * @generated
	 */
	EAttribute getSpaceXYRobot_Coordinate();

	/**
	 * Returns the meta object for the attribute '{@link dsl.SpaceXYRobot#getLowerGreater <em>Lower Greater</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Greater</em>'.
	 * @see dsl.SpaceXYRobot#getLowerGreater()
	 * @see #getSpaceXYRobot()
	 * @generated
	 */
	EAttribute getSpaceXYRobot_LowerGreater();

	/**
	 * Returns the meta object for the attribute '{@link dsl.SpaceXYRobot#getVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see dsl.SpaceXYRobot#getVal()
	 * @see #getSpaceXYRobot()
	 * @generated
	 */
	EAttribute getSpaceXYRobot_Val();

	/**
	 * Returns the meta object for the reference '{@link dsl.SpaceXYRobot#getRobot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Robot</em>'.
	 * @see dsl.SpaceXYRobot#getRobot()
	 * @see #getSpaceXYRobot()
	 * @generated
	 */
	EReference getSpaceXYRobot_Robot();

	/**
	 * Returns the meta object for the attribute '{@link dsl.SpaceXYRobot#getAllrobots <em>Allrobots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allrobots</em>'.
	 * @see dsl.SpaceXYRobot#getAllrobots()
	 * @see #getSpaceXYRobot()
	 * @generated
	 */
	EAttribute getSpaceXYRobot_Allrobots();

	/**
	 * Returns the meta object for class '{@link dsl.TaskTime <em>Task Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Time</em>'.
	 * @see dsl.TaskTime
	 * @generated
	 */
	EClass getTaskTime();

	/**
	 * Returns the meta object for the reference '{@link dsl.TaskTime#getAt <em>At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>At</em>'.
	 * @see dsl.TaskTime#getAt()
	 * @see #getTaskTime()
	 * @generated
	 */
	EReference getTaskTime_At();

	/**
	 * Returns the meta object for the reference '{@link dsl.TaskTime#getCt <em>Ct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ct</em>'.
	 * @see dsl.TaskTime#getCt()
	 * @see #getTaskTime()
	 * @generated
	 */
	EReference getTaskTime_Ct();

	/**
	 * Returns the meta object for the reference '{@link dsl.TaskTime#getMt <em>Mt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mt</em>'.
	 * @see dsl.TaskTime#getMt()
	 * @see #getTaskTime()
	 * @generated
	 */
	EReference getTaskTime_Mt();

	/**
	 * Returns the meta object for the attribute '{@link dsl.TaskTime#getStartEnd <em>Start End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start End</em>'.
	 * @see dsl.TaskTime#getStartEnd()
	 * @see #getTaskTime()
	 * @generated
	 */
	EAttribute getTaskTime_StartEnd();

	/**
	 * Returns the meta object for the attribute '{@link dsl.TaskTime#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see dsl.TaskTime#getTime()
	 * @see #getTaskTime()
	 * @generated
	 */
	EAttribute getTaskTime_Time();

	/**
	 * Returns the meta object for class '{@link dsl.AllocateT <em>Allocate T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocate T</em>'.
	 * @see dsl.AllocateT
	 * @generated
	 */
	EClass getAllocateT();

	/**
	 * Returns the meta object for the reference '{@link dsl.AllocateT#getAt <em>At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>At</em>'.
	 * @see dsl.AllocateT#getAt()
	 * @see #getAllocateT()
	 * @generated
	 */
	EReference getAllocateT_At();

	/**
	 * Returns the meta object for the reference '{@link dsl.AllocateT#getCt <em>Ct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ct</em>'.
	 * @see dsl.AllocateT#getCt()
	 * @see #getAllocateT()
	 * @generated
	 */
	EReference getAllocateT_Ct();

	/**
	 * Returns the meta object for the reference '{@link dsl.AllocateT#getMt <em>Mt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mt</em>'.
	 * @see dsl.AllocateT#getMt()
	 * @see #getAllocateT()
	 * @generated
	 */
	EReference getAllocateT_Mt();

	/**
	 * Returns the meta object for the reference '{@link dsl.AllocateT#getRobot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Robot</em>'.
	 * @see dsl.AllocateT#getRobot()
	 * @see #getAllocateT()
	 * @generated
	 */
	EReference getAllocateT_Robot();

	/**
	 * Returns the meta object for class '{@link dsl.Closest <em>Closest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Closest</em>'.
	 * @see dsl.Closest
	 * @generated
	 */
	EClass getClosest();

	/**
	 * Returns the meta object for the reference '{@link dsl.Closest#getAt <em>At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>At</em>'.
	 * @see dsl.Closest#getAt()
	 * @see #getClosest()
	 * @generated
	 */
	EReference getClosest_At();

	/**
	 * Returns the meta object for the reference '{@link dsl.Closest#getCt <em>Ct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ct</em>'.
	 * @see dsl.Closest#getCt()
	 * @see #getClosest()
	 * @generated
	 */
	EReference getClosest_Ct();

	/**
	 * Returns the meta object for the reference '{@link dsl.Closest#getMt <em>Mt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mt</em>'.
	 * @see dsl.Closest#getMt()
	 * @see #getClosest()
	 * @generated
	 */
	EReference getClosest_Mt();

	/**
	 * Returns the meta object for the attribute '{@link dsl.Closest#getAll <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All</em>'.
	 * @see dsl.Closest#getAll()
	 * @see #getClosest()
	 * @generated
	 */
	EAttribute getClosest_All();

	/**
	 * Returns the meta object for class '{@link dsl.MaxTasks <em>Max Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Max Tasks</em>'.
	 * @see dsl.MaxTasks
	 * @generated
	 */
	EClass getMaxTasks();

	/**
	 * Returns the meta object for the reference '{@link dsl.MaxTasks#getRobot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Robot</em>'.
	 * @see dsl.MaxTasks#getRobot()
	 * @see #getMaxTasks()
	 * @generated
	 */
	EReference getMaxTasks_Robot();

	/**
	 * Returns the meta object for the attribute '{@link dsl.MaxTasks#getAll <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All</em>'.
	 * @see dsl.MaxTasks#getAll()
	 * @see #getMaxTasks()
	 * @generated
	 */
	EAttribute getMaxTasks_All();

	/**
	 * Returns the meta object for the attribute '{@link dsl.MaxTasks#getNum <em>Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num</em>'.
	 * @see dsl.MaxTasks#getNum()
	 * @see #getMaxTasks()
	 * @generated
	 */
	EAttribute getMaxTasks_Num();

	/**
	 * Returns the meta object for enum '{@link dsl.Objective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Objective</em>'.
	 * @see dsl.Objective
	 * @generated
	 */
	EEnum getObjective();

	/**
	 * Returns the meta object for enum '{@link dsl.XY <em>XY</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>XY</em>'.
	 * @see dsl.XY
	 * @generated
	 */
	EEnum getXY();

	/**
	 * Returns the meta object for enum '{@link dsl.LowerGreater <em>Lower Greater</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Lower Greater</em>'.
	 * @see dsl.LowerGreater
	 * @generated
	 */
	EEnum getLowerGreater();

	/**
	 * Returns the meta object for enum '{@link dsl.StartEnd <em>Start End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Start End</em>'.
	 * @see dsl.StartEnd
	 * @generated
	 */
	EEnum getStartEnd();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DslFactory getDslFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dsl.impl.ProblemSpecificationImpl <em>Problem Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.ProblemSpecificationImpl
		 * @see dsl.impl.DslPackageImpl#getProblemSpecification()
		 * @generated
		 */
		EClass PROBLEM_SPECIFICATION = eINSTANCE.getProblemSpecification();

		/**
		 * The meta object literal for the '<em><b>World Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_SPECIFICATION__WORLD_MODEL = eINSTANCE.getProblemSpecification_WorldModel();

		/**
		 * The meta object literal for the '<em><b>Robots Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_SPECIFICATION__ROBOTS_MODEL = eINSTANCE.getProblemSpecification_RobotsModel();

		/**
		 * The meta object literal for the '<em><b>Tasks Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_SPECIFICATION__TASKS_MODEL = eINSTANCE.getProblemSpecification_TasksModel();

		/**
		 * The meta object literal for the '<em><b>Mission</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_SPECIFICATION__MISSION = eINSTANCE.getProblemSpecification_Mission();

		/**
		 * The meta object literal for the '<em><b>Add Auto Distances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM_SPECIFICATION__ADD_AUTO_DISTANCES = eINSTANCE.getProblemSpecification_AddAutoDistances();

		/**
		 * The meta object literal for the '{@link dsl.impl.WorldModelImpl <em>World Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.WorldModelImpl
		 * @see dsl.impl.DslPackageImpl#getWorldModel()
		 * @generated
		 */
		EClass WORLD_MODEL = eINSTANCE.getWorldModel();

		/**
		 * The meta object literal for the '{@link dsl.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.LocationImpl
		 * @see dsl.impl.DslPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__NAME = eINSTANCE.getLocation_Name();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__X = eINSTANCE.getLocation_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__Y = eINSTANCE.getLocation_Y();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__DESCRIPTION = eINSTANCE.getLocation_Description();

		/**
		 * The meta object literal for the '{@link dsl.impl.PathsImpl <em>Paths</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.PathsImpl
		 * @see dsl.impl.DslPackageImpl#getPaths()
		 * @generated
		 */
		EClass PATHS = eINSTANCE.getPaths();

		/**
		 * The meta object literal for the '<em><b>Loc1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATHS__LOC1 = eINSTANCE.getPaths_Loc1();

		/**
		 * The meta object literal for the '<em><b>Loc2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATHS__LOC2 = eINSTANCE.getPaths_Loc2();

		/**
		 * The meta object literal for the '<em><b>Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATHS__DISTANCE = eINSTANCE.getPaths_Distance();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATHS__SUCCESS = eINSTANCE.getPaths_Success();

		/**
		 * The meta object literal for the '<em><b>Type Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATHS__TYPE_DISTANCE = eINSTANCE.getPaths_TypeDistance();

		/**
		 * The meta object literal for the '{@link dsl.impl.RobotImpl <em>Robot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.RobotImpl
		 * @see dsl.impl.DslPackageImpl#getRobot()
		 * @generated
		 */
		EClass ROBOT = eINSTANCE.getRobot();

		/**
		 * The meta object literal for the '<em><b>Init Loc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOT__INIT_LOC = eINSTANCE.getRobot_InitLoc();

		/**
		 * The meta object literal for the '<em><b>Velocity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOT__VELOCITY = eINSTANCE.getRobot_Velocity();

		/**
		 * The meta object literal for the '<em><b>Capabilities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOT__CAPABILITIES = eINSTANCE.getRobot_Capabilities();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOT__NAME = eINSTANCE.getRobot_Name();

		/**
		 * The meta object literal for the '{@link dsl.impl.CapabilityImpl <em>Capability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.CapabilityImpl
		 * @see dsl.impl.DslPackageImpl#getCapability()
		 * @generated
		 */
		EClass CAPABILITY = eINSTANCE.getCapability();

		/**
		 * The meta object literal for the '<em><b>At</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPABILITY__AT = eINSTANCE.getCapability_At();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPABILITY__TIME = eINSTANCE.getCapability_Time();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPABILITY__SUCCESS = eINSTANCE.getCapability_Success();

		/**
		 * The meta object literal for the '{@link dsl.impl.TasksModelImpl <em>Tasks Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.TasksModelImpl
		 * @see dsl.impl.DslPackageImpl#getTasksModel()
		 * @generated
		 */
		EClass TASKS_MODEL = eINSTANCE.getTasksModel();

		/**
		 * The meta object literal for the '{@link dsl.impl.AtomicTaskImpl <em>Atomic Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.AtomicTaskImpl
		 * @see dsl.impl.DslPackageImpl#getAtomicTask()
		 * @generated
		 */
		EClass ATOMIC_TASK = eINSTANCE.getAtomicTask();

		/**
		 * The meta object literal for the '<em><b>Loc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOMIC_TASK__LOC = eINSTANCE.getAtomicTask_Loc();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOMIC_TASK__NAME = eINSTANCE.getAtomicTask_Name();

		/**
		 * The meta object literal for the '<em><b>Robots</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOMIC_TASK__ROBOTS = eINSTANCE.getAtomicTask_Robots();

		/**
		 * The meta object literal for the '<em><b>Retry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOMIC_TASK__RETRY = eINSTANCE.getAtomicTask_Retry();

		/**
		 * The meta object literal for the '{@link dsl.impl.CompoundTaskImpl <em>Compound Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.CompoundTaskImpl
		 * @see dsl.impl.DslPackageImpl#getCompoundTask()
		 * @generated
		 */
		EClass COMPOUND_TASK = eINSTANCE.getCompoundTask();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOUND_TASK__NAME = eINSTANCE.getCompoundTask_Name();

		/**
		 * The meta object literal for the '<em><b>Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOUND_TASK__ORDERED = eINSTANCE.getCompoundTask_Ordered();

		/**
		 * The meta object literal for the '<em><b>Consecutive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOUND_TASK__CONSECUTIVE = eINSTANCE.getCompoundTask_Consecutive();

		/**
		 * The meta object literal for the '<em><b>Can Do Task</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_TASK__CAN_DO_TASK = eINSTANCE.getCompoundTask_CanDoTask();

		/**
		 * The meta object literal for the '{@link dsl.impl.MissionImpl <em>Mission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.MissionImpl
		 * @see dsl.impl.DslPackageImpl#getMission()
		 * @generated
		 */
		EClass MISSION = eINSTANCE.getMission();

		/**
		 * The meta object literal for the '<em><b>Mission Task</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISSION__MISSION_TASK = eINSTANCE.getMission_MissionTask();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISSION__CONSTRAINTS = eINSTANCE.getMission_Constraints();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION__TIME = eINSTANCE.getMission_Time();

		/**
		 * The meta object literal for the '<em><b>Num Alloc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION__NUM_ALLOC = eINSTANCE.getMission_NumAlloc();

		/**
		 * The meta object literal for the '<em><b>Population</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION__POPULATION = eINSTANCE.getMission_Population();

		/**
		 * The meta object literal for the '<em><b>Evaluations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION__EVALUATIONS = eINSTANCE.getMission_Evaluations();

		/**
		 * The meta object literal for the '<em><b>Obj</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION__OBJ = eINSTANCE.getMission_Obj();

		/**
		 * The meta object literal for the '{@link dsl.impl.MissionTaskImpl <em>Mission Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.MissionTaskImpl
		 * @see dsl.impl.DslPackageImpl#getMissionTask()
		 * @generated
		 */
		EClass MISSION_TASK = eINSTANCE.getMissionTask();

		/**
		 * The meta object literal for the '<em><b>At</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISSION_TASK__AT = eINSTANCE.getMissionTask_At();

		/**
		 * The meta object literal for the '<em><b>Ct</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISSION_TASK__CT = eINSTANCE.getMissionTask_Ct();

		/**
		 * The meta object literal for the '<em><b>Loc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISSION_TASK__LOC = eINSTANCE.getMissionTask_Loc();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MISSION_TASK__NAME = eINSTANCE.getMissionTask_Name();

		/**
		 * The meta object literal for the '{@link dsl.impl.ConstraintsImpl <em>Constraints</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.ConstraintsImpl
		 * @see dsl.impl.DslPackageImpl#getConstraints()
		 * @generated
		 */
		EClass CONSTRAINTS = eINSTANCE.getConstraints();

		/**
		 * The meta object literal for the '{@link dsl.impl.RateSuccImpl <em>Rate Succ</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.RateSuccImpl
		 * @see dsl.impl.DslPackageImpl#getRateSucc()
		 * @generated
		 */
		EClass RATE_SUCC = eINSTANCE.getRateSucc();

		/**
		 * The meta object literal for the '<em><b>Rate Succ</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RATE_SUCC__RATE_SUCC = eINSTANCE.getRateSucc_RateSucc();

		/**
		 * The meta object literal for the '{@link dsl.impl.SpaceXYRobotImpl <em>Space XY Robot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.SpaceXYRobotImpl
		 * @see dsl.impl.DslPackageImpl#getSpaceXYRobot()
		 * @generated
		 */
		EClass SPACE_XY_ROBOT = eINSTANCE.getSpaceXYRobot();

		/**
		 * The meta object literal for the '<em><b>Coordinate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPACE_XY_ROBOT__COORDINATE = eINSTANCE.getSpaceXYRobot_Coordinate();

		/**
		 * The meta object literal for the '<em><b>Lower Greater</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPACE_XY_ROBOT__LOWER_GREATER = eINSTANCE.getSpaceXYRobot_LowerGreater();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPACE_XY_ROBOT__VAL = eINSTANCE.getSpaceXYRobot_Val();

		/**
		 * The meta object literal for the '<em><b>Robot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE_XY_ROBOT__ROBOT = eINSTANCE.getSpaceXYRobot_Robot();

		/**
		 * The meta object literal for the '<em><b>Allrobots</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPACE_XY_ROBOT__ALLROBOTS = eINSTANCE.getSpaceXYRobot_Allrobots();

		/**
		 * The meta object literal for the '{@link dsl.impl.TaskTimeImpl <em>Task Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.TaskTimeImpl
		 * @see dsl.impl.DslPackageImpl#getTaskTime()
		 * @generated
		 */
		EClass TASK_TIME = eINSTANCE.getTaskTime();

		/**
		 * The meta object literal for the '<em><b>At</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_TIME__AT = eINSTANCE.getTaskTime_At();

		/**
		 * The meta object literal for the '<em><b>Ct</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_TIME__CT = eINSTANCE.getTaskTime_Ct();

		/**
		 * The meta object literal for the '<em><b>Mt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_TIME__MT = eINSTANCE.getTaskTime_Mt();

		/**
		 * The meta object literal for the '<em><b>Start End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_TIME__START_END = eINSTANCE.getTaskTime_StartEnd();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_TIME__TIME = eINSTANCE.getTaskTime_Time();

		/**
		 * The meta object literal for the '{@link dsl.impl.AllocateTImpl <em>Allocate T</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.AllocateTImpl
		 * @see dsl.impl.DslPackageImpl#getAllocateT()
		 * @generated
		 */
		EClass ALLOCATE_T = eINSTANCE.getAllocateT();

		/**
		 * The meta object literal for the '<em><b>At</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATE_T__AT = eINSTANCE.getAllocateT_At();

		/**
		 * The meta object literal for the '<em><b>Ct</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATE_T__CT = eINSTANCE.getAllocateT_Ct();

		/**
		 * The meta object literal for the '<em><b>Mt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATE_T__MT = eINSTANCE.getAllocateT_Mt();

		/**
		 * The meta object literal for the '<em><b>Robot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATE_T__ROBOT = eINSTANCE.getAllocateT_Robot();

		/**
		 * The meta object literal for the '{@link dsl.impl.ClosestImpl <em>Closest</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.ClosestImpl
		 * @see dsl.impl.DslPackageImpl#getClosest()
		 * @generated
		 */
		EClass CLOSEST = eINSTANCE.getClosest();

		/**
		 * The meta object literal for the '<em><b>At</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOSEST__AT = eINSTANCE.getClosest_At();

		/**
		 * The meta object literal for the '<em><b>Ct</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOSEST__CT = eINSTANCE.getClosest_Ct();

		/**
		 * The meta object literal for the '<em><b>Mt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOSEST__MT = eINSTANCE.getClosest_Mt();

		/**
		 * The meta object literal for the '<em><b>All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSEST__ALL = eINSTANCE.getClosest_All();

		/**
		 * The meta object literal for the '{@link dsl.impl.MaxTasksImpl <em>Max Tasks</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.impl.MaxTasksImpl
		 * @see dsl.impl.DslPackageImpl#getMaxTasks()
		 * @generated
		 */
		EClass MAX_TASKS = eINSTANCE.getMaxTasks();

		/**
		 * The meta object literal for the '<em><b>Robot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAX_TASKS__ROBOT = eINSTANCE.getMaxTasks_Robot();

		/**
		 * The meta object literal for the '<em><b>All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAX_TASKS__ALL = eINSTANCE.getMaxTasks_All();

		/**
		 * The meta object literal for the '<em><b>Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAX_TASKS__NUM = eINSTANCE.getMaxTasks_Num();

		/**
		 * The meta object literal for the '{@link dsl.Objective <em>Objective</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.Objective
		 * @see dsl.impl.DslPackageImpl#getObjective()
		 * @generated
		 */
		EEnum OBJECTIVE = eINSTANCE.getObjective();

		/**
		 * The meta object literal for the '{@link dsl.XY <em>XY</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.XY
		 * @see dsl.impl.DslPackageImpl#getXY()
		 * @generated
		 */
		EEnum XY = eINSTANCE.getXY();

		/**
		 * The meta object literal for the '{@link dsl.LowerGreater <em>Lower Greater</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.LowerGreater
		 * @see dsl.impl.DslPackageImpl#getLowerGreater()
		 * @generated
		 */
		EEnum LOWER_GREATER = eINSTANCE.getLowerGreater();

		/**
		 * The meta object literal for the '{@link dsl.StartEnd <em>Start End</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dsl.StartEnd
		 * @see dsl.impl.DslPackageImpl#getStartEnd()
		 * @generated
		 */
		EEnum START_END = eINSTANCE.getStartEnd();

	}

} //DslPackage
