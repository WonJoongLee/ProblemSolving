import sys

t = int(input())
l = []
for i in range(t):
    s = str(sys.stdin.readline())
    s = s[:len(s) - 1]

    if s.find(" ") != -1:
        if s[:s.find(" ")] == "push_back":
            l.append(s[s.find(" "):])  # 여기 int 추가해야하는지?
        elif s[:s.find(" ")] == "push_front":
            l.insert(0, s[s.find(" "):])
    elif s == "pop_front":
        if len(l) == 0:
            print("-1")
        else:
            x = l.pop(0)
            print(x[1:])
    elif s == "pop_back":
        if len(l) == 0:
            print("-1")
        else:
            x = l.pop()
            print(x[1:])
    elif s == "size":
        print(str(len(l)))
    elif s == "empty":
        if len(l) == 0:
            print("1")
        else:
            print("0")
    elif s == "front":
        if len(l) == 0:
            print("-1")
        else:
            print(l[0][1:])
    elif s == "back":
        if len(l) == 0:
            print("-1")
        else:
            print(l[len(l) - 1][1:])
