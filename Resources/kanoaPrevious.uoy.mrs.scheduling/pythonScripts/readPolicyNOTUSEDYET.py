import os
from glob import glob

directory = "C:/Users/grist/OneDrive/21.- PhD 2020/2021 Second Year Report/Python code/Read prism output/Hospital-Example/6 Policy synthesis"



def read_states_in_path(list_states , file):
	# open file
	f = open(file,"r")
	lines = f.readlines()
	f.close()

	state_meaning = eval(lines[0].replace("(","(\"").replace(")","\")").replace(",","\",\""))
	print(state_meaning)

	tasks = []

	for i in list_states[1:]: # for each state, get the info in states.txt file

		line = lines[int(i)+1] # 45:(4,true,true,false,true,true,false,false)
		print("i",i)
		print(line)
		state = line.split(':')[0] # 45
		variables = eval(line.split(':')[1].replace("(","(\"").replace(")","\")").replace(",","\",\"")) # (4,true,true,false,true,true,false,false)

		for v in range(0,len(variables)):

			if variables[v]=="true":
				print (variables[v],v)
				print(state_meaning[v])
				if state_meaning[v] not in tasks:
					tasks.append(state_meaning[v])
	return(tasks)




def read_best_policy(file):

	# open best policy file
	f = open(file,"r")
	lines = f.readlines()
	f.close()

	# a) Get all transitions
	# dictionary for transitions
	dic = {} # dictionary with all i_lines in the best policy file

	#for each line in Best Policy file
	for i in range (1,len(lines)): # lines[0] constains number of states, so start in 1
		i_line = lines[i].split(' ')

		# get initial state and info
		init_state = str(i_line[0]) #must be string or get confused with index of the dic
		info_state =  [i_line[1] , i_line[2], i_line[3].replace('\n','') ]

		#add to dictionary
		dic[init_state] = info_state
	


	# b) Get list with only of the transitions for the robots path
	states_path = []
	state = 0 #start in state 0
	count = 0 # just to ensure it does not go forever
	check= True
	states_path.append(state)
	while check==True or count>len(dic.keys()): #count added for security

		try:
			final = dic[str(state)][0]
			print("From state ",state," go to ",final, " do ",dic[str(state)][2])
			state = final
			states_path.append(state)
		except Exception as e:
			check = False
			#raise
		finally:
			count+=1

	return(states_path , dic)





def read_states(file):
	f = open(file,"r")
	lines = f.readlines()
	f.close()
	print(type(lines))
	for i in i_lines:
		print(lines[int(i)+1])

	



def main():

	files_Policy_Synthesis = glob(directory+"/*")

	# for each folder "PrisminstanceX"
	for i in files_Policy_Synthesis:
		#transitive clousure files transitiveClosureX:
		files_transitive = glob(i+"/*")

		#for each transitiveClosureX:

		for file_t in files_transitive:
			
			f_bp = file_t+"\\best-policy.txt"
			f_st = file_t+"\\states.txt" # states file
			print(f_bp)
			list_states , best_policy = read_best_policy(f_bp) # best policy file

			

			tasks = read_states_in_path(list_states , f_st) # 

			print(tasks)


main()