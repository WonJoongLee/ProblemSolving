t = int(input())
l = list(map(int, input().split()))
save = []
for i in range(t):
    s = 0  # s = sum
    for j in range(t):
        if i == j:
            continue
        elif l[i] >= l[j]:
            s += l[i] - l[j]
        elif l[i] < l[j]:
            s += l[j] - l[i]
    save.append(s)

m = 1987654321
mindex = 0
for i in range(len(save)):
    if save[i] == m and l[i] < l[mindex]:
        m = save[i]
        mindex = i
    elif save[i] < m:
        m = save[i]
        mindex = i

print(l[mindex])
