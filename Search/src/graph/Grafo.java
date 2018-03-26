package graph;

import graph.interfaces.IGrafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Grafo implements IGrafo {

    private Set<Vertice> vertices = new HashSet<Vertice>();
    private Set<Aresta> arestas = new HashSet<Aresta>();
    private ArrayList<Vertice> f;

    public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    @Override
    public Set<Vertice> getAdjacentes(Vertice v) {
        Set<Vertice> adjacentes = new HashSet<Vertice>();

        for(Aresta aresta: this.arestas) {
            if(aresta.getA() == v) {
                adjacentes.add(aresta.getB());
            }

            if(aresta.getB() == v) {
                adjacentes.add(aresta.getA());
            }
        }
        return adjacentes;

    }

    @Override
    public boolean ehConexo() {
        return false;
    }

    @Override
    public void buscaLargura() {
    	f = new ArrayList<>();
		ArrayList<Vertice> visitados = new ArrayList<>();
		Object[] v = this.vertices.toArray();
		Vertice u;
		
		visitados.add((Vertice)v[0]);
		f.add((Vertice) v[0]);
		
		while(f.size() > 0) {
			int z = 0;
			u = f.get(0);
			f.remove(u);
			Object[] w = this.getAdjacentes(u).toArray();			
			for(int i = 0; i < w.length;i++) {
				if(!visitados.contains((Vertice)w[i])) {
					visitados.add((Vertice)w[i]);
					f.add((Vertice)w[i]);
				}
			}
		}
    }

    @Override
    public void buscaProfundidade() {

    }


    @Override
    public String toString() {

        String retorno = "";

        for(Vertice v: vertices) {
            retorno += v.toString() + "[ ";

            Set<Vertice> adjacentes = this.getAdjacentes(v);

            for(Vertice adj: adjacentes) {
                retorno += adj.toString() + " ";
            }

            retorno += "]\n";


        }

        return retorno;
    }


}
