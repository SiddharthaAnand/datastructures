# https://www.interviewbit.com/problems/add-one-to-number/
class Solution:
    # @param A : list of integers
    # @return a list of integers
    def plusOne(self, A):
        # Carry or No Carry
        carry = 1
        if (carry + A[-1]) > 9:
            ptr = len(A)-1
            while (carry + A[ptr]) > 9 and ptr > 0:
                carry += A[ptr]
                A[ptr] = carry % 10
                carry = carry / 10
                ptr -= 1
            if ptr == 0 and (carry + A[ptr]) > 9:
                prev = A[ptr]
                A[ptr] = (carry + A[ptr]) % 10
                A.insert(0, (carry + prev)/10)
            elif ptr == 0 and (carry + A[ptr]) < 9:
                A[ptr] = (carry + A[ptr]) % 10
            else:
                A[ptr] = carry + A[ptr]
        else:
            A[-1] += 1
        B = []
        i = 0
        if A[0] == 0:
            while A[i] == 0:
                i += 1
        A = A[i:]
        return A
