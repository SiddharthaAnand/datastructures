# Given profits in the form of an array, your task is to figure out the 
# maximum profit that can be made. The constraint is only those profits
# must be considered where i < j (positions) and profit[j] is a multiple
# of profit[i].

def _profit(arr):
	if arr is None or len(arr) == 0:
		return None
	if len(arr) == 1:
		return arr[0]
	profit = []
	profit.append(arr[0])
	ptr = 1
	while ptr < len(arr):
		sptr = ptr
		while sptr > 0:
			sptr -= 1
			if arr[ptr] % arr[sptr] == 0:
				profit.append(profit[sptr] + arr[ptr])
				break
		ptr += 1
	print profit
	return max(profit)

if __name__ == '__main__':
	_list = raw_input('Enter the list values')
	arr = [int(x) for x in _list.strip().split()]
	print _profit(arr)
