import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Main {

    private static Connection connection;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Please refresh DB minions_db");
        connection = connectionToMySQL();
        System.out.println("Enter the problem number:");

        switch (reader.readLine()) {
            case "2" -> problemTwo();
            case "3" -> problemThree();
            case "4" -> problemFour();
            case "5" -> problemFive();
            case "7" -> problemSeven();
            case "8" -> problemEight();
            case "9" -> problemNine();
        }
    }

    private static void problemNine() throws IOException, SQLException {
        System.out.println("Enter minion ID:");
        int minionId = Integer.parseInt(reader.readLine());
/*
DELIMITER $$
CREATE PROCEDURE usp_get_older(minion_id INT)
BEGIN
    UPDATE `minions`
        SET `age` = `age` + 1
    WHERE `id` = minion_id;

end $$
DELIMITER ;
 */
        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1, minionId);
        callableStatement.executeUpdate();

        PreparedStatement preparedStatement = connection.
                prepareStatement("SELECT name, age FROM minions WHERE id = ?");
        preparedStatement.setInt(1, minionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.printf("%s %s", resultSet.getString(1), resultSet.getString(2));
        }

    }

    private static void problemEight() throws IOException, SQLException {
        System.out.println("Enter minion ID:");
        String minionId = reader.readLine();

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE minions SET age = age + 1, name = LOWER(name) " +
                        "WHERE id = ?;");
        preparedStatement.setString(1, minionId);
        preparedStatement.executeUpdate();

        PreparedStatement preparedStatementM = connection
                .prepareStatement("SELECT * FROM minions");
        ResultSet resultSet = preparedStatementM.executeQuery();

        while (resultSet.next()){
            System.out.printf("%d %s %s%n", resultSet.getInt(1),
                    resultSet.getString(2),resultSet.getInt(3));
        }
    }

    private static void problemSeven() throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM minions;");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> allMinions = new ArrayList<>();

        while (resultSet.next()){
            allMinions.add(resultSet.getString("name"));
        }
        int count = 0;
        for (int i = 0; i < allMinions.size()/2; i++) {
            System.out.println(allMinions.get(i));
            System.out.println(allMinions.get(allMinions.size()-i-1));
        }
    }

    private static void problemFive() throws IOException, SQLException {
        System.out.println("Enter country name:");

        String countryName = reader.readLine();

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?");
        preparedStatement.setString(1, countryName);

        int resultSet = preparedStatement.executeUpdate();

        ArrayList<String> towns = new ArrayList<>();

        if (resultSet == 0) {
            System.out.print("No town names were affected.");
            return;
        }
        System.out.printf("%d town names were affected.%n", resultSet);

        PreparedStatement preparedStatementTown = connection.prepareStatement(
                "SELECT name FROM towns WHERE country = ?");

        preparedStatementTown.setString(1, countryName);
        ResultSet resultSetTown = preparedStatementTown.executeQuery();
        while (resultSetTown.next()){
            towns.add(resultSetTown.getString("name"));

        }
        System.out.println(towns);
    }

    private static void problemFour() throws SQLException, IOException {
        Connection conn = connectionToMySQL();
        System.out.println("Enter the full input:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] moreLines = new String[2];
        for (int i = 0; i < 2; i++) {
            moreLines[i] = reader.readLine();
        }
        String[] inputVillain = moreLines[1].split("\\s+");
        String[] inputMinions = moreLines[0].split("\\s+");

        String minionName = inputMinions[1];
        String minionAge = inputMinions[2];
        String minionCity = inputMinions[3];
        String villainName = inputVillain[1];


        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO villains(`name`) VALUES (?);");
        preparedStatement.setString(1, villainName);

        System.out.printf("Villain %s was added to the database.%n", villainName);


//        String townNumber = "";
//
//        if (rs.next()){
//            townNumber = rs.getString(1);
//            PreparedStatement ps = conn.prepareStatement("INSERT INTO `minions`(`name`, `age`, `town_id`) VALUES (?, ?, ?);");
//            ps.setString(1, minionName);
//            ps.setString(2, minionAge);
//            ps.setString(3, townNumber);
//            ps.execute();
//        } else {
//            PreparedStatement  preparedStatementMin = conn.prepareStatement("SELECT id FROM minions WHERE `name` LIKE ?;");
//            preparedStatement.setString(1, minionName);
//            ResultSet rsMin = preparedStatement.executeQuery();
//            PreparedStatement ps = conn.prepareStatement("INSERT INTO `towns`(`name`) VALUES (?);");
//            ps.setString(1, minionCity);
//            ps.execute();
//            PreparedStatement pst = conn.prepareStatement(
//                    "INSERT INTO `minions_villains`(`minion_id`,`villain_id`) VALUES (?, ?);");
//            pst.setString(1, rsMin.getString(1));
//            pst.setString(2, rsMin.getString(2));
//            pst.execute();
//
//            PreparedStatement psts = conn.prepareStatement(
//                    "INSERT INTO `minions`(`name`,`age`,`town_id`) VALUES (?, ?, ?);");
//            psts.setString(1, minionName);
//            psts.setString(2, minionAge);
//            psts.setString(3, rs.getString(1));
//            psts.execute();
//            System.out.printf("Town %s was added to the database.%n", minionCity);
//        }

        System.out.printf("Successfully added %s to be minion of %s.",
                minionName, villainName);
    }

    private static void problemThree() throws SQLException, IOException {

        System.out.println("Enter the villain Id number:");
        int villainId = Integer.parseInt(readFromConsole());

        PreparedStatement pstmt = connectionToMySQL().prepareStatement("SELECT DISTINCT `name` FROM `villains` WHERE `id` = ?;");
        pstmt.setInt(1, villainId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.printf("Villain: %s%n", rs.getString(1));
        }
        pstmt = connectionToMySQL().prepareStatement("SELECT DISTINCT m.`name`, m.`age`\n" +
                "FROM `villains` AS v\n" +
                "    JOIN `minions_villains` AS mv\n" +
                "        ON mv.`villain_id` = v.`id`\n" +
                "JOIN minions m on m.id = mv.minion_id\n" +
                "WHERE `villain_id` = ?;");
        pstmt.setInt(1, villainId);
        rs = pstmt.executeQuery();

        int count = 0;
        while (rs.next()) {
            System.out.printf("%d. %s %d%n", ++count, rs.getString(1), rs.getInt(2));

        }
    }

    private static void problemTwo() throws SQLException {
        Connection conn = connectionToMySQL();

        try (conn) {
            Statement statement = conn.createStatement();
            String sql =
                    "SELECT v.`name`, COUNT(DISTINCT mv.`minion_id`) AS 'm_count'\n" +
                            "FROM `villains` AS v\n" +
                            "    JOIN `minions_villains` AS mv\n" +
                            "        ON mv.`villain_id` = v.`id`\n" +
                            "GROUP BY v.`name`\n" +
                            "HAVING m_count > 15\n" +
                            "ORDER BY m_count DESC;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("%s %d%n", rs.getString("name"), rs.getInt("m_count"));
            }
        }
    }

    private static Connection connectionToMySQL() throws SQLException {
        Properties prop = new Properties();
//TODO Insert user name for the MySQL access.
        prop.setProperty("user", "root");
//TODO Insert password for the MySQL access.
        prop.setProperty("password", "Kopacha");
        String url = "jdbc:mysql://localhost:3306/minions_db";
        return DriverManager.getConnection(url, prop);
    }

    private static String readFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
