package sn.thiare.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.thiare.entities.Student;
import sn.thiare.interfaces.StudentLocal;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private StudentLocal studentLocal;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println("action" + action);
		request.setAttribute("etudiant", null);
		if (action != null) {
			switch (action) {
			  
			  case "add":
				  request = addStudent(request);
				  break;
			  case "delete":
				  deleteStudent(request);
				  break;
			  case "edit":
				  request = editStudent(request);
				  break;
			  case "detail":
				  request = detail(request);
			  default :
				  break;
			}
			
		}
		
		List<Student> students = studentLocal.getAll();
		request.setAttribute("etudiants", students);
		request.getRequestDispatcher("student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	private HttpServletRequest detail(HttpServletRequest request) {
		Student student = studentLocal.getStudent(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("etudent", student);
		System.out.println("Data" + student.getId());
		return request;
	}

	private HttpServletRequest editStudent(HttpServletRequest request) {
		
		Student student = new Student();
		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		try {
			student.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthdate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		student.setPhone(request.getParameter("phone"));
		
		Student result = studentLocal.update(student.getId(), student);
		
		if (result != null) {
			String message = "Creation succes";
			request.setAttribute("message", message);
		} else {
			String erreur = "Non enregistrer";
			request.setAttribute("erreur", erreur);
		}
		return request;
	}

	private void deleteStudent(HttpServletRequest request) {
		studentLocal.delete(Integer.parseInt(request.getParameter("id")));
	}

	private HttpServletRequest addStudent(HttpServletRequest request) {
		Student student = new Student();
		
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		String date = request.getParameter("birthdate");
		try {
			
			Date dateTime = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			student.setBirthdate(dateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		student.setPhone(request.getParameter("phone"));
		
		Student result = studentLocal.create(student);
		
		if (result != null) {
			String message = "Creation succes";
			request.setAttribute("message", message);
		} else {
			String erreur = "Non enregistrer";
			request.setAttribute("erreur", erreur);
		}
		
		return request;
	}

}
