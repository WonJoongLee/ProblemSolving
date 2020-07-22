fibo = [0 for i in range(91)]
fibo[0] = 0
fibo[1] = 1
t = int(input())
for i in range(2, t+1):
    fibo[i] = fibo[i - 1] + fibo[i - 2]
print(fibo[t])