package algorithm_1.lec1.quick_union;

public class QuickUnionV2 {
  public QuickUnionV2(int n) {
    this.n = n
    this.arr = new int[n];
    this.sz = new int[n];

    for(int i =0; i < n; i++) this.arr[i] = i;
  }

  public int root(int p) {
    while(p != arr[p]) p = arr[p];
    return p;
  }

  public find(int p, int q) {
    return root(p) == root(q);
  }

  public union(int p, int q) {
    int proot = root(p);
    int qroot = root(q);
    if(proot == qroot) return;
    if(sz[proot] < sz[qroot]) {
      arr[proot] = qroot;
      sz[qroot] += sz[proot];
    } else {
      arr[qroot] = proot;
      sz[proot] += sz[qroot];
    }
  }
}