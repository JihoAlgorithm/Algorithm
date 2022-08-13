N = input()
A = [*input().split()]
V = input()
print(len([*filter(lambda v: v == V, A)]))
