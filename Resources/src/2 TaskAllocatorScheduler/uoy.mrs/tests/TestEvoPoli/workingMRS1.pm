mdp

formula done = ( r5_order=2&r1_order=2 );

const int TT = 5;
const int r5_travDist1 = 1;
const int r1_travDist1 = 1;
const double p = 0.9;
module r5
	r5_order:[0..2];
	r5_travDist:[0..16] init 16;
	r5_time:[0..TT];
    r5_fail:[0..1];
	[r5travel]	r5_order = 0 -> (r5_order' = 1);
	[r5_init_at1]	r5_order = 1 -> (r5_order' = 2);
    [r5idle]    (r5_order != 2) & (r5_time + 1<=TT) -> p:(r5_time' = r5_time+1) + (1-p):(r5_time' = r5_time+1) & (r5_fail'=1);
endmodule 


module r1
	r1_order:[0..2];
	r1_travDist:[0..16] init 16;
	r1_time:[0..TT];
    r1_fail:[0..1];
	[r1travel]	r1_order = 0 -> (r1_order' = 1);
	[r1_init_at1]	r1_order = 1 -> (r1_order' = 2);
	[r1idle]	(r1_order != 2) & (r1_time + 1<=TT) -> p:(r1_time' = r1_time+1) + (1-p):(r1_time' = r1_time+1) & (r1_fail'=1);
endmodule 


rewards "travel"
	[r5travel] true :r5_travDist1;
	[r1travel] true :r1_travDist1;
endrewards

rewards "idle"
	[r5idle] true :1;
	[r1idle] true :1;
endrewards

