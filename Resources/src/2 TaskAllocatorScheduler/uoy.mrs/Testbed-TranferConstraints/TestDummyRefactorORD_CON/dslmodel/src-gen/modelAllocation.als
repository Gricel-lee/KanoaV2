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
lone sig r4 extends Robot{}
{disj[capability ,  Capability]}
lone sig r5 extends Robot{}
{disj[capability ,  Capability]}

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

// ----------------ATOMIC TASKS:

abstract sig at2,at3,at4 extends AtomicTask {}
fact{all a:at2 | #do.a=1}	// number of robots needed
fact{all a:at3 | #do.a=1}	// number of robots needed
fact{all a:at4 | #do.a=1}	// number of robots needed
one sig at4_6 extends at4{} {x=1 y=1} //do at location l1
one sig at4_7 extends at4{} {x=1 y=1} //do at location l1
one sig at3_8 extends at3{} {x=1 y=1} //do at location l1
one sig at2_9 extends at2{} {x=1 y=1} //do at location l1
one sig at4_3 extends at4{} {x=10 y=5} //do at location room5
one sig at3_4 extends at3{} {x=10 y=5} //do at location room5
one sig at2_5 extends at2{} {x=10 y=5} //do at location room5
one sig at3_1 extends at3{} {x=10 y=1} //do at location room4
one sig at2_2 extends at2{} {x=10 y=1} //do at location room4

// ----------------PREDICATE:

pred TaskAllocation{
}

// ----------------CONSTRAINTS:

 fact{ all r:r4| all c:r.capability | all do:c.do | do.x>9}

// ----------------RUN COMMAND:

run TaskAllocation for
5 Int, 6 Capability, exactly 9 AtomicTask, 4 Robot