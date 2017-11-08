package edu.txstate.cs3320.kasten;

import java.io.IOException;
import java.io.PrintWriter;
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
import edu.txstate.internet.cyberflix.utils.HTMLTags;

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
				
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
				
		/*
		// this heading displays at the top of the page, regardless of results
		out.append(HTMLTags.HTML_HEADER_START)
		   .append(HTMLTags.TITLE_START + "Search Results" + HTMLTags.TITLE_END)
		   .append(HTMLTags.HTML_HEADER_END + HTMLTags.BODY_START)
		   .append("\n\n<h1>Search Results:</h1>\n");
		if (foundFilms != null) {
			// this list only displays if there were movies found
			out.append(HTMLTags.UNORDERED_LIST_START);
			for (Film aFilm : foundFilms) {
				out.append(HTMLTags.LIST_ITEM_START)
				   .append(HTMLTags.createHTMLLinkToFile("CyberFlixMovieDetailServlet?film_title=" + aFilm.getTitle(), aFilm.getTitle()))
				   .append("<i> (" + aFilm.getReleaseYear() + ") </i>")
				   .append(aFilm.getDescription() + "<br><br>")
				   .append(HTMLTags.LIST_ITEM_END);
			}
			out.append(HTMLTags.UNORDERED_LIST_END);
		} else {
			// this message only displays when no movies are found
			out.append("<h3>No films matching your search criteria..</h3>");
		}
		// this closes out our HTML, regardless of results
		out.append(HTMLTags.BODY_END + HTMLTags.HTML_END);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
