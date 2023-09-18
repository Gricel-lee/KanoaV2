mdp

formula done = (r1_order=4);

// failure
formula fail = (r1_fail=0 );

// total time available
const int TT=60;

// completion tasks time
const int r1at4_notify_2Time=4;
const int r1at2_floor_3Time=5;
const int r1at3_sanit_4Time=4;

// probabilities of succeeding with a task
const double pr1_Succ_at2_floor = 0.9;
const double pr1_Succ_at3_sanit = 0.9;
const double pr1_Succ_at4_notify = 0.9;

// travelling costs of each robot
const int r1_travDist = 6; //l7->room2->room2->room2

// tasks to track for ordering constraints
//const int at3_sanit_7 = 0;
//const int at3_sanit_13 = 0;
//const int at2_floor_9 = 0;
//const int at2_floor_6 = 0;
//const int at4_notify_8 = 0;
//const int at4_notify_2 = 0;
//const int at2_floor_12 = 0;
//const int at2_floor_3 = 0;
//const int at4_notify_11 = 0;
//const int at4_notify_5 = 0;
//const int at3_sanit_10 = 0;
//const int at3_sanit_4 = 0;


//---------- Robot r1 MODULE----------
module r1
  //r1_order=0: travel cost 
  //r1_order=1: task at2_floor_3
  //r1_order=2: task at3_sanit_4
  //r1_order=3: task at4_notify_2
  r1_order: [0..4] init 0; // execution order
  r1_time:[0..TT] init 0; //time available
  r1_travel: [0..1] init 0; // get travelling reward
  r1_fail: [0..1] init 0; // failure detected

  // tasks to track for ordering constraints
  at2_floor_3:[0..1];
  at3_sanit_4:[0..1];
  at4_notify_2:[0..1];

  // travel captured as a reward
  [r1travel] r1_order=0 -> (r1_order'=1);
  // do sequence of tasks
  [ ] r1_order=1 & r1_fail=0 & at3_sanit_4=1 & at4_notify_2=1 & (r1_time+ r1at2_floor_3Time + 6 <=TT) -> (pr1_Succ_at2_floor): (r1_order'=2) & (r1_time'= r1_time+ r1at2_floor_3Time + 6) & (at2_floor_3'=1)+ (1-pr1_Succ_at2_floor): (r1_fail'=1) & (r1_order'=2) & (r1_time'= r1_time+ r1at2_floor_3Time + 6) & (at2_floor_3'=1);
  [ ] r1_order=2 & r1_fail=0 & at4_notify_2=1 & (r1_time+ r1at3_sanit_4Time + 0 <=TT) -> (pr1_Succ_at3_sanit): (r1_order'=3) & (r1_time'= r1_time+ r1at3_sanit_4Time + 0) & (at3_sanit_4'=1)+ (1-pr1_Succ_at3_sanit): (r1_fail'=1) & (r1_order'=3) & (r1_time'= r1_time+ r1at3_sanit_4Time + 0) & (at3_sanit_4'=1);
  [ ] r1_order=3 & r1_fail=0 & (r1_time+ r1at4_notify_2Time + 0 <=TT) -> (pr1_Succ_at4_notify): (r1_order'=4) & (r1_time'= r1_time+ r1at4_notify_2Time + 0) & (at4_notify_2'=1)+ (1-pr1_Succ_at4_notify): (r1_fail'=1) & (r1_order'=4) & (r1_time'= r1_time+ r1at4_notify_2Time + 0) & (at4_notify_2'=1);

  // failure and recovery
  [ ] r1_fail=1 -> (r1_fail'=0); // fail
  [r1idle] r1_order!=4 & r1_fail=0 & (r1_time+1<=TT) -> (r1_time'=r1_time+1); // idle
endmodule

rewards "travel" 
 [r1travel] true: r1_travDist;
endrewards
rewards "idle" 
 [r1idle] true: 1;
endrewards