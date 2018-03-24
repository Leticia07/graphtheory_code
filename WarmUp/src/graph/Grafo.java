package graph;

import java.util.HashSet;
import java.util.Set;

import graph.interfaces.IGrafo;


public class Grafo implements IGrafo {

    private Set<Vertice> vertices = new HashSet<Vertice>();
    private Set<Aresta> arestas = new HashSet<Aresta>();

    public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    @Override
    public boolean ehCompleto() {
    	int cont = 0;

		for (Vertice v : this.vertices) {
			if (this.getAdjacentes(v).size() == this.vertices.size() - 1) {
				cont++;
			}
		}

		if (cont == this.vertices.size()) {
			return true;
		} else {
			return false;
		}
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
    public boolean ehRegular() {
    	int valor = 0, cont = 0;

		Object[] v = this.vertices.toArray();
		for (int i = 0; i < v.length; i++) {
			if (i == 0) {
				valor = this.getAdjacentes((Vertice) v[i]).size();
			}
			if (this.getAdjacentes((Vertice) v[i]).size() == valor) {
				cont++;
			}
		}

		if (cont == this.vertices.size()) {
			return true;
		} else {
			return false;
		}
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
