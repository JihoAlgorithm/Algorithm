winner, w__price = input().split()
xxx___, x__price = input().split()
yyy___, y__price = input().split()
___xxx, _x_price = input().split()
___yyy, _y_price = input().split()
____zz, _z_price = input().split()

while True:
    number = input()
    if number == "-1":
        break
    price = 0
    if number == winner:
        price += int(w__price)
    if number[:3] == xxx___:
        price += int(x__price)
    if number[:3] == yyy___:
        price += int(y__price)
    if number[3:] == ___xxx:
        price += int(_x_price)
    if number[3:] == ___yyy:
        price += int(_y_price)
    if number[4:] == ____zz:
        price += int(_z_price)
    print(price)
