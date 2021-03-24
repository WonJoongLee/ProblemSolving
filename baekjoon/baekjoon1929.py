m, n = map(int, input().split())
l = []
k = [1 for i in range(1000001)]  # 1로 초기화
for i in range(0, 1000001):
    l.append(i)

for i in range(2, int(n ** (1 / 2)) + 1):
    j = 2
    while i * j <= n:
        k[i * j] = 0  # 소수가 아닌 것으로 판별
        j += 1

for i in range(m, n+1):
    if k[i] != 0 and l[i] != 1:
        print(l[i])