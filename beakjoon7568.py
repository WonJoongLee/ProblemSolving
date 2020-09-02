n = int(input())
w = []
h = []
cnt=[]

for i in range(n):
    a, b = map(int, input().split())
    w.append(a)
    h.append(b)
    cnt.append(1)


for i in range(n):
    for j in range(n):
        if i != j and w[i] < w[j] and h[i] < h[j]:
            cnt[i] += 1

for i in range(n):
    print(cnt[i], end=" ")
