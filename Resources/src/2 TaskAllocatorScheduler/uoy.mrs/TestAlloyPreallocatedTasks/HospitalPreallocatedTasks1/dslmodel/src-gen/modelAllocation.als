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

lone sig r1 extends Robot{}
{disj[capability ,  Capability-r1at2-r1at3-r1at4]}
lone sig r2 extends Robot{}
{disj[capability ,  Capability-r2at2-r2at3-r2at4]}
lone sig r3 extends Robot{}
{disj[capability ,  Capability-r3at2-r3at3-r3at4]}
lone sig r4 extends Robot{}
{disj[capability ,  Capability-r4at1]}
lone sig r5 extends Robot{}
{disj[capability ,  Capability-r5at1]}
lone sig r6 extends Robot{}
{disj[capability ,  Capability-r6at6]}

// ----------------CAPABILITIES:

lone sig r1at2 extends Capability{}
{all d:do | d in at2}
lone sig r1at3 extends Capability{}
{all d:do | d in at3}
lone sig r1at4 extends Capability{}
{all d:do | d in at4}
lone sig r2at2 extends Capability{}
{all d:do | d in at2}
lone sig r2at3 extends Capability{}
{all d:do | d in at3}
lone sig r2at4 extends Capability{}
{all d:do | d in at4}
lone sig r3at2 extends Capability{}
{all d:do | d in at2}
lone sig r3at3 extends Capability{}
{all d:do | d in at3}
lone sig r3at4 extends Capability{}
{all d:do | d in at4}
lone sig r4at1 extends Capability{}
{all d:do | d in at1}
lone sig r5at1 extends Capability{}
{all d:do | d in at1}
lone sig r6at6 extends Capability{}
{all d:do | d in at6}

// ----------------ATOMIC TASKS:

abstract sig at2,at1,at3,at6,at4 extends AtomicTask {}
fact{all a:at2 | #do.a=1}	// number of robots needed
fact{all a:at1 | #do.a=2}	// number of robots needed
fact{all a:at3 | #do.a=1}	// number of robots needed
fact{all a:at6 | #do.a=1}	// number of robots needed
fact{all a:at4 | #do.a=1}	// number of robots needed
one sig at4_9 extends at4{} {x=10 y=1}
one sig at3_4 extends at3{} {x=1 y=7}
one sig at2_11 extends at2{} {x=10 y=1}
one sig at4_6 extends at4{} {x=4 y=1}
one sig at4_3 extends at4{} {x=1 y=7}
one sig at4_12 extends at4{} {x=10 y=5}
one sig at2_8 extends at2{} {x=4 y=1}
one sig at1_2 extends at1{} {x=9 y=7}
one sig at3_13 extends at3{} {x=10 y=5}
one sig at1_1 extends at1{} {x=2 y=3}
one sig at2_5 extends at2{} {x=1 y=7}
one sig at6_15 extends at6{} {x=9 y=7}
one sig at3_10 extends at3{} {x=10 y=1}
one sig at3_7 extends at3{} {x=4 y=1}
one sig at2_14 extends at2{} {x=10 y=5}

// ----------------PREDICATE:

pred TaskAllocation{
}

// ----------------CONSTRAINTS:

 fact {all at: at6| one d: do.at | d in r6.capability}

// ----------------RUN COMMAND:

run TaskAllocation for
7 Int, 12 Capability, exactly 15 AtomicTask, 6 Robot