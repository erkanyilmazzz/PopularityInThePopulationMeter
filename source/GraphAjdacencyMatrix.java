
package com.company;

public class GraphAjdacencyMatrix extends Graph{
    int vertex;
    int matrix[][];


    public GraphAjdacencyMatrix(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    /**
     * add a edge
     * @param  source
     * @param destination
     * O(1)
     * */
    public void addEdge(int source, int destination) {
        //add edge
        matrix[source-1][destination-1]=1;//for  0 people

        //add bak edge for undirected graph
        //matrix[destination][source] = 1;
    }

    /**
     * print adjacency matrix of graph
     * O(n^2)
     * */
    public void printGraph() {
        System.out.println("Graph: (Adjacency Matrix)");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j <vertex ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

    }
    /**
     * make it Transitive Closure by using  warshals algorith
     * worscase O(n^3)
     * */
    public void getTC() {
        int [][] graph=matrix;
        this.vertex = graph.length;
        matrix = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++){
                if (graph[i][j] != 0)
                    matrix[i][j] = 1;
            }
            matrix[i][i] = 1;
        }
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                if (matrix[j][i]==1){
                    for (int k = 0; k < vertex; k++){
                        if (matrix[j][i]==1 && matrix[i][k]==1)
                            matrix[j][k] = 1;
                    }
                }
            }
        }


    }
    /**
     * delete a edge
     * @param source
     * @param destination
     * O(1)
     * */
    public   void deleteEdge(int source, int destination){
        //add edge
        matrix[source-1][destination-1]=0;//for  0 people

        //add bak edge for undirected graph
        //matrix[destination][source] = 0;

    }
    /**
     * return number of populer people for every one in this population
     * O(n^2)
     * */
    public int  numberOfPopulerPeople(){
        this.getTC();
        int counter=0;
        int folovers;
            int i;
            int j;
            for(i=0;i<vertex;++i){
                folovers=0;
              for(j=0;j<vertex;++j){
                if(matrix[j][i]==1){
                    folovers++;
                }
              }
              if(folovers==vertex)
                  counter++;
            }

        return counter;
    }



    public static  void test(){
       GraphAjdacencyMatrix graph = new GraphAjdacencyMatrix(5);

            graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(2, 2);
        graph.addEdge(1, 4);


    }
}
