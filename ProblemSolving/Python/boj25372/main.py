passwords = [input() for _ in range(int(input()))]
print("\n".join(map(lambda s: "yes" if 6 <= len(s) <= 9 else "no", passwords)))
