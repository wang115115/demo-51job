package org.java1928.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java1928.service.JobService;

import com.alibaba.fastjson.JSON;

/** 
 * 	职位信息控制器
 */
@WebServlet("/job")
public class JobController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "init":
			init(request, response);
			break;
		}
	}

	// 通过爬虫初始化数据
	private void init(HttpServletRequest request, HttpServletResponse response) {
		
		JobService jobService = new JobService();
		
		String startPage = request.getParameter("startPage");
		String endPage = request.getParameter("endPage");
		
		Long counts = jobService.init(Integer.valueOf(startPage), Integer.valueOf(endPage));
		
		HashMap<Object, Object> jsonObj = new HashMap<>();
		jsonObj.put("counts", counts);
		
		String json = JSON.toJSONString(jsonObj);
		System.err.println(json);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
