package br.com.webacupuntura.modeloquery;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RelatorioConsulta {
	private Date dataInicial;
	private Date dataFinal;
	private boolean paga = false, 
					finalizada = false,
					incluirPagoEFinalizado = false;
	private SimpleDateFormat formatador;
	
	public RelatorioConsulta() {
		formatador = new SimpleDateFormat("yyyy-MM-dd");
		dataInicial = Calendar.getInstance().getTime();
		dataFinal = Calendar.getInstance().getTime();
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}

	public String getDataInicialAsString() {
		return formatador.format(dataInicial);
	}
	
	public void setDataInicial(Date impressaoDataInicial) {
		this.dataInicial = impressaoDataInicial;
	}
	
	public String getDataFinalAsString() {
		return formatador.format(dataFinal);
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date impressaoDataFinal) {
		this.dataFinal = impressaoDataFinal;
	}

	public boolean getPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

	public boolean getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public boolean isIncluirPagoEFinalizado() {
		return incluirPagoEFinalizado;
	}

	public void setIncluirPagoEFinalizado(boolean incluirPagoEFinalizado) {
		this.incluirPagoEFinalizado = incluirPagoEFinalizado;
	}
}
