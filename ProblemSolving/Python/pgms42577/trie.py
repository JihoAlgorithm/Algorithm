"""TLE 효율성 4번 - 이유를 모르겠음"""
from typing import List


def solution(phone_book: List[str]):
    trie = Trie()
    is_available = True
    for number in phone_book:
        if is_available:
            is_available = trie.insert(number)
    return is_available


class Trie:
    def __init__(self) -> None:
        self.is_tail = False
        self.children = [None] * 10

    def insert(self, number: str) -> bool:
        t = self
        length = len(number)

        for i in range(length):
            idx = int(number[i])

            if t.children[idx] is None:
                t.children[idx] = Trie()
            else:
                if t.children[idx].is_tail and i + 1 != length:
                    return False
                if i + 1 == length:
                    return False

            t = t.children[idx]

        t.is_tail = True
        return True


if __name__ == "__main__":
    assert solution(["119", "97674223", "1195524421"]) == False  # noqa: E712
    assert solution(["123", "456", "789"]) == True  # noqa: E712
    assert solution(["12", "123", "1235", "567", "88"]) == False  # noqa: E712
    print("SUCCESS")
