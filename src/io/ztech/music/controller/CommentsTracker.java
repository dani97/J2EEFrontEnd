package io.ztech.music.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.ztech.music.delegates.ArtistProfilesDelegate;
import io.ztech.music.delegates.RecordsDelegate;

/**
 * Servlet implementation class CommentsTracker
 */
@WebServlet("/CommentsTracker")
public class CommentsTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsTracker() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArtistProfilesDelegate artistDel = new ArtistProfilesDelegate();
		RecordsDelegate recordDel = new RecordsDelegate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("GetInsights.jsp");
		request.setAttribute("artists", artistDel.getAllArtistProfiles());
		request.setAttribute("records", recordDel.getAllRecords(request, response));
		dispatcher.forward(request, response);
		
	}

}
