def count(s):
    cur = ""
    con = 1
    max_continuous = 1
    for c in s:
        if cur == c:
            con += 1
            max_continuous = max(max_continuous, con)
        else:
            con = 1
        cur = c
    return max_continuous


print(count(input()))
print(count(input()))
print(count(input()))
