package Graph;

import java.util.*;

public class DFS {
    HashMap<Integer, HashMap<Integer , Integer>>map;
    int v;
    public DFS(int v){
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
    public ArrayList<Integer> DfsTraversal(){
        boolean visited[]= new boolean[v+1];
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer>list = new ArrayList<>();
        for(int key: map.keySet()){
            if(visited[key]) {
                continue;
            }

            st.push(key);
            while(!st.isEmpty()){
                int rv = st.pop();

                if(visited[rv])continue;
                list.add(rv);
                visited[rv]=true;

                for(int nbr: map.get(rv).keySet()){
                    if(!visited[nbr]){
                        st.push(nbr);
                    }
                }


            }
        }
        return list;
    }

    public static void main(String[] args) {
        DFS g = new DFS(7);
        g.addedge(1, 4, 5);
        g.addedge(1, 2, 10);
        g.addedge(2, 3, 7);
        g.addedge(3, 4, 2);
        g.addedge(4, 5, 4);
        g.addedge(5, 6, 3);
        g.addedge(5, 7, 2);
        g.addedge(6, 7, 7);
        System.out.println(g.DfsTraversal());

    }
}
