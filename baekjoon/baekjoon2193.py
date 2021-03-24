def go(n):
    if n == 1:
        return 1
    if n == 2:
        return 1

    if d[n] > 0:
        return d[n]
    else:
        d[n] = go(n - 1) + go(n - 2)
        return d[n]


user = int(input())
d = [0 for _ in range(user+1)]
print(go(user))