package br.com.alunomobile.exemplos;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class DukeServlet extends HttpServlet{

       public void init(){
       //c�digo que ser� executado quando o
       //servlet for iniciado
       }
       public void destroy(){
       //c�digo que ser� executado quando o
       //servlet for finalizado
       }
       public void doGet(HttpServletRequest request, HttpServletResponse response ){
              try{
                  response.setContentType("application/octetc-stream");
                  
                  DataOutputStream out = new DataOutputStream(response.getOutputStream());
                  
                  String dados = request.getParameter("msg");
                  
                  if( dados.equals("OI") ){
                      out.writeUTF("Ola Rafael Santos");
                      System.out.println("Recebendo Texto = "+ dados);
                  }else{
                         System.out.println("Mensagem Recebida: " + dados);
                  }
              } catch( IOException ioe){
                       System.out.println("Erro de IO");
              }
       }// fim do m�todo doGet
}// fim da classe DukeServlet
