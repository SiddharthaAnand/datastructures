import random

def random_based_on_weights(rand_no_weights):
	total = sum(rand_no_weights)
	rand = random.randint(1, total)
	curr_sum = 0
	for no, val in enumerate(rand_no_weights):
		curr_sum += val
		if rand > curr_sum:
			continue
		else:
			return no
	return len(rand_no_weights)-1

if __name__ == '__main__':
	print 'Enter the weights/probablity by which the numbers should be returned'
	weight_list = [float(x) for x in raw_input().strip().split()]
	print random_based_on_weights(weight_list)
	

