package br.com.javaparaweb.capitulo12.primefaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped; 
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name = "vendaBean") //1*
@RequestScoped //2*
public class VendaBean {
	private PieChartModel vendaPais;

	public VendaBean() { //3*
		this.vendaPais = new PieChartModel();
		this.vendaPais.set("Brasil", 540.50f);
		this.vendaPais.set("Estados Unidos", 590.52f);
		this.vendaPais.set("Inglaterra", 475.30f);
		this.vendaPais.set("Fran�a", 400);
		this.vendaPais.set("Alemanha", 397.33f);
		this.vendaPais.setTitle("Gr�fico de vendas por pa�s");
		this.vendaPais.setLegendPosition("e");
		this.vendaPais.setShowDataLabels(true);
		this.vendaPais.setDataFormat("percent");
	}

	public PieChartModel getVendaPais() {
		return vendaPais;
	}
}

/*
 * 1 - Mapeamos nossa classe com a nota��o do JSF 2, em que o apelido (alias) de nossa classe passa a ser vendaBean,sendo 
 * este o nome referenciado em nossa pagina.
 * 
 * 2 - Mapeamos o escopo de requisi��o, que, no caso, � do tipo @RequestScoped.
 * 
 * 3 - No construtor da classe foram criados os dados com as informa��es dos paises que podem ser adicionados diretamente 
 * aos gr�fico. As informa��es em seguida referem-se �s configura��es do grafico, como titulo,posi��o da legenda,se os
 * valores aparecer�o nas fatias da pizza e etc.
 * 
 */