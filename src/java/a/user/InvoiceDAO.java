package a.user;

import a.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {

    private static final String SEARCH = "SELECT userID, proID, quantity, price, phone, time from Invoice where userID like ? Order by time desc";
    private static final String INSERT = "INSERT INTO Invoice(userID, proID, quantity, price, phone, time) VALUES(?,?,?,?,?,?)";

    public boolean insert(String userID, String proID, int quantity, float price, String phone, String time) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, userID);
                ptm.setString(2, proID);
                ptm.setInt(3, quantity);
                ptm.setFloat(4, price);
                ptm.setString(5, phone);
                ptm.setString(6, time);
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

    public List<InvoiceDTO> getListInvoice(String search) throws SQLException {
        List<InvoiceDTO> list = new ArrayList<>();
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
                    String proID = rs.getString("proID");
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    float price = Float.parseFloat(rs.getString("price"));
                    String phone = rs.getString("phone");
                    String time = rs.getString("time");
                    list.add(new InvoiceDTO(proID, userID, quantity, price, phone, time));
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
