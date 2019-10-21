package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import com.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public void testDbConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?" +
                    "user=root&password=");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");

            Groups groups = new Groups();
            while (rs.next()) {
                groups.add(new GroupMap().withGroupId(rs.getInt("group_id"))
                        .withGroupName(rs.getString("group_name"))
                        .withGroupFooter(rs.getString("group_footer"))
                        .withGroupHeader(rs.getString("group_header")));
            }
            rs.close();
            st.close();
            conn.close();

            System.out.println(groups);


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
