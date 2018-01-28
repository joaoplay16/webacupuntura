package br.com.webacupuntura.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;


import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class Relatorio {
	private HttpServletResponse response;
	private FacesContext context;
	private Connection con;

	public Relatorio() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) context.getExternalContext().getResponse();
	}

	
	public void getRelatorio(String arquivo, Long codigo) {

		try {
			
			String caminho = "/report/"+arquivo+".jasper";
			InputStream stream =  this.getClass().getResourceAsStream(caminho);
				
			URL url = this.getClass().getResource(caminho);
			System.out.println("URL: " +url);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			JasperReport jasper = (JasperReport) JRLoader.loadObject(stream);
			Map<String, Object> params = new HashMap<String, Object>();
			
			if(codigo!=null)
			params.put("codigo", codigo);
			params.put("banner", "/report/leaf_banner_gray.png");
			
			
				//JRBeanCollectionDataSource datasrc = new JRBeanCollectionDataSource(lista);
			
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
			System.err.println("ERRO METODO GERAR: ");
			e.printStackTrace();
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
