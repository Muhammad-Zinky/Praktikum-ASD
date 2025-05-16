public class AntrianKRS10 {
    Mahasiswa10q[] antrian;
    int front, rear, size, max;
    int jumlahDiproses;

    public AntrianKRS10(int kapasitas) {
        max = kapasitas;
        antrian = new Mahasiswa10q[max];
        front = 0;
        rear = -1;
        size = 0;
        jumlahDiproses = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian dikosongkan.");
    }

    public void tambahAntrian(Mahasiswa10q mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }
        rear = (rear + 1) % max;
        antrian[rear] = mhs;
        size++;
        System.out.println("Mahasiswa berhasil masuk antrian.");
    }

    public void prosesKRS() {
        if (size < 2) {
            System.out.println("Tidak cukup mahasiswa untuk diproses (minimal 2).");
            return;
        }
        System.out.println("Memproses 2 mahasiswa:");
        for (int i = 0; i < 2; i++) {
            Mahasiswa10q mhs = antrian[front];
            mhs.tampilkan();
            front = (front + 1) % max;
            size--;
            jumlahDiproses++;
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            antrian[index].tampilkan();
        }
    }

    public void lihatDuaTerdepan() {
        if (size < 2) {
            System.out.println("Tidak cukup mahasiswa dalam antrian.");
            return;
        }
        System.out.println("Dua mahasiswa terdepan:");
        for (int i = 0; i < 2; i++) {
            int index = (front + i) % max;
            antrian[index].tampilkan();
        }
    }

    public void lihatTerakhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling akhir:");
            antrian[rear].tampilkan();
        }
    }

    public int jumlahAntrian() {
        return size;
    }

    public int jumlahSudahProses() {
        return jumlahDiproses;
    }

    public int jumlahBelumProses() {
        int totalMaksimal = 30;
        return totalMaksimal - jumlahDiproses;
    }
}