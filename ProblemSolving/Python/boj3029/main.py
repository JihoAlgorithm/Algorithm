s = [*map(int, input().split(":"))]
e = [*map(int, input().split(":"))]

s = sum([s[0] * 3600, s[1] * 60, s[2]])
e = sum([e[0] * 3600, e[1] * 60, e[2]])

r = e - s if e > s else e - s + 86400
r = (r // 3600, r // 60 % 60, r % 60)

print("%02d:%02d:%02d" % r)
