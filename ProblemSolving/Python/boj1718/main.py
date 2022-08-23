target = input()
key = input()

key_index = -1
key_size = len(key)

answer = ""
for c in target:
    key_index += 1
    k = key[key_index % key_size]
    p = (ord(c) - ord(k) + 26) % 26

    if c == " ":
        p = -64
    if not p:
        p += 26

    answer += chr(p + 96)

print(answer)
