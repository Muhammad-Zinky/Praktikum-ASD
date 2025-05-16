import java.util.Scanner;

public class KRSMain10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS10 antrian = new AntrianKRS10(10);
        int pilihan;

        do {
            System.out.println("\n=== MENU PENGAJUAN KRS MAHASISWA ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Proses KRS untuk 2 Mahasiswa");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Lihat 2 Mahasiswa Terdepan");
            System.out.println("5. Lihat Mahasiswa Terakhir");
            System.out.println("6. Cek Jumlah Antrian");
            System.out.println("7. Cek Jumlah Sudah Proses");
            System.out.println("8. Cek Mahasiswa Belum Proses");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt(); sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    Mahasiswa10q mhs = new Mahasiswa10q(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    antrian.prosesKRS();
                    break;
                case 3:
                    antrian.tampilkanSemua();
                    break;
                case 4:
                    antrian.lihatDuaTerdepan();
                    break;
                case 5:
                    antrian.lihatTerakhir();
                    break;
                case 6:
                    System.out.println("Jumlah mahasiswa dalam antrian: " + antrian.jumlahAntrian());
                    break;
                case 7:
                    System.out.println("Jumlah mahasiswa yang sudah diproses: " + antrian.jumlahSudahProses());
                    break;
                case 8:
                    System.out.println("Jumlah mahasiswa yang belum diproses: " + antrian.jumlahBelumProses());
                    break;
                case 9:
                    antrian.clear();
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}