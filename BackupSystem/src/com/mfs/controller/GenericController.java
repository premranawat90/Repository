package com.mfs.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

/**************************************************
 * Authore            : Prem Singh Ranawat
 * Organization       : OwnTask
 * Description        : GenericController.java  
 * User 			     : Lenovo
 * File Creation Date : 13-Jul-2017 :3:04:19 pm
 ***************************************************/

public class GenericController {

	public static void main(String[] args) 
	{
		File currentDir = new File("D:\\Old Laptop Data\\family bank backup\\07022017\\mfmbsnew"); // current directory
		//displayDirectoryContents(currentDir);
		
		
		//System.out.println(displayDirectoryFilePath(currentDir));
//		/printFiles(currentDir);
		System.out.println(" "+getData("C:\\apache-tomcat-7.0.77-windows-x64\\apache-tomcat-7.0.77\\webapps\\mfmbsold\\admincorpar.jsp"));
	}


	File currentDir = new File("D:\\Old Laptop Data\\family bank backup\\07022017\\mfmbsnew"); // current directory
	
	public   static void displayDirectoryContents(File dir) 
	{
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) 
				{
					System.out.println("Folder :" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					stackdata.add(  file.getAbsolutePath() ); //getCanonicalPath
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void listDirectory(String dirPath, int level)
	{
	    File dir = new File(dirPath);
	    File[] firstLevelFiles = dir.listFiles();
	    if (firstLevelFiles != null && firstLevelFiles.length > 0) {
	        for (File aFile : firstLevelFiles) {
	            for (int i = 0; i < level; i++) {
	                System.out.print("\t");
	            }
	            if (aFile.isDirectory()) {
	                System.out.println("[" + aFile.getName() + "]");
	                listDirectory(aFile.getAbsolutePath(), level + 1);
	            } else {
	                System.out.println(aFile.getName());
	            }
	        }
	    }
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
	static  TreeSet  stackdata = new TreeSet();
	public static void  printFiles(File dir) 
	{
		 Stack<File> stack = new Stack<File>();
			  stack.push(dir);
			  while(!stack.isEmpty()) {
			    File child = stack.pop();
			    if (child.isDirectory()) {
			      for(File f : child.listFiles()) stack.push(f);
			    } else if (child.isFile()) 
			    {
			    	stackdata.add(child.getPath());
			    }
			  } 
	}
	
	public static  TreeSet getData()
	{
		File currentDir = new File("D:\\Old Laptop Data\\family bank backup\\07022017\\mfmbsnew"); // current directory
					//	 printFiles(currentDir);
						displayDirectoryContents(currentDir);
		return stackdata; 
	}
	
	public static  TreeSet getData(String path)
	{
		
		String pathFolder=path.substring(0,path.lastIndexOf("\\"));
		File currentDir = new File(pathFolder); // current directory
					//	 printFiles(currentDir);
						displayDirectoryContents(currentDir);
		return stackdata; 
	}
	
	
	
}
