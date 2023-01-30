package com.abner.game.personagem;

public class Jogo {
	
	public static void main(String[] args) {
		Humano abner = new Humano(100, 70, 25, 15, "Abner");
		Elfo legolas = new Elfo  (100, 30, 20, 25, "Legolas");
		Orc uruk =     new Orc   (120, 45, 30, 10, "Uruk");
		Artefato espadaMadeira = new Artefato ("Espada de Madeira", 0, 10, 5, -2, false);
		Artefato escudoMadeira = new Artefato ("Escudo de Madeira", 10, 0, 15, 0, false);
		Artefato armaduraMadeira = new Artefato ("Armadura de Madeira", 20, 0, 10, 0, false);
		Artefato arcoMadeira = new Artefato ("Arco de Madeira", 0, 5, 0, 10, false);
		
		abner.especialHumano();
		legolas.especialElfo();
		uruk.especialOrc();
		
		abner.pegarItem(espadaMadeira);
		abner.pegarItem(armaduraMadeira);
		legolas.pegarItem(arcoMadeira);
		uruk.pegarItem(escudoMadeira);
		uruk.pegarItem(armaduraMadeira);
		
		abner.equiparItem(espadaMadeira);
		abner.equiparItem(armaduraMadeira);
		legolas.equiparItem(arcoMadeira);
		uruk.equiparItem(escudoMadeira);
		uruk.equiparItem(armaduraMadeira);
		
		abner.soltarrItem(armaduraMadeira);
		uruk.pegarItem(armaduraMadeira);
		uruk.equiparItem(armaduraMadeira);
		abner.equiparItem(armaduraMadeira);
		
		
		
		System.out.println(abner.toString());
		System.out.println(legolas.toString());
		System.out.println(uruk.toString());
		
		
		abner.lutar(uruk);
		uruk.lutar(legolas);
		legolas.lutar(abner);
		
		
	}

}
