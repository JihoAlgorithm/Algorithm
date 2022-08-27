votes = {"Lion": 0, "Tiger": 0}

for _ in range(9):
    votes[input()] += 1

print("Lion" if votes["Lion"] > votes["Tiger"] else "Tiger")
