from typing import List


def solution(phone_book: List[str]):
    phone_book = sorted(phone_book)

    for i in range(1, len(phone_book)):
        a = phone_book[i - 1]
        b = phone_book[i]
        if len(a) < len(b):
            if b.startswith(a):
                return False
    return True


if __name__ == "__main__":
    assert solution(["119", "97674223", "1195524421"]) == False  # noqa: E712
    assert solution(["123", "456", "789"]) == True  # noqa: E712
    assert solution(["12", "123", "1235", "567", "88"]) == False  # noqa: E712
    print("SUCCESS")
