mdp

formula done = ( r5_order=2&r1_order=2 );

const int TT = 5;
const double p = 0.9;

module selector
    R5:[0..2] init 0;
    R1:[0..2] init 0;
    
    [] R1=0 -> (R1'=1);
    [] R1=0 -> (R1'=2);
    [] R5=0 -> (R5'=1);
    [] R5=0 -> (R5'=2);

endmodule

module r5
    r5_order:[0..2];
    r5_time:[0..TT];
        r5_fail:[0..1];
    // r5_1
    [r5travel_1] R5=1 &    r5_order = 0 -> p:(r5_order' = 1) + (1-p):(r5_order' = r5_order+1) & (r5_fail'=1);
    [r5_init_at1] R5=1 &    r5_order = 1 -> p:(r5_order' = 2) + (1-p):(r5_order' = r5_order+1) & (r5_fail'=1);
        [r5idle] R5=1 &   (r5_order != 2) & (r5_time + 1<=TT) -> (r5_time' = r5_time+1);
    // r5_2
    [r5travel_2] R5=0 &    r5_order = 0 -> p:(r5_order' = 1) + (1-p):(r5_order' = r5_order+1) & (r5_fail'=1);
    [r5_init_at1] R5=0 &    r5_order = 1 -> p:(r5_order' = 2) + (1-p):(r5_order' = r5_order+1) & (r5_fail'=1);
        [r5idle] R5=0 &   (r5_order != 2) & (r5_time + 1<=TT) -> (r5_time' = r5_time+1);
endmodule


module r1
    r1_order:[0..2];
    r1_time:[0..TT];
        r1_fail:[0..1];
    [r1travel] R1=1 &    r1_order = 0 -> p:(r1_order' = 1) + (1-p):(r1_order' = r1_order+1) & (r1_fail'=1);
    [r1_init_at1] R1=1 &    r1_order = 1 -> p:(r1_order' = 2) + (1-p):(r1_order' = r1_order+1) & (r1_fail'=1);
    [r1idle] R1=1 &    (r1_order != 2) & (r1_time + 1<=TT) -> (r1_time' = r1_time+1);
endmodule


rewards "travel"
    [r5travel_1] true :10;
    [r5travel_2] true :1;
    [r1travel] true :4;
endrewards

rewards "idle"
    [r5idle] true :1;
    [r1idle] true :1;
endrewards

