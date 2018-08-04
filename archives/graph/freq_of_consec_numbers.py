# print the frequency of consecutive characters
# same characters at different positions should be
# treated differently.

def freq_cosec_repeating_characters(inp):
    if inp == None or len(inp) == 0:
        return -1
    
    curr_count = 1
    for idx in range(len(inp)-1):
        if inp[idx] == inp[idx+1]:
            curr_count += 1
            continue
        else:
            print inp[idx], curr_count
            curr_count = 1
    
    print inp[idx], curr_count

if __name__ == '__main__':
    # test cases for this problem
    print "aaaabbbcccdd"
    freq_cosec_repeating_characters("aaaabbbcccdd")
    print "abcd"
    freq_cosec_repeating_characters("abcd")
    print ""
    freq_cosec_repeating_characters("")
    print "aabbccddaa"
    
    freq_cosec_repeating_characters("aabbccddaa")
    
