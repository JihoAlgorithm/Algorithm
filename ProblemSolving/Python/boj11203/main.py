import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

H, *commands = input().decode().split()
H = int(H)
size = 1 << (H + 1)


def drop() -> int:
    idx = 1
    if commands:
        for command in commands[0]:
            if command == "L":
                idx <<= 1
            else:
                idx <<= 1
                idx += 1
    return size - idx


if __name__ == "__main__":
    print(drop())
