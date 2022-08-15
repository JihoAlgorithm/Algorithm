n, c = map(int, input().split())
rooms = [input().split() for _ in range(n)]
bedroom = 0
balcony = 0
flats = 0

for room in rooms:
    area = int(room[0])
    if room[1] == "bedroom":
        bedroom += area
    elif room[1] == "balcony":
        balcony += area
    flats += area

print(flats)
print(bedroom)
print(c * (flats - balcony / 2))
