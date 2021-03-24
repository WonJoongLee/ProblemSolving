import itertools


def gcd(x, y):
    if y == 0:
        return x
    else:
        return gcd(y, x % y)


t = int(input())
for i in range(t):
    num = list(map(int, input().split()))
    num = num[1:]
    ans = 0
    for a, b in itertools.combinations(num, 2):
        ans += gcd(a, b)
    print(ans)
