package Graph;
import java.util.*;

public class PrintAllPaths {
    HashMap<Integer, HashMap<Integer, Integer>>map;
    public PrintAllPaths(int v){
        map = new HashMap<>();
        for(int i=1; i<=v; i++){
            map.put(i , new HashMap<>());
        }
    }
    public void addedge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1,cost);
    }
    public void printPaths(int src, int des, HashSet<Integer>visited, String path){
        if(src==des){
            System.out.println(path);
            return;
        }
        visited.add(src);
        for(int key: map.get(src).keySet()){
            if(!visited.contains(key)){
                printPaths(key , des, visited, path+key+" ");
            }
        }
        visited.remove(src);
    }

    public static void main(String[] args) {
        PrintAllPaths g = new PrintAllPaths(7);
        g.addedge(1, 4, 5);
        g.addedge(1, 2, 10);
        g.addedge(2, 3, 7);
        g.addedge(3, 4, 2);
        g.addedge(4, 5, 4);
        g.addedge(5, 6, 3);
        g.addedge(5, 7, 2);
        g.addedge(6, 7, 7);
        HashSet<Integer>set = new HashSet<>();
      g.printPaths(1, 6 , set , 1+" ");

    }
}
