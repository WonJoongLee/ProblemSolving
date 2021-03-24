a, b = map(int, input().split())
month = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
sum = 0

for i in range(a):
    sum += month[i]

sum = (sum + b) % 7

if sum == 1:
    print("MON")
elif sum == 2:
    print("TUE")
elif sum == 3:
    print("WED")
elif sum == 4:
    print("THU")
elif sum == 5:
    print("FRI")
elif sum == 6:
    print("SAT")
elif sum == 0:
    print("SUN")
else:
    print("먼가잘못됨")
