k, p, n = input().split()
k = int(k)
p = int(p)
n = int(n)
arr = list()

for i in range(n):
    k = k * p
    if k >= 1000000007:
        k = k % 1000000007
print(k)
