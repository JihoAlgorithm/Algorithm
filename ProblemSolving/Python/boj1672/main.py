ctoi = {"A": 0, "G": 1, "C": 2, "T": 3}
mapper = [[0, 2, 0, 1], [2, 1, 3, 0], [0, 3, 2, 1], [1, 0, 1, 3]]

idx = int(input()) - 1
seq = input()
last = ctoi[seq[idx]]

while idx > 0:
    idx -= 1
    last = mapper[ctoi[seq[idx]]][last]

print("AGCT"[last])
