package eightpuzzle;

public class Main {

	public static void main(String[] args) {
		int[][] tabuleiroInicial = {
//				{0,2,3}, {1,4,5}, {7,8,6}
//				{1,0,2}, {7,5,4}, {8,6,3}
				{1,0,2}, {4,5,3}, {6,7,8}
		};

		AEstrela a = new AEstrela();
		
		System.out.println("Disposição inicial:");
		a.imprimirTabuleiro(tabuleiroInicial); //
		
		System.out.println("\nSolução do problema:");
		for (Estado i: a.solucionar(tabuleiroInicial)){
			a.imprimirTabuleiro(i.getEstado());
			System.out.println("--------");
		}
	}

}
