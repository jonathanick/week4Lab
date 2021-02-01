/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;


/**
 *
 * @author 828200
 */
public class NoteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String edit=request.getParameter("edit");
        String title=request.getParameter("title");
        String contents=request.getParameter("contents");
        Note note=new Note(title,contents);
        request.setAttribute("note",note);
      
        if(edit==null)
        { 
            
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line=br.readLine();
            note.setTitle(line);
            note.setContents(br.readLine());
            br.close();
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
            .forward(request,response);
        }
        else
        {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line=br.readLine();
            note.setTitle(line);
            note.setContents(br.readLine());
            br.close();
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
            .forward(request,response);
         }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title=request.getParameter("title");
        String contents=request.getParameter("contents");
        Note note=new Note(title,contents);
        request.setAttribute("note",note);
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        pw.println(title);
        pw.println(contents);
        pw.close();
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
            .forward(request,response);
    }

   
}
