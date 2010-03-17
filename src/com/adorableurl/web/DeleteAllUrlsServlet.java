package com.adorableurl.web;

import java.io.IOException;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adorableurl.model.Url;
import com.adorableurl.util.PMF;

@SuppressWarnings("serial")
public class DeleteAllUrlsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Extent<Url> extent = pm.getExtent(Url.class);
		try {
			for (Url url : extent) {
				pm.deletePersistent(url);
			}
		} finally {
			extent.closeAll();
		}
		resp.getWriter().print("All deleted");
	}

}
