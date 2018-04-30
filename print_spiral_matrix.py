# Works only for square matrix of any dimension

def print_spiral_matrix(matrix, row, col, iteration, orig_row):
	# base case
	# if no of rows is even then iterate condition
	if orig_row % 2 == 0:
		if iteration > orig_row/2:
			return
	# if no of rows is even then iterate condition plus one
	elif orig_row % 2 != 0:
		if iteration > orig_row/2 + 1:
			return
	
	# second base case
	# if 2X2 matrix then print it straight away.
	elif row == 2 and col == 2:
		print matrix[0][0], matrix[0][1], matrix[1][1], matrix[1][0],
		return
	
	# First print first row
	print matrix[0],

	#print last column
	for i in range(1, row):
		print matrix[i][col-1],
	#print last row
	for i in range(col-2, -1, -1):
		print matrix[row-1][i],
	#print first column in reverse
	for i in range(row-2, 0, -1):
		print matrix[i][0],

	# create a new matrix excluding the outer rows and columns
	old_matrix = matrix
	matrix = []

	for i in range(1, row-1):
		temp = []
		for h in range(1, col-1):
			temp.append(old_matrix[i][h])
		matrix.append(temp)

	# recurse over a new amrtix shortened by one from both sides
	print_spiral_matrix(matrix, row-2, col-2, iteration+1, orig_row)

if __name__ == '__main__':
	matrix = [[1,2,3,4,5], [5,6,7,8,9], [9,10,11,12,13], [13,14,15,16,17], [18,14,15,16,17]]
	row = len(matrix)
	col = len(matrix[0])
	print "_______________________"
	print "Input Matrix Printed: "
	print "_______________________"

	for i in range(row):
		for j in range(col):
			print matrix[i][j],
		print
	print "_______________________"
	print "Spiral Matrix Printed: "
	print "_______________________"
	print_spiral_matrix(matrix, row, col, 1, row)

