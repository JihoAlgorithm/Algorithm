import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

N, M = map(int, input().decode().split())
board = [input().decode().rstrip() for _ in range(N)]


def check(board: list, dir1: str, dir2: str) -> None:
    for row in board:
        if "#" in row:
            if "#.#" in "".join(row):
                print(dir1)
            break
    for row in reversed(board):
        if "#" in row:
            if "#.#" in "".join(row):
                print(dir2)
            break


if __name__ == "__main__":
    check(board, "UP", "DOWN")
    check([*zip(*board)], "LEFT", "RIGHT")
