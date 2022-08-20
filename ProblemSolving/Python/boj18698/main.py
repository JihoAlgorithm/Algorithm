for _ in range(int(input())):
    count = 0
    for arms in input():
        if arms == "D":
            break
        count += 1
    print(count)
