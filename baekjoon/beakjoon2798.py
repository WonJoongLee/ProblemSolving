n, m = map(int, input().split())
big = 0
a = list(map(int, input().split()))
for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            if m >= a[i]+a[j]+a[k] > big:
                big = a[i]+a[j]+a[k]
print(big)