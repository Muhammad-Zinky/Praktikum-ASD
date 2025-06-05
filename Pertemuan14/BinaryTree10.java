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

