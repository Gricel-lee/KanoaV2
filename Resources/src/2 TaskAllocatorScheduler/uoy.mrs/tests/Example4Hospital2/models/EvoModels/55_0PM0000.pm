mdp

formula done = (r5_order=6 & r4_order=6 & r1_order=8 & r2_order=4);

// failure
formula fail = (r5_fail=0 & r4_fail=0 & r1_fail=0 & r2_fail=0 );

// total time available
const int TT=60;

// completion tasks time
const int r5at1_move_0Time=5;
const int r5at1_move_1Time=5;
const int r5at4_notify_11Time=1;
const int r4at1_move_0Time=4;
const int r4at1_move_1Time=4;
const int r4at4_notify_2Time=1;
const int r1at3_sanit_4Time=4;
const int r1at4_notify_5Time=4;
const int r1at2_floor_6Time=5;
const int r1at2_floor_9Time=5;
const int r1at3_sanit_10Time=4;
const int r1at2_floor_12Time=5;
const int r1at3_sanit_13Time=4;
const int r2at2_floor_3Time=7;
const int r2at3_sanit_7Time=5;
const int r2at4_notify_8Time=5;

// probabilities of succeeding with a task
const double pr5_Succ_at1_move = 0.8;
const double pr5_Succ_at4_notify = 0.7;
const double pr4_Succ_at1_move = 0.9;
const double pr4_Succ_at4_notify = 0.9;
const double pr1_Succ_at2_floor = 0.9;
const double pr1_Succ_at3_sanit = 0.9;
const double pr1_Succ_at4_notify = 0.9;
const double pr2_Succ_at2_floor = 0.85;
const double pr2_Succ_at3_sanit = 0.9;
const double pr2_Succ_at4_notify = 0.85;

// travelling costs of each robot
const int r5_travDist = 13; //l11->room1->room6->room5
const int r4_travDist = 12; //l10->room1->room6->room2
const int r1_travDist = 12; //l7->room2->room3->room3->room4->room4->room5->room5
const int r2_travDist = 10; //l8->room2->room3->room4

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
  //r5_order=1: time travel to join task at1_move_0
  //r5_order=2: join task at1_move_0
  //r5_order=3: time travel to join task at1_move_1
  //r5_order=4: join task at1_move_1
  //r5_order=5: task at4_notify_11
  r5_order: [0..6] init 0; // execution order
  r5_time:[0..TT] init 0; //time available
  r5_travel: [0..1] init 0; // get travelling reward
  r5_fail: [0..1] init 0; // failure detected

  // tasks to track for ordering constraints
  at4_notify_11:[0..1];

  // travel captured as a reward
  [r5travel] r5_order=0 -> (r5_order'=1);
  // do sequence of tasks
  [ ] r5_order=1 & r5_fail=0 & (r5_time+9<=TT) -> (pr5_Succ_at1_move): (r5_order'=2) & (r5_time'= r5_time+9)+ (1-pr5_Succ_at1_move): (r5_fail'=1) & (r5_order'=2) & (r5_time'= r5_time+9); // travel to join task at1_move_0
  [at1_move_0] r5_order=2 & r5_fail=0 & (r5_time+r5at1_move_0Time<=TT) & r5_time=r4_time -> (r5_order'=3) & (r5_time'= r5_time + r5at1_move_0Time);
  [ ] r5_order=3 & r5_fail=0 & (r5_time+2<=TT) -> (pr5_Succ_at1_move): (r5_order'=4) & (r5_time'= r5_time+2)+ (1-pr5_Succ_at1_move): (r5_fail'=1) & (r5_order'=4) & (r5_time'= r5_time+2); // travel to join task at1_move_1
  [at1_move_1] r5_order=4 & r5_fail=0 & (r5_time+r5at1_move_1Time<=TT) & r5_time=r4_time -> (r5_order'=5) & (r5_time'= r5_time + r5at1_move_1Time);
  [ ] r5_order=5 & r5_fail=0 & (r5_time+ r5at4_notify_11Time + 2 <=TT) -> (pr5_Succ_at4_notify): (r5_order'=6) & (r5_time'= r5_time+ r5at4_notify_11Time + 2) & (at4_notify_11'=1)+ (1-pr5_Succ_at4_notify): (r5_fail'=1) & (r5_order'=6) & (r5_time'= r5_time+ r5at4_notify_11Time + 2) & (at4_notify_11'=1);

  // failure and recovery
  [ ] r5_fail=1 -> (r5_fail'=0); // fail
  [r5idle] r5_order!=6 & r5_fail=0 & (r5_time+1<=TT) -> (r5_time'=r5_time+1); // idle
endmodule


//---------- Robot r4 MODULE----------
module r4
  //r4_order=0: travel cost 
  //r4_order=1: time travel to join task at1_move_0
  //r4_order=2: join task at1_move_0
  //r4_order=3: time travel to join task at1_move_1
  //r4_order=4: join task at1_move_1
  //r4_order=5: task at4_notify_2
  r4_order: [0..6] init 0; // execution order
  r4_time:[0..TT] init 0; //time available
  r4_travel: [0..1] init 0; // get travelling reward
  r4_fail: [0..1] init 0; // failure detected

  // tasks to track for ordering constraints
  at4_notify_2:[0..1];

  // travel captured as a reward
  [r4travel] r4_order=0 -> (r4_order'=1);
  // do sequence of tasks
  [ ] r4_order=1 & r4_fail=0 & (r4_time+8<=TT) -> (pr4_Succ_at1_move): (r4_order'=2) & (r4_time'= r4_time+8)+ (1-pr4_Succ_at1_move): (r4_fail'=1) & (r4_order'=2) & (r4_time'= r4_time+8); // travel to join task at1_move_0
  [at1_move_0] r4_order=2 & r4_fail=0 & (r4_time+r4at1_move_0Time<=TT) & r4_time=r5_time -> (r4_order'=3) & (r4_time'= r4_time + r4at1_move_0Time);
  [ ] r4_order=3 & r4_fail=0 & (r4_time+2<=TT) -> (pr4_Succ_at1_move): (r4_order'=4) & (r4_time'= r4_time+2)+ (1-pr4_Succ_at1_move): (r4_fail'=1) & (r4_order'=4) & (r4_time'= r4_time+2); // travel to join task at1_move_1
  [at1_move_1] r4_order=4 & r4_fail=0 & (r4_time+r4at1_move_1Time<=TT) & r4_time=r5_time -> (r4_order'=5) & (r4_time'= r4_time + r4at1_move_1Time);
  [ ] r4_order=5 & r4_fail=0 & (r4_time+ r4at4_notify_2Time + 2 <=TT) -> (pr4_Succ_at4_notify): (r4_order'=6) & (r4_time'= r4_time+ r4at4_notify_2Time + 2) & (at4_notify_2'=1)+ (1-pr4_Succ_at4_notify): (r4_fail'=1) & (r4_order'=6) & (r4_time'= r4_time+ r4at4_notify_2Time + 2) & (at4_notify_2'=1);

  // failure and recovery
  [ ] r4_fail=1 -> (r4_fail'=0); // fail
  [r4idle] r4_order!=6 & r4_fail=0 & (r4_time+1<=TT) -> (r4_time'=r4_time+1); // idle
endmodule


//---------- Robot r1 MODULE----------
module r1
  //r1_order=0: travel cost 
  //r1_order=1: task at3_sanit_4
  //r1_order=2: task at4_notify_5
  //r1_order=3: task at2_floor_6
  //r1_order=4: task at2_floor_9
  //r1_order=5: task at3_sanit_10
  //r1_order=6: task at2_floor_12
  //r1_order=7: task at3_sanit_13
  r1_order: [0..8] init 0; // execution order
  r1_time:[0..TT] init 0; //time available
  r1_travel: [0..1] init 0; // get travelling reward
  r1_fail: [0..1] init 0; // failure detected

  // tasks to track for ordering constraints
  at3_sanit_4:[0..1];
  at4_notify_5:[0..1];
  at2_floor_6:[0..1];
  at2_floor_9:[0..1];
  at3_sanit_10:[0..1];
  at2_floor_12:[0..1];
  at3_sanit_13:[0..1];

  // travel captured as a reward
  [r1travel] r1_order=0 -> (r1_order'=1);
  // do sequence of tasks
  [ ] r1_order=1 & r1_fail=0 & at4_notify_2=1 & r1_time>=r4_time & (r1_time+ r1at3_sanit_4Time + 6 <=TT) -> (pr1_Succ_at3_sanit): (r1_order'=2) & (r1_time'= r1_time+ r1at3_sanit_4Time + 6) & (at3_sanit_4'=1)+ (1-pr1_Succ_at3_sanit): (r1_fail'=1) & (r1_order'=2) & (r1_time'= r1_time+ r1at3_sanit_4Time + 6) & (at3_sanit_4'=1);
  [ ] r1_order=2 & r1_fail=0 & (r1_time+ r1at4_notify_5Time + 2 <=TT) -> (pr1_Succ_at4_notify): (r1_order'=3) & (r1_time'= r1_time+ r1at4_notify_5Time + 2) & (at4_notify_5'=1)+ (1-pr1_Succ_at4_notify): (r1_fail'=1) & (r1_order'=3) & (r1_time'= r1_time+ r1at4_notify_5Time + 2) & (at4_notify_5'=1);
  [ ] r1_order=3 & r1_fail=0 & at3_sanit_7=1 & at4_notify_5=1 & r1_time>=r2_time & (r1_time+ r1at2_floor_6Time + 0 <=TT) -> (pr1_Succ_at2_floor): (r1_order'=4) & (r1_time'= r1_time+ r1at2_floor_6Time + 0) & (at2_floor_6'=1)+ (1-pr1_Succ_at2_floor): (r1_fail'=1) & (r1_order'=4) & (r1_time'= r1_time+ r1at2_floor_6Time + 0) & (at2_floor_6'=1);
  [ ] r1_order=4 & r1_fail=0 & at3_sanit_10=1 & at4_notify_8=1 & (r1_time+ r1at2_floor_9Time + 2 <=TT) -> (pr1_Succ_at2_floor): (r1_order'=5) & (r1_time'= r1_time+ r1at2_floor_9Time + 2) & (at2_floor_9'=1)+ (1-pr1_Succ_at2_floor): (r1_fail'=1) & (r1_order'=5) & (r1_time'= r1_time+ r1at2_floor_9Time + 2) & (at2_floor_9'=1);
  [ ] r1_order=5 & r1_fail=0 & at4_notify_8=1 & r1_time>=r2_time & (r1_time+ r1at3_sanit_10Time + 0 <=TT) -> (pr1_Succ_at3_sanit): (r1_order'=6) & (r1_time'= r1_time+ r1at3_sanit_10Time + 0) & (at3_sanit_10'=1)+ (1-pr1_Succ_at3_sanit): (r1_fail'=1) & (r1_order'=6) & (r1_time'= r1_time+ r1at3_sanit_10Time + 0) & (at3_sanit_10'=1);
  [ ] r1_order=6 & r1_fail=0 & at3_sanit_13=1 & at4_notify_11=1 & (r1_time+ r1at2_floor_12Time + 2 <=TT) -> (pr1_Succ_at2_floor): (r1_order'=7) & (r1_time'= r1_time+ r1at2_floor_12Time + 2) & (at2_floor_12'=1)+ (1-pr1_Succ_at2_floor): (r1_fail'=1) & (r1_order'=7) & (r1_time'= r1_time+ r1at2_floor_12Time + 2) & (at2_floor_12'=1);
  [ ] r1_order=7 & r1_fail=0 & at4_notify_11=1 & r1_time>=r5_time & (r1_time+ r1at3_sanit_13Time + 0 <=TT) -> (pr1_Succ_at3_sanit): (r1_order'=8) & (r1_time'= r1_time+ r1at3_sanit_13Time + 0) & (at3_sanit_13'=1)+ (1-pr1_Succ_at3_sanit): (r1_fail'=1) & (r1_order'=8) & (r1_time'= r1_time+ r1at3_sanit_13Time + 0) & (at3_sanit_13'=1);

  // failure and recovery
  [ ] r1_fail=1 -> (r1_fail'=0); // fail
  [r1idle] r1_order!=8 & r1_fail=0 & (r1_time+1<=TT) -> (r1_time'=r1_time+1); // idle
endmodule


//---------- Robot r2 MODULE----------
module r2
  //r2_order=0: travel cost 
  //r2_order=1: task at2_floor_3
  //r2_order=2: task at3_sanit_7
  //r2_order=3: task at4_notify_8
  r2_order: [0..4] init 0; // execution order
  r2_time:[0..TT] init 0; //time available
  r2_travel: [0..1] init 0; // get travelling reward
  r2_fail: [0..1] init 0; // failure detected

  // tasks to track for ordering constraints
  at2_floor_3:[0..1];
  at3_sanit_7:[0..1];
  at4_notify_8:[0..1];

  // travel captured as a reward
  [r2travel] r2_order=0 -> (r2_order'=1);
  // do sequence of tasks
  [ ] r2_order=1 & r2_fail=0 & at3_sanit_4=1 & at4_notify_2=1 & r2_time>=r1_time & (r2_time+ r2at2_floor_3Time + 6 <=TT) -> (pr2_Succ_at2_floor): (r2_order'=2) & (r2_time'= r2_time+ r2at2_floor_3Time + 6) & (at2_floor_3'=1)+ (1-pr2_Succ_at2_floor): (r2_fail'=1) & (r2_order'=2) & (r2_time'= r2_time+ r2at2_floor_3Time + 6) & (at2_floor_3'=1);
  [ ] r2_order=2 & r2_fail=0 & at4_notify_5=1 & r2_time>=r1_time & (r2_time+ r2at3_sanit_7Time + 2 <=TT) -> (pr2_Succ_at3_sanit): (r2_order'=3) & (r2_time'= r2_time+ r2at3_sanit_7Time + 2) & (at3_sanit_7'=1)+ (1-pr2_Succ_at3_sanit): (r2_fail'=1) & (r2_order'=3) & (r2_time'= r2_time+ r2at3_sanit_7Time + 2) & (at3_sanit_7'=1);
  [ ] r2_order=3 & r2_fail=0 & (r2_time+ r2at4_notify_8Time + 2 <=TT) -> (pr2_Succ_at4_notify): (r2_order'=4) & (r2_time'= r2_time+ r2at4_notify_8Time + 2) & (at4_notify_8'=1)+ (1-pr2_Succ_at4_notify): (r2_fail'=1) & (r2_order'=4) & (r2_time'= r2_time+ r2at4_notify_8Time + 2) & (at4_notify_8'=1);

  // failure and recovery
  [ ] r2_fail=1 -> (r2_fail'=0); // fail
  [r2idle] r2_order!=4 & r2_fail=0 & (r2_time+1<=TT) -> (r2_time'=r2_time+1); // idle
endmodule

rewards "travel" 
 [r5travel] true: r5_travDist;
 [r4travel] true: r4_travDist;
 [r1travel] true: r1_travDist;
 [r2travel] true: r2_travDist;
endrewards
rewards "idle" 
 [r5idle] true: 1;
 [r4idle] true: 1;
 [r1idle] true: 1;
 [r2idle] true: 1;
endrewards