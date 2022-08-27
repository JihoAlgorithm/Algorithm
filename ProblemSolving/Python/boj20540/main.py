mapper = {
    "E": "I",
    "I": "E",
    "S": "N",
    "N": "S",
    "T": "F",
    "F": "T",
    "J": "P",
    "P": "J",
}

print("".join(map(lambda k: mapper[k], input())))
