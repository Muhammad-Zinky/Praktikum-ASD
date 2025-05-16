public class Mahasiswa10q {
    String nim;
    String nama;
    String prodi;
    String kelas;

    public Mahasiswa10q(String nim, String nama, String prodi, double kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }

    public void tampilkan() {
        System.out.println(nim + " - " + nama + " - " + prodi + " - " + kelas);
    }

    public void tampilInformasi() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tampilInformasi'");
    }
}