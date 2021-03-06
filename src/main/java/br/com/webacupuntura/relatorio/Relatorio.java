package br.com.webacupuntura.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import br.com.webacupuntura.modeloquery.RelatorioConsulta;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class Relatorio implements Serializable{

	private static final long serialVersionUID = -4273436482364256714L;
	private HttpServletResponse response;
	private FacesContext context;
	private Connection con;

	public Relatorio() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) context.getExternalContext().getResponse();
	}

	
	public void getRelatorio(String arquivo,Map<String,Object> params) {

		try {
			
			String caminho = "reports/"+arquivo+".jasper";
			InputStream stream =  this.getClass().getClassLoader().getResourceAsStream(caminho);
				
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			JasperReport jasper = (JasperReport) JRLoader.loadObject(stream);
			
			if(params != null){
				params.put("SUBREPORT_DIR", "reports/");
				params.put("IMAGENS_DIR", "imagens/");
			}
			
				//JRBeanCollectionDataSource datasrc = new JRBeanCollectionDataSource(lista);
			
				// para usar JavaBeanDataSource define 'datasrc' como datasource
				JasperPrint print = JasperFillManager.fillReport(jasper, params, getConexao());
				JasperExportManager.exportReportToPdfStream(print, baos);
				
			
			response.reset();

			response.setContentType("application/pdf");

			response.setContentLength(baos.size());

			response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");

			response.getOutputStream().write(baos.toByteArray());

			response.getOutputStream().flush();

			response.getOutputStream().close();

			context.responseComplete();
			
			closeConnection();
			System.out.println("BYTES: " + baos.size());
		} catch (IllegalStateException e) {
			e.getMessage();
		}
		
		catch (Exception e) {
			System.err.println("ERRO METODO GERAR: ");
			e.printStackTrace();
		}

	}
	
	private Connection getConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/TGNmAyL5rl", "TGNmAyL5rl", "D1YYIvpyAE");
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
			if(this.con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
