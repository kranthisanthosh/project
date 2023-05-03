package Registration.controller;

import java.io.IOException;

import  javax.servlet.RequestDispatcher;
import  javax.servlet.ServletException;
import  javax.servlet.annotation.WebServlet;
import  javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import Registration.Dao.Customerdao;
import Registration.module.Customer;

/**
 * Servlet implementation class Customerservelt
 */
@WebServlet("/Customerservelt")
public class Customerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	System.out.println("hi");
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in cst get method");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerregister.jsp");
		dispatcher.forward(request,response);}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in post");
		 String name = request.getParameter("name");
	        String phno  = request.getParameter("phno");
	        String adress = request.getParameter("adress");
	        String joindate = request.getParameter("joindate");
	        String aadhar = request.getParameter("aadhar");
	       
	        Customer customer = new Customer();
	        customer.setName(name);
	        customer.setPhno(phno);
	        customer.setAdress(adress);
	        customer.setJoindate(joindate);
	        customer.setAadharnum(aadhar);
	        System.out.println(name +phno +adress );

	        try {
	            Customerdao customerdao = new Customerdao();
				customerdao.registerCustomer(customer);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Customerdetails.jsp");
		dispatcher.forward(request,response);
	}
}
		