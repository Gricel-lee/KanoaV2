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
sig r2 extends Robot{}
{disj[capability ,  Capability-r2at1_move]}
fact{#r2<=1}

// ----------------CAPABILITIES:

sig r1at1_move extends Capability{}
{all d:do | d in at1_move}
sig r2at1_move extends Capability{}
{all d:do | d in at1_move}

fact{#r1at1_move<=1
#r2at1_move<=1
} // robot capabilities appear once (if robot appears, and if capab. tasks assigned)

// ----------------ATOMIC TASKS:

abstract sig at1_move extends AtomicTask {}
fact{all a:at1_move | #do.a=2}	// number of robots needed
sig at1_move_0 extends at1_move{}
{x=1
y=1}
sig at1_move_1 extends at1_move{}
{x=2
y=1}
sig at1_move_2 extends at1_move{}
{x=3
y=1}
sig at1_move_3 extends at1_move{}
{x=4
y=1}
sig at1_move_4 extends at1_move{}
{x=5
y=1}

// ----------------PREDICATE:

pred TaskAllocation{
}

// ----------------CONSTRAINTS:


// ----------------RUN COMMAND:

run TaskAllocation for
7 Int,
2 Capability,
exactly 5 AtomicTask,
2 Robot,
exactly 1 at1_move_0,
exactly 1 at1_move_1,
exactly 1 at1_move_2,
exactly 1 at1_move_3,
exactly 1 at1_move_4