package com.inventine.controller.dashboard.financeAdmin;

import com.inventine.dao.*;
import com.inventine.model.*;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FinanceAdminServlet", value = "/dashboard/financeAdmin")
public class FinanceAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        UserDaoImplementation userDao = new UserDaoImplementation();
        PayoutDaoImplementation payoutDao = new PayoutDaoImplementation();
        PaymentDaoImplementation paymentDao = new PaymentDaoImplementation();
        RefundDaoImplementation refundDao = new RefundDaoImplementation();
        InvestorDaoImplementation investorDao = new InvestorDaoImplementation();

        String topic= "User Dashboard";
        String condition;
        request.setAttribute("Dashboard",topic);

        request.setAttribute("payment",paymentDao.getCountAmount(""));
        request.setAttribute("payouts", payoutDao.getCountAmount(""));
        request.setAttribute("refunds", refundDao.getCount(""));
        request.setAttribute("Investors", investorDao.getCount(""));


        List<Payment> payments = paymentDao.getPayments("");

        request.setAttribute("payments",payments);
        request.getRequestDispatcher("/WEB-INF/dashboard/financeAdmin/financeAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
