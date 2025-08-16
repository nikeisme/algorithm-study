class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# 3을 가진 Node 생성
node = Node(3) # 현재는 next 가 없이 하나의 노드인 상태


class LinkedList:
    def __init__(self, value):
        self.head = Node(value)  # head 에 시작하는 Node 를 연결

    def append(self, value):  # LinkedList 가장 끝에 있는 노드에 새로운 노드를 연결.
        cur = self.head
        while cur.next is not None: # cur의 다음이 끝에 갈 때까지 이동
            cur = cur.next
        cur.next = Node(value)


linked_list = LinkedList(5)
linked_list.append(12) #5 -> 12 형태로 노드를 연결
linked_list.append(8) # 5 -> 12 -> 8 형태로 노드를 연결
