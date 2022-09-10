for _ in range(int(input())):
    print(f"Hamming distance is {sum(a != b for a, b in zip(input(), input()))}.")
