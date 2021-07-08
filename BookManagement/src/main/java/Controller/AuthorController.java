package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Repository.AuthorRepository;

/**
 * Servlet implementation class AuthorController
 */
@WebServlet("/")
public class AuthorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AuthorRepository authorRepository;
       
    /**
     * @see BaseController#AbstractController()
     */
    public AuthorController() {
        super();

        this.authorRepository = new AuthorRepository(
    		Persistence
    			.createEntityManagerFactory("default")
    			.createEntityManager()
        );
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {

			case "/show":
				show(request, response);
				break;

			case "/create":
				create(request, response);
				break;

			case "/edit":
				edit(request, response);
				break;

			default:
				index(request, response);
				break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		
		switch (action) {

			case "/store":
				store(request, response);
				break;
				
			case "/update":
				update(request, response);
				break;

			case "/delete":
				delete(request, response);
				break;

			default:
				index(request, response);
				break;
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute(
			"authors",
			this.authorRepository.all()
		);

		request
			.getRequestDispatcher("views/author/index.jsp")
			.forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute(
			"author",
			this.authorRepository.findOne(
				Integer.parseInt(request.getParameter("id"))
			)
		);
		
		request
			.getRequestDispatcher("views/author/show.jsp")
			.forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request
			.getRequestDispatcher("views/author/create.jsp")
			.forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("firstname", request.getParameter("firstname"));
		data.put("lastname", request.getParameter("lastname"));
		data.put("address", request.getParameter("address"));
		data.put("birthDate", request.getParameter("birthDate"));
		
		this.authorRepository.create(data);
		
		response.sendRedirect("/BookManagement");
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute(
			"author",
			this.authorRepository.findOne(
				Integer.parseInt(request.getParameter("id"))
			)
		);
		
		request
			.getRequestDispatcher("views/author/edit.jsp")
			.forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("firstname", request.getParameter("firstname"));
		data.put("lastname", request.getParameter("lastname"));
		data.put("address", request.getParameter("address"));
		data.put("birthDate", request.getParameter("birthDate"));
		
		this.authorRepository.update(
			this.authorRepository.findOne(
				Integer.parseInt(request.getParameter("id"))
			),
			data
		);
		
		response.sendRedirect("/BookManagement");
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.authorRepository.delete(
			this.authorRepository.findOne(
				Integer.parseInt(request.getParameter("id"))
			)
		);
		
		response.sendRedirect("/BookManagement");
		
	}

}
