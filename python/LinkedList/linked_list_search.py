class Node :
    def __init__(self,data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self,value):
        self.head = Node(value)

    def append(self,value):
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        cur.next = Node(value)

    def print_all(self):
        cur = self.head
        while cur is not None:
            print(cur.data)
            cur = cur.next

    def get_node(self,index):
        cur = self.head
        cur_index = 0

        while cur_index != index:
            cur = cur.next
            cur_index += 1
        return cur

if __name__ == "__main__":
    linked_list = LinkedList(5)
    linked_list.append(12)
    linked_list.append(8)
    linked_list.append(20)

    print("전체 LinkedList:")
    linked_list.print_all()

    index_to_find = 2
    node = linked_list.get_node(index_to_find)
    if node:
        print(f"\n인덱스 {index_to_find} 의 값:", node.data)
    else:
        print(f"\n인덱스 {index_to_find} 는 존재하지 않습니다.")