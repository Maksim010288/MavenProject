package romannumbers.mappers.databases;

import romannumbers.mappers.databases.connect.DBConnectionData;
import romannumbers.mappers.databases.connect.SQLConnect;

import java.util.List;

public class Main {
    public static void main(String[] args){
        DBConnectionData dbConnectionData = null;

        List<Integer> listOfNumber = List.of(9, 90, 100);

        try {
            SQLRequests requests = new SQLRequests(new SQLConnect(dbConnectionData).getDbConnect());
            //requests.create();
           // requests.outputResult(listOfNumber);
            requests.outputResult(listOfNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
