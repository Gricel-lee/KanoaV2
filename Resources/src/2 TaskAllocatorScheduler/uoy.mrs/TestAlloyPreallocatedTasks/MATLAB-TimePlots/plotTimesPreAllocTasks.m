%Times to get (only one possible) allocation for
%1,25 or 50 preallocated tasks to robot r6
allocTasks0=[0,0,0,0];
allocTasks1=[458,476,470,461,466];
allocTasks25=[898,919,915,907,909];
allocTasks50=[1276,1253,1251,1244,1256];

%Times to get 10 allocations for:
%1, 25 or 50 preallocated tasks to robot r6 + tasks and robots in the Hospital scenario
hospAllocTasks50=[2565,2525,2538,2605,2536];
hospAllocTasks25=[1974,2078,2202,2109,2090];
hospAllocTasks1=[1397,1534,1439,1381,1437];
hospAllocTasks0=[1383,1529,1333,1403,1412];

%% Get mean values
%num of allocated tasks
x = [0,1,25,50];
%time preallocated
a_time = [mean(allocTasks0), mean(allocTasks1), mean(allocTasks25), mean(allocTasks50)];
%time hospital + preallocated
ha_time = [mean(hospAllocTasks0), mean(hospAllocTasks1), mean(hospAllocTasks25), mean(hospAllocTasks50)];

% Note: Deviation to small to notice, so not used   %https://kakearney.github.io/2016/06/10/boundedline.html
% e = [std(allocTasks0), std(allocTasks1), std(allocTasks25), std(allocTasks50)] %error = std. deviation


%% Plot
plot(x,a_time,'--o',x,ha_time,'-o','LineWidth',4,'MarkerSize',15)%,x,y3,'c*')
ylabel('Time for task-allocation (ms)')
xlabel('Number of pre-allocated tasks')
legend({'Robot with pre-allocated tasks','Robot with pre-allocated tasks + Hospital case study.'})
fontsize(gcf,scale=2)
hold on
%% Getting slope of lines -- results from polifyt = [a,b], meaning coefficients: (ax + b)
%removing 0 tasks
x = [1,25,50];
a_time = [mean(allocTasks1), mean(allocTasks25), mean(allocTasks50)];
%time hospital + preallocated
ha_time = [mean(hospAllocTasks1), mean(hospAllocTasks25), mean(hospAllocTasks50)];

fprintf("Line for pre-allocated tasks")
polyfit(x,a_time,1)

fprintf("Line for pre-allocated tasks + Hospital")
polyfit(x,ha_time,1)

% from polyfit results, plot lines:
a1=16.10; a2=469.33;
 x= linspace(0,50, 5); % Adapt n for resolution of graph
 y= a1*x+a2;
 plot(x,y,'g')
hold on


a1=22.80; a2=1451.10;
 x= linspace(0,50, 5); % Adapt n for resolution of graph
 y= a1*x+a2;
 plot(x,y,'g')
hold on

hold off