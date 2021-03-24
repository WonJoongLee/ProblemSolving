cnt = 0
for i in range(int(input())):
    a = []
    l = input()
    a.append(l[0])
    k = 0
    for j in range(1, len(l)):
        a.append(l[j])
        if a[len(a) - 1] == a[len(a) - 2] and len(a) > 1:
            a.pop(len(a) - 1)
            a.pop(len(a) - 1)
        k += 1
    if len(a) == 0:
        cnt += 1

print(cnt)
