package br.com.elo.desafiosonda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.elo.desafiosonda.enums.Direcao;
import br.com.elo.desafiosonda.exception.ComandoNaoInformadoException;
import br.com.elo.desafiosonda.exception.MovimentacaoInvalidaException;
import br.com.elo.desafiosonda.exception.PosicaoInvalidaException;

public class Sonda {

	private Long id;
	private Ponto pontoAtual;

	@JsonIgnore
	private final int largura = 5;
	@JsonIgnore
	private final int altura = 5;

	public Sonda(Ponto pontoDePouso) {
		this.pontoAtual = pontoDePouso;

	}

	public int getAltura() {
		return altura;
	}

	public int getLargura() {
		return largura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ponto getPontoAtual() {
		return pontoAtual;
	}

	public Ponto movimentaSonda(String comando)
			throws ComandoNaoInformadoException, MovimentacaoInvalidaException, PosicaoInvalidaException {

		if (comando == null || comando.isEmpty()) {
			throw new ComandoNaoInformadoException("Parâmetro não foi informado.");
		}

		char[] comandos = comando.toCharArray();

		for (int i = 0; i < comandos.length; i++) {

			char c = comandos[i];

			switch (c) {
			case 'M':
				this.movimenta();
				break;

			case 'L':
				this.viraEsquerda90Graus();
				break;

			case 'R':
				this.viraDireita90Graus();
				break;

			default:
				throw new MovimentacaoInvalidaException("Comando não foi reconhecido, faça a correção do seu comando.");
			}
		}
		return this.pontoAtual;
	}

	private void movimenta() throws PosicaoInvalidaException {

		if (this.pontoAtual.getDirecao() == Direcao.NORTE) {
			this.pontoAtual.incrementaOrdenadaY();
		} else if (this.pontoAtual.getDirecao() == Direcao.SUL) {
			this.pontoAtual.decrementaOrdenadaY();
		} else if (this.pontoAtual.getDirecao() == Direcao.LESTE) {
			this.pontoAtual.incrementaAbscissaX();
		} else {
			this.pontoAtual.decrementaAbscissaX();
			;
		}

		if (this.pontoAtual.getAbscissaX() < 0 || this.pontoAtual.getAbscissaX() > this.getLargura()
				|| this.pontoAtual.getOrdenadaY() < 0 || this.pontoAtual.getOrdenadaY() > this.getAltura()) {

			throw new PosicaoInvalidaException("A sonda não está na área, verifique a posição dela e os comandos informados.");
		}

	}

	private void viraEsquerda90Graus() {

		switch (this.pontoAtual.getDirecao()) {

		case NORTE:
			this.pontoAtual.setDirecao(Direcao.OESTE);
			break;

		case SUL:
			this.pontoAtual.setDirecao(Direcao.LESTE);
			break;

		case LESTE:
			this.pontoAtual.setDirecao(Direcao.NORTE);
			break;

		case OESTE:
			this.pontoAtual.setDirecao(Direcao.SUL);
		}

	}

	private void viraDireita90Graus() {

		switch (this.pontoAtual.getDirecao()) {

		case NORTE:
			this.pontoAtual.setDirecao(Direcao.LESTE);
			break;

		case SUL:
			this.pontoAtual.setDirecao(Direcao.OESTE);
			break;

		case LESTE:
			this.pontoAtual.setDirecao(Direcao.SUL);
			break;

		case OESTE:
			this.pontoAtual.setDirecao(Direcao.NORTE);
		}

	}

}
