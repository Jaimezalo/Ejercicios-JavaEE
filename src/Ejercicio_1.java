

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio_1
 */
@WebServlet("/Ejercicio_1")
public class Ejercicio_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void procesaPeticion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio 1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ejercicio 1: </h1>");

            out.println("<ul>");
            Enumeration<String> nombresDeCabeceras = request.getHeaderNames();
            while (nombresDeCabeceras.hasMoreElements()) {
            	
                String cabecera = nombresDeCabeceras.nextElement();
                
                if(cabecera.equals("user-agent")) {
                	
                	String valor = request.getHeader(cabecera);
                	out.println( cabecera + " = " +valor);
                	
                	if(valor.indexOf("Firefox")!=-1) {
                		out.println("<script>alert(\"Utilizas Firefox\")</script>");
                	}else {
                		out.println("<script>alert(\"No utilizas Firefox\")</script>");
                	}
                        
                }
            }
            
            
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaPeticion(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaPeticion(request, response);
	}

}
