package sample.sp24.t4s2.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sample.sp24.t4s2.utils.DBUtils;

public class UserDAO {

    private static final String LOGIN = "SELECT fullName, roleID, address, DOB, phone, email, status from tblUsers WHERE status = 1 AND userID=? AND password=?";
    private static final String SEARCH = "SELECT userID, fullName, roleID, address, DOB, phone, email, status FROM tblUsers WHERE fullName LIKE ?";
    private static final String DELETE = "DELETE From tblUsers WHERE userID = ?";
    private static final String UPDATE = "UPDATE tblUsers SET fullName = ?, roleID = ?, address = ?, DOB = ?, phone = ?, email = ?, status = ? WHERE userID = ?";
    private static final String INSERT = "INSERT INTO tblUsers(userID, fullName, password, roleID, address, DOB, phone, email, status) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT fullName FROM tblUsers WHERE userID = ?";
    private static final String TOP_CUSTOMER = "SELECT TOP 5 O.userID, U.fullName, U.phone, U.email, U.DOB, U.address, SUM(O.total) AS total_spent FROM tblOrder AS O JOIN tblUsers AS U ON O.userID = U.userID \n"
            + "GROUP BY O.userID, U.fullName, U.phone, U.email, U.DOB, U.address ORDER BY total_spent DESC";
    private static final String RESET_PASSWORD = "UPDATE tblUsers SET password = ? WHERE userID = ?";

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String address = rs.getString("address");
                    Date dob = rs.getDate("dob");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    int status = rs.getInt("status");
                    user = new UserDTO(userID, fullName, "***", roleID, address, dob, phone, email, status);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
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
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> listUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String address = rs.getString("address");
                    Date dob = rs.getDate("dob");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    int status = rs.getInt("status");
                    UserDTO user = new UserDTO(userID, fullName, "***", roleID, address, dob, phone, email, status);
                    listUser.add(user);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
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
        return listUser;
    }

    public boolean deleteUser(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean update(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getFullName());
                ptm.setString(2, user.getRoleID());
                ptm.setString(3, user.getAddress());
                ptm.setDate(4, (java.sql.Date) user.getDob());
                ptm.setString(5, user.getPhone());
                ptm.setString(6, user.getEmail());
                ptm.setInt(7, user.getStatus());
                ptm.setString(8, user.getUserID());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                ptm.close();
            }
        }
        return check;
    }

    public boolean insert(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getPassword());
                ptm.setString(4, user.getRoleID());
                ptm.setString(5, user.getAddress());
                ptm.setDate(6, (java.sql.Date) user.getDob());
                ptm.setString(7, user.getPhone());
                ptm.setString(8, user.getEmail());
                ptm.setInt(9, user.getStatus());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean insertV2(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getPassword());
                ptm.setString(4, user.getRoleID());
                ptm.setString(5, user.getAddress());
                ptm.setDate(6, (java.sql.Date) user.getDob());
                ptm.setString(7, user.getPhone());
                ptm.setString(8, user.getEmail());
                ptm.setInt(9, user.getStatus());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
                ptm.close();
            }
        }
        return check;
    }

    public List<UserDTO> topCustomer() throws SQLException {
        List<UserDTO> listUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(TOP_CUSTOMER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String address = rs.getString("address");
                    Date dob = rs.getDate("dob");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    double spent = rs.getDouble("total_spent");
                    UserDTO user = new UserDTO(userID, fullName, address, dob, phone, email, spent);
                    listUser.add(user);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
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
        return listUser;
    }

    public boolean resetPassword(String username, String newPassword) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(RESET_PASSWORD);
                ptm.setString(1, newPassword);
                ptm.setString(2, username);
                check = ptm.executeUpdate() > 0;
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
                ptm.close();
            }
        }
        return check;
    }
}
