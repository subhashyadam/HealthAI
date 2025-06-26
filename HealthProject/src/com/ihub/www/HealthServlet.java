package com.ihub.www;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HealthServlet extends HttpServlet {

    private HealthService healthService = new HealthService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display input form with enhanced style
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>HealthAI - Input</title>");//#f2f2f2
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: red; padding: 20px; }");
        out.println("h2 { color: #003366; text-align: center; font-size: 28px; }");
        out.println("form { background: #ffffff; padding: 30px; border-radius: 10px; width: 600px; margin: auto; box-shadow: 0 0 15px rgba(0,0,0,0.1); font-size: 18px; }");
        out.println("textarea { width: 100%; height: 150px; padding: 12px; font-size: 16px; border: 1px solid #ccc; border-radius: 6px; resize: none; }");
        out.println(".btn-container { text-align: center; margin-top: 20px; }");
        out.println("input[type='submit'] { padding: 12px 24px; background-color: #28a745; color: white; font-size: 18px; border: none; border-radius: 6px; cursor: pointer; }");
        out.println("input[type='submit']:hover { background-color: #218838; }");
        out.println("</style></head><body>");

        out.println("<h2>HealthAI - Symptom Analyzer</h2>");
        out.println("<form method='post' action='analyze'>");
        out.println("<label><strong>Enter your symptoms below:</strong></label><br><br>");
        out.println("<textarea name='symptoms' placeholder='e.g. cold, headache, fever...'></textarea><br>");
        out.println("<div class='btn-container'><input type='submit' value='Predict Disease'></div>");
        out.println("</form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String symptoms = request.getParameter("symptoms");

        String disease = healthService.predictDisease(symptoms);
        String remedy = healthService.getHomeRemedy(disease);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>HealthAI - Result</title>");//#f2f2f2
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: red; padding: 20px; }");
        out.println("div.result { background: #ffffff; width: 600px; margin: auto; padding: 30px; border-radius: 10px; box-shadow: 0 0 15px rgba(0,0,0,0.1); font-size: 18px; }");
        out.println("h2 { color: #0056b3; text-align: center; font-size: 26px; }");
        out.println("p { font-size: 18px; line-height: 1.6; }");
        out.println(".btn-container { text-align: center; margin-top: 25px; }");
        out.println("a.button { padding: 12px 24px; background-color: #007bff; color: white; font-size: 18px; text-decoration: none; border-radius: 6px; display: inline-block; }");
        out.println("a.button:hover { background-color: #0056b3; }");
        out.println("</style></head><body>");

        out.println("<div class='result'>");
        out.println("<h2>Prediction Result</h2>");
        out.println("<p><strong>Symptoms:</strong> " + symptoms + "</p>");
        out.println("<p><strong>Predicted Disease:</strong> " + disease + "</p>");
        out.println("<p><strong>Home Remedy:</strong> " + remedy + "</p>");
        out.println("<div class='btn-container'><a class='button' href='analyze'>Go Back</a></div>");
        out.println("</div></body></html>");
    }
}
