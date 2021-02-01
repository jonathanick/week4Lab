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
        
        
        if(edit==null){
              getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
              .forward(request,response);
               String path = getServletContext().getRealPath("/WEB-INF/note.txt");
               BufferedReader br = new BufferedReader(new FileReader(new File(path)));
               String text = br.readLine();
               int i=0;
               while(text != null) 
                {
                    text = br.readLine();
                    if(i==0)
                    {
                       request.setAttribute("title",text);
                       
                    }
                    else
                    {
                        request.setAttribute("contents",text); 
                    }
                    i++;
                }
              br.close();
            }
        else{
                  getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
              .forward(request,response);
                  if(title.equals("")||title == null||contents.equals("")||contents==null)
                    {
                       request.setAttribute("title",title);
                        request.setAttribute("contents",contents);
                        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                         .forward(request,response);

                        return;
                    }
                   String path = getServletContext().getRealPath("/WEB-INF/note.txt");
                   BufferedReader br = new BufferedReader(new FileReader(new File(path)));
                   String text = br.readLine();
               int i=0;
               while(text != null) 
                {
                    text = br.readLine();
                    if(i==0)
                    {
                       request.setAttribute("title",text);
                       
                    }
                    else
                    {
                        request.setAttribute("contents",text); 
                    }
                    i++;
                }
                  br.close();
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
            pw.println(note.getTitle());
            pw.println(note.getContents());
         pw.close();
                getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
              .forward(request,response);
    }

   
}
