package br.com.alunomobile.exemplos;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;

/**
* Essa classe trata do arquivo XML de configuração
*/
public class getXMLConfig{
       /** O nome da classe atual, para ser impresso na tela ou no Log */
       private static final String THISCLASSNAME= "getXMLConfig";
       /** Global value so it can be ref'd by the tree-adapter */
       private static Document document;
       /** Armazena uma única instancia desse objeto */
       private static getXMLConfig thisObject = null;

       /**
       * Use este método para pegar uma instancia desse objeto
       */
       public static getXMLConfig getInstance(){

              if (thisObject == null ) thisObject = new getXMLConfig();

              return thisObject;
       }

       /**
       * Retorna o endereço onde está o arquivo de configuraçao do servidor.
       * Deve estar embaixo do diretório corrente em /curr_dir/config/conexoes
       * @return O caminho completo do arquivo de configuraçao de conexao
       */
       public final static String getConexaoConfig(){

              String sep = System.getProperty("file.separator");

              return System.getProperty("user.dir")+sep+"config"+sep+"conexoes"+sep+"conexoes.xml";

       }

       /**
       * Carrega o arquivo XML
       */
       private getXMLConfig(){

               DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
               //factory.setValidating(true);
               //factory.setNamespaceAware(true);

               try {

                   DocumentBuilder builder = factory.newDocumentBuilder();
                   document = builder.parse( new File(getConexaoConfig()) );

               } catch (SAXException sxe) {

                   // Error generated during parsing)

                   Exception x = sxe;

                   if (sxe.getException() != null)
                      x = sxe.getException();

                   x.printStackTrace();

               } catch (ParserConfigurationException pce) {

                   // Parser with specified options can't be built
                   pce.printStackTrace();

               } catch (IOException ioe) {

                   // I/O error
                   ioe.printStackTrace();

               }

       }//fim construtor

       /**
       * Basic TreeModel operations
       * @return Element Returning root document
       */
       public Element getRoot() {

              return document.getDocumentElement();

       }

       /**
       * Retorna o valor de uma determinada TAG, sempre do item(0) <br>
       * Por exemplo, digamos que exista um arquivo de configuração assim: <br>
       * <pre>
       * &lt;conexao title="EBDFV"&gt;
       * &lt;jdbc-database-url&gt;jdbc:odbc:DDEBDFV&lt;/jdbc-database-url&gt;
       * </pre>
       * <p>
       * A tag da chamada da funçÃo seria <i>jdbc-database-url</i> E o node estaria apontando para o Element <i>conexao</i>
       * @param Element O Element que deseja-se buscar a TAG
       * @param tag A tag que deseja-se pegar o valor
       * @return String com o valor da tag
       */
       public static String getStrElement(Element n, String tag){

              if (n == null) return null;

              NodeList nlTemp = n.getElementsByTagName(tag);

              if (nlTemp == null ) return null;

              if ( nlTemp.getLength() == 0) return null;

              Element eTemp = (Element)(nlTemp).item(0);

              if (eTemp.getFirstChild() == null ) return "";

              return eTemp.getFirstChild().getNodeValue();

       }

       //***********************************************************************************

       /**
       * Conta quantos Titles tem no XML
       * @return int O número de Titles do documento XML
       */
       public static int getNumTitles(){

              NodeList nlTitles = getXMLConfig.getInstance().getRoot().getElementsByTagName("conexao");

              return nlTitles.getLength();

       }

       /**
       * Procura os dados de conexão de acordo com o titulo
       * @param title O título da conexão a ser procurado no arquivo XML
       * @return String <code> return new String[]{jdbcDriver, jdbcUrl, jdbcLogin, jdbcSenha, jdbcBegin, jdbcMax};</code>
       */
       public static String [] getJdbcData(String title){

              NodeList nlTitles = getXMLConfig.getInstance().getRoot().getElementsByTagName("conexao");

              Element nTitle = null;

              for (int i = 0; i < nlTitles.getLength(); i++ ){

                  Node nTemp = nlTitles.item(i);

                  NamedNodeMap nnMap = nTemp.getAttributes();

                  if ( nnMap.getNamedItem("title").getNodeValue().equalsIgnoreCase(title)) {

                     nTitle = (Element) nTemp;

                  }

              }

              if (nTitle == null) return null;

              String jdbcDriver = getStrElement(nTitle, "jdbc-driver-name");

              System.out.println("Drivername="+ jdbcDriver);

              String jdbcUrl = getStrElement(nTitle, "jdbc-database-url");

              System.out.println("jdbcUrl="+ jdbcUrl);

              String jdbcLogin = getStrElement(nTitle, "jdbc-login-name");

              System.out.println("jdbcLogin="+ jdbcLogin);

              String jdbcSenha = getStrElement(nTitle, "jdbc-password-name");

              System.out.println("jdbcSenha="+ jdbcSenha);

              String jdbcBegin = getStrElement(nTitle, "jdb-begin-connection");

              System.out.println("jdbcBegin="+ jdbcBegin);

              String jdbcMax = getStrElement(nTitle, "jdb-max-connection");

              System.out.println("jdbcMax="+ jdbcMax);

              return new String[]{jdbcDriver, jdbcUrl, jdbcLogin, jdbcSenha, jdbcBegin, jdbcMax};

       }//fim getJdbcData(String title)

}//fim class
