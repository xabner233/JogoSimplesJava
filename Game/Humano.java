package com.abner.game.personagem;

public class Humano extends Personagem{

	public Humano(int vida, int ataque, int defesa, int velocidade, String nome) {
		super(vida, ataque, defesa, velocidade, nome);
		// TODO Auto-generated constructor stub
	}
	
	public void especialHumano() {
		this.setAtaque(getAtaque()+20);
		this.setVelocidade(getVelocidade()+7);
	}

}
