def edit(S, i, T, j):
    if i == 0:
        return j-i
    if j == 0:
        return i - j
    if S[i] == T[j]:
        return edit(S, i-1, T, j-1)
    if S[i] != T[j]:
        return 1 + min(edit(S, i-1, T, j), edit(S, i, T, j-1))
        
while (t > 0):
    t -= 1
    i, j = [int(x) for x in input().split()]
    S, T = [x for x in input().split()]
    print (edit(S, i-1, T, j-1))
    