import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

oxygen, ocean, temperature = 0, 0, -30

for _ in range(int(input().decode())):
    exec(input().decode().replace("+", "+="))

print("◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢")
print(oxygen, ocean, temperature)
print("◤◢◤◢◤◢◤◢◤◢◤◢◤◢◤◢")

print("lniovte albilvee a b l e"[oxygen < 14 or ocean < 9 or temperature < 8 :: 2])

# if oxygen < 14 or ocean < 9 or temperature < 8:
#     print("not liveable")
# else:
#     print("liveable")
