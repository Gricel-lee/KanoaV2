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
{disj[capability ,  Capability-r1at3_sanit]}
fact{#r1<=1}

// ----------------CAPABILITIES:

sig r1at3_sanit extends Capability{}
{all d:do | d in at3_sanit}

fact{#r1at3_sanit<=1
} // robot capabilities appear once (if robot appears, and if capab. tasks assigned)

// ----------------ATOMIC TASKS:

abstract sig at3_sanit extends AtomicTask {}
fact{all a:at3_sanit | #do.a=1}	// number of robots needed
sig at3_sanit_0 extends at3_sanit{}
{x=1
y=0}
sig at3_sanit_1 extends at3_sanit{}
{x=2
y=0}
sig at3_sanit_2 extends at3_sanit{}
{x=3
y=0}
sig at3_sanit_3 extends at3_sanit{}
{x=4
y=0}
sig at3_sanit_4 extends at3_sanit{}
{x=5
y=0}
sig at3_sanit_5 extends at3_sanit{}
{x=6
y=0}
sig at3_sanit_6 extends at3_sanit{}
{x=7
y=0}
sig at3_sanit_7 extends at3_sanit{}
{x=8
y=0}
sig at3_sanit_8 extends at3_sanit{}
{x=9
y=0}
sig at3_sanit_9 extends at3_sanit{}
{x=10
y=0}
sig at3_sanit_10 extends at3_sanit{}
{x=11
y=0}
sig at3_sanit_11 extends at3_sanit{}
{x=12
y=0}
sig at3_sanit_12 extends at3_sanit{}
{x=13
y=0}
sig at3_sanit_13 extends at3_sanit{}
{x=14
y=0}
sig at3_sanit_14 extends at3_sanit{}
{x=15
y=0}

// ----------------PREDICATE:

pred TaskAllocation{
}

// ----------------CONSTRAINTS:


// ----------------RUN COMMAND:

run TaskAllocation for
7 Int,
1 Capability,
exactly 15 AtomicTask,
1 Robot,
exactly 1 at3_sanit_0,
exactly 1 at3_sanit_1,
exactly 1 at3_sanit_2,
exactly 1 at3_sanit_3,
exactly 1 at3_sanit_4,
exactly 1 at3_sanit_5,
exactly 1 at3_sanit_6,
exactly 1 at3_sanit_7,
exactly 1 at3_sanit_8,
exactly 1 at3_sanit_9,
exactly 1 at3_sanit_10,
exactly 1 at3_sanit_11,
exactly 1 at3_sanit_12,
exactly 1 at3_sanit_13,
exactly 1 at3_sanit_14