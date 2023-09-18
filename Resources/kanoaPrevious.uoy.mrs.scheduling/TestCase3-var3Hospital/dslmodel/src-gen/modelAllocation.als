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
{disj[capability ,  Capability-r1at2_floor-r1at3_sanit-r1at4_notify]}
fact{#r1<=1}
sig r2 extends Robot{}
{disj[capability ,  Capability-r2at2_floor-r2at3_sanit-r2at4_notify]}
fact{#r2<=1}
sig r3 extends Robot{}
{disj[capability ,  Capability-r3at1_move-r3at4_notify]}
fact{#r3<=1}
sig r4 extends Robot{}
{disj[capability ,  Capability-r4at1_move-r4at4_notify]}
fact{#r4<=1}
sig r5 extends Robot{}
{disj[capability ,  Capability-r5at1_move-r5at4_notify]}
fact{#r5<=1}

// ----------------CAPABILITIES:


sig r1at3_sanit extends Capability{}
{all d:do | d in at3_sanit}
sig r1at2_floor extends Capability{}
{all d:do | d in at2_floor}
sig r1at4_notify extends Capability{}
{all d:do | d in at4_notify}
sig r2at3_sanit extends Capability{}
{all d:do | d in at3_sanit}
sig r2at4_notify extends Capability{}
{all d:do | d in at4_notify}
sig r3at1_move extends Capability{}
{all d:do | d in at1_move}
sig r3at4_notify extends Capability{}
{all d:do | d in at4_notify}
sig r4at1_move extends Capability{}
{all d:do | d in at1_move}
sig r4at4_notify extends Capability{}
{all d:do | d in at4_notify}
sig r5at1_move extends Capability{}
{all d:do | d in at1_move}
sig r5at4_notify extends Capability{}
{all d:do | d in at4_notify}
sig r2at2_floor extends Capability{}
{all d:do | d in at2_floor}

fact{#r1at3_sanit<=1
#r1at3_sanit<=1
#r1at2_floor<=1
#r1at3_sanit<=1
#r1at4_notify<=1
#r2at2_floor<=1
#r2at3_sanit<=1
#r2at4_notify<=1
#r3at1_move<=1
#r3at4_notify<=1
#r4at1_move<=1
#r4at4_notify<=1
#r5at1_move<=1
#r5at4_notify<=1
#r1at2_floor<=1
#r1at3_sanit<=1
#r1at4_notify<=1
#r2at2_floor<=1
#r2at3_sanit<=1
#r2at4_notify<=1
#r3at1_move<=1
#r3at4_notify<=1
#r4at1_move<=1
#r4at4_notify<=1
#r5at1_move<=1
#r5at4_notify<=1
#r1at2_floor<=1
#r1at3_sanit<=1
#r1at4_notify<=1
#r2at2_floor<=1
#r2at3_sanit<=1
#r2at4_notify<=1
#r3at1_move<=1
#r3at4_notify<=1
#r4at1_move<=1
#r4at4_notify<=1
#r5at1_move<=1
#r5at4_notify<=1
#r1at2_floor<=1
#r1at3_sanit<=1
#r1at4_notify<=1
#r2at2_floor<=1
#r2at3_sanit<=1
#r2at4_notify<=1
#r3at1_move<=1
#r3at4_notify<=1
#r4at1_move<=1
#r4at4_notify<=1
#r5at1_move<=1
#r5at4_notify<=1
#r1at2_floor<=1
#r1at3_sanit<=1
#r1at4_notify<=1
#r2at2_floor<=1
#r2at3_sanit<=1
#r2at4_notify<=1
#r3at1_move<=1
#r3at4_notify<=1
#r4at1_move<=1
#r4at4_notify<=1
#r5at1_move<=1
#r5at4_notify<=1
#r1at2_floor<=1
#r1at3_sanit<=1
#r1at4_notify<=1
#r2at2_floor<=1
#r2at3_sanit<=1
#r2at4_notify<=1
#r3at1_move<=1
#r3at4_notify<=1
#r4at1_move<=1
#r4at4_notify<=1
#r5at1_move<=1
#r5at4_notify<=1
} // robot capabilities appear once (if robot appears, and if capab. tasks assigned)

// ----------------ATOMIC TASKS:

abstract sig at3_sanit,at4_notify,at2_floor,at1_move extends AtomicTask {}
fact{all a:at3_sanit | #do.a=1}	// number of robots needed
fact{all a:at4_notify | #do.a=1}	// number of robots needed
fact{all a:at2_floor | #do.a=1}	// number of robots needed
fact{all a:at1_move | #do.a=2}	// number of robots needed
sig at1_move_0 extends at1_move{}
{x=2
y=3}
sig at1_move_1 extends at1_move{}
{x=9
y=7}
sig at4_notify_2 extends at4_notify{}
{x=1
y=7}
sig at2_floor_3 extends at2_floor{}
{x=1
y=7}
sig at3_sanit_4 extends at3_sanit{}
{x=1
y=7}
sig at4_notify_5 extends at4_notify{}
{x=4
y=1}
sig at2_floor_6 extends at2_floor{}
{x=4
y=1}
sig at3_sanit_7 extends at3_sanit{}
{x=4
y=1}
sig at4_notify_8 extends at4_notify{}
{x=10
y=1}
sig at2_floor_9 extends at2_floor{}
{x=10
y=1}
sig at3_sanit_10 extends at3_sanit{}
{x=10
y=1}
sig at4_notify_11 extends at4_notify{}
{x=10
y=5}
sig at2_floor_12 extends at2_floor{}
{x=10
y=5}
sig at3_sanit_13 extends at3_sanit{}
{x=10
y=5}

// ----------------PREDICATE:

pred TaskAllocation{
}

// ----------------CONSTRAINTS:


// ----------------RUN COMMAND:

run TaskAllocation for
7 Int,
74 Capability,
exactly 14 AtomicTask,
5 Robot,
exactly 1 at1_move_0,
exactly 1 at1_move_1,
exactly 1 at4_notify_2,
exactly 1 at2_floor_3,
exactly 1 at3_sanit_4,
exactly 1 at4_notify_5,
exactly 1 at2_floor_6,
exactly 1 at3_sanit_7,
exactly 1 at4_notify_8,
exactly 1 at2_floor_9,
exactly 1 at3_sanit_10,
exactly 1 at4_notify_11,
exactly 1 at2_floor_12,
exactly 1 at3_sanit_13