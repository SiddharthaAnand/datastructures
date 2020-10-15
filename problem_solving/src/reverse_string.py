# Reverse a string recursively and iteratively, which is given as input.
def reverse_string(_input, start, end, _reversed):
	while start <= end:
		_reversed += _input[end]
		end -= 1
	print _reversed


def reverse_string_recursive(_input, start, end, _reversed):
	if start <= end:
		reverse_string_recursive(_input, start+1, end, _reversed)
		_reversed += _input[start]
		#print _reversed,
	print _reversed,
_reversed = ""
#reverse_string("Siddhartha", 0, len("Siddhartha")-1, _reversed)

_string = raw_input("Enter the string to reverse:")
reverse_string_recursive(_string, 0, len(_string)-1, _reversed)
