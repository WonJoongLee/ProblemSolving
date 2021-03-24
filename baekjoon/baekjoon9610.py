q1, q2, q3, q4, axis = 0, 0, 0, 0, 0
for i in range(int(input())):
    a, b = map(int, input().split())
    if a > 0 and b > 0:
        q1 += 1
    elif a > 0 and b < 0:
        q4 += 1
    elif a < 0 and b > 0:
        q2 += 1
    elif a < 0 and b < 0:
        q3 += 1
    else:
        axis += 1

print("Q1: " + str(q1) + "\n" + "Q2: " + str(q2) + "\n" + "Q3: " + str(q3) + "\n" + "Q4: " + str(q4) + "\n" + "AXIS: " + str(axis))
