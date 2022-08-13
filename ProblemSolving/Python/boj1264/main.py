vowel = "aeiou"

while True:
    s = input().lower()
    if s == "#":
        break
    print(sum([s.count(v) for v in vowel]))
