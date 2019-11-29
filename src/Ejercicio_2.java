

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="FormularioServlet", urlPatterns={"/formularioHobbies"})
public class Ejercicio_2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String edad = request.getParameter("edad");
        String sexo = request.getParameter("sexo");
        String[] hobbies = request.getParameterValues("hobbies");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio 2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + "Hola " + nombre + " " + apellidos+  "</h1>");
            out.println("Tu sexo es " + sexo);
            
            if(sexo.equals("hombre")) {
            	out.println("<img src=\"/Ejercicios1/hombre.png\"");
            }else {
            	out.println("<img src=\"/Ejercicios1/mujer.png\"");
            }
            
            out.println("Tu Franja de edad es " + edad + " y tus hobbies son:");

            out.println("<ul>");
            for (String hobby : hobbies) {
                out.println("<li>" + hobby + "</li>");
            }
            out.println("</ul>");
            out.println("Este formulario ha sido invocado con Los siguientes parametros:<br/>");
            out.println(request.getQueryString());

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
