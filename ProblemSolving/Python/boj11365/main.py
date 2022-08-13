while True:
    password = input()
    if password == "END":
        break
    print("".join(reversed(password)))
