/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import FrameTools.MsgBox;
import encrypt.AES;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import utils.XFile;

/**
 *
 * @author ndhlt
 */
public final class XJdbc {

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection con = null;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void openSavedConnection() {
        try {
            String key = "0BWEzKfw5ZRlhlT5zHjBdwOYdttJgttA";
            Path path = Paths.get("lastConnection.ser");

            // Cài đặt file thành hidden
            Files.setAttribute(path, "dos:hidden", false);
            HashMap<String, String> saved = XFile.readObject("lastConnection.ser");
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(AES.decryptPassword(saved.get("url"), key), AES.decryptPassword(saved.get("username"), key), AES.decryptPassword(saved.get("password"), key));
            }
            Files.setAttribute(path, "dos:hidden", true);
        } catch (SQLException | IOException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            MsgBox.alert(null, ex.getMessage());
            new LocalSqlServer().setVisible(true);
            Logger.getLogger(XJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void openConnection(String Url, String username, String password) throws ClassNotFoundException, SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(Url, username, password);
        }
    }

    public static void closeConnection() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public static final Object select(String sql, Object... args) throws SQLException, ClassNotFoundException {
        ResultSet rs;
        Object packedRs;
        if (args.length > 0) {
            PreparedStatement pst = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pst.setObject(i + 1, args[i]);
            }
            rs = pst.executeQuery();
        } else {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
        }
        packedRs = rs;
        return packedRs;
    }

    public static final Object getValue(String sql, Object... args) throws SQLException, ClassNotFoundException {
        ResultSet rs = (ResultSet) select(sql, args);
        return rs.getObject(1);
    }

    public static final int IUD(String sql, Object... args) throws SQLException, ClassNotFoundException {
        int result;
        if (args.length > 0) {
            try (PreparedStatement prst = con.prepareStatement(sql)) {
                for (int i = 0; i < args.length; i++) {
                    prst.setObject(i + 1, args[i]);
                }
                result = prst.executeUpdate();
            }
        } else {
            try (Statement st = con.createStatement()) {
                result = st.executeUpdate(sql);
            }
        }
        return result;
    }

    public static final Object callNoOutput(String sql, Object... args) throws SQLException, ClassNotFoundException {
        boolean result;
        CallableStatement cst = con.prepareCall(sql);
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                cst.setObject(i + 1, args[i]);
            }
        }
        result = cst.execute();
        Object packedRs = cst.getResultSet();
        Integer updateCount = cst.getUpdateCount();
        return result ? packedRs : updateCount;
    }

    public static final Object callWithOutput(String sql, Object[] args, int output, SQLType sqlType) throws SQLException, ClassNotFoundException {
        boolean result;
        CallableStatement cst = con.prepareCall(sql);
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                cst.setObject(i + 1, args[i]);
            }
            cst.registerOutParameter(output, sqlType);
        }
        result = cst.execute();
        Object packedRs = cst.getResultSet();
        Integer updateCount = cst.getUpdateCount();
        return result ? packedRs : updateCount;
    }
}
