import sys

l = []
top = 0
for i in range(int(sys.stdin.readline().rstrip())):
    c = sys.stdin.readline().rstrip().split(' ')
    if c[0] == "push":
        l.append(c[1])
    elif c[0] == "pop":
        if len(l) - top == 0:
            print("-1")
        else:
            print(l[top])
            top += 1
    elif c[0] == "size":
        print(len(l) - top)
    elif c[0] == "empty":
        print("1" if len(l) - top == 0 else "0")
    elif c[0] == "front":
        print(l[top] if len(l) - top != 0 else "-1")
    elif c[0] == "back":
        print(l[-1] if len(l) - top != 0 else "-1")
