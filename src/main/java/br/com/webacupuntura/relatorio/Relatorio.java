package br.com.webacupuntura.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import br.com.webacupuntura.modelo.Consulta;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class Relatorio <T>{
	private HttpServletResponse response;
	private FacesContext context;
	private Connection con;

	public Relatorio() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) context.getExternalContext().getResponse();
	}

	public void getRelatorio(List<T> lista) {

		try {

			String caminho = "/report/wa2.jasper";
			InputStream stream = this.getClass().getResourceAsStream(caminho);
			URL url = this.getClass().getResource(caminho);
			
			System.out.println("URL:" + url);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			JRBeanCollectionDataSource datasrc = new JRBeanCollectionDataSource(lista);

			JasperReport jasper = (JasperReport) JRLoader.loadObject(stream);
			Map<String, Object> params = new HashMap<String, Object>();
			
			// para usar JavaBeanDataSource define 'datasrc' como datasource
			JasperPrint print = JasperFillManager.fillReport(jasper, params, getConexao());

			JasperExportManager.exportReportToPdfStream(print, baos);
			System.out.println("BYTES: " + baos.size());
			response.reset();

			response.setContentType("application/pdf");

			response.setContentLength(baos.size());

			response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");

			response.getOutputStream().write(baos.toByteArray());

			response.getOutputStream().flush();

			response.getOutputStream().close();

			context.responseComplete();
			


			closeConnection();

		} catch (Exception e) {
			System.err.println("ERRO METODO GERAR: " +e.getCause());
		}

	}

	private Connection getConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webacupuntura", "root", "");
			return con;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("ERRO NA CONEXAO " + e.getCause());
		}
		return con;
	}

	private void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
