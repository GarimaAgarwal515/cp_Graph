package Graph;

import java.util.*;


public class FindPath {
      HashMap<Integer,  HashMap<Integer, Integer>>map;
    public FindPath(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }
    public  void addedge(int v1, int v2, int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1, cost);


    }
    public  boolean haspath(int src, int dis, HashSet<Integer> visited) {

        if (src == dis) {
            return true;
        }
        visited.add(src);

        for (int key : map.get(src).keySet()) {
            if (!visited.contains(key)) {
                boolean path = haspath(key, dis, visited);
                if (path) {
                    return path;
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        FindPath g = new FindPath(7);
        g.addedge(1, 4, 5);
        g.addedge(1, 2, 10);
        g.addedge(2, 3, 7);
        g.addedge(3, 4, 2);
        g.addedge(4, 5, 4);
        g.addedge(5, 6, 3);
        g.addedge(5, 7, 2);
        g.addedge(6, 7, 7);
         HashSet<Integer>set = new HashSet<>();
        System.out.println(g.haspath(1, 9, set));



    }
}
