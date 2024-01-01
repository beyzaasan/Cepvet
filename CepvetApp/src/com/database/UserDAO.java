package com.database;

import com.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
   public UserDAO() {
   }

   public boolean isValidUser(User user) {
      String sql = "select user_id, password from user where user_id = ? and password = ?";

      try {
         Connection conn = DBConnectionManager.getConnection();
         Throwable var4 = null;

         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getId());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();

            do {
               if (rs == null || !rs.next()) {
                  return false;
               }
            } while(!rs.getString(1).equals(user.getId()) || !rs.getString(2).equals(user.getPassword()));

            boolean var7 = true;
            return var7;
         } catch (Throwable var18) {
            var4 = var18;
            throw var18;
         } finally {
            if (conn != null) {
               if (var4 != null) {
                  try {
                     conn.close();
                  } catch (Throwable var17) {
                     var4.addSuppressed(var17);
                  }
               } else {
                  conn.close();
               }
            }

         }
      } catch (SQLException var20) {
         Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, (String)null, var20);
         return false;
      }
   }
}

