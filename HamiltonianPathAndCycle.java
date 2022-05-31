package Graph;
import java.util.*;

public class HamiltonianPathAndCycle {
    HashMap<Integer, HashMap<Integer , Integer>>map;
    int v;
    public HamiltonianPathAndCycle(int v){
        this.v=v;
        map = new HashMap<>();
        for(int i=1; i<=v; i++){
            map.put(i , new HashMap<>());
        }
    }
    public void addedge(int v1, int v2, int cost){
        map.get(v1).put(v2 , cost);
        map.get(v2).put(v1 , cost);
    }
    public void findHamiltonianPathAndcycle(int src , int osrc ,HashSet<Integer>visited, String path){
        if(visited.size()== map.size()-1){
            System.out.print(path);
            boolean cycleExist = false;
            for(int key : map.get(src).keySet()){
                if(key==osrc){
                    cycleExist=true;
                    break;
                }
            }
            if(cycleExist==true) System.out.println(" * ");
            else
                System.out.println(" . ");
            return;
        }
        visited.add(src);
        for(int key: map.get(src).keySet()){
            if(!visited.contains(key)){
                findHamiltonianPathAndcycle(key , osrc, visited, path+key+" ");
            }
        }
        visited.remove(src);
    }

    public static void main(String[] args) {
        HamiltonianPathAndCycle g = new HamiltonianPathAndCycle(7);
        g.addedge(1 ,2, 10);
        g.addedge(1,3,10);
        g.addedge(2,4,10);
        g.addedge(4,3,10);
        g.addedge(3,5,10);
        g.addedge(5,6,10);
        g.addedge(4,6,10);
        g.addedge(5,7,10);
        g.addedge(6,7,10);
        HashSet<Integer>set = new HashSet<>();
        g.findHamiltonianPathAndcycle(1 ,  1 , set , 1+" ");
    }


}
