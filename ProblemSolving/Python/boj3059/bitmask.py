for _ in range(int(input())):
    visited = 0
    answer = 0
    for c in input():
        visited |= 1 << (ord(c) & 31)
    for i in range(1, 27):
        if not visited & (1 << i):
            answer += 64 + i
    print(answer)
