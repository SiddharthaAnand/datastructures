# https://www.hackerrank.com/challenges/kangaroo/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
# Complete the kangaroo function below.
# Kangaroo
def kangaroo(x1, v1, x2, v2):
    # jump  = (x2 - x1)/(v1-v2)
    # Case 1: If the kangaroo is behind the other and the velocity is less than the other
    if (x1 < x2 and v1 <= v2) or (x1 > x2 and v1 >= v2):
        return "NO"
    elif x1 < x2 and v1 > v2:
        jumps = (x2 - x1)/(v1 - v2)
    elif x1 > x2 and v1 < v2:
        jumps = (x1 - x2)/(v2 - v1)
    if x1 + v1*jumps == x2 + v2*jumps:
        return "YES"
    return "NO"