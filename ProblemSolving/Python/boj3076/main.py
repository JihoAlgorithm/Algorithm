R, C = map(int, input().split())
A, B = map(int, input().split())

type_1 = ("X" * B + "." * B) * (C >> 1) + ("X" * B if C & 1 else "")
type_2 = ("." * B + "X" * B) * (C >> 1) + ("." * B if C & 1 else "")

for i in range(R):
    for _ in range(A):
        print(type_2 if i & 1 else type_1)
