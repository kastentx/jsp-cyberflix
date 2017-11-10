package edu.txstate.cs3320.kasten;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.internet.cyberflix.data.DataSource;
import edu.txstate.internet.cyberflix.data.film.Film;

/**
 * Servlet implementation class CyberFlixMovieDetailServlet
 */
@WebServlet("/CyberFlixMovieDetailServlet")
public class CyberFlixMovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixMovieDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filmTitle = request.getParameter("film_title");
		String filmCover = request.getParameter("cover_image");
		Film myFilm = DataSource.findFilmByTitle(filmTitle).get(0);
			
		// pass the correct film object to the detail view
		request.setAttribute("film", myFilm);
		
		// display the correct cover in the detail view
		request.setAttribute("cover", filmCover);
				 
		// forward this request to the following jsp page
		request.getRequestDispatcher("moviedetailpage.jsp").
			forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
