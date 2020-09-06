l = []
for i in range(int(input())):
    n = int(input())
    if n == 0:
        l.pop()
    else:
        l.append(n)
print(sum(l))