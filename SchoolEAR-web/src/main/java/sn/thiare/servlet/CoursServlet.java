package sn.thiare.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.thiare.entities.Courses;
import sn.thiare.interfaces.CoursesLocal;

/**
 * Servlet implementation class CoursServlet
 */
public class CoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CoursesLocal coursesLocal;

    /**
     * Default constructor. 
     */
    public CoursServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		System.out.println("action" + action);
		request.setAttribute("cours", null);
		if (action != null) {
			switch (action) {
			  
			  case "add":
				  request = addCours(request);
				  break;
			  case "delete":
				  deleteCours(request);
				  break;
			  case "edit":
				  request = editCours(request);
				  break;
			  case "detail":
				  request = detail(request);
			  default :
				  break;
			}
			
		}
		
		List<Courses> courses = coursesLocal.getAll();
		request.setAttribute("cours", courses);
		request.getRequestDispatcher("cours.jsp").forward(request, response);
	}

	private HttpServletRequest detail(HttpServletRequest request) {
		Courses courses = coursesLocal.getCourses(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("course", courses);
		System.out.println("Data" + courses.getName());
		return request;
	}

	private HttpServletRequest editCours(HttpServletRequest request) {
		
		Courses courses = new Courses();
		courses.setId(Integer.parseInt(request.getParameter("id")));
		courses.setName(request.getParameter("name"));
		courses.setProgramme(request.getParameter("programme"));
		
		Courses result = coursesLocal.update(courses.getId(), courses);
		
		if (result != null) {
			String message = "Creation succes";
			request.setAttribute("message", message);
		} else {
			String erreur = "Non enregistrer";
			request.setAttribute("erreur", erreur);
		}
		return request;
	}

	private void deleteCours(HttpServletRequest request) {
		coursesLocal.delete(Integer.parseInt(request.getParameter("id")));
	}

	private HttpServletRequest addCours(HttpServletRequest request) {
		Courses courses = new Courses();
		courses.setName(request.getParameter("name"));
		courses.setProgramme(request.getParameter("programme"));
		
		Courses result = coursesLocal.create(courses);
		
		if (result != null) {
			String message = "Creation succes";
			request.setAttribute("message", message);
		} else {
			String erreur = "Non enregistrer";
			request.setAttribute("erreur", erreur);
		}
		
		return request;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
