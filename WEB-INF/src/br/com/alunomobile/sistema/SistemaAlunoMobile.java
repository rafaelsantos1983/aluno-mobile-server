/*
 * Criado em 30/07/2005
 * Copyright 2005. Todos os direitos reservados a Eduardo Cheng, Rafael Santos, Ranieri Queiroz e Roberta Costa.
 */
package br.com.alunomobile.sistema;

import br.com.alunomobile.sistema.cadastro.ControladorAluno;
import br.com.alunomobile.sistema.cadastro.ControladorAviso;
import br.com.alunomobile.sistema.cadastro.ControladorFalta;
import br.com.alunomobile.sistema.cadastro.ControladorNota;
import br.com.alunomobile.sistema.cadastro.ControladorPtp;

/**
 * @author Eduardo Cheng
 * @author Rafael Santos
 * @author Ranieri Queiroz
 * @author Roberta Costa
 * @since 30/07/2005
 */
public class SistemaAlunoMobile {

    //ATRIBUTOS ESTÁTICOS DA CLASSE
    private static ControladorAluno controladorAluno;
    private static ControladorAviso controladorAviso;
    private static ControladorFalta controladorFalta;
    private static ControladorNota controladorNota;
    private static ControladorPtp controladorPtp;
    
    //ÚNICA INSTÂNCIA DA CLASSE
    private static SistemaAlunoMobile thisObject;
    
    //CRIA OU RETORNA A ÚNICA INSTÂNCIA DA CLASSE
    //@return Uma única instância para o acesso ao SistemaAlunoMobile
    public static SistemaAlunoMobile getInstance(){
        if(thisObject == null){
            thisObject = new SistemaAlunoMobile();
        }
        return thisObject;
    }
    
    //CONTROLADOR DE ALUNO
    //@return uma única isntância para o acesso ao controlador
    private static ControladorAluno getControladorAluno(){
        if(controladorAluno == null){
            controladorAluno = new ControladorAluno();
        }
        return controladorAluno;
    }
    
    //CONTROLADOR DE AVISO
    //@return uma única isntância para o acesso ao controlador
    private static ControladorAviso getControladorAviso(){
        if(controladorAviso == null){
            controladorAviso = new ControladorAviso();
        }
        return controladorAviso;
    }
    
    //CONTROLADOR DE FALTA
    //@return uma única isntância para o acesso ao controlador
    private static ControladorFalta getControladorFalta(){
        if(controladorFalta == null){
            controladorFalta = new ControladorFalta();
        }
        return controladorFalta;
    }

    //CONTROLADOR DE NOTA
    //@return uma única isntância para o acesso ao controlador
    private static ControladorNota getControladorNota(){
        if(controladorNota == null){
            controladorNota = new ControladorNota();
        }
        return controladorNota;
    }

    //CONTROLADOR DE PTP
    //@return uma única isntância para o acesso ao controlador
    private static ControladorPtp getControladorPtp(){
        if(controladorPtp == null){
            controladorPtp = new ControladorPtp();
        }
        return controladorPtp;
    }
    
    
}
