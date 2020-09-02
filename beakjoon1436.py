n = int(input())
temp = 0
cnt = 0
while True:
    temp += 1
    if '666' in str(temp):
        cnt += 1
    if n == cnt:
        print(temp)
        break
