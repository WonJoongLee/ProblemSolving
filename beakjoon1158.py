N, K = map(int, input().split())
arr = [i for i in range(1, N + 1)]  # 맨 처음에 원에 앉아있는 사람들

answer = []  # 제거된 사람들을 넣을 배열
pos = 0  # 제거될 사람의 인덱스 번호

for t in range(N):
    pos += K - 1
    if pos >= len(arr):  # 한바퀴를 돌고 그다음으로 돌아올때를 대비해 값을 나머지로 바꿈
        pos = pos % len(arr)

    answer.append(str(arr.pop(pos)))
print("<", ", ".join(answer)[:], ">", sep='')
