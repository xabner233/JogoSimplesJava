package com.abner.game.personagem;

public class Jogo {
	
	public static void main(String[] args) {
		Humano abner = new Humano(100, 70, 25, 15, "Abner");
		Elfo legolas = new Elfo  (100, 30, 20, 25, "Legolas");
		Orc uruk =     new Orc   (120, 45, 30, 10, "Uruk");
		
		abner.especialHumano();
		legolas.especialElfo();
		uruk.especialOrc();
		
		System.out.println(abner.toString());
		System.out.println(legolas.toString());
		System.out.println(uruk.toString());
		
		
		abner.lutar(uruk);
		uruk.lutar(legolas);
		legolas.lutar(abner);
	}

}
