for _ in range(int(input())):
    print(2015 - sum(set(map(lambda c: ord(c), input()))))
