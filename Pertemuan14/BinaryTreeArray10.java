package Pertemuan14;

public class BinaryTreeArray10 {
        Mahasiswa10[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray10() {
        this.dataMahasiswa = new Mahasiswa10[10];
    }

    void populateData(Mahasiswa10[] dataMhs, int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1); 
                dataMahasiswa[idxStart].tampilInformasi();
                traverseInOrder(2 * idxStart + 2); 
            }
        }
    }
}

