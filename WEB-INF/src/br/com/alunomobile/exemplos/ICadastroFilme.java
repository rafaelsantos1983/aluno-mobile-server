/*
 * Criado em 27/05/2005
 * Copyright (c) 2004 Eduardo Costa, Rafael Santos, Ranieri Queiroz e Roberta Costa.  All rights reserved.
 */
package sistema.cadastro;

import arquivo.organizacao.excecoes.GeralException;
import tabela.Filme;

/**
 * Interface para manipulação de Filme
 * @author Eduardo Costa
 * @author Rafael Santos
 * @author Ranieri Queiroz
 * @author Roberta Costa
 * @since 27/05/2005
 */
public interface ICadastroFilme {
	
	/**
	 * Incluir Filme
	 * @param filme O Filme
	 * @throws GeralException
	 */
	public void incluirFilme(Filme filme) throws GeralException;

	/**
	 * Alterar Filme
	 * @param filme O Filme
	 */
	public void alterarFilme(Filme filme);
	
	/**
	 * Localizar Filme
	 * @param filme O Filme
	 * @throws GeralException
	 */
	public Filme localizarFilme(Filme filme) throws GeralException;
	
	/**
	 * Excluir Filme
	 * @param filme O Filme
	 */
	public void excluirFilme(Filme filme);

	/**
	 * Verifica se Existe o filme
	 * @param codigo
	 * @return
	 * @throws GeralException
	 */
	public boolean existeFilme(int codigo) throws GeralException;
	
}
