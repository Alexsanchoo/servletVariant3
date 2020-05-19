import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet extends HttpServlet {
    //создаем строку, в которой будем искать слово
    private String text = "Advertisers study how people learn so that they can ‘teach’ them to respond to their advertising. They want us to be interested, to try something, and then to do it again. These are the elements of learning: interest, experience and repetition." +
            " If an advert can achieve this, it is successful. If an advert works well, the same technique can be used to advertise different things. So, for example, in winter if the weather is cold and you see a family having a warming cup of tea and feeling cosy, you may " +
            "be interested and note the name of the tea … Here the same technique is being used as with the cool, refreshing drink.";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");/* Устанавливает тип контента ответа, отправляемого клиенту, если ответ еще не фиксировался.*/
        request.setCharacterEncoding("UTF-8"); /* Устанавливает кодировку символов (набор символов MIME) ответа, отправляемого клиенту, например, UTF-8.*/
        PrintWriter out = response.getWriter();/*Возвращает в PrintWriter объект, который может отправить символьный текст клиенту.*/
        String symbols = request.getParameter("Symbol");/* возвращает значение параметров в форматеString */

        String result;
        if(symbols.length() == 1) {
            result = text;
            char[] resultChar = result.toCharArray();
            char symbolChange = symbols .charAt(0);
            for (int i = 2; i < resultChar.length; i += 3) {
                resultChar[i] = symbolChange;
            }
            result = new String(resultChar);
        }
        else {
            result = "Error! You need to enter one character.";
        }

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Text Redactor Server</title>");
            out.println("</head>");
            out.println("<h1 align='center'><font face = 'Calibri'><b>The result:</b></font><br></h1>");
            out.println("<body>");
            out.println("<center>" + result +"</center><br></br>");
            out.println("<a href = \"http://localhost:8080\">Click here to see main page</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("text", text);
        processRequest(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("text", text);
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

