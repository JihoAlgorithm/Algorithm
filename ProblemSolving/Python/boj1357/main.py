def Rev(x):
    return x[::-1]


rev_x, rev_y = map(int, [*map(Rev, input().split())])
print(int(Rev(str(rev_x + rev_y))))
