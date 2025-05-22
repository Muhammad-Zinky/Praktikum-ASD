package P1Jobsheet12;

import java.util.Scanner;

public class DLLMain10 {

    public static Mahasiswa10 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = scan.nextDouble();
        scan.nextLine(); 
        return new Mahasiswa10(nim, nama, kelas, ipk);
    }

    public static void main(String[] args) {
        DoubleLinkedList10 list = new DoubleLinkedList10();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Menu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus dari awal");
            System.out.println("4. Hapus dari akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari mahasiswa berdasarkan NIM");
            System.out.println("7. Insert after");
            System.out.println("8. Tambah pada indeks tertentu");
            System.out.println("9. Hapus pada indeks tertentu");
            System.out.println("10. Tampilkan jumlah data");
            System.out.println("11. Tampilkan data pertama");
            System.out.println("12. Tampilkan data terakhir");
            System.out.println("13. Tampilkan data pada indeks tertentu");
            System.out.println("14. Tampilkan total indeks"); 
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine(); 
        switch (pilihan) {
            case 1 -> {
                Mahasiswa10 mhs = inputMahasiswa(scan);
                list.addFirst(mhs);
            }
            case 2 -> {
                Mahasiswa10 mhs = inputMahasiswa(scan);
                list.addLast(mhs);
            }
            case 3 -> list.removeFirst();
            case 4 -> list.removeLast();
            case 5 -> list.print();
            case 6 -> {
                System.out.println("Masukkan NIM yang dicari: ");
                String nim = scan.nextLine();
                Node10 found = list.search(nim);
                if (found != null) {
                    System.out.println("Data ditemukan: ");
                    found.data.tampil();
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }
            case 7 -> {
                System.out.print("Masukkan NIM setelah data mana ingin disisipkan: ");
                String keyNim = scan.nextLine();
                Mahasiswa10 mhs = inputMahasiswa(scan);
                list.insertAfter(keyNim, mhs);
            }
            case 8 -> {
                System.out.print("Masukkan indeks: ");
                int idx = scan.nextInt();
                scan.nextLine();
                Mahasiswa10 mhs = inputMahasiswa(scan);
                list.add(idx, mhs);
            }
            case 9 -> {
                System.out.print("Masukkan indeks yang ingin dihapus: ");
                int idx = scan.nextInt();
                scan.nextLine();
                list.remove(idx);
            }
            case 10 -> System.out.println("Jumlah data dalam linked list: " + list.getSize());
            case 11 -> list.getFirst();
            case 12 -> list.getLast();
            case 13 -> {
                System.out.print("Masukkan indeks: ");
                int idx = scan.nextInt();
                scan.nextLine();
                list.getIndex(idx);
            }
            case 14 -> {
                if (list.getSize() == 0) {
                    System.out.println("Linked list masih kosong. Total indeks: 0");
                } else {
                    System.out.println("Total indeks: " + (list.getSize() + 1));
                }
            }
            case 0 -> System.out.println("Keluar dari program.");
            default -> System.out.println("Pilihan tidak valid!");
        }
        }
        while (pilihan != 0);
        scan.close();
    }
}
