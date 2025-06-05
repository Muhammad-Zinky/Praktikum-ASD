package Pertemuan14;

public class BinaryTree10 {
    Node10 root;

    public BinaryTree10() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa10 mahasiswa10) {
        Node10 newNode = new Node10(mahasiswa10);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node10 current = root;
            Node10 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa10.ipk < current.mahasiswa10.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void addRekursif(Mahasiswa10 mhs) {
        root = addRekursif(root, mhs);
    }
    Node10 addRekursif(Node10 node, Mahasiswa10 mhs) {
        if (node == null) {
            return new Node10(mhs);
        }
        if (mhs.ipk < node.mahasiswa10.ipk) {
            node.left = addRekursif(node.left, mhs);
        } else {
            node.right = addRekursif(node.right, mhs);
        }
        return node;
    }

    public void cariMinIPK() {
        if (root == null) {
            System.out.println("Tree kosong");
            return;
        }
        Node10 current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.println("Mahasiswa dengan IPK terkecil:");
        current.mahasiswa10.tampilInformasi();
    }

    public void cariMaxIPK() {
        if (root == null) {
            System.out.println("Tree kosong");
            return;
        }
        Node10 current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("Mahasiswa dengan IPK terbesar:");
        current.mahasiswa10.tampilInformasi();
    }

    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        tampilMahasiswaIPKdiAtas(root, ipkBatas);
    }

    void tampilMahasiswaIPKdiAtas(Node10 node, double ipkBatas) {
        if (node != null) {
            tampilMahasiswaIPKdiAtas(node.left, ipkBatas);
            if (node.mahasiswa10.ipk > ipkBatas) {
                node.mahasiswa10.tampilInformasi();
            }
            tampilMahasiswaIPKdiAtas(node.right, ipkBatas);
        }
    }

    boolean find(double ipk) {
        boolean result = false;
        Node10 current = root;
        while (current != null) {
            if (current.mahasiswa10.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa10.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    void traversePreOrder(Node10 node) {
        if (node != null) {
            node.mahasiswa10.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node10 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa10.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node10 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa10.tampilInformasi();
        }
    }

    Node10 GetSuccessor(Node10 del) {
        Node10 successor = del.right;
        Node10 successorParent = del;

        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }

        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong.");
            return;
        }

        Node10 parent = root;
        Node10 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa10.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa10.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa10.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
                
            } else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {
                Node10 successor = GetSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa10.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }
}