package lk.sankalpa.Util;

import lk.sankalpa.connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {

    public static <T>T execute(String sql, Object... args) {
        PreparedStatement pstm = null;
        try {
            pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            pstm.setObject((i+1), args[i]);
        }
        if(sql.startsWith("SELECT") || sql.startsWith("select")) {
            return (T)pstm.executeQuery();
        }
        } catch (SQLException e) {
        }
        try {
            return (T)((Boolean)(pstm.executeUpdate() > 0));   // convert boolean to Boolean(Boxing type)
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
