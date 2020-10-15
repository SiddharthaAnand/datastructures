# https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms


def minimumAbsoluteDifference(arr):
    arr.sort()
    _min = 2*10**9
    for idx, val in enumerate(arr):
        if idx < (len(arr)-1) and abs(arr[idx] - arr[idx+1]) < _min:
            _min = abs(arr[idx] - arr[idx+1])
    return _min

if __name__ == '__main__':
	arr = [int(x) for x in raw_input().strip().split()]
	print minimumAbsoluteDifference(arr)