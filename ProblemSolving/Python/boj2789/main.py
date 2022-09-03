block = int("1000010001010111110", 2)
answer = ""

for c in input():
    answer += "" if 1 << (ord(c) & 31) & block else c

print(answer)
