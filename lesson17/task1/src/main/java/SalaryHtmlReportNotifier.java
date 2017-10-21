/**
 * Created by User on 21.10.2017.
 */

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SalaryHtmlReportNotifier {

    private Connection connection;


    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }

    public boolean sendHtmlSalaryReport(StringBuilder resultingHtml, String recipients) {
        try {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("mail.google.com");
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(recipients);
            helper.setText(resultingHtml.toString(), true);
            helper.setSubject("Monthly department salary report");
            mailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ResultSet getFromSql(String departmentId, LocalDate dateFrom, LocalDate dateTo) {
        ResultSet results = null;
        try {  // prepare statement with sql
            PreparedStatement ps = connection.prepareStatement("select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary from employee emp left join" +
                    "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
                    " sp.date >= ? and sp.date <= ? group by emp.id, emp.name");
            // inject parameters to sql
            ps.setString(0, departmentId);
            ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
            ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));
            // execute query and get the results
            results = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public StringBuilder generateReport(ResultSet results) throws SQLException {

        // create a StringBuilder holding a resulting html
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        while (results.next()) {
            // process each row of query results
            resultingHtml.append("<tr>"); // add row start tag
            resultingHtml.append("<td>").append(results.getString("emp_name")).append("</td>"); // appending employee name
            resultingHtml.append("<td>").append(results.getDouble("salary")).append("</td>"); // appending employee salary for period
            resultingHtml.append("</tr>"); // add row end tag
            totals += results.getDouble("salary"); // add salary to totals
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");

        return resultingHtml;

    }

    public void startAll(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) throws SQLException {
        ResultSet resultSet = getFromSql(departmentId, dateFrom, dateTo);
        StringBuilder report = generateReport(resultSet);
        sendHtmlSalaryReport(report, recipients);
    }
}
