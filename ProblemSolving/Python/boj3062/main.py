for _ in range(int(input())):
    s = input()
    r = s[::-1]
    k = str(int(s) + int(r))
    print("YES" if k == k[::-1] else "NO")
