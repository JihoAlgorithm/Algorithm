N = int(input())
speaks = input().split()
blocks = ["he", "she", "him", "her"]

print(sum(blocks.count(s) for s in speaks))
