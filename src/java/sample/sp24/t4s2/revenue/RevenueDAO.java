package sample.sp24.t4s2.revenue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.sp24.t4s2.utils.DBUtils;

public class RevenueDAO {

    private static final String GET_REVENUE_BY_DATE = "SELECT orderDate, SUM(total) AS TotalRevenue FROM tblOrder WHERE orderDate = ? GROUP BY orderDate";
    private static final String GET_REVENUE_BY_MONTH = "SELECT YEAR(orderDate) AS Year, MONTH(orderDate) AS Month, SUM(total) AS TotalRevenue FROM tblOrder WHERE YEAR(orderDate) = ? AND MONTH(orderDate) = ? GROUP BY YEAR(orderDate), MONTH(orderDate)";
    private static final String GET_REVENUE_BY_YEAR = "SELECT YEAR(orderDate) AS Year, SUM(total) AS TotalRevenue FROM tblOrder WHERE YEAR(orderDate) = ? GROUP BY YEAR(orderDate)";
    private static final String GET_REVENUE_IN_RANGE = "SELECT SUM(TotalRevenue) AS TotalSum FROM (SELECT SUM(total) AS TotalRevenue FROM tblOrder WHERE orderDate BETWEEN ? AND ? GROUP BY orderDate) AS SubQueryResult";
    private static final String GET_REVENUE_DAILY = "SELECT orderDate, SUM(total) AS TotalRevenue FROM tblOrder GROUP BY orderDate ORDER BY orderDate";
    private static final String GET_REVENUE_MONTHLY = "SELECT YEAR(orderDate) AS Year, MONTH(orderDate) AS Month, SUM(total) AS TotalRevenue FROM tblOrder GROUP BY YEAR(orderDate), MONTH(orderDate) ORDER BY Year, Month";
    private static final String GET_REVENUE_YEARLY = "SELECT YEAR(orderDate) AS Year, SUM(total) AS TotalRevenue FROM tblOrder GROUP BY YEAR(orderDate) ORDER BY Year";

    public double getRevenueByDay(Date date) throws SQLException {
        double result = 0;

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_REVENUE_BY_DATE);
                ptm.setDate(1, date);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    result = rs.getDouble("TotalRevenue");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return result;
    }

    public double getRevenueByMonth(String year, String month) throws SQLException {
        double result = 0;

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_REVENUE_BY_MONTH);
                ptm.setString(1, year);
                ptm.setString(2, month);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    result = rs.getDouble("TotalRevenue");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return result;
    }

    public double getRevenueByYear(String year) throws SQLException {
        double result = 0;

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_REVENUE_BY_YEAR);
                ptm.setString(1, year);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    result = rs.getDouble("TotalRevenue");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return result;
    }

    public double getRevenueInRange(String dateStart, String dateEnd) throws SQLException {
        double result = 0;

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_REVENUE_IN_RANGE);
                ptm.setString(1, dateStart);
                ptm.setString(2, dateEnd);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    result = rs.getDouble("TotalSum");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return result;
    }

    public List<RevenueDTO> getRevenueReportDaily() throws SQLException {
        List<RevenueDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_REVENUE_DAILY);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String orderDate = rs.getString("orderDate");
                    double revenue = rs.getDouble("totalRevenue");
                    RevenueDTO newRevenue = new RevenueDTO(orderDate, revenue);
                    list.add(newRevenue);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<RevenueDTO> getRevenueReportMonthly() throws SQLException {
        List<RevenueDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_REVENUE_MONTHLY);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new RevenueDTO(rs.getString("month") + "/" + rs.getString("year"), rs.getDouble("totalRevenue")));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<RevenueDTO> getRevenueReportYearly() throws SQLException {
        List<RevenueDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_REVENUE_YEARLY);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new RevenueDTO(rs.getString("year"), rs.getDouble("totalRevenue")));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

}
