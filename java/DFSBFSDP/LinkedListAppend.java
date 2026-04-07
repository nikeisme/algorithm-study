public class LinkedListAppend { // LinkedListAppend 클래스 선언

    // Node 클래스 : 데이터와 다음 노드에 대한 참조를 가리킨다.
    static class Node {
        int data; // 노드가 저장하는 값
        Node next; // 다음 노드를 가리키는 포인터
        public Node(int data) {
            this.data = data;
        }
    }

    Node head; // 연결 리스트의 시작점

    //생성자 : 초기 노드를 만들어 head에 연결
    public LinkedListAppend(int value) {
        this.head = new Node(value);
    }

    // 리스트의 끝에 새로운 노드를 추가하는 함수
    public void append(int value) {
        Node cur = this.head;
        while (cur.next != null) { // 마지막 노드까지 이동
            cur = cur.next;
        }
        cur.next = new Node(value); // 마지막 노드의 next에 새 노드 연결
    }

    public void printAll() {
        Node cur = this.head;
        while (cur != null) { // 마지막 노드까지 이동
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        LinkedListAppend linkedList = new LinkedListAppend(5); // 첫 노드 생성
        linkedList.append(12); // 값이 12인 노드 추가
        linkedList.append(8); // 값이 8인 노드 추가
        linkedList.printAll(); // 전체 출력
    }
}
