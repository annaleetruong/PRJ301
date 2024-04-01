package a.product;

import a.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private static final String LOAD = "Select proID, name, description, price, quantity, srcImg, sale, categoryID from Products";
    private static final String SEARCH = "SELECT proID, name, description, price, quantity, srcImg, sale, categoryID FROM Products where name like ?";
    private static final String GET = "SELECT proID, name, description, price, quantity, srcImg, sale, categoryID FROM Products where proID = ?";
    private static final String UPDATE = "UPDATE Products SET name = ?, price = ? , quantity = ?, sale = ? where proID =?";
    private static final String SEARCH_BY_CATEGORY = "Select proID, name, description, price, quantity, srcImg, sale, categoryID from Products Where categoryID = ?";
    private static final String SEARCH_BY_PRICE_TWO_VALUE = "Select proID, name, description, price, quantity, srcImg, sale, categoryID from Products Where price BETWEEN ? AND ?";
    private static final String SEARCH_BY_PRICE = "Select proID, name, description, price, quantity, srcImg, sale, categoryID from Products Where price  > ?";

    public List<ProductDTO> loadAllProduct() throws SQLException {
        List<ProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                stm = conn.createStatement();
                rs = stm.executeQuery(LOAD);
                while (rs.next()) {
                    String proID = rs.getString("proID");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String srcImg = rs.getString("srcImg");
                    boolean sale = rs.getBoolean("sale");
                    String category = rs.getString("categoryID");
                    if (sale) {
                        listProduct.add(new ProductDTO(proID, name, description, price, quantity, srcImg, sale, category));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listProduct;
    }

    public List<ProductDTO> getListProductByUser(String searchProduct) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + searchProduct + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("proID");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String srcImg = rs.getString("srcImg");
                    boolean sale = rs.getBoolean("sale");
                    String category = rs.getString("categoryID");
                    if (sale) {
                        list.add(new ProductDTO(proID, name, description, price, quantity, srcImg, sale, category));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getListProductByAdmin(String searchProduct) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + searchProduct + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("proID");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String srcImg = rs.getString("srcImg");
                    boolean sale = rs.getBoolean("sale");
                    String category = rs.getString("categoryID");
                    list.add(new ProductDTO(proID, name, description, price, quantity, srcImg, sale, category));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return list;
    }

    public ProductDTO getProductByID(String proID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET);
                ptm.setString(1, proID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String srcImg = rs.getString("srcImg");
                    boolean sale = rs.getBoolean("sale");
                    String category = rs.getString("categoryID");
                    return new ProductDTO(proID, name, description, price, quantity, srcImg, sale, category);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return null;
    }

    public boolean update(ProductDTO product) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, product.getName());
                ptm.setFloat(2, product.getPrice());
                ptm.setInt(3, product.getQuantity());
                ptm.setBoolean(4, product.isSale());
                ptm.setString(5, product.getProID());
                return ptm.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public List<ProductDTO> getListProductByCategory(String category) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_BY_CATEGORY);
                ptm.setString(1, category);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("proID");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String srcImg = rs.getString("srcImg");
                    boolean sale = rs.getBoolean("sale");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(proID, name, description, price, quantity, srcImg, sale, categoryID));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getListProductByPrice(double min, double max) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_BY_PRICE_TWO_VALUE);
                ptm.setDouble(1, min);
                ptm.setDouble(2, max);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("proID");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String srcImg = rs.getString("srcImg");
                    boolean sale = rs.getBoolean("sale");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(proID, name, description, price, quantity, srcImg, sale, categoryID));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getListProductByPrice(double search) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_BY_PRICE);
                ptm.setDouble(1, search);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proID = rs.getString("proID");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String srcImg = rs.getString("srcImg");
                    boolean sale = rs.getBoolean("sale");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(proID, name, description, price, quantity, srcImg, sale, categoryID));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return list;
    }
}
