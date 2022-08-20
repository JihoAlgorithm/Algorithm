for i in range(int(input())):
    print(f"String #{i + 1}")
    string = ""
    for c in input():
        k = "A" if c == "Z" else chr(ord(c) + 1)
        string += k
    print(string, end="\n\n")
