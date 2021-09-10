import itertools

n, m = map(int, input().split())
l = list(map(int, input().split()))
ans = []
for i in list(itertools.permutations(l, m)):
    ans.append(i)
ans = list(set(ans))
for i in sorted(ans):
    for j in i:
        print(j, end=' ')
    print()
