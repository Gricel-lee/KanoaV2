mdp

formula done = (r4_order=6 & r3_order=6 & r2_order=4 & r1_order=8);

// failure
formula fail = (r4_fail=0 & r3_fail=0 & r2_fail=0 & r1_fail=0 );

// total time available
const int TT=60;

// completion tasks time
const int r4at1_move_0Time=4;
const int r4at1_move_1Time=4;
const int r4at4_notify_11Time=1;
const int r3at1_move_0Time=4;
const int r3at1_move_1Time=4;
const int r3at4_notify_5Time=1;
const int r2at4_notify_8Time=5;
const int r2at2_floor_12Time=7;
const int r2at3_sanit_13Time=5;
const int r1at4_notify_2Time=4;
const int r1at2_floor_3Time=5;
const int r1at3_sanit_4Time=4;
const int r1at2_floor_6Time=5;
const int r1at3_sanit_7Time=4;
const int r1at2_floor_9Time=5;
const int r1at3_sanit_10Time=4;

// probabilities of succeeding with a task
const double pr4_Succ_at1_move = 0.9;
const double pr4_Succ_at4_notify = 0.9;
const double pr3_Succ_at1_move = 0.9;
const double pr3_Succ_at4_notify = 0.9;
const double pr2_Succ_at2_floor = 0.85;
const double pr2_Succ_at3_sanit = 0.9;
const double pr2_Succ_at4_notify = 0.85;
const double pr1_Succ_at2_floor = 0.9;
const double pr1_Succ_at3_sanit = 0.9;
const double pr1_Succ_at4_notify = 0.9;

// travelling costs of each robot
const int r4_travDist = 12; //l10->room1->room6->room5
const int r3_travDist = 11; //l9->room1->room6->room3
const int r2_travDist = 10; //l8->room4->room5->room5