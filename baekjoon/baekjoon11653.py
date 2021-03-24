def div(n):
    for i in range(2, n+1):
        if n % i == 0:
            return i


n = int(input())
ans = []
while n != 1:
    ans.append(div(n))
    n //= div(n)

for i in range(len(ans)):
    print(ans[i])
