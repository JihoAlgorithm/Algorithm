for _ in range(int(input())):
    s = input()
    k = str(int(s) + int(s[::-1]))
    print("YES" if k == k[::-1] else "NO")
