n, m = map(int, input().split())
last = chr(64 + m)


def check_bound(problems: str) -> bool:
    for problem in problems:
        if last < problem:
            return False
    return True


def solution() -> int:
    count = 0
    for _ in range(n):
        problems = input()
        if check_bound(problems):
            possible = len(set(problems))
            if len(problems) == possible:
                count += 1
    return count


print(solution())
