mdp

formula done = (r4_order=5 & r3_order=5);

// failure
formula fail = (r4_fail=0 & r3_fail=0 );

// total time available
const int TT=60;

// completion tasks time
const int r4at1_move_0Time=4;
const int r4at1_move_1Time=4;
const int r3at1_move_0Time=4;
const int r3at1_move_1Time=4;

// probabilities of succeeding with a task
const double pr4_Succ_at1_move = 0.9;
const double pr4_Succ_at4_notify = 0.9;
const double pr3_Succ_at1_move = 0.9;
const double pr3_Succ_at4_notify = 0.9;

// travelling costs of each robot
const int r4_travDist = 4; //l10->room6->room1
const int r3_travDist = 9; //l9->room1->room6

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


//---------- Robot r4 MODULE----------
module r4
  //r4_order=0: travel cost 
  //r4_order=1: time travel to join task at1_move_1
  //r4_order=2: join task at1_move_1
  //r4_order=3: time travel to join task at1_move_0
  //r4_order=4: join task at1_move_0
  r4_order: [0..5] init 0; // execution order
  r4_time:[0..TT] init 0; //time available
  r4_travel: [0..1] init 0; // get travelling reward
  r4_fail: [0..1] init 0; // failure detected

  // travel captured as a reward
  [r4travel] r4_order=0 -> (r4_order'=1);
  // do sequence of tasks
  [ ] r4_order=1 & r4_fail=0 & (r4_time+2<=TT) -> (pr4_Succ_at1_move): (r4_order'=2) & (r4_time'= r4_time+2)+ (1-pr4_Succ_at1_move): (r4_fail'=1) & (r4_order'=2) & (r4_time'= r4_time+2); // travel to join task at1_move_1
  [at1_move_1] r4_order=2 & r4_fail=0 & (r4_time+r4at1_move_1Time<=TT) & r4_time=r3_time -> (r4_order'=3) & (r4_time'= r4_time + r4at1_move_1Time);
  [ ] r4_order=3 & r4_fail=0 & (r4_time+2<=TT) -> (pr4_Succ_at1_move): (r4_order'=4) & (r4_time'= r4_time+2)+ (1-pr4_Succ_at1_move): (r4_fail'=1) & (r4_order'=4) & (r4_time'= r4_time+2); // travel to join task at1_move_0
  [at1_move_0] r4_order=4 & r4_fail=0 & (r4_time+r4at1_move_0Time<=TT) & r4_time=r3_time -> (r4_order'=5) & (r4_time'= r4_time + r4at1_move_0Time);

  // failure and recovery
  [ ] r4_fail=1 -> (r4_fail'=0); // fail
  [r4idle] r4_order!=5 & r4_fail=0 & (r4_time+1<=TT) -> (r4_time'=r4_time+1); // idle
endmodule


//---------- Robot r3 MODULE----------
module r3
  //r3_order=0: travel cost 
  //r3_order=1: time travel to join task at1_move_0
  //r3_order=2: join task at1_move_0
  //r3_order=3: time travel to join task at1_move_1
  //r3_order=4: join task at1_move_1
  r3_order: [0..5] init 0; // execution order
  r3_time:[0..TT] init 0; //time available
  r3_travel: [0..1] init 0; // get travelling reward
  r3_fail: [0..1] init 0; // failure detected

  // travel captured as a reward
  [r3travel] r3_order=0 -> (r3_order'=1);
  // do sequence of tasks
  [ ] r3_order=1 & r3_fail=0 & (r3_time+7<=TT) -> (pr3_Succ_at1_move): (r3_order'=2) & (r3_time'= r3_time+7)+ (1-pr3_Succ_at1_move): (r3_fail'=1) & (r3_order'=2) & (r3_time'= r3_time+7); // travel to join task at1_move_0
  [at1_move_0] r3_order=2 & r3_fail=0 & (r3_time+r3at1_move_0Time<=TT) & r3_time=r4_time -> (r3_order'=3) & (r3_time'= r3_time + r3at1_move_0Time);
  [ ] r3_order=3 & r3_fail=0 & (r3_time+2<=TT) -> (pr3_Succ_at1_move): (r3_order'=4) & (r3_time'= r3_time+2)+ (1-pr3_Succ_at1_move): (r3_fail'=1) & (r3_order'=4) & (r3_time'= r3_time+2); // travel to join task at1_move_1
  [at1_move_1] r3_order=4 & r3_fail=0 & (r3_time+r3at1_move_1Time<=TT) & r3_time=r4_time -> (r3_order'=5) & (r3_time'= r3_time + r3at1_move_1Time);

  // failure and recovery
  [ ] r3_fail=1 -> (r3_fail'=0); // fail
  [r3idle] r3_order!=5 & r3_fail=0 & (r3_time+1<=TT) -> (r3_time'=r3_time+1); // idle
endmodule

rewards "travel" 
 [r4travel] true: r4_travDist;
 [r3travel] true: r3_travDist;
endrewards
rewards "idle" 
 [r4idle] true: 1;
 [r3idle] true: 1;
endrewards