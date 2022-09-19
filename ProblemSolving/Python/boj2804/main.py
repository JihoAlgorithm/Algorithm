A, B = input().split()
col = 0

for i, a in enumerate(A):
    if a in B:
        col = i
        row = B.index(a)
        break

l_points = "." * col
r_points = "." * (len(A) - col - 1)

for i in range(row):
    print(l_points, B[i], r_points, sep="")

print(A)

for i in range(row + 1, len(B)):
    print(l_points, B[i], r_points, sep="")
