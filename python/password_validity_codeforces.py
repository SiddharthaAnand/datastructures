# http://codeforces.com/contest/1051/problem/A
# Vasya And Password
#s
def check_valid(s):
    num = 0
    low = 0
    high = 0
    for i in s:
        if i >= 0 and i <= 9:
            num += 1
        if ord(i) >= 'a' and ord(i) <= 'z':
            low += 1
        if ord(i) >= 'A' and ord(i) <= 'Z':
            high += 1
    if num > 0 and low > 0  and high > 0:
        return True
    return False
    
def change_pwd(s):
    pass

T = int(raw_input())
while T > 0:
    T -= 1
    string = raw_input()
    if check_valid(string) == True:
        print string
    else:
        print change_pwd(string)