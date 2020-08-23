/*
 * Criado em 26/07/2005
 * Copyright 2005. Todos os direitos reservados a Eduardo Costa, Rafael Santos, Ranieri Queiroz e Roberta Costa.
 */

package br.com.alunomobile.hp;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mobile
 * @since 26/07/2005	
 */
public class HPAlunoMobile extends HttpServlet {

	public void init(){
       //código que será executado quando o
       //servlet for iniciado
    }
   	
    public void destroy(){
        //código que será executado quando o
        //servlet for finalizado
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response ){
    	int comando = 0;
    	String matricula = "";
    	String senha = "";
    	
        try{
            response.setContentType("application/octetc-stream");
            
            DataOutputStream out = new DataOutputStream(response.getOutputStream());
            
            String dados = request.getParameter("matsenha");
            
            //TRATANDO OS DADOS
            comando = Integer.parseInt(dados.substring(1,2));
            matricula = dados.substring(3,20);
            senha = dados.substring(21);

            //CHAMADAS DAS FUNCIONALIDADES
            switch (comando) {
			case 0://ENVIAR TODAS INFORMAÇÕES AO MÓVEL
				
				break;
			case 1://ENVIAR AVISOS
				
				break;
			case 2://ENVIAR NOTAS
				
				break;
			case 3://ENVIAR FALTAS
				
				break;
			case 4://PTP
				
				break;
			default:

				break;
			}
            
        } catch( IOException ioe){
                 System.out.println("Erro de IO");
        }
            
    }
    
    private String getAvisos(String matricula){
    	String retorno = new String();

    	if(matricula == "20041169026"){
    		retorno = "#29072005|Saiu edital para monitoria#29072005|Data de inicio das aulas para os veteranos 02/03/2005";
    	}else{
    		retorno = "";
    	}
    	return retorno;
    }

    private String getNotas(String matricula){
    	String retorno = new String();

    	if(matricula == "20041169026"){
    		retorno = "#169ARC4|AV1|0800" + 
					  "#169BAD4|AV1|0603" + 
					  "#169ESA3|AV1|0905" +
					  "#169LAP4|AV1|0505" +
					  "#169POO4|AV1|0905";
    	}else{
    		retorno = "";
    	}
    	return retorno;
    }

    private String getFaltas(String matricula){
    	String retorno = new String();

    	if(matricula == "20041169026"){
    		retorno = "#169ARC4|M1|2" + 
			  		  "#169ESA3|M1|5" +
					  "#169POO4|M3|3";
    	}else{
    		retorno = "";
    	}
    	return retorno;
    }

    private String getPtp(String matricula){
    	String retorno = new String();

    	if(matricula == "20041169026"){
    		retorno = "#25";
    	}else{
    		retorno = "";
    	}
    	return retorno;
    }
}
