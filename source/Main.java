package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        int NumberOfPeople;
        int NumberOfRelations;

        try {
            File f=new File("input.txt");
            Scanner in= new Scanner(f);

            NumberOfPeople=in.nextInt();
            NumberOfRelations=in.nextInt();
            GraphAjdacencyMatrix graph = new GraphAjdacencyMatrix(NumberOfPeople);

            int i;
            int p1,p2;
            for(i=0;i<NumberOfRelations;++i){
                p1=in.nextInt();
                p2=in.nextInt();
                graph.addEdge(p1, p2);
            }
            graph.printGraph();
            System.out.println(graph.numberOfPopulerPeople());
            graph.printGraph();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
