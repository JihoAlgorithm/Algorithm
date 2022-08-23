num = sum(map(lambda c: (ord(c) & 31) + (26 if ord(c) < 97 else 0), input()))
is_prime = True

if num == 1:
    is_prime = True
else:
    i = 2
    bound = int(num**0.5)
    while i <= bound:
        if not num % i:
            is_prime = False
            break
        i += 1

print("It", "is" if is_prime else "is not", "a prime word.")
