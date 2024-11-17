import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /*

        import package
        load and register driver
        create connection
        create statement
        execute statement
        process the results
        close

         */

        String name = "baxtiyor";
        Integer age = 27;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "1923";
        String sqlForAllData = "select * from student";
        String sqlInsertSimple = "insert into student(name, age) values ('" + name + "'," + age + ");";
        String sqlInsertPreparedStatement = "insert into student(name, age) values (?, ?);";
        String sqlDelete = "delete from student where id = 2";
        String sqlUpdate = "update student set name='bolajon' where id=2;";
//         todo: loading the driver
        Class.forName("org.postgresql.Driver");

        // todo: create connection
        Connection connection = DriverManager.getConnection(url, username, password);

        // todo: create statement
//        Statement statement = connection.createStatement();
        PreparedStatement statement = connection.prepareStatement(sqlInsertPreparedStatement);
        statement.setString(1, name);
        statement.setInt(2, age);

        // todo: execute statement
//        ResultSet resultSet = statement.executeQuery(sqlForAllData);

//        boolean status = statement.execute(sqlInsert);
//        System.out.println(status);
        statement.execute();
//        statement.execute(sqlUpdate);

//        statement.execute(sqlDelete);

        // todo: process the results
//        resultSet.next();
//        String name = resultSet.getString("name");
//        System.out.println("Name of the student is " + name);

        // todo: fetching all the rows

//        while (resultSet.next()){
//            System.out.println(resultSet.getInt("id")  + " - " + resultSet.getString("name") + " - " + resultSet.getString("age"));
//        }


        // todo: close connection
        connection.close();

    }
}