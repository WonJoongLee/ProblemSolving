num = int(input())
for i in range(num):
    vps = list(input())
    while len(vps) != 0:
        if vps[0] == ')':
            print('NO')
            break
        else:
            if ')' in vps:
                vps.remove(')')
                vps.remove('(')
            else:
                print("NO")
                break
        if len(vps) == 0:
            print("YES")
