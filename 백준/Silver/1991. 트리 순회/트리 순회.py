import collections


def preorder(node):
    if node == ".":
        return

    print(node, end='')
    preorder(tree[node][0])
    preorder(tree[node][1])


def inorder(node):
    if node == ".":
        return
    inorder(tree[node][0])
    print(node, end='')
    inorder(tree[node][1])


def postorder(node):
    if node == ".":
        return
    postorder(tree[node][0])
    postorder(tree[node][1])
    print(node, end='')


N = int(input())
tree = collections.defaultdict(list)
for _ in range(N):
    self, left, right = input().split()
    tree[self] = [left, right]

root = "A"
preorder(root)
print()
inorder(root)
print()
postorder(root)
