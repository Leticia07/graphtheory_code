package graph;

import graph.interfaces.IGrafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Grafo implements IGrafo {

    private Set<Vertice> vertices = new HashSet<Vertice>();
    private Set<Aresta> arestas = new HashSet<Aresta>();
    private ArrayList<Vertice> f;
    private ArrayList<Vertice> p;
    private ArrayList<Vertice> visitados;

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
    
    public Set<Vertice> getAdjacentesOrientado(Vertice v){
    	Set<Vertice> adjacentes = new HashSet<Vertice>();
    	
    	for(Aresta aresta: this.arestas) {
    		if(aresta.getA() == v) {
    			adjacentes.add(aresta.getB());
    		}
    	}
    	
    	return adjacentes;
    }

    @Override
    public boolean ehConexo() {
    	buscaLargura();
    	if (visitados.size() == vertices.size()) {
    		return true;
    	}
        return false;
    }

    @Override
    public void buscaLargura() {
    	f = new ArrayList<>();
		visitados = new ArrayList<>();
		Object[] v = this.vertices.toArray();
		Vertice u;
		
		visitados.add((Vertice)v[0]);
		f.add((Vertice) v[0]);
		
		while(f.size() > 0) {
			int z = 0;
			u = f.get(0);
			//System.out.println(u);
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
    	p = new ArrayList<>();
    	visitados = new ArrayList<>();
    	Object[] v = this.vertices.toArray();
    	Vertice u;
    	
    	visitados.add((Vertice)v[0]);
    	p.add((Vertice)v[0]);
    	
    	while(p.size() > 0) {
    		for(Vertice vertice :getAdjacentes(p.get(p.size()-1))){
    			if (!visitados.contains(vertice)) {
    				visitados.add(vertice);
    				p.add(vertice);
    			}
    		}
    		//System.out.println(p.get(p.size()-1));
    		p.remove(p.size()-1);
    	}
    }
    
    public void menorCaminho(Vertice v) {
    	double valor = Double.POSITIVE_INFINITY;
    	ArrayList<Vertice> visitados = new ArrayList<>();
    	Vertice menor = null;
    	Vertice u = v;
		
		for (Vertice vertice: this.vertices) {
			if(vertice == v) {
				vertice.setDist(0);
				vertice.setVisitado("sim");
				visitados.add(vertice);
				vertice.setPath("-");
			}else {
				vertice.setDist(valor);
				vertice.setVisitado("não");
			}
		}
		
		while (visitados.size() < this.vertices.size()) {
			for(Vertice vertice: getAdjacentesOrientado(u)) {
				if (vertice.getDist() > u.getDist() + getPesoAresta(u,vertice)) {
					vertice.setDist(getPesoAresta(u,vertice) + u.getDist());
					vertice.setPath(u.getNome());
					menor = vertice;
				}
			}
			
			for(Vertice vertice: this.vertices) {
				if(vertice.getVisitado() == "não") {
					if(menor.getDist() >= vertice.getDist()) {
						menor = vertice;
						vertice.setVisitado("sim");
						visitados.add(vertice);
						u = vertice;
					}
				}
			}
		}
		
		System.out.println("   Vertice \t S \tDist \tPath");
    	for(Vertice vertice: this.vertices) {
    		System.out.println("\t" + vertice.getNome() + "\t" + vertice.getVisitado() + "\t" + 
    				vertice.getDist() + "\t" + vertice.getPath());
    	}
    }
    
    public Vertice getVertice (String nome) {
    	Vertice v = null;
    	for (Vertice vertice:this.vertices) {
    		if(vertice.getNome() == nome) {
    			v = vertice;
    		}
    	}
    	return v;
    }
    
    public double getPesoAresta(Vertice v1, Vertice v2) {
    	double peso = 0;
    	for(Aresta aresta: this.arestas) {
    		if(aresta.getA() == v1 && aresta.getB() == v2) {
    			peso = aresta.getPeso();
    		}
    	}
    	return peso;
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
