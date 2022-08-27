n = int(input())
mumbles = input().split()


def check(mumbles) -> str:
    for i, a in enumerate(mumbles):
        if a != "mumble":
            if int(a) != i + 1:
                return "something is fishy"
    return "makes sense"


print(check(mumbles))
