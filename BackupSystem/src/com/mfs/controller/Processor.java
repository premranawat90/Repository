package com.mfs.controller;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Processor extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Processor() {
        super();
        // TODO Auto-generated constructor stub
    }

	public   static String displayDirectoryFilePath(File dir) 
	{
		
		String data="";
		try {
		
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) 
				{  System.out.println("folder"+file.getCanonicalPath());
						//data ="Folder :" + file.getCanonicalPath();
						displayDirectoryFilePath(file);
						
				} else
				{ System.out.println("FILE"+file.getCanonicalPath());
					data= " File:out" + file.getCanonicalPath();
					
				}
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String filePath=request.getParameter("path");
		TreeSet data=GenericController.getData(filePath);
		
		request.setAttribute("FilePath", filePath);
		request.setAttribute("data", data);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
