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

fact{all c: Capability | #capability.c=1} //all Capability appearing must be assigned to a robot
fact{all r: Robot | #r.capability.do>0} //all Robots appearing must have assigned tasks
fact{all c: Capability | #c.do>0} // all capability appearing must have assigned tasks
fact{all r:Robot | #r<=1} // all robots appears max. once

// ----------------ROBOTS:

lone sig r6 extends Robot{}
{disj[capability ,  Capability-r6at6]}

// ----------------CAPABILITIES:

lone sig r6at6 extends Capability{}
{all d:do | d in at6}

// ----------------ATOMIC TASKS:

abstract sig at6 extends AtomicTask {}
fact{all a:at6 | #do.a=1}	// number of robots needed
one sig at6_9 extends at6{} {x=2 y=3}
one sig at6_8 extends at6{} {x=2 y=3}
one sig at6_7 extends at6{} {x=2 y=3}
one sig at6_6 extends at6{} {x=2 y=3}
one sig at6_5 extends at6{} {x=2 y=3}
one sig at6_4 extends at6{} {x=2 y=3}
one sig at6_3 extends at6{} {x=2 y=3}
one sig at6_2 extends at6{} {x=2 y=3}
one sig at6_1 extends at6{} {x=2 y=3}
one sig at6_19 extends at6{} {x=2 y=3}
one sig at6_18 extends at6{} {x=2 y=3}
one sig at6_17 extends at6{} {x=2 y=3}
one sig at6_16 extends at6{} {x=2 y=3}
one sig at6_15 extends at6{} {x=2 y=3}
one sig at6_14 extends at6{} {x=2 y=3}
one sig at6_13 extends at6{} {x=2 y=3}
one sig at6_12 extends at6{} {x=2 y=3}
one sig at6_11 extends at6{} {x=2 y=3}
one sig at6_10 extends at6{} {x=2 y=3}
one sig at6_25 extends at6{} {x=2 y=3}
one sig at6_24 extends at6{} {x=2 y=3}
one sig at6_23 extends at6{} {x=2 y=3}
one sig at6_22 extends at6{} {x=2 y=3}
one sig at6_21 extends at6{} {x=2 y=3}
one sig at6_20 extends at6{} {x=2 y=3}

// ----------------PREDICATE:

pred TaskAllocation{
}

// ----------------CONSTRAINTS:

 fact {all at: at6| one d: do.at | d in r6.capability}

// ----------------RUN COMMAND:

run TaskAllocation for
7 Int, 1 Capability, exactly 25 AtomicTask, 1 Robot