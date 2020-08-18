n, b = map(int, input().split())

tmp = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

result = ""

while n:
    result += str(tmp[n%b])
    n //= b
print(result[::-1])
