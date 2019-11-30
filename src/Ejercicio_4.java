

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Ejercicio_4
 */
@WebServlet("/Ejercicio_4")
public class Ejercicio_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
       
		int[] lista = ArrayNumeros();
		
		response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio 4</title>");
            out.println("<style>table{border-collapse:collapse}"
            		+ "table td{border:solid black 2px}"
            		+ "td{width:40px;height:40px;text-align:center;}</style>");
            out.println("</head>");
            out.println("<body>");          
            out.println("<table><tr>");
            
            	for(int j=0; j<lista.length; j++) {
            		out.println("<td>" + lista[j] + "</td>");
            	}
        	out.println("</tr></table>");	
            out.println("<ul><li>El valor máximo es: " + Maximo(lista) + "</li>");
            out.println("<li>El valor mínimo es: " + Minimo(lista) + "</li>");
            out.println("<li>El valor que más veces se repite es: " + MasRepetido(lista) + "</li></ul>");
            out.println("</body>");
            out.println("</html>");
            
        } finally { 
            out.close();
        }
	}
	
	private int[] ArrayNumeros() {
		
		int[]arrayNumeros = new int[20];
		
		for(int i=0; i<20; i++) {
			int num = (int) Math.floor(Math.random()*10+1);
			arrayNumeros[i] = num;
		}

		return arrayNumeros;
		
	}
	
	private int Maximo(int[] arrayNumeros) {
		
		int maximo = 0;
	
		for(int valor:arrayNumeros) {
			if(valor > maximo) {
				maximo = valor;
			}
		}
		return maximo;
	}
	
	private int Minimo(int[] arrayNumeros) {
		
		int minimo = 11;
		
		
		for(int valor:arrayNumeros) {
			if(valor < minimo) {
				minimo = valor;
			}
		}
		return minimo;
	}
	
	private int MasRepetido(int[] arrayNumeros) {
		int contador = 0;
		int masRepetido = 0;
		int mediana = -1;
		
		for(int i=0; i<arrayNumeros.length; i++) {
			
			for(int j=0; j<arrayNumeros.length; j++) {
				if(arrayNumeros[i]==arrayNumeros[j]) {
					contador++;
				}
			}
			
			if(contador > masRepetido) {
				mediana = arrayNumeros[i];
				masRepetido = contador;
			}
			
			contador = 0;
		}
		
		return mediana;
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
