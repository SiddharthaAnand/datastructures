# Problem URL: https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0
# Solution: https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

from collections import deque

T = int(input())

for _ in range(T):
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    deq = deque([])

    for i in range(K):
        while deq and arr[deq[-1]] < arr[i]:
            deq.pop()
        deq.append(i)

    for i in range(K, N):
        print(arr[deq[0]], end=" ")
        while deq and deq[0] <= i - K:
            deq.popleft()
        while deq and arr[deq[-1]] <= arr[i]:
            deq.pop()
        deq.append(i)
    print(arr[deq[0]])

