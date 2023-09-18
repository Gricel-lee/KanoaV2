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
#r1at3_sanit<=1
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
sig at3_sanit_15 extends at3_sanit{}
{x=16
y=0}
sig at3_sanit_16 extends at3_sanit{}
{x=17
y=0}
sig at3_sanit_17 extends at3_sanit{}
{x=18
y=0}
sig at3_sanit_18 extends at3_sanit{}
{x=19
y=0}
sig at3_sanit_19 extends at3_sanit{}
{x=20
y=0}
sig at3_sanit_20 extends at3_sanit{}
{x=21
y=0}
sig at3_sanit_21 extends at3_sanit{}
{x=22
y=0}
sig at3_sanit_22 extends at3_sanit{}
{x=23
y=0}
sig at3_sanit_23 extends at3_sanit{}
{x=24
y=0}
sig at3_sanit_24 extends at3_sanit{}
{x=25
y=0}
sig at3_sanit_25 extends at3_sanit{}
{x=26
y=0}
sig at3_sanit_26 extends at3_sanit{}
{x=27
y=0}
sig at3_sanit_27 extends at3_sanit{}
{x=28
y=0}
sig at3_sanit_28 extends at3_sanit{}
{x=29
y=0}
sig at3_sanit_29 extends at3_sanit{}
{x=30
y=0}
sig at3_sanit_30 extends at3_sanit{}
{x=31
y=0}
sig at3_sanit_31 extends at3_sanit{}
{x=32
y=0}
sig at3_sanit_32 extends at3_sanit{}
{x=33
y=0}
sig at3_sanit_33 extends at3_sanit{}
{x=34
y=0}
sig at3_sanit_34 extends at3_sanit{}
{x=35
y=0}
sig at3_sanit_35 extends at3_sanit{}
{x=36
y=0}
sig at3_sanit_36 extends at3_sanit{}
{x=37
y=0}
sig at3_sanit_37 extends at3_sanit{}
{x=38
y=0}
sig at3_sanit_38 extends at3_sanit{}
{x=39
y=0}
sig at3_sanit_39 extends at3_sanit{}
{x=40
y=0}
sig at3_sanit_40 extends at3_sanit{}
{x=41
y=0}
sig at3_sanit_41 extends at3_sanit{}
{x=42
y=0}
sig at3_sanit_42 extends at3_sanit{}
{x=43
y=0}
sig at3_sanit_43 extends at3_sanit{}
{x=44
y=0}
sig at3_sanit_44 extends at3_sanit{}
{x=45
y=0}
sig at3_sanit_45 extends at3_sanit{}
{x=46
y=0}
sig at3_sanit_46 extends at3_sanit{}
{x=47
y=0}
sig at3_sanit_47 extends at3_sanit{}
{x=48
y=0}
sig at3_sanit_48 extends at3_sanit{}
{x=49
y=0}
sig at3_sanit_49 extends at3_sanit{}
{x=50
y=0}

// ----------------PREDICATE:

pred TaskAllocation{
}

// ----------------CONSTRAINTS:


// ----------------RUN COMMAND:

run TaskAllocation for
7 Int,
2 Capability,
exactly 50 AtomicTask,
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
exactly 1 at3_sanit_14,
exactly 1 at3_sanit_15,
exactly 1 at3_sanit_16,
exactly 1 at3_sanit_17,
exactly 1 at3_sanit_18,
exactly 1 at3_sanit_19,
exactly 1 at3_sanit_20,
exactly 1 at3_sanit_21,
exactly 1 at3_sanit_22,
exactly 1 at3_sanit_23,
exactly 1 at3_sanit_24,
exactly 1 at3_sanit_25,
exactly 1 at3_sanit_26,
exactly 1 at3_sanit_27,
exactly 1 at3_sanit_28,
exactly 1 at3_sanit_29,
exactly 1 at3_sanit_30,
exactly 1 at3_sanit_31,
exactly 1 at3_sanit_32,
exactly 1 at3_sanit_33,
exactly 1 at3_sanit_34,
exactly 1 at3_sanit_35,
exactly 1 at3_sanit_36,
exactly 1 at3_sanit_37,
exactly 1 at3_sanit_38,
exactly 1 at3_sanit_39,
exactly 1 at3_sanit_40,
exactly 1 at3_sanit_41,
exactly 1 at3_sanit_42,
exactly 1 at3_sanit_43,
exactly 1 at3_sanit_44,
exactly 1 at3_sanit_45,
exactly 1 at3_sanit_46,
exactly 1 at3_sanit_47,
exactly 1 at3_sanit_48,
exactly 1 at3_sanit_49