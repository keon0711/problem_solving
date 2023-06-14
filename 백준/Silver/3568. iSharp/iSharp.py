import sys

def solution():
    def split_var_name(var):
        for i, c in enumerate(var):
            if c in li:
                return var[:i], var[i:]

        return var, ""


    def reverse_type(type):
        result = []
        for c in type[::-1]:
            if c == "[":
                result.append("]")
            elif c == "]":
                result.append("[")
            else:
                result.append(c)
        return "".join(result)


    input = sys.stdin.readline

    li = ["*", "&", "["]
    str_split = input().rstrip().split(" ")
    for s in str_split[1:]:
        a, b = split_var_name(s[:-1])
        print(str_split[0] + reverse_type(b), a + ";")


solution()