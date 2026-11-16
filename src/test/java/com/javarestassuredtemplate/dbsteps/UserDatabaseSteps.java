package com.javarestassuredtemplate.dbsteps;

import com.javarestassuredtemplate.utils.DBUtils;
import com.javarestassuredtemplate.utils.GeneralUtils;

public class UserDatabaseSteps {
    private static String queriesPath = System.getProperty("user.dir")+"/src/test/java/com/javarestassuredtemplate/queries/";

    public static String getUserPassword(String username){
        String query = GeneralUtils.readFileAsString(queriesPath + "getUserPasswordQuery.sql");
        query = query.replace("$username", username);

        return DBUtils.getQueryResult(query).get(0);
    }
}
