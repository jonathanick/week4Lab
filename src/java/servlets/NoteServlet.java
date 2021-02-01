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
        String edit=request.getAttribute("edit");
        if(edit==null){
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
              .forward(request,response);
            }
        else{
                getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
              .forward(request,response);
            }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title=request.getParameter("title");
        String contents=request.getParameter("contents");
        
         
         if(title.equals("")||title == null||contents.equals("")||contents==null)
         {
            request.setAttribute("title",title);
             request.setAttribute("contents",contents);
             getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
              .forward(request,response);
             
             return;
         }
         
            Note note=new Note(title,contents);
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
            request.setAttribute("note",note);
            pw.write(note.getTitle()+"\n");
            pw.write(note.getContents());
         pw.close();
                getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
              .forward(request,response);
    }

   
}
