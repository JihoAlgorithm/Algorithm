for _ in range(int(input())):
    char, num = input().split("-")
    char_sum = 0

    for i, c in enumerate(char):
        char_sum += 26 ** (2 - i) * (ord(c) - 65)

    if -100 <= char_sum - int(num) <= 100:
        print("nice")
    else:
        print("not nice")
