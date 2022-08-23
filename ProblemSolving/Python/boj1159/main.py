squad = {}

for _ in range(int(input())):
    name = input()

    if name[0] in squad.keys():
        squad[name[0]] += 1
    else:
        squad[name[0]] = 1

available = ""

for key in sorted(squad.keys()):
    if squad[key] > 4:
        available += key

print(available if available else "PREDAJA")
