def solution(s: str) -> str:
    count_2 = s.count("2")
    count_e = s.count("e")
    if count_2 == count_e:
        return "yee"
    return "2" if count_2 > count_e else "e"


input()
print(solution(input()))
