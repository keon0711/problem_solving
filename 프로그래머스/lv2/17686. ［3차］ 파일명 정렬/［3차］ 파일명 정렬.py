import re


def solution(files):
    li = []
    p = re.compile("[0-9]+")
    
    for file in files:
        m = p.search(file)
        li.append([file[:m.start()].lower(), int(m.group()), file])
    
    
    li.sort(key = lambda x: (x[0], x[1]))
    return [x[-1] for x in li]