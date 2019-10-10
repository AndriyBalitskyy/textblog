package com.vpodobano.textblog.controller.ajax;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vpodobano.textblog.controller.AbstractController;
import com.vpodobano.textblog.entity.Comment;
import com.vpodobano.textblog.exception.ApplicationException;
import com.vpodobano.textblog.exception.ValidateException;
import com.vpodobano.textblog.form.CommentForm;

@WebServlet("/ajax/comment")
public class NewCommentController extends AbstractController{
	/**
	 * 
	 */
	private static final long serialVersionUID = -367596646483919173L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			CommentForm form = createForm(req, CommentForm.class);
			Comment comment = getBusinessService().createComment(form);
			req.setAttribute("comments", Collections.singleton(comment));
			forwardToFragment("comments.jsp", req, resp);
		} catch (ValidateException e) {
			throw new ApplicationException("Invalid create comment try: " + e.getMessage(), e);
		}
	}
}
