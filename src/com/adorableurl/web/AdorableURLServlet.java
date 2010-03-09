package com.adorableurl.web;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adorableurl.model.Url;
import com.adorableurl.util.AdorableConverter;
import com.adorableurl.util.PMF;
import com.google.appengine.api.datastore.Link;

@SuppressWarnings("serial")
public class AdorableURLServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getRequestURI());
		if (req.getRequestURI().equals("/")) {
			getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
			return;
		} else if (req.getRequestURI().equals("/favicon.ico")) {
			resp.setStatus(404);
			return;
		}
		String adorable = req.getRequestURI().substring(1);
		Long id = AdorableConverter.decode(adorable);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Url url = pm.getObjectById(Url.class, id);
			System.out.println("Redirecting to: " + url.getUrl());
			resp.sendRedirect(url.getUrl().toString());
		} finally {
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String u = req.getParameter("u");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = null;
		try {
			query = pm.newQuery(Url.class, "url == :u");
			List<Url> results = (List<Url>) query.execute(new Link(u));
			Url url = null;
			if (results.isEmpty()) {
				url = new Url(u);
				pm.makePersistent(url);
			} else {
				url = results.get(0);
			}
			req.setAttribute("url-code", AdorableConverter.encode(url.getId()));
			getServletConfig().getServletContext().getRequestDispatcher("/created.jsp").forward(req,resp);
		} finally {
			if (query != null) query.closeAll();
			pm.close();
		}
	}

}
