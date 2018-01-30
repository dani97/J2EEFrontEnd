package io.ztech.music.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.ztech.music.beans.ArtistProfilesBean;
import io.ztech.music.delegates.ArtistProfilesDelegate;

/**
 * Servlet implementation class ArtistProfiles
 */
@WebServlet("/ArtistProfiles")
public class ArtistProfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistProfiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArtistProfilesDelegate delegate = new ArtistProfilesDelegate();
		ArrayList<ArtistProfilesBean> artists = delegate.getAllArtistProfiles();
		request.setAttribute("artists", artists);
		RequestDispatcher rd = request.getRequestDispatcher("artistList.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
