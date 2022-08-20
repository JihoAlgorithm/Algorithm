agent = []

for i in range(5):
    if "FBI" in input():
        agent.append(i + 1)

if agent:
    print(*agent)
else:
    print("HE GOT AWAY!")
