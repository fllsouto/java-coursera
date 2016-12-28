package algorithms_1.lec1.quick_find;

import algorithms_1.lec1.UnionFind;
import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class QuickFind implements UnionFind {

  //Instance variables
  private int n;
  private int[] arr;

  //Constructor
  //Complexity: O(n), we need to set up each position of array
  public QuickFind(int n) {
    this.n = n;
    this.arr = new int[n];
    for(int i = 0; i < arr.length; i++)
      arr[i] = i;
  }


  //Instace methods

  public void show_unions() {
    int i = 0;
    for(int e : arr) {
      System.out.format("[%d] = %d\n", i, e);
      i++;
    }
  }

  //Complexity: O(n) to perform just 1 union
  //O(n^2) to perform 'n' unions
  public void union(int p, int q) {
    int pid = arr[p];
    int qid = arr[q];
    for(int i = 0; i < arr.length; i++)
      if(arr[i] == pid) arr[i] = qid;
  }

  //Complexity: O(1) to perform the checking
  public boolean connected(int p, int q) { return arr[p] == arr[q]; }
  public int find(int p) { return 0; }
  public int count() { return 1; }

  public static void main(String[] args) throws IOException {
    FileReader in  = null;
    BufferedReader br = null;

    try {
      in = new FileReader(args[0]);
      br = new BufferedReader(in);
      read_file(br);
    } catch(IOException e) {
      System.err.println("Exception thrown: " + e);
    } finally {
      if(br != null) {
        br.close();
      }
    }
  }

  private static void read_file(BufferedReader br) throws IOException{
    String line = null;
    int n = Integer.parseInt(br.readLine());
    String pattern = "^(\\d)\\s+(\\d)$";
    QuickFind qf = new QuickFind(n);
    Pattern p = Pattern.compile(pattern);

    while((line = br.readLine()) != null) {
      Matcher m = p.matcher(line);
      m.find();
      qf.union(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
    }
    qf.show_unions();
  }


}