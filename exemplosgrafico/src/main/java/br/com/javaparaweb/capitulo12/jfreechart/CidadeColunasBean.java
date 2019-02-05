package br.com.javaparaweb.capitulo12.jfreechart;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;
import javax.faces.bean.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.*;

@ManagedBean
@RequestScoped
public class CidadeColunasBean {

	private StreamedContent			grafico;
	private static final Logger	log	= Logger.getLogger(CidadeColunasBean.class.getName());

	public CidadeColunasBean() {
		try {
			JFreeChart graficoColunas = ChartFactory.createBarChart("5 cidades mais populosas de SC",
				"Cidades", "Popula��o", this.geraDados(), PlotOrientation.VERTICAL, false, true, false); //1*
			File arquivoGrafico = new File("colunas.png");
			ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoColunas, 500, 325);
			this.grafico = new DefaultStreamedContent(new FileInputStream(arquivoGrafico), "image/png");
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
	}

	private DefaultCategoryDataset geraDados() { //*2
		DefaultCategoryDataset dts = new DefaultCategoryDataset();
		dts.setValue(new Double(334002.0), "Popula��o", "Blumenau");
		dts.setValue(new Double(204667.0), "Popula��o", "Crici�ma");		
		dts.setValue(new Double(461524.0), "Popula��o", "Florianop�lis");
		dts.setValue(new Double(554601.0), "Popula��o", "Joinville");
		dts.setValue(new Double(228561.0), "Popula��o", "S�o Jos�");	
		return dts;
	}
	public StreamedContent getGrafico() {
		return this.grafico;
	}
}


/* 1 - Estamos gerando um grafico de colunas : veja a chamada para a classe ChartFactory.createBartChart.Ali s�o passados
 * como par�metros nome e grafico, o titulo do exo X, o titulo do eixo Y,a fonte de dados, o eixo que ser� o eixo vertical,
 * no caso, o eixo Y,se h� legenda, se h� informa�o�s (tips) e a aus�ncia de URLs vinculadas.
 * 
 * 2 - Geramos as informa��es necessarias. foi preciso informar tr�s dados: o valor de cada coluna,o valor para as linhas
 * do grafico e o valor para as colunas do gr�fico.Observe tamb�m que trabalhamos com outra classe(DefaltCategoryDataset)
 * para armazenar os dados, ja que agora o tipo de grafico mudou.
 * 
 * 
 */
