q = int(input())
quotes = [input() for _ in range(q)]

for _ in range(int(input())):
    r = int(input())
    if 0 < r <= q:
        print(f"Rule {r}: {quotes[r - 1]}")
    else:
        print(f"Rule {r}: No such rule")
