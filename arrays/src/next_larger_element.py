# Problem URL: https://practice.geeksforgeeks.org/problems/next-larger-element/0/?ref=self
T = int(input())

for _ in range(T):
    N = int(input())
    arr = list(map(int, input().strip().split()))
    next_larger = [-1] * N
    stack = []

    for i in range(N - 1, -1, -1):
        while stack and stack[-1] <= arr[i]:
            stack.pop()
        next_larger[i] = stack[-1] if stack else -1
        stack.append(arr[i])

    for i in range(N):
        print(next_larger[i], end=" ")
    print()