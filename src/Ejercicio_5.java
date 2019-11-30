

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio_5
 */
@WebServlet("/Ejercicio_5")
public class Ejercicio_5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {

		HashMap<String, String> periodicos = new HashMap<String, String>();
		IncluirPeriodicos(periodicos);
		
		
		        response.setContentType("text/html;charset=UTF-8");
		        
		        PrintWriter out = response.getWriter();
		        try {
		            out.println("<html>");
		            out.println("<head>");
		            out.println("<title>Ejercicio 5</title>");
		            out.println("</head>");
		            out.println("<body><ul>");
		            
		            for (String i : periodicos.keySet()) {
		            	  out.println("<li><a href=\""+ periodicos.get(i)+ "\">" + i + "</a></li>");
		            	}
		            
		            String[]nombres = {"El Pais","El Mundo","ABC","El Diario.es","El Mundo Today"};  
		            
		            int num = (int) Math.floor(Math.random()*4);
		            String elegido = nombres[num];
		            
		            out.println("<br/><br/>El Medio recomendado es: " + "<a href=\""+ periodicos.get(elegido)+ "\">" + elegido + "</a>");

		            out.println("</body>");
		            out.println("</html>");
		            
		        } finally { 
		            out.close();
		        }
		    } 

	private void IncluirPeriodicos(HashMap<String, String> periodicos) {
		
		periodicos.put("El Pais", "https://elpais.com/");
		periodicos.put("El Mundo", "https://www.elmundo.es/");
		periodicos.put("ABC", "https://www.abc.es/");
		periodicos.put("El Diario.es", "https://www.eldiario.es/");
		periodicos.put("El Mundo Today", "https://www.elmundotoday.com/");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
