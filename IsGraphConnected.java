package Graph;

import java.util.*;

public class IsGraphConnected {
    HashMap<Integer , HashMap<Integer , Integer>> map;
    int v;
    public IsGraphConnected(int v1){
        map = new HashMap<>();
        this.v=v1;
        for(int i=1; i<=v; i++){
            map.put(i , new HashMap<>());
        }
    }
    public void addedge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1,cost);
    }
    public  void  components(){
        ArrayList<ArrayList<Integer>>list = new ArrayList<>();
        boolean[]visited = new boolean[v+1];
        for(int i=1; i<=v; i++){
            if(!visited[i]){
                ArrayList<Integer>al = new ArrayList<>();
                getConnectedComponents( i , visited , al);
                list.add(al);
            }
        }
        System.out.println(list.size()==1);

    }
    public void getConnectedComponents(int src , boolean[]visited , ArrayList<Integer>al){
        visited[src]=true;
        al.add(src);
        for(int key: map.get(src).keySet()){
            if(!visited[key]){
                getConnectedComponents(key , visited, al);
            }
        }
    }

    public static void main(String[] args) {
       IsGraphConnected g = new IsGraphConnected(7);
        g.addedge(1,2,10);
        g.addedge(3,4,10);
        g.addedge(5,6,10);
        g.addedge(5,7,10);
        g.addedge(6,7,10);
       g.components();


    }

}



