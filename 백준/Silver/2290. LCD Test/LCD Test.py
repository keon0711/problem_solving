s, numbers = input().split()
s = int(s)

h, v = '-', '|'

def fill_segment(num):
    lcd = [[' ' for _ in range(s + 2)] for _ in range(2*s + 3)]

    for i in range(s):
        if num in '23567890':
            lcd[0][1 + i] = h
        if num in '2345689':
            lcd[s + 1][1 + i] = h
        if num in '2356890':
            lcd[2*s + 2][1 + i] = h

        if num in '456890':
            lcd[1 + i][0] = v
        if num in '2680':
            lcd[s + 2 + i][0] = v

        if num in '12347890':
            lcd[1 + i][s + 1] = v
        if num in '134567890':
            lcd[s + 2 + i][s + 1] = v

    return lcd

display = [fill_segment(n) for n in numbers]

for line in zip(*display):
    for l in line:
        print(''.join(l), end = ' ')
    print()