package com.abner.game.personagem;

public class Elfo extends Personagem {	

	public Elfo(int vida, int ataque, int defesa, int velocidade, String nome) {
		super(vida, ataque, defesa, velocidade, nome);
		
	}
	
	public void especialElfo() {
		this.setVelocidade(getVelocidade()+10);
		this.setAtaque(getAtaque()+10);
	}

}
