package main;

import graph.Aresta;
import graph.Grafo;
import graph.Vertice;

import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Set<Vertice> vertices = new HashSet<Vertice>();
        Set<Aresta> arestas = new HashSet<Aresta>();

        /*Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");

        Aresta aresta1 = new Aresta(v1, v2, 0);
        Aresta aresta2 = new Aresta(v1, v3, 0);
        Aresta aresta3 = new Aresta(v3, v2, 0);

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);

        arestas.add(aresta1);
        arestas.add(aresta2);
        arestas.add(aresta3);
         */
        Vertice t = new Vertice("t");
        Vertice u = new Vertice("u");
        Vertice x = new Vertice("x");
        Vertice v = new Vertice("v");
        Vertice y = new Vertice("y");
        
        Aresta tx = new Aresta(t,x,5);
        Aresta tu = new Aresta(t,u,10);
        Aresta ux = new Aresta(u,x,2);
        Aresta xu = new Aresta(x,u,3);
        Aresta uv = new Aresta(u,v,1);
        Aresta xv = new Aresta(x,v,9);
        Aresta vy = new Aresta(v,y,4);
        Aresta yv = new Aresta(y,v,6);
        Aresta xy = new Aresta(x,y,2);
        Aresta yt = new Aresta(y,t,7);
        
        vertices.add(t);
        vertices.add(u);
        vertices.add(x);
        vertices.add(v);
        vertices.add(y);
        
        arestas.add(tx);
        arestas.add(tu);
        arestas.add(ux);
        arestas.add(xu);
        arestas.add(uv);
        arestas.add(xv);
        arestas.add(vy);
        arestas.add(yv);
        arestas.add(xy);
        arestas.add(yt);
        
        Grafo grafo = new Grafo(vertices, arestas);

        System.out.println(grafo.toString());
        
        //System.out.println(grafo.ehConexo());
        
        //grafo.buscaProfundidade();
        
        //System.out.println(grafo.getAdjacentesOrientado(t));
        
        grafo.menorCaminho(t);

    }

}
