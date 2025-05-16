public class SLLMain10 {
    public static void main(String[] args) {
        SingleLinkedList10 sll = new SingleLinkedList10();
        Mahasiswa10 mhs1 = new Mahasiswa10("101", "Zeki", "1A", 3.7);
        Mahasiswa10 mhs2 = new Mahasiswa10("102", "Zinky", "1C", 3.5);
        Mahasiswa10 mhs3 = new Mahasiswa10("103", "Angga", "1D", 3.8);
        Mahasiswa10 mhs4 = new Mahasiswa10("104", "Sastra", "1B", 3.6);
        Mahasiswa10 mhs5 = new Mahasiswa10("105", "Syamlan", "1E", 3.9);

        sll.print();
        sll.addFirst(mhs4);
        sll.print();
        sll.addLast(mhs1);
        sll.print();
        sll.insertAfter("Sastra", mhs3);
        sll.insertAt(2, mhs2);
        sll.insertAt(3, mhs5);
        sll.print();
    }
}
