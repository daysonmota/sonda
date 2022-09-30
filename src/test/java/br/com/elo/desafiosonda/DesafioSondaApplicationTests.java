package br.com.elo.desafiosonda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.elo.desafiosonda.enums.Direcao;
import br.com.elo.desafiosonda.model.Ponto;
import br.com.elo.desafiosonda.model.Sonda;
import br.com.elo.desafiosonda.persistencia.SondaRepository;

@SpringBootTest
class DesafioSondaApplicationTests {

	private static SondaRepository sondaRepository;

	@BeforeAll
	public static  void contextLoads() {
		sondaRepository = new SondaRepository();
	}

	@Test
	public void testaLocalizacaoPrimeiraSonda() throws Exception {

		Ponto pontoIncial = new Ponto(1, 2, Direcao.NORTE);

		Ponto pontoEsperado = new Ponto(1, 3, Direcao.NORTE);

		String comando = "LMLMLMLMM";

		Sonda sonda = new Sonda(pontoIncial);

		sondaRepository.salva(sonda);

		Assertions.assertNotNull(sonda.getId());

		Ponto ponto = sonda.movimentaSonda(comando);
		System.out.println(ponto);

		Assertions.assertEquals(ponto, pontoEsperado);
	}

	@Test
	public void testaLocalizacaoSegundaSonda() throws Exception {

		Ponto pontoIncial = new Ponto(3, 3, Direcao.LESTE);

		Ponto pontoEsperado = new Ponto(5, 1, Direcao.NORTE);

		String comando = "MMRMMRMRRML";

		Sonda sonda = new Sonda(pontoIncial);

		sondaRepository.salva(sonda);

		Assertions.assertNotNull(sonda.getId());

		Ponto ponto = sonda.movimentaSonda(comando);
		System.out.println(ponto);

		Assertions.assertEquals(ponto, pontoEsperado);
	}

}
