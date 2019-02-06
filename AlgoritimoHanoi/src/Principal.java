

public class Principal {
	
//você deve mover um disco de cada vez, sendo que um disco maior nunca pode ficar em cima de um disco menor

	public static void main(String[] args) {
		
		int discos = 3;
		hanoi(discos,"Primeiro Pino","Segundo Pino","Terceiro Pino");
	}

	private static void hanoi(int discos, String pino_de_origem, String pino_auxiliar, String pino_de_destino) {
		
		if (discos > 0) {
			
			//Movimentar o disco do pino de origem para o pino auxilar (n-1 discos)
			hanoi(discos - 1,pino_de_origem,pino_de_destino,pino_auxiliar); 
			
			//Movimento da origem para destino
			System.out.printf("Mover o %s disco do %s para o %s\n",discos, pino_de_origem,pino_de_destino);
			
			//Auxiliar para o destino(n-1 discos)
			hanoi(discos - 1,pino_auxiliar,pino_de_origem,pino_de_destino);
			
		}
		
	}
		
}
