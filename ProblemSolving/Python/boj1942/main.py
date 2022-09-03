def parse_int(t):
    return t[0] * 3600 + t[1] * 60 + t[2]


def parse_time_string(t):
    return "".join(map(lambda x: str(x).zfill(2), t))


def check(s, e):
    count = 0
    while parse_int(s) <= parse_int(e):
        if not sum(map(int, parse_time_string(s))) % 3:
            count += 1
        s[2] += 1
        if s[2] > 59:
            s[2] = 0
            s[1] += 1
        if s[1] > 59:
            s[1] = 0
            s[0] += 1
    return count


for _ in range(3):
    answer = 0

    t = input().split()
    s = [*map(int, t[0].split(":"))]
    e = [*map(int, t[1].split(":"))]

    if parse_int(s) > parse_int(e):
        answer += check([0, 0, 0], e)
        answer += check(s, [23, 59, 59])
    else:
        answer += check(s, e)

    print(answer)
