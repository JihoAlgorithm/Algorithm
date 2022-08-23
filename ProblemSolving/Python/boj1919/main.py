a_cnt = [0] * 27
b_cnt = [0] * 27

a = input()
b = input()

for c in a:
    a_cnt[ord(c) & 31] += 1
for c in b:
    b_cnt[ord(c) & 31] += 1

answer = 0

for x, y in zip(a_cnt, b_cnt):
    if x != y:
        answer += abs(x - y)

print(answer)
