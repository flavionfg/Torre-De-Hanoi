package br.com.javaparaweb.capitulo12.jfreechart;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;
import javax.faces.bean.*;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class CidadeBean {
	private StreamedContent	grafico;
	private static final Logger	log	= Logger.getLogger(CidadeBean.class.getName()); //1* 

	public CidadeBean() {
		try {
			JFreeChart graficoPizza = ChartFactory.createPieChart("5 cidades mais populosas de SC", 
				this.geraDados(), true, true, false);  //2*
			File arquivoGrafico = new File("pizza.png"); //3*
			ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoPizza, 500, 300); //4*
			this.grafico = new DefaultStreamedContent(new FileInputStream(arquivoGrafico), "image/png"); //5*
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
	}
	private DefaultPieDataset geraDados() {
		DefaultPieDataset dts = new DefaultPieDataset(); //6*
		dts.setValue("Blumenau", new Double(334002.0));
		dts.setValue("Crici�ma", new Double(204667.0));
		dts.setValue("Florianop�lis", new Double(461524.0));
		dts.setValue("Joinville", new Double(554601.0));
		dts.setValue("S�o Jos�", new Double(228561.0));
		return dts;
	}
	public StreamedContent	getGrafico() {
		return this.grafico;
	}
}


/* O grafico da biblioteca JfreeChart � parecido com o do PrimeFaces,mas as configura��es s�o mais faceis,e aqui
 * o grafico � gerado � uma imagem est�tica.
 * 
 * 1 - Usamos um log para monitorar a gera��o da imagem do gr�fico. Essa propriedade pode ser retirada, mas 
 * � util quando estamos deputando nosso codigo-fonte.
 * 
 * 2 - Variavel graficoPizza que armazena nosso grafico. Com a classe ChartFactory especificamos que gr�fico
 * queremos construir, e � a partir dessa classe que montamos os diversos tipos de gr�fico. Os par�metros 
 * passados referem-se ao titulo do grafico,� fonte de dados,� existencia ou n�o de legenda,informa��es(tips)
 * e URLs vinculadas.
 * 
 * 3 - Criamos um arquivo para guardar a imagem que ser� gerada para o grafico.Pode-se especificar um caminho
 * completona qual dever� ser gravada a imagem. Em nosso exemplo,Passamossomente o nome do arquivo Pizza.png
 * mas poderia ser c:\\pizza.png.
 * 
 * 4 - Uma imagem do grafico ent�o � criada usando a classe ChartUtilities e o m�todo saveChartAsPNG. os parametros
 * passados s�o o nome do arquivo a ser gravado, o gr�fico em si,a largura da imagem e a sua altura.
 * 
 * 5 - Geramos o recurso que cont�m a imagem que deve ser mostrada na p�gina JSF. A classe DefaultStreamedContent 
 * da biblioteca PrimeFaces � responsavel por isso.
 * 
 * 6 - Dentro do m�todo geraDados, temos a constru��o dos dados necess�rios ao grafico. A partir da classe 
 * DefaultStreamedContent montamos uma cole��o das informa��es que precisamos.Cada tipo de gr�fico tem uma 
 * classe do tipo Dataset especifica.
 * 
 * 
 * *  */
