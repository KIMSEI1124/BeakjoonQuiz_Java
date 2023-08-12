package etc;

public class 수열_편집 {
    public static void main(String[] args) {

    }

    private static class Node {
        private long value;  // 해당 노드
        private Node prev;  // 이전 노드
        private Node next;  // 다음 노드

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public long getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private static class CustomLinkedList {
        private Node head;
        private Node tail;
        private int size;

        public void add(Node node) {
            if (isEmpty()) {
                head = node;
                tail = node;
                size++;
                return;
            }

            tail.setNext(node); // 리스트의 마지막 노드의 다음 노드를 새로운 노드로 선언
            node.setPrev(tail); // 새로운 노드의 아전 노드를 리스트의 마지막 노드로 선언
            tail = node; // 리스트의 마지막 노드를 새로 삽입된 노드로 수정
            size++;
        }

        public void add(int index, Node node) {
            /* 마지막 번호에 삽입할 경우 */
            if (index == size) {
                add(node);
                return;
            }

            Node nextNode = search(index);
            Node prevNode = nextNode.getPrev();

            /* nextNode Update */
            nextNode.setPrev(node);
            node.setNext(nextNode);

            /* prevNode Update */
            prevNode.setNext(node);
            node.setPrev(prevNode);
            size++;
        }

        public boolean remove(int index) {
            Node removeNode = search(index);

            /* 삭제가 안 될 경우 return 값은 false */
            if (removeNode == null) {
                return false;
            }

            if (removeNode.equals(head)) {

            }

            if (removeNode.equals(tail)) {

            }

            Node prevNode = removeNode.getPrev();
            Node nextNode = removeNode.getNext();

            return true;
        }

        public long update(int index, long value) {
            Node searchNode = search(index);

            /* 값이 비어있으면 -1을 리턴 */
            if (searchNode == null) {
                return -1L;
            }

            return value;
        }

        public Node search(int index) {
            if (isEmpty() || index > size) {
                return null;
            }

            Node searchNode = head;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    break;
                }
                searchNode = searchNode.getNext();
            }

            return searchNode;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
