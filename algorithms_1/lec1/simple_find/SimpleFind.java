package algorithms_1.lec1.simple_find;

import algorithms_1.lec1.UnionFind;
import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleFind implements UnionFind {
  //Instance variables
  private int n;
  private int[] arr;

  //Constructor
  public SimpleFind(int n) {
    this.n = n;
    arr = new int[n];
    Arrays.fill(arr, -1);
  }

  //Interface Methods
  public void union(int p, int q) {
    System.out.println("P : " + p);
    System.out.println("q : " + q);
  }

  public boolean connected(int p, int q) { return arr[p] == arr[q]; }
  public int find(int p) { return 0; }
  public int count() { return 1; }


  //Class Methods

  public static void main(String[] args) throws IOException {
    FileReader in = null;
    BufferedReader bufferedReader = null;
    try {
      in = new FileReader(args[0]);
      bufferedReader = new BufferedReader(in);
      read_file(bufferedReader);
    } catch(IOException e) {
      System.out.println("Exception thrown: " + e);
    } finally {
      if (bufferedReader != null) {
        bufferedReader.close();
      }
    }
  }

  public static void read_file(BufferedReader bufferedReader) throws IOException {
    String line = null;
    int n = Integer.parseInt(bufferedReader.readLine());
    SimpleFind uf = new SimpleFind(n);
    String pattern = "^(\\d)\\s+(\\d)$";
    Pattern r = Pattern.compile(pattern);

    while((line = bufferedReader.readLine()) != null) {
      Matcher m = r.matcher(line);
      m.find();
      uf.union(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
      // System.out.println("V0: " + m.group(0));
      // System.out.println("V1: " + m.group(1));
      // System.out.println("V2: " + m.group(2));
    }
  }
}