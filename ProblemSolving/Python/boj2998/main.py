binary = input()
length = len(binary)

if length % 3:
    binary = "0" * (3 - (length % 3)) + binary
    length = len(binary)

chunks = [binary[i : i + 3] for i in range(0, len(binary), 3)]
print("".join(map(lambda n: str(int(n, 2)), chunks)))
