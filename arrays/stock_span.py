# Problem URL: https://practice.geeksforgeeks.org/problems/stock-span-problem/0
T = int(input())

for _ in range(T):
    N = int(input())
    arr = list(map(int, input().strip().split()))
    stack = []

    for i in range(N):
        while stack and arr[stack[-1]] <= arr[i]:
            stack.pop()
        count = i - stack[-1] if stack else i + 1
        print(count, end=" ")
        stack.append(i)
    print()
