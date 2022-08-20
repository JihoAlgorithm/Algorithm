import re

a, b, c = map(int, re.split(r"[+=]", input()))
print("YES" if a + b == c else "NO")
