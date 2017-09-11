# Geeksforgeeks solution
# A program to test if the given input string's any anagram 
# makes a pallindrome or not.
# Input: AANNM
# Output: Yes (NAMAN)

def checkAnagramPallindrome(str_input):
	'''
	Any pallindrome string has either of the two possible cases:
	All characters are only even;
	OR
	All characters except one are even;
	'''
	#Take a dictionary to store the frequency of characters in the string.
	char_frequency = {}
	for char in str_input:
		if char not in char_frequency:
			char_frequency[char] = 1
		else:
			char_frequency[char] += 1

	odd_value = 0

	#Check both cases as stated above.
	for key in char_frequency:
		if char_frequency[key] % 2 == 0:
			continue
		elif char_frequency[key] % 2 != 0:
			odd_value += 1
		
	if odd_value in [0, 1]:
		print "Yes"
	else:
		print "No"

T = int(raw_input())
while T:
	T -= 1
	str_input = raw_input()
	checkAnagramPallindrome(str_input)