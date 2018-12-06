def reverse_string(_input, start, end, _reversed):
	while start <= end:
		_reversed += _input[end]
		end -= 1
	print _reversed
reverse_string("Siddhartha", 0, len("Siddhartha")-1, "")