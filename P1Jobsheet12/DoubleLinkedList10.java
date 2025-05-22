package P1Jobsheet12;

public class DoubleLinkedList10 {
    Node10 head;
    Node10 tail;
    int size;

    public DoubleLinkedList10() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa10 data) {
        Node10 newNode = new Node10(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        }
        size++;
    }

    public void addLast(Mahasiswa10 data) {
        Node10 newNode = new Node10(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void insertAfter(String keyNim, Mahasiswa10 data) {
        Node10 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node10 newNode = new Node10(data);

        if(current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah NIM" + keyNim);
        size++;
    }

    public void add(int index, Mahasiswa10 data) {
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node10 current = head;
        int i = 0;
        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Indeks melebihi panjang list.");
            return;
        }

        if (current == tail) {
            addLast(data);
            return;
        }

        Node10 newNode = new Node10(data);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    public void print() {
    if (isEmpty()) {
        System.out.println("Linked list masih kosong.");
        return;
    }
        Node10 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public void removeFirst() {
    if (isEmpty()) {
        System.out.println("List kosong, tidak bisa dihapus.");
        return;
    }

    System.out.println("Data yang terhapus adalah: ");
    head.data.tampil();

    if (head == tail) {
        head = tail = null;
    } else {
        head = head.next;
        head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void removeAfter(String keyNim) {
        Node10 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Node setelah NIM " + keyNim + " tidak ditemukan atau tidak ada.");
            return;
        }

        Node10 nodeToRemove = current.next;
        System.out.print("Data yang terhapus setelah NIM " + keyNim + " adalah: ");
        nodeToRemove.data.tampil();

        if (nodeToRemove == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = nodeToRemove.next;
            nodeToRemove.next.prev = current;
        }
        size--;
    }

    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }

        Node10 current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Indeks melebihi panjang list.");
            return;
        }

        System.out.print("Data yang terhapus pada indeks " + index + " adalah: ");
        current.data.tampil();

        if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
        size--;
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
        } else {
            System.out.print("Data pada node head: ");
            head.data.tampil();
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
        } else {
            System.out.print("Data pada node tail: ");
            tail.data.tampil();
        }
    }

    public void getIndex(int index) {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
            return;
        }
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        Node10 current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }
        if (current == null) {
            System.out.println("Indeks melebihi panjang list.");
        } else {
            System.out.print("Data pada indeks " + index + ": ");
            current.data.tampil();
        }
    }

    public int getSize() {
        return size;
    }

    public Node10 search(String nim) {
        Node10 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
