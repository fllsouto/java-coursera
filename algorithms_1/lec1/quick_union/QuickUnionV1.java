package algorithms_1.lec1.quick_union;

public class QuickUnionV1 {
  
  private int n;
  private int[] arr;

  public QuickUnionV1(int n) {
    this.n = n;
    arr = new int[n];
    for(int i = 0; i < n; i++) arr[i] = i;
  }

  public boolean find(int p, int q) {
    return root(p) == root(q); 
  }

  public int root(int p) {
    while(p != arr[p]) p = arr[p];
    return p;
  }

  public void union(int p, int q) {
    int proot = root(p);
    int qroot = root(q);
    arr[proot] = qroot;
  }

  public void show_unions() {
    System.out.format("\n");
    for(int e : arr) System.out.format("[%d]", e);
    System.out.format("\n");
  }

  public void askFind(int p, int q) {
    if(this.find(p, q)) {
      System.out.format("%d and %d are connected!\n", p, q);
    } else {
      System.out.format("%d and %d aren't connected!\n", p, q);
    }
  }

  public static void main(String[] args) {
    int n = 10;
    QuickUnionV1 qf = new QuickUnionV1(n);
    qf.union(4, 3);
    qf.askFind(4,3);
    qf.askFind(4,8);
    qf.union(3, 8);
    qf.union(6, 5);
    qf.union(9, 4);
    qf.union(2, 1);
    qf.union(8, 9);
    qf.union(5, 0);
    qf.union(7, 2);
    qf.union(6, 1);
    qf.askFind(7,3);
    qf.union(7, 3);
    qf.askFind(7,3);
    qf.show_unions();

    qf.askFind(1, 4);
  }
}