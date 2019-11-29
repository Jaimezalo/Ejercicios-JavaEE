
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Ejercicio_3", urlPatterns={"/formularioAcceso"})
public class Ejercicio_3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");

        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio 3</title>");
            out.println("</head>");
            out.println("<body>");
            
            if((usuario.equals("alumno"))&&(clave.equals("alumno"))) {
            	out.println("<script>alert(\"Bienvenido\")</script>");
            }else {
            	out.println("<script type=\"text/javascript\">history.back()</script>");
            }

            out.println("</body>");
            out.println("</html>");
            
        } finally { 
            out.close();
        }
    } 

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

}