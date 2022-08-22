try:
    a, b = map(int, input().split())
    exec("print(a - b)")
except Exception:
    print("NaN")
