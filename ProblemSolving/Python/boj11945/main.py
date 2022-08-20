N, M = map(int, input().split())
fish_shaped_bun = [input()[::-1] for _ in range(N)]
print("\n".join(fish_shaped_bun))
