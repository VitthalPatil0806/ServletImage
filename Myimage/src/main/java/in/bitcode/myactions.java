package in.bitcode;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Servlet implementation class myactions
 */
public class myactions extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public myactions() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        String imagePath = "D:\\img.jpg";

        // creating obj of file
        File imageFile = new File(imagePath);

        if(!imageFile.exists()) {
            return;
        }
        if(!imageFile.canRead()) {
            return;
        }
        if(!imageFile.isFile()) {
            return;
        }

        // set the content type
        response.setContentType("image/jpeg");

        // create 
        try (FileInputStream fin = new FileInputStream(imagePath);
             OutputStream fout = response.getOutputStream()) {

            byte[] data = new byte[1024 * 16];
            int imagech;

            while((imagech = fin.read(data)) != -1) {
                fout.write(data, 0, imagech);
            }

            fout.flush();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
