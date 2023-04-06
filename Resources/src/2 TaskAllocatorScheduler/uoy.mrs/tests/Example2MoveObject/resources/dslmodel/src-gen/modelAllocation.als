// ----------------Initialise constraint solver-------------//
open util/integer

abstract sig Robot {
	capability: set Capability,
}

abstract sig Capability {
	do: set AtomicTask
}

abstract sig AtomicTask {
	x: one Int,
	y: one Int
}

fact{all rt: Capability | #capability.rt=1} //all Capability appearing must be assigned to a robot
fact{all r: Robot | #r.capability.do>0} //all Robots appearing must have assigned tasks
fact{all rt: Capability | #rt.do>0} // all capability appearing must have assigned tasks
fact{all r:Robot | #r<=1} // all robots appears max. once


// ----------------ROBOTS:

sig r1 extends Robot{}
{disj[capability ,  Capability-r1at1_move]}
fact{#r1<=1}
sig r5 extends Robot{}
{disj[capability ,  Capability-r5at1_move]}
fact{#r5<=1}

// ----------------CAPABILITIES:

sig r1at1_move extends Capability{}
{all d:do | d in at1_move}
sig r5at1_move extends Capability{}
{all d:do | d in at1_move}

fact{#r1at1_move<=1
#r5at1_move<=1
} // robot capabilities appear once (if robot appears, and if capab. tasks assigned)

// ----------------ATOMIC TASKS:

abstract sig at1_move extends AtomicTask {}
fact{all a:at1_move | #do.a=2}	// number of robots needed
sig at1_move_0 extends at1_move{}
{x=4
y=1}
sig at1_move_1 extends at1_move{}
{x=10
y=5}

// ----------------PREDICATE:

pred TaskAllocation{
}

// ----------------CONSTRAINTS:


// ----------------RUN COMMAND:

run TaskAllocation for
7 Int,
2 Capability,
exactly 2 AtomicTask,
exactly 2 Robot,// deploy all robots,
exactly 1 at1_move_0,
exactly 1 at1_move_1
