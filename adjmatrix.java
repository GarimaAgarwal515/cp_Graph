package Graph;

public class adjmatrix {
    int [][]adjMatrix;
    public adjmatrix(int nodes){
        this.adjMatrix = new int[nodes][nodes];
    }
    public void addEdge(int u, int v){
        adjMatrix[u][v]=1;
        adjMatrix[v][u]=1;
    }

    public static void main(String[] args) {
        adjmatrix graph = new adjmatrix(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
       for(int i=0; i<graph.adjMatrix.length; i++){
           for(int j=0; j<graph.adjMatrix.length; j++){
               System.out.print(graph.adjMatrix[i][j]+" ");
           }
           System.out.println();
       }

    }

}
