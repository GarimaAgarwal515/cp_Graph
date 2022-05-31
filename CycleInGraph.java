package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInGraph {

    HashMap<Integer, HashMap<Integer , Integer>>map;
    int v;
    public CycleInGraph(int v){
        this.v=v;
        map = new HashMap<>();
        for(int i=1; i<=v; i++){
            map.put(i , new HashMap<>());
        }
    }
    public void addedge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }
    static class pair{
        int src;
        String path;
        public pair(int src, String path){
            this.src = src;
            this.path=path;
        }

    }
    public boolean  hasCycle(){
        boolean visited[]= new boolean[v+1];
        Queue<Integer> q = new LinkedList<>();

        for(int key: map.keySet()){
            if(visited[key]) {
                continue;
            }

            q.add(key);
            while(!q.isEmpty()){
                int rv = q.remove();

                if(visited[rv])return true;

                visited[rv]=true;

                for(int nbr: map.get(rv).keySet()){
                    if(!visited[nbr]){
                        q.add(nbr);
                    }
                }


            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleInGraph g = new CycleInGraph(7);
        g.addedge(1, 4, 5);
        g.addedge(1, 2, 10);
        g.addedge(2, 3, 7);
        g.addedge(3,4,10);
        g.addedge(4, 5, 4);
        g.addedge(5, 6, 3);
        g.addedge(5,7,10);
        g.addedge(6, 7, 7);
        System.out.println(g.hasCycle());

    }
}
