package algorithms_1.lec1;

public interface UnionFind {
  public void union(int p, int q);
  public boolean connected(int p, int q);
  public int find(int p);
  public int count();
}