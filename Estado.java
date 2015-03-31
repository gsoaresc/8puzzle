package eightpuzzle;

public class Estado implements Comparable<Estado>{
	private int [][] estado;
	private int heuristicaManhattam;
	private int nivelNaArvore;
	
	/**
	 * Construtor padrÃ£o
	 * @param estado
	 * @param heuristicaManhattam
	 * @param nivelNaArvore
	 */
	public Estado(int[][] estado, int heuristicaManhattam, int nivelNaArvore) {
		super();
		this.estado = estado;
		this.heuristicaManhattam = heuristicaManhattam;
		this.nivelNaArvore = nivelNaArvore;
	}
	
	public int[][] getEstado() {
		return estado;
	}
	public void setEstado(int[][] estado) {
		this.estado = estado;
	}
	public int getHeuristicaManhattam() {
		return heuristicaManhattam;
	}
	public void setHeuristicaManhattam(int heuristicaManhattam) {
		this.heuristicaManhattam = heuristicaManhattam;
	}
	public int getNivelNaArvore() {
		return nivelNaArvore;
	}
	public void setNivelNaArvore(int nivelNaArvore) {
		this.nivelNaArvore = nivelNaArvore;
	}
	
	/**
	 * Usado para ordenar a lista de estados
	 */
	@Override
	public int compareTo(Estado comparador) {
		 int compareage = ((Estado)comparador).getHeuristicaManhattam() + ((Estado)comparador).getNivelNaArvore();
	        //Este mÃ©todo compara a formula (heuristica + nivelNaArvore)
	        return this.heuristicaManhattam + this.nivelNaArvore -(compareage);
	}
	
	
	

}
