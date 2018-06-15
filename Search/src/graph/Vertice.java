package graph;

public class Vertice implements Comparable<Vertice> {

    private String nome;
    private double dist;
    private String path;
    private String visitado;

    public Vertice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String toString() {
        return this.getNome();
    }

    public double getDist() {
		return dist;
	}

	public void setDist(double dist) {
		this.dist = dist;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getVisitado() {
		return visitado;
	}

	public void setVisitado(String visitado) {
		this.visitado = visitado;
	}

	public int compareTo(Vertice vertice) {
        return this.getNome().compareTo(vertice.getNome());
    }

}
