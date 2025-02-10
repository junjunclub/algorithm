import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BinarySearchTree5639 root;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        root.postTraversal();
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new BinarySearchTree5639();

        int rootValue = Integer.parseInt(br.readLine());
        root.insert(rootValue);

        while (true) {
            String input;
            input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(input));
        }
    }
}

class Node5639 {
    int value;
    Node5639 right, left;

    public Node5639 (int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }
}

class BinarySearchTree5639 {
    Node5639 root;

    public BinarySearchTree5639() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    public Node5639 insertRec(Node5639 root, int value) {
        if (root == null) {
            root = new Node5639(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public boolean searchRec(Node5639 root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        return (value < root.value) ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    public void postTraversal() {
        postOrderRec(root);
    }

    private void postOrderRec(Node5639 root) {
        if (root == null) {
            return;
        }
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.println(root.value);
    }
}
