T = int(input())
while T:
    a, b = input().split()
    print("OK" if a == b else "ERROR")
    T -= 1
