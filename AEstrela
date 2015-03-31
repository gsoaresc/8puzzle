package eightpuzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AEstrela {


	private static final int[][] OBJETIVO = {{1,2,3}, {4,0,5}, {6,7,8}};

	private List<Estado> listaEstados;
	private int nivelAtual;
	
	/**
	 * Construtor padrão
	 */
	public AEstrela() {
		this.listaEstados = new ArrayList<Estado>();
		this.nivelAtual = 0;
	}
	
	
	
	/**
	 * Metodo utilizado para solucionar determinado estado do jogo 8-puzzle
	 * @param estadoInicial o estado a ser solucionado
	 * @return uma lista com todos os estados utilizados nessa soluÃ§Ã£o
	 */
	public List<Estado> solucionar(int[][] estadoInicial){
		if(!isEstadoFinal(estadoInicial)){
			List<Estado> listaDeMovimentos = this.movimentosPossiveis(estadoInicial);
			Collections.sort(listaDeMovimentos);

			this.listaEstados.add(listaDeMovimentos.get(0));
			this.solucionar(listaDeMovimentos.get(0).getEstado());

		} 

		return this.listaEstados;
	}

	/**
	 * Retorna o valor manhattan de determinado estado passado por parÃ¢metro
	 * @param tabuleiro o estado a ser analizado
	 * @return o valor da heuristica manhattan
	 */
	public int distanciaManhattan(int [][] tabuleiro){
		int distanciaTotal = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int posicao = tabuleiro[i][j];
				switch(posicao){
				case 1:
					distanciaTotal += Math.abs(i - 0) + Math.abs(j - 0);
					break;
				case 2:
					distanciaTotal += Math.abs(i - 0) + Math.abs(j - 1);
					break;
				case 3:
					distanciaTotal += Math.abs(i - 0) + Math.abs(j - 2);
					break;
				case 4:
					distanciaTotal += Math.abs(i - 1) + Math.abs(j - 0);
					break;
				case 0:
					distanciaTotal += Math.abs(i - 1) + Math.abs(j - 1);
					break;
				case 5:
					distanciaTotal += Math.abs(i - 1) + Math.abs(j - 2);
					break;
				case 6:
					distanciaTotal += Math.abs(i - 2) + Math.abs(j - 0);
					break;
				case 7:
					distanciaTotal += Math.abs(i - 2) + Math.abs(j - 1);
					break;
				case 8:
					distanciaTotal +=  Math.abs(i - 2) + Math.abs(j - 2);
					break;
				}
			}
		}
		return distanciaTotal;
	}

	/**
	 * Retorna uma lista de movimentos possÃ­veis
	 * @param estado o estado inicial
	 * @return a lista de movimentos possÃ­veis
	 */
	private List<Estado> movimentosPossiveis(int [][] estado){
		this.nivelAtual +=1;
		List <Estado> movimentosPossiveis = new ArrayList<Estado>();
		int [] posicaoVazia = this.getPosicaoVazia(estado);

		int [] superior = {posicaoVazia[0]-1, posicaoVazia[1]};
		int [] inferior = {posicaoVazia[0]+1, posicaoVazia[1]};
		int [] esquerda = {posicaoVazia[0], posicaoVazia[1]-1};
		int [] direita = {posicaoVazia[0], posicaoVazia[1]+1};

		try{
			int[][] novoEstado = this.trocarPosicao(estado, posicaoVazia, superior);
			movimentosPossiveis.add(new Estado(novoEstado, this.distanciaManhattan(novoEstado), nivelAtual));

		} catch(ArrayIndexOutOfBoundsException e){}
		try{
			int[][] novoEstado = this.trocarPosicao(estado, posicaoVazia, inferior);
			movimentosPossiveis.add(new Estado(novoEstado, this.distanciaManhattan(novoEstado), nivelAtual));

		} catch(ArrayIndexOutOfBoundsException e){}
		try{
			int[][] novoEstado = this.trocarPosicao(estado, posicaoVazia, esquerda);
			movimentosPossiveis.add(new Estado(novoEstado, this.distanciaManhattan(novoEstado), nivelAtual));

		} catch(ArrayIndexOutOfBoundsException e){}
		try{
			int[][] novoEstado = this.trocarPosicao(estado, posicaoVazia, direita);
			movimentosPossiveis.add(new Estado(novoEstado, this.distanciaManhattan(novoEstado), nivelAtual));
		} catch(ArrayIndexOutOfBoundsException e){}

		return movimentosPossiveis;
	}


	/**
	 * Retorna uma matriz com duas posiÃ§Ãµes trocadas
	 * @param s a matrix a ser modificada
	 * @param i um array com as coordenadas da posiÃ§Ã£o inicial, exemplo: {0,1}; {2,2}
	 * @param j um array com as coordenadas da posiÃ§Ã£o final, exemplo: {0,1}; {2,2}
	 * @return a matrix com as posiÃ§Ãµes trocadas
	 */
	public int[][] trocarPosicao(int[][] s, int[] i, int[] j) {
		int[][] n_s = new int[s.length][];
		for (int k = 0; k < s.length; k++){
			n_s[k] = (int[]) s[k].clone();
		}
		n_s[i[0]][i[1]] = s[j[0]][j[1]];
		n_s[j[0]][j[1]] = s[i[0]][i[1]];
		return n_s;
	} 


	/* verifica se já alcançou o objetivo*/
	private boolean isEstadoFinal(int [][] tabuleiro){
		boolean booleano = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++){
				if(tabuleiro[i][j] != OBJETIVO[i][j]){
					booleano = false;
				}
			}
		}
		return booleano;
	}
	
	
	/* retorna um array com a localização da posição 0 */
	private int [] getPosicaoVazia(int[][] tabuleiro){
		int [] posicaoVazia = {};
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (tabuleiro[i][j] == 0){
					posicaoVazia = new int [] {i,j};
				}
			}
		}
		return posicaoVazia;
	}

	/* mostra a situação atual do tabuleiro, pegando cada posição dele*/
	public void imprimirTabuleiro(int[][] tabuleiro){
		System.out.println("[" + tabuleiro[0][0] + "," + tabuleiro[0][1] + "," + tabuleiro[0][2] + "]");
		System.out.println("[" + tabuleiro[1][0] + "," + tabuleiro[1][1] + "," + tabuleiro[1][2] + "]");
		System.out.println("[" + tabuleiro[2][0] + "," + tabuleiro[2][1] + "," + tabuleiro[2][2] + "]");
	}

}
