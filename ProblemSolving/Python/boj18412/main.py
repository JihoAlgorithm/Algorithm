N, A, B = map(int, input().split())
S = input()

if A > 2:
    print(S[: A - 1] + S[B - 1 : A - 2 : -1] + S[B:])
else:
    print(S[: A - 1] + S[B - 1 :: -1] + S[B:])
