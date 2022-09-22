mapper = [
    ("A", "000000"),
    ("B", "001111"),
    ("C", "010011"),
    ("D", "011100"),
    ("E", "100110"),
    ("F", "101001"),
    ("G", "110101"),
    ("H", "111010"),
]

N = int(input())
letters = input()
letters = [letters[i : i + 6] for i in range(0, len(letters), 6)]
answer = ""


def check(letter):
    res = ""
    for char in mapper:
        diff = sum(map(lambda t: t[0] == t[1], zip(letter, char[1])))
        if diff >= 5:
            res = char[0]
            break
    return res


for i, letter in enumerate(letters):
    res = check(letter)
    if res:
        answer += res
    else:
        answer = i + 1
        break

print(answer)
