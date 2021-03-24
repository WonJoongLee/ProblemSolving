while True:
    word = str(input())
    rev = ''.join(reversed(word))
    if word == '0':
        break
    if word == rev:
        print("yes")
    else:
        print("no")
