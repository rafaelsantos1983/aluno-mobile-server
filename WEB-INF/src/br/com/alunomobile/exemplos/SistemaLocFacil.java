/*
 * Criado em 27/05/2005
 * Copyright (c) 2004 Eduardo Costa, Rafael Santos, Ranieri Queiroz e Roberta Costa.  All rights reserved.
 */
package sistema;

import arquivo.organizacao.excecoes.FilmeExistenteException;
import arquivo.organizacao.excecoes.GeralException;
import sistema.cadastro.ControladorFilme;
import tabela.Filme;

/**
 * Sistema LocFacil
 * Fachada do Sistema
 * @author Eduardo Costa
 * @author Rafael Santos
 * @author Ranieri Queiroz
 * @author Roberta Costa
 * @since 27/05/2005
 */
public class SistemaLocFacil {
	
	private static ControladorFilme controladorFilme;
	
	/**
	 * Unica instancia da Classe
	 */
	private static SistemaLocFacil thisObject;
	
	/**
	 * Cria ou retorna a unica instancia da classe
	 * @return um unica instancia para o acesso ao SietamLocFacil
	 */
	public static SistemaLocFacil getInstance(){
    	if (thisObject == null){
    		thisObject = new SistemaLocFacil();
    	}
  		return thisObject;
    }	
	
	/**
	 * Controlador de Filme
	 * @return um unica instancia para o acesso ao controlador
	 */
	private static ControladorFilme getControladorFilme(){
    	if (controladorFilme == null){
    		controladorFilme = new ControladorFilme();
    	}
  		return controladorFilme;
	}
	
	/**
	 * Incluir Filme
	 * @throws GeralException
	 * @throws FilmeExistenteException
	 */
	public void incluirFilme(Filme filme) throws GeralException{
		getControladorFilme().incluirFilme(filme);
	}
	
	/**
	 * Verifica se existe filme
	 * @param codigo
	 * @return
	 * @throws GeralException
	 */
	public boolean existeFilme(int codigo) throws GeralException{
		return getControladorFilme().existeFilme(codigo); 
	}
	
	/**
	 * Verifica se existe filme
	 * @param codigo
	 * @return
	 * @throws GeralException
	 */
	public Filme consultarFilme(Filme filme) throws GeralException{
		return getControladorFilme().localizarFilme(filme); 
	}	
	

}
