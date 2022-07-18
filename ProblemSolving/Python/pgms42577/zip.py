from typing import List


def solution(phone_book: List[str]):
    phone_book = sorted(phone_book)

    for a, b in zip(phone_book, phone_book[1:]):
        if b.startswith(a):
            return False

    return True


if __name__ == "__main__":
    assert solution(["119", "97674223", "1195524421"]) == False  # noqa: E712
    assert solution(["123", "456", "789"]) == True  # noqa: E712
    assert solution(["12", "123", "1235", "567", "88"]) == False  # noqa: E712
    print("SUCCESS")
