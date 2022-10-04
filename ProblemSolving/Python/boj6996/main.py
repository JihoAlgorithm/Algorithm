N = int(input())

for _ in range(N):
    a, b = input().split()
    x = sorted(list(a))
    y = sorted(list(b))
    are_anagram = "are anagrams." if x == y else "are NOT anagrams."
    print(f"{a} & {b} {are_anagram}")
