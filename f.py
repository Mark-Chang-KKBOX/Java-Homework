def f(n):
    ladderTypes = (1, 3, 5)
    f = [0] * (n + 1)
    f[0] = 1

    for totalLen in range(1, n + 1):
        for ladderLen in ladderTypes:
            if totalLen >= ladderLen:
                f[totalLen] = f[totalLen] + f[totalLen - ladderLen];

    return f[n]

print (f(1000))

