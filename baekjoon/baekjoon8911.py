for i in range(int(input())):
    s = input()
    xco, yco = 0, 0
    d = ["up", "right", "down", "left"]  # di는 direction으로 방향 up, down, left, right 가능
    k = 0  # 처음에는 북쪽을 보고 있으니까 0으로 해준다
    minx = 0
    maxx = 0
    miny = 0
    maxy = 0

    for j in range(len(s)):
        if s[j] == "F": # 앞으로 가는 것일 때
            if d[k] == d[0]:
                yco += 1
            elif d[k] == d[1]:
                xco += 1
            elif d[k] == d[2]:
                yco -= 1
            elif d[k] == d[3]:
                xco -= 1
        elif s[j] == "B": # 뒤로 가는 것일 때
            if d[k] == d[0]:
                yco -= 1
            elif d[k] == d[1]:
                xco -= 1
            elif d[k] == d[2]:
                yco += 1
            elif d[k] == d[3]:
                xco += 1
        elif s[j] == "L":
            if k - 1 < 0:
                k = 3
            else:
                k -= 1
        elif s[j] == "R":
            if k + 1 > 3:
                k = 0
            else:
                k += 1

        if xco > maxx:
            maxx = xco
        if xco < minx:
            minx = xco
        if yco > maxy:
            maxy = yco
        if yco < miny:
            miny = yco

    print((maxx-minx)*(maxy-miny))
