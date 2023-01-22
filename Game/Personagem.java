package com.abner.game.personagem;

import java.util.Random;

public class Personagem {

	private int vida;
	private int ataque;
	private int defesa;
	private int velocidade;
	private String nome;

	public Personagem(int vida, int ataque, int defesa, int velocidade, String nome) {
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public void lutar(Personagem p) {		
		System.out.println();
		System.out.println(" ------- ");
		System.out.println("Atacante: " + this.nome);
		System.out.println("Defensor: "+ p.nome);		
		calcularAtaque(p);
		calcularDefesa(p);
	}
	
	private Integer numeroAleatorio() {
		Random random = new Random();		
		return random.nextInt(25);
	}

	private void calcularAtaque(Personagem p) {
		System.out.println(" ------- ");
		System.out.println("Ataque: "+ this.nome );
		System.out.println("Defensor: "+ p.nome );
		int dano;
		int vidaAux = p.vida;
		int golpes = getVelocidade() / p.getVelocidade();
		if (golpes < 1)
			golpes = 2;
		else
			golpes +=1;
		System.out.println();
		System.out.println("Golpes do ataque foi: " + golpes);		
		int num = numeroAleatorio();
		dano = getAtaque() - p.getDefesa() - num;
		if (dano < 0)
			dano = 0;
		System.out.println("Dano do ataque foi: " + dano);
		vidaAux = vidaAux - (dano * golpes);
		System.out.println("Vida do defensor: " +vidaAux);
		
		
	}

	private void calcularDefesa(Personagem p) {
		System.out.println(" ------- ");
		System.out.println("Ataque: "+ p.nome);
		System.out.println("Defensor: "+ this.nome);
		int dano;
		int vidaAux = this.vida;
		Integer golpes = p.getVelocidade() / getVelocidade();
		if (golpes < 1)
			golpes = 1;
		System.out.println();
		System.out.println("Golpes da defensa: " + golpes);
		int num = numeroAleatorio();
		dano = p.getAtaque() - getDefesa() - num;
		if (dano < 0)
			dano = 0;
		System.out.println("Dano da defesa foi: " + dano);
		vidaAux = vidaAux - (dano * golpes);
		System.out.println("Vida do atacante: " + vidaAux);
		System.out.println(" ------- ");
	}
	
	public String toString() {
		return "Nome do personage: " + this.nome + 
				"\n Vida do personagem: " + this.vida + 
				"\n Ataque do personagem: " + this.ataque + 
				"\n Defesa do personagem: " + this.defesa+ 
				"\n Velocidade do personagem: " + this.velocidade + 
				"\n Classe do personagem: " + this.getClass().getSimpleName();

	}

}
