n = int(input())
mem = []
for i in range(n):
    mem.append(list(input().split()))

mem.sort(key=lambda x: int(x[0]))
for i, j in mem:
    print(i, j)
