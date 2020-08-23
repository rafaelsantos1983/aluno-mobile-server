/*
 * Criado em 27/05/2005
 * Copyright (c) 2004 Eduardo Costa, Rafael Santos, Ranieri Queiroz e Roberta Costa.  All rights reserved.
 */
package br.com.alunomobile.exemplos;

import tabela.Filme;
import arquivo.organizacao.RepositorioCadastroFilme;
import arquivo.organizacao.excecoes.FilmeExistenteException;
import arquivo.organizacao.excecoes.GeralException;

/**
 * Controlador de Filme
 * Coordena a manipulação de Filme
 * @author Eduardo Costa
 * @author Rafael Santos
 * @author Ranieri Queiroz
 * @author Roberta Costa
 * @since 27/05/2005
 */
public class ControladorFilme {

	/**
	 * Incluir o Filme
	 * @param filme O Filme
	 * @throws GeralException
	 * @throws FilmeExistenteException
	 */
	public void incluirFilme(Filme filme) throws GeralException{
		ICadastroFilme repositorioCadastroFilme = new RepositorioCadastroFilme();
		repositorioCadastroFilme.incluirFilme(filme);
	}

	/**
	 * Localiza o Filme
	 * @param filme o Filme
	 * @return O filme Localizado ou null
	 * @throws FilmeExistenteException
	 * @throws GeralException
	 */	
	public Filme localizarFilme(Filme filme) throws GeralException {
		ICadastroFilme repositorioCadastroFilme = new RepositorioCadastroFilme();
		return repositorioCadastroFilme.localizarFilme(filme);
		
	}	
	
	/**
	 * Verifica se existe o filme cadastrado
	 * @param codigo
	 * @return true se existir, false caso contrario
	 * @throws GeralException
	 */
	public boolean existeFilme(int codigo) throws GeralException{
		ICadastroFilme respositorioCadastroFilme = new RepositorioCadastroFilme();
		return respositorioCadastroFilme.existeFilme(codigo);
	}
	
}
