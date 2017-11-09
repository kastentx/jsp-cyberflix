package edu.txstate.cs3320.kasten;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.DataSource;
import edu.txstate.internet.cyberflix.utils.ServletUtils;

/**
 * Servlet implementation class CyberFlixServlet
 */
@WebServlet("/CyberFlixServlet")
public class CyberFlixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixServlet() {
        super();
    }
    
    public void init() {
    		ServletConfig myConfig = getServletConfig();
    		ServletUtils.setAbsolutePath(myConfig);
    		DataSource.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Film> foundFilms = DataSource.findFilmByTitle(request.getParameter("film_title"));
		
		request.setAttribute("detailServlet",  
				  "http://localhost:8080/CyberFlixOne/CyberFlixMovieDetailServlet");
				 
		// pass the list of films that matched the search query
		request.setAttribute("films", foundFilms);
		 
		// forward this request to the following jsp page
		request.getRequestDispatcher("moviesearchresults.jsp").
			forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
