package edu.txstate.cs3320.kasten;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.internet.cyberflix.data.DataSource;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.utils.HTMLTags;

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
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String filmTitle = request.getParameter("film_title");
		Film myFilm = DataSource.findFilmByTitle(filmTitle).get(0);
		
		//out.append("detail page for " + myFilm.getTitle());
		
		// pass the list of films that matched the search query
		request.setAttribute("film", myFilm);
				 
				// forward this request to the following jsp page
		request.getRequestDispatcher("moviedetailpage.jsp").
			forward(request,  response);
		/*
		out.append(HTMLTags.HTML_HEADER_START)
		   .append(HTMLTags.TITLE_START + filmTitle + HTMLTags.TITLE_END)
		   .append(HTMLTags.HTML_HEADER_END + HTMLTags.BODY_START);

		// FILM NAME
		out.append(HTMLTags.H1_START)
		   .append(myFilm.getTitle())
		   .append(HTMLTags.H1_END);
		// RELEASE YEAR
		out.append(HTMLTags.BOLD_START + "Released: " + HTMLTags.BOLD_END)
		   .append(myFilm.getReleaseYear())
		   .append(HTMLTags.LINE_BREAK);
		// RUNNING TIME
		out.append(HTMLTags.BOLD_START + "Running Time: " + HTMLTags.BOLD_END)
		   .append(new Integer(myFilm.getLength()).toString() + " minutes")
		   .append(HTMLTags.LINE_BREAK);
		// RATING
		out.append(HTMLTags.BOLD_START + "Rating: " + HTMLTags.BOLD_END)
		   .append(myFilm.getRating().toString())
		   .append(HTMLTags.LINE_BREAK);
		// DESCRIPTION
		out.append(HTMLTags.LINE_BREAK + myFilm.getDescription())
		   .append(HTMLTags.BODY_END + HTMLTags.HTML_END);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
