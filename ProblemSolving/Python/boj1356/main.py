def mul(arr):
    res = 1
    for x in arr:
        res *= x
    return res


def check(number):
    for i in range(1, len(number)):
        l = map(int, number[:i])
        r = map(int, number[i:])

        if mul(l) == mul(r):
            return "YES"

    return "NO"


print(check(input()))
