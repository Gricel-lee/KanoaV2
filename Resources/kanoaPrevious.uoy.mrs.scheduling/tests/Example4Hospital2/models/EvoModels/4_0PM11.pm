mdp

formula done = (r5_order=5 & r3_order=5);

// failure
formula fail = (r5_fail=0 & r3_fail=0 );

// total time available
const int TT=60;

// completion tasks time
const int r5at1_move_0Time=5;
const int r5at1_move_1Time=5;
const int r3at1_move_0Time=4;
const int r3at1_move_1Time=4;

// probabilities of succeeding with a task
const double pr5_Succ_at1_move = 0.8;
const double pr5_Succ_at4_notify = 0.7;
const double pr3_Succ_at1_move = 0.9;
const double pr3_Succ_at4_notify = 0.9;

// travelling costs of each robot
const int r5_travDist = 3; //l11->room6->room1
const int r3_travDist = 5; //l9->room6->room1

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


//---------- Robot r5 MODULE----------
module r5
  //r5_order=0: travel cost 
  //r5_order=1: time travel to join task at1_move_1
  //r5_order=2: join task at1_move_1
  //r5_order=3: time travel to join task at1_move_0
  //r5_order=4: join task at1_move_0
  r5_order: [0..5] init 0; // execution order
  r5_time:[0..TT] init 0; //time available
  r5_travel: [0..1] init 0; // get travelling reward
  r5_fail: [0..1] init 0; // failure detected

  // travel captured as a reward
  [r5travel] r5_order=0 -> (r5_order'=1);
  // do sequence of tasks
  [ ] r5_order=1 & r5_fail=0 & (r5_time+1<=TT) -> (pr5_Succ_at1_move): (r5_order'=2) & (r5_time'= r5_time+1)+ (1-pr5_Succ_at1_move): (r5_fail'=1) & (r5_order'=2) & (r5_time'= r5_time+1); // travel to join task at1_move_1
  [at1_move_1] r5_order=2 & r5_fail=0 & (r5_time+r5at1_move_1Time<=TT) & r5_time=r3_time -> (r5_order'=3) & (r5_time'= r5_time + r5at1_move_1Time);
  [ ] r5_order=3 & r5_fail=0 & (r5_time+2<=TT) -> (pr5_Succ_at1_move): (r5_order'=4) & (r5_time'= r5_time+2)+ (1-pr5_Succ_at1_move): (r5_fail'=1) & (r5_order'=4) & (r5_time'= r5_time+2); // travel to join task at1_move_0
  [at1_move_0] r5_order=4 & r5_fail=0 & (r5_time+r5at1_move_0Time<=TT) & r5_time=r3_time -> (r5_order'=5) & (r5_time'= r5_time + r5at1_move_0Time);

  // failure and recovery
  [ ] r5_fail=1 -> (r5_fail'=0); // fail
  [r5idle] r5_order!=5 & r5_fail=0 & (r5_time+1<=TT) -> (r5_time'=r5_time+1); // idle
endmodule


//---------- Robot r3 MODULE----------
module r3
  //r3_order=0: travel cost 
  //r3_order=1: time travel to join task at1_move_1
  //r3_order=2: join task at1_move_1
  //r3_order=3: time travel to join task at1_move_0
  //r3_order=4: join task at1_move_0
  r3_order: [0..5] init 0; // execution order
  r3_time:[0..TT] init 0; //time available
  r3_travel: [0..1] init 0; // get travelling reward
  r3_fail: [0..1] init 0; // failure detected

  // travel captured as a reward
  [r3travel] r3_order=0 -> (r3_order'=1);
  // do sequence of tasks
  [ ] r3_order=1 & r3_fail=0 & (r3_time+3<=TT) -> (pr3_Succ_at1_move): (r3_order'=2) & (r3_time'= r3_time+3)+ (1-pr3_Succ_at1_move): (r3_fail'=1) & (r3_order'=2) & (r3_time'= r3_time+3); // travel to join task at1_move_1
  [at1_move_1] r3_order=2 & r3_fail=0 & (r3_time+r3at1_move_1Time<=TT) & r3_time=r5_time -> (r3_order'=3) & (r3_time'= r3_time + r3at1_move_1Time);
  [ ] r3_order=3 & r3_fail=0 & (r3_time+2<=TT) -> (pr3_Succ_at1_move): (r3_order'=4) & (r3_time'= r3_time+2)+ (1-pr3_Succ_at1_move): (r3_fail'=1) & (r3_order'=4) & (r3_time'= r3_time+2); // travel to join task at1_move_0
  [at1_move_0] r3_order=4 & r3_fail=0 & (r3_time+r3at1_move_0Time<=TT) & r3_time=r5_time -> (r3_order'=5) & (r3_time'= r3_time + r3at1_move_0Time);

  // failure and recovery
  [ ] r3_fail=1 -> (r3_fail'=0); // fail
  [r3idle] r3_order!=5 & r3_fail=0 & (r3_time+1<=TT) -> (r3_time'=r3_time+1); // idle
endmodule

rewards "travel" 
 [r5travel] true: r5_travDist;
 [r3travel] true: r3_travDist;
endrewards
rewards "idle" 
 [r5idle] true: 1;
 [r3idle] true: 1;
endrewards