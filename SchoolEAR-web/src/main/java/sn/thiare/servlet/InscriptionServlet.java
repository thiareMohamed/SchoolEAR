package sn.thiare.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.thiare.entities.Courses;
import sn.thiare.entities.Inscription;
import sn.thiare.entities.Student;
import sn.thiare.entities.Year;
import sn.thiare.interfaces.CoursesLocal;
import sn.thiare.interfaces.InscriptionLocal;
import sn.thiare.interfaces.StudentLocal;
import sn.thiare.interfaces.YearLocal;

/**
 * Servlet implementation class InscriptionServlet
 */
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private StudentLocal studentLocal;
	
	@EJB
	private CoursesLocal coursesLocal;
	
	@EJB
	private InscriptionLocal inscriptionLocal;
	
	@EJB
	private YearLocal yearLocal;
	
	private Year result;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println("action" + action);
		if (action != null) {
			switch (action) {
			case "view":
				request = view(request);
				break;
			case "add":
				 request = add(request);
				 break;
			 case "inscription":
				  request = inscriptionForm(request);
				  request.getRequestDispatcher("inscription.jsp").forward(request, response);
				  break;
			  default :
				  break;
			}
		}
		
//		List<Inscription> inscriptions = inscriptionLocal.getAll();
//		request.setAttribute("inscriptions", inscriptions);
		request.getRequestDispatcher("student-detail.jsp").forward(request, response);
	}

	private HttpServletRequest view(HttpServletRequest request) {
		int etudiantId = Integer.parseInt(request.getParameter("id"));
		List<Inscription> inscriptions = inscriptionLocal.getAllByStudentId(etudiantId);
		request.setAttribute("inscriptions", inscriptions);
		
		return request;
	}

	private HttpServletRequest add(HttpServletRequest request) {
		String detail = request.getParameter("details");
		Student student = studentLocal.getStudent(Integer.parseInt(request.getParameter("etudiantId")));
		Courses courses = coursesLocal.getCourses(Integer.parseInt(request.getParameter("coursId")));
		
		Year year = this.getYear();
		
		Inscription inscription = new Inscription();
		inscription.setCourses(courses);
		inscription.setStudent(student);
		inscription.setYear(year);
		inscription.setDetails(detail);
		
		Inscription result = inscriptionLocal.create(inscription);
		request.setAttribute("inscription", inscription);
		
		return request;
	}

	private Year getYear() {
		int currentYear = java.time.Year.now().getValue();
		List<Year> years = yearLocal.getAll();
		
		if (years != null) {
			for(Year item : years) {
				if(item.getName().equals(String.valueOf(currentYear))) {
					return item;
				}
			}
		}
		
		Year newYear = new Year();
		newYear.setName(String.valueOf(currentYear));
		result = yearLocal.create(newYear); 
		
		return result;
	}

	private HttpServletRequest inscriptionForm(HttpServletRequest request) {
		Student student = studentLocal.getStudent(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("etudiant", student);
		List<Courses> courses = coursesLocal.getAll();
		request.setAttribute("cours", courses);
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
