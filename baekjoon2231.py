t = str(input())  # str형식 입력받은 수
digit = len(t)  # digit = 자릿수
start = 10 ** (int(digit) - 2)  # start = 10, 100, 1000과 같이 시작하는 수, 조금이라도 O(n)줄여주기위함
ans = 0  # 정답 저장할 변수
if int(t) <= 10:
    pass
else:
    for i in range(start, int(t)):
        e = list(map(int, str(i)))  # 216이라면 2,1,6이렇게 나눠주는 것!! 중요, 이부분을 몰랐음
        if int(t) == i + sum(e):
            ans = i
            break
if ans == 0 or ans < 10:
    print("0")
else:
    print(ans)
