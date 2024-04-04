package sample.sp24.t4s2.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import sample.sp24.t4s2.utils.DBUtils;

public class ProductDAO {

    private static final String CHECK_QUANTITY = "SELECT productID FROM tblProduct WHERE productID = ? AND quantity >= ?";
    private static final String UPDATE_QUANTITY = "UPDATE tblProduct SET quantity = quantity - ?  WHERE productID = ?";
    private static final String INSERT_ORDER = "INSERT INTO tblOrder (orderDate, total, userID) VALUES (?, ?, ?)";
    private static final String INSERT_ORDERDETAIL = "INSERT INTO tblOrderDetail(price, quantity, orderID, productID) VALUES(?,?,?,?)";
    private static final String GET_ORDER_NUMBER = "SELECT TOP 1 orderID FROM tblOrder ORDER BY orderID DESC";
    private static final String LIST_ALL_PRODUCT = "SELECT productID,productName, image, price, quantity, memory, categoryID, status FROM tblProduct WHERE status = 1";
    private static final String SEARCH_PRODUCT = "SELECT productID,productName, image, price, quantity, memory, categoryID, status FROM tblProduct WHERE productName LIKE ?";
    private static final String UPDATE_PRODUCT = "UPDATE tblProduct SET productName=?, image=?,price=?, quantity=?, memory=?,categoryID=?,status=? WHERE productID = ?";
    private static final String INSERT_PRODUCT = "INSERT tblProduct(productName, image, price, quantity, memory, categoryID, status) VALUES (?,?,?,?,?,?,?)";
    private static final String DELETE_PRODUCT = "DELETE FROM tblProduct WHERE productID = ?";
    private static final String DELETE_PRODUCT_SECOND = "UPDATE tblProduct SET status= 0 WHERE productID = ?";
    private static final String SEARCH_PRODUCT_BY_CATEGORY = "SELECT productID,productName, image, price, quantity, memory, categoryID, status FROM tblProduct WHERE categoryID IN (SELECT categoryID FROM tblCategory where categoryName like ?)";
    private static final String LIST_ALL_CATEGORY = "SELECT categoryName FROM tblCategory";
    private static final String BEST_SELLER = "SELECT top 5 P.productID, P.productName, P.image, P.price, P.quantity, P.memory, P.status, P.categoryID, C.categoryName, COUNT(OD.productID) AS sold FROM tblProduct AS P JOIN tblCategory AS C ON P.categoryID = C.categoryID LEFT JOIN tblOrderDetail AS OD ON P.productID = OD.productID GROUP BY P.productID, P.status, P.productName, P.image, P.price, P.quantity, P.memory, P.categoryID, C.categoryName ORDER BY sold DESC";
    private static final String ALMOST_OVER_PRODUCTS = "SELECT productID,productName, image, price, quantity, memory, categoryID, status FROM tblProduct WHERE quantity < 5";
    private static final String GET_PRODUCTS_IN_RANGE = "SELECT P.productID, P.productName, P.image, P.price, P.quantity, P.memory, P.categoryID, C.categoryName, P.status FROM tblProduct AS P JOIN tblCategory AS C ON P.categoryID = C.categoryID WHERE P.price BETWEEN ? AND ?";

    public boolean checkQuantity(int id, int quantity) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_QUANTITY);
                ptm.setInt(1, id);
                ptm.setInt(2, quantity);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
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

        return check;
    }

    public boolean createOrder(double total, String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_ORDER);
                ptm.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                ptm.setDouble(2, total);
                ptm.setString(3, userID);
                check = ptm.executeUpdate() > 0;

            }
        } catch (ClassNotFoundException | SQLException e) {
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

    public boolean createOrderDetail(double price, int quantity, int newOrderID, int id) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_ORDERDETAIL);
                ptm.setDouble(1, price);
                ptm.setInt(2, quantity);
                ptm.setInt(3, newOrderID);
                ptm.setInt(4, id);
                check = ptm.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
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

    public boolean updateQuantity(ProductDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_QUANTITY);
                ptm.setInt(1, product.getQuantity());
                ptm.setInt(2, product.getProductID());
                check = ptm.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
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

    public int getNewOrderID() throws SQLException {
        int result = 0;

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ORDER_NUMBER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    result = orderID;
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

    public List<ProductDTO> getAllProduct() throws SQLException {
        List<ProductDTO> listAllProducts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_ALL_PRODUCT);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int memory = rs.getInt("memory");
                    int status = rs.getInt("status");
                    ProductDTO product = new ProductDTO(productID, productName, image, price, quantity, memory, memory, status);
                    listAllProducts.add(product);
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
        return listAllProducts;
    }

    public List<ProductDTO> getListProductByName(String search) throws SQLException {
        List<ProductDTO> listAllProducts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_PRODUCT);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int memory = rs.getInt("memory");
                    int categoryID = rs.getInt("categoryID");
                    int status = rs.getInt("status");
                    ProductDTO product = new ProductDTO(productID, productName, image, price, quantity, memory, categoryID, status);
                    listAllProducts.add(product);
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
        return listAllProducts;
    }

    public boolean updateProduct(ProductDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_PRODUCT);
                ptm.setString(1, product.getProductName());
                ptm.setString(2, product.getImage());
                ptm.setDouble(3, product.getPrice());
                ptm.setInt(4, product.getQuantity());
                ptm.setInt(5, product.getMemory());
                ptm.setInt(6, product.getCategory());
                ptm.setInt(7, product.getStatus());
                ptm.setInt(8, product.getProductID());
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

    public boolean insert(ProductDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_PRODUCT);
                ptm.setString(1, product.getProductName());
                ptm.setString(2, product.getImage());
                ptm.setDouble(3, product.getPrice());
                ptm.setInt(4, product.getQuantity());
                ptm.setInt(5, product.getMemory());
                ptm.setInt(6, product.getCategory());
                ptm.setInt(7, product.getStatus());
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

    public boolean deleteProduct(String productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_PRODUCT);
                ptm.setString(1, productID);
                check = ptm.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            if(e.toString().contains("REFERENCE constraint")) {
                PreparedStatement ptm2 = null;
                ptm2 = conn.prepareStatement(DELETE_PRODUCT_SECOND);
                ptm2.setString(1, productID);
                check = ptm2.executeUpdate() > 0;
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

    public List<ProductDTO> getListProductByCategory(String category) throws SQLException {
        List<ProductDTO> listAllProducts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_PRODUCT_BY_CATEGORY);
                ptm.setString(1, "%" + category + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int memory = rs.getInt("memory");
                    int categoryID = rs.getInt("categoryID");
                    int status = rs.getInt("status");
                    ProductDTO product = new ProductDTO(productID, productName, image, price, quantity, memory, categoryID, status);
                    listAllProducts.add(product);
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
        return listAllProducts;
    }

    public List<String> getCategory() throws SQLException {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_ALL_CATEGORY);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String category = rs.getString("categoryName");
                    list.add(category);
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
        return list;
    }

    public List<ProductDTO> getBestSeller() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(BEST_SELLER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int memory = rs.getInt("memory");
                    int categoryID = rs.getInt("categoryID");
                    int status = rs.getInt("status");
                    String categoryName = rs.getString("categoryName");
                    int sold = rs.getInt("sold");
                    ProductDTO product = new ProductDTO(productID, productName, image, price, quantity, memory, categoryID, status, categoryName, sold);
                    list.add(product);
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
        return list;
    }

    public List<ProductDTO> getAlmostOverProducts() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ALMOST_OVER_PRODUCTS);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int memory = rs.getInt("memory");
                    int categoryID = rs.getInt("categoryID");
                    int status = rs.getInt("status");
                    ProductDTO product = new ProductDTO(productID, productName, image, price, quantity, memory, categoryID, status);
                    list.add(product);
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
        return list;
    }

    public List<ProductDTO> getProductInRange(String priceStart, String priceEnd) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRODUCTS_IN_RANGE);
                ptm.setString(1, priceStart);
                ptm.setString(2, priceEnd);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int memory = rs.getInt("memory");
                    int categoryID = rs.getInt("categoryID");
                    int status = rs.getInt("status");
                    String categoryName = rs.getString("categoryName");
                    ProductDTO product = new ProductDTO(productID, productName, image, price, quantity, memory, categoryID, status, categoryName);
                    list.add(product);
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
        return list;
    }
}
