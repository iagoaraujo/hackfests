import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.*;
import models.strategy.ETipoEvento;


public class SistemaTest {
	private Sistema sistema;
	private Evento evento1;
	private Evento evento2;
	private Evento evento3;
	private Evento evento4;
	private Evento evento5;
	private Evento evento6;
	private Evento evento7;
	private Evento evento8;
	private Evento evento9;
	private Evento evento10;
	private Evento eventoSemAdm;
	private Pessoa pessoa1;
	private Pessoa pessoa2;
	private Pessoa pessoa3;
	private Pessoa pessoa4;
	private Pessoa pessoa5;
	private String tema1;
	private String tema2;
	private String tema3;
	private String tema4;
	private String tema5;
	private Local local1;
	
	
	@Before
	public void iniciar(){
		sistema = new Sistema();
		
		local1 = new Local("UFCG", "Próximo ao conjunto dos professores", 5);
		
		pessoa1 = new Pessoa("Jose", "jose@gmail.com", "password");
		pessoa2 = new Pessoa("Maria", "maria@gmail.com", "password");
		pessoa3 = new Pessoa("Alex", "alex@gmail.com", "password");
		pessoa4 = new Pessoa("Ana", "ana@gmail.com", "password");
		pessoa5 = new Pessoa("Gleyser", "gleyser@gmail.com", "password");
		
		evento1 = new Evento("Dados abertos", "Esse evento tem o objetivo de realizar atividades com dados abertos", "11/09/2014", pessoa1);
		evento1.setLocal(local1);
		evento2 = new Evento("HTML", "Esse evento tem o objetivo de realizar atividades com HTML", "09/09/2014", pessoa1);
		evento3 = new Evento("Computacao Desplugada", "Esse evento tem o objetivo de realizar atividades com computacao desplugada", "11/06/2014", pessoa1);
		evento4 = new Evento("Metodos Formais", "Esse evento tem o objetivo de realizar atividades com metodos formais", "18/06/2014", pessoa1);
		evento5 = new Evento("Banco de Dados Gerenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados gerenciais", "11/09/2014", pessoa1);
		evento6 = new Evento("Banco de Dados Sequenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados sequenciais", "14/09/2014", pessoa1);
		evento7 = new Evento("Sites Dinamicos", "Esse evento tem o objetivo de realizar atividades com sites dinamicos", "17/08/2014", pessoa1);
		evento8 = new Evento("Aplicações Java", "Esse evento tem o objetivo de realizar atividades com aplicacoes java", "01/09/2014", pessoa1);
		evento9 = new Evento("Estruturas de dados", "Esse evento tem o objetivo de realizar atividades com estruturas de dados", "12/07/2014", pessoa1);
		evento10 = new Evento("Binarios", "Esse evento tem o objetivo de realizar atividades com binarios sem a utilizacao de computador", "11/09/2014", pessoa1);
		eventoSemAdm = new Evento();
		eventoSemAdm.setNome("Computacao Verde");
		eventoSemAdm.setDescricao("Evento cujo tema e computacao verde");
		eventoSemAdm.setData("2014-12-04");
		
		tema1 = "Engenharia de Software";
		tema2 = "Sistemas da Informacao";
		tema3 = "Banco de Dados";
		tema4 = "Computacao Desplugada";
		tema5 = "Desenvolvimento para Web";
		
		// 5 eventos no tema 1
		evento1.addTema(tema1);
		evento4.addTema(tema1);
		evento8.addTema(tema1);
		evento9.addTema(tema1);
		evento10.addTema(tema1);
		
		// 2 eventos no tema 2
		evento4.addTema(tema2);
		evento10.addTema(tema2);
		
		// 4 eventos no tema 3
		evento2.addTema(tema3);		
		evento4.addTema(tema3);
		evento5.addTema(tema3);
		evento6.addTema(tema3);
		
		// 4 eventos no tema 4
		evento1.addTema(tema4);
		evento3.addTema(tema4);
		evento4.addTema(tema4);
		evento10.addTema(tema4);
		
		// 3 eventos no tema 5
		evento1.addTema(tema5);
		evento2.addTema(tema5);
		evento7.addTema(tema5);	
		
		// 4 participantes no evento 1
		evento1.addParticipanteNoEvento(pessoa2);
		evento1.addParticipanteNoEvento(pessoa3);
		evento1.addParticipanteNoEvento(pessoa4);
		evento1.addParticipanteNoEvento(pessoa5);
		
		// 3 participantes no evento 2
		evento2.addParticipanteNoEvento(pessoa3);
		evento2.addParticipanteNoEvento(pessoa4);
		evento2.addParticipanteNoEvento(pessoa5);
		
		// 2 participantes no evento 3
		evento3.addParticipanteNoEvento(pessoa1);
		evento3.addParticipanteNoEvento(pessoa5);
		
		// 1 participante no evento 4
		evento4.addParticipanteNoEvento(pessoa5);
		
		sistema.addEvento(evento1);
		sistema.addEvento(evento2);
		sistema.addEvento(evento3);
		sistema.addEvento(evento4);
		sistema.addEvento(evento5);
		sistema.addEvento(evento6);
		sistema.addEvento(evento7);
		sistema.addEvento(evento8);
		sistema.addEvento(evento9);
		sistema.addEvento(evento10);	
		
	}
	
	@Test
	public void testaAdicionarEventoNoSistema(){
		Assert.assertEquals(10, sistema.numDeEventos());
		Assert.assertTrue(sistema.contemEvento(evento1));
		Assert.assertTrue(sistema.contemEvento(evento5));
		Assert.assertEquals(evento1, sistema.getEventos().get(0));
		Assert.assertEquals(evento5, sistema.getEventos().get(4));		
		
	}
	
	@Test
	public void testaRemoverEventoNoSistema(){
		Assert.assertEquals(10, sistema.numDeEventos());
		Assert.assertEquals(evento1, sistema.getEventos().get(0));
		Assert.assertEquals(evento5, sistema.getEventos().get(4));	
		sistema.removeEvento(evento1);
		Assert.assertEquals(evento2, sistema.getEventos().get(0));
		sistema.removeEvento(evento2);
		Assert.assertFalse(sistema.contemEvento(evento2));
		Assert.assertEquals(evento3, sistema.getEventos().get(0));
		Assert.assertEquals(8, sistema.numDeEventos());
		Assert.assertEquals(evento5, sistema.getEventos().get(2));
		Assert.assertFalse(sistema.removeEvento(evento2));
		
	}
	
	@Test
	public void testaEventosPorTema(){
		Assert.assertEquals(5, sistema.eventosPorTema(tema1).size());
		Assert.assertEquals(2, sistema.eventosPorTema(tema2).size());
		Assert.assertEquals(4, sistema.eventosPorTema(tema3).size());
		Assert.assertEquals(4, sistema.eventosPorTema(tema4).size());
		Assert.assertEquals(3, sistema.eventosPorTema(tema5).size());
		Assert.assertEquals(evento1, sistema.eventosPorTema(tema1).get(0));
		Assert.assertEquals(evento1, sistema.eventosPorTema(tema5).get(0));
		sistema.removeEvento(evento1);
		// Testando apos uma remocao
		Assert.assertEquals(evento4, sistema.eventosPorTema(tema1).get(0));
	}
	
	@Test
	public void testaOrdenaPorNumeroDePessoas(){
		Assert.assertEquals(evento1, sistema.eventosOrdenadosPorQuantidadeDePessoas().get(0));
		Assert.assertEquals(evento2, sistema.eventosOrdenadosPorQuantidadeDePessoas().get(1));
		Assert.assertEquals(evento3, sistema.eventosOrdenadosPorQuantidadeDePessoas().get(2));
		Assert.assertEquals(evento4, sistema.eventosOrdenadosPorQuantidadeDePessoas().get(3));
		
		// Adicionar mais pessoas no evento 2 para verificar se ele passar a ser o primeiro da lista
		Pessoa pessoa12 = new Pessoa("Margarida", "margarida@gmail.com", "password");
		Pessoa pessoa13 = new Pessoa("Magna", "magda@gmail.com", "password");
		Pessoa pessoa14 = new Pessoa("Hiago", "hiago@gmail.com", "password");		
		sistema.addPessoaNoEvento(evento2, pessoa12);
		sistema.addPessoaNoEvento(evento2, pessoa13);
		sistema.addPessoaNoEvento(evento2, pessoa14);
		Assert.assertEquals(evento2, sistema.eventosOrdenadosPorQuantidadeDePessoas().get(0));
		
		// Adicionar mais no evento 1 para verificar se ele volta a ser o primeiro da lista
		sistema.addPessoaNoEvento(evento1, pessoa12);
		sistema.addPessoaNoEvento(evento1, pessoa13);
		sistema.addPessoaNoEvento(evento1, pessoa14);
		Assert.assertEquals(evento1, sistema.eventosOrdenadosPorQuantidadeDePessoas().get(0));
	}

	@Test
	public void testaEventoEncerrado() {
		//Evento normal
		Assert.assertFalse(evento1.isEventoClosed());
		evento1.addParticipanteNoEvento(pessoa1);
		Assert.assertTrue(evento1.isEventoClosed());
		
		//Evento prioritario
		evento1.setTipoDeEvento(ETipoEvento.PRIORIDADE_EXPERIENTES.getNome());
		Assert.assertFalse(evento1.isEventoClosed());
	}
	
	/*
	 * Testa se a confirmacao de inscricao de usuarios mais experientes em eventos
	 * prioritarios.
	 */
	@Test
	public void testaInscricaoEmEventoPrioritario() {
		Pessoa usuarioMaisExperiente = new Pessoa("Experiente", "experiente@gmail.com", 
				"password");
		usuarioMaisExperiente.setNumEventosCriados(1);
		Pessoa usuarioIntermediario = new Pessoa("Intermediario", "intermediario@gmail.com",
				"password");
		usuarioIntermediario.setNumEventosInscritos(2);
		Pessoa usuarioMenosExperiente = new Pessoa("Menos Experiente", "menosExperiente@gmail.com",
				"password");
		Local localEventoPrioritario = new Local();
		localEventoPrioritario.setCapacidade(1);
		Evento eventoPrioritario = new Evento();
		eventoPrioritario.setTipoDeEvento(ETipoEvento.PRIORIDADE_EXPERIENTES.getNome());
		eventoPrioritario.setLocal(localEventoPrioritario);
		
		eventoPrioritario.addParticipanteNoEvento(usuarioMenosExperiente);
		Assert.assertTrue(eventoPrioritario.isUsuarioConfirmado(usuarioMenosExperiente));
		
		eventoPrioritario.addParticipanteNoEvento(usuarioIntermediario);
		Assert.assertFalse(eventoPrioritario.isUsuarioConfirmado(usuarioMenosExperiente));
		Assert.assertTrue(eventoPrioritario.isUsuarioConfirmado(usuarioIntermediario));

		eventoPrioritario.addParticipanteNoEvento(usuarioMaisExperiente);
		Assert.assertFalse(eventoPrioritario.isUsuarioConfirmado(usuarioMenosExperiente));
		Assert.assertFalse(eventoPrioritario.isUsuarioConfirmado(usuarioIntermediario));
		Assert.assertTrue(eventoPrioritario.isUsuarioConfirmado(usuarioMaisExperiente));
	}
	
	@Test
	public void testaCriaEventoComNovoLocal() {
		sistema.setUsuarioLogado(pessoa1);
		sistema.criaEventoComNovoLocal(eventoSemAdm, local1);
		Assert.assertEquals(eventoSemAdm.getAdministrador(), pessoa1);
		Assert.assertEquals(eventoSemAdm.getLocal(), local1);
		Assert.assertTrue(sistema.getEventos().contains(eventoSemAdm));
		Assert.assertTrue(sistema.getLocais().contains(local1));
	}
	
	@Test
	public void testaCriaEventoComLocalJaCadastrado() {
		sistema.setUsuarioLogado(pessoa1);
		final long LOCAL_ID = 1;
		local1.setId(LOCAL_ID);
		sistema.addLocal(local1);
		sistema.criaEventoLocalCadastrado(eventoSemAdm, LOCAL_ID);
		Assert.assertEquals(eventoSemAdm.getAdministrador(), pessoa1);
		Assert.assertEquals(eventoSemAdm.getLocal(), local1);
		Assert.assertTrue(sistema.getEventos().contains(eventoSemAdm));
	}
}
