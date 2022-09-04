words = input().split()
useless = ["i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"]
answer = words.pop(0)[0]

for word in words:
    if word not in useless:
        answer += word[0]

print(answer.upper())
