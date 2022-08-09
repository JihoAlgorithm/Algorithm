S = input()
alphabet = {}

for i in range(26):
    alphabet.setdefault(chr(97 + i), 0)

for c in S:
    alphabet[c] += 1

print(*alphabet.values())
