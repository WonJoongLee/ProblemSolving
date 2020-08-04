import sys

n, m = map(int, input().split())
board = [list(sys.stdin.readline().rstrip()) for _ in range(n)]

def block_cnt(_i, _j):
    cntWB = 0
    cntBW = 0
    for i2 in range(_i, _i + 8):
        for j2 in range(_j, _j + 8):
            if (i2 - _i + j2 - _j) % 2 == 0:
                if board[i2][j2] == 'B':
                    cntWB += 1
                else:
                    cntBW += 1
            else:
                if board[i2][j2] == 'W':
                    cntWB += 1
                else:
                    cntBW += 1
    return cntWB, cntBW


_min = n * m
for i in range(n-7):
    for j in range(m-7):
        cnt1, cnt2 = block_cnt(i, j)
        _min = min(_min, cnt1, cnt2)
print(_min)
