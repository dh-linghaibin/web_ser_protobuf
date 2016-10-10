package com.imooc.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pbmsg.UserProto.User;
import pbmsg.UserProto.User.Builder;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InputStream inputstream = request.getInputStream();
		byte len[] = new byte[1024];
		int count = inputstream.read(len);
		byte[] temp = new byte[count];
		for (int i = 0; i < count; i++) {
			temp[i] = len[i];
		}
		User user = User.parseFrom(temp);
		System.out.println(user.getID());
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		
		//User uproto = User.newBuilder().setID(88888888)
				//.setPassword("654321").setUserName("zwq").build();
		///byte[] content = uproto.toByteArray();
		
		//PrintWriter out = response.getWriter();
		///out.println("1234");
		//String name = request.getParameter("name");
		//String age = request.getParameter("age");
		
		User uproto = User.newBuilder().setID(1234)
				.setPassword("654321").setUserName("·þÎñÆ÷").build();
		byte[] content = uproto.toByteArray();
		//String haha = Arrays.toString(uproto.toByteArray());
		OutputStream out = response.getOutputStream();
		//out.println(content);
		//uproto.writeTo(response.getOutputStream());
		//String haha = uproto.toString();
		//out.write(uproto.toString());
		out.write(content);
		
		//User user = User.parseFrom(content);
		//System.out.println(user.getID());
		//System.out.println(user.getUserName());
		//System.out.println(user.getPassword());
		//PrintWriter out = response.getWriter();
		//out.println("sdfsdf");
		//System.out.println("675756");
	}

}
