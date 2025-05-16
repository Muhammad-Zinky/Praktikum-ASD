package Tugas;

public class Queue10 {
    Node10 front, rear;
    int size, maxSize;

    public Queue10(int maxSize) {
        this.front = this.rear = null;
        this.size = 0;
        this.maxSize = maxSize;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean isFull() {
        return size >= maxSize;
    }

    public void enqueue(Mahasiswa10 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh. Tidak bisa menambahkan.");
            return;
        }

        Node10 newNode = new Node10(mhs);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Mahasiswa berhasil ditambahkan ke antrian.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong. Tidak ada yang bisa dipanggil.");
            return;
        }

        System.out.println("Memanggil: " + front.data);
        front = front.next;
        if (front == null) rear = null;
        size--;
    }

    public void clear() {
        front = rear = null;
        size = 0;
        System.out.println("Antrian dikosongkan.");
    }

    public void tampilDepanBelakang() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian terdepan: " + front.data);
            System.out.println("Antrian terakhir : " + rear.data);
        }
    }

    public void tampilJumlah() {
        System.out.println("Jumlah mahasiswa dalam antrian: " + size);
    }

    public void tampilSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Daftar antrian:");
        Node10 temp = front;
        int no = 1;
        while (temp != null) {
            System.out.println(no + ". " + temp.data);
            temp = temp.next;
            no++;
        }
    }
}
