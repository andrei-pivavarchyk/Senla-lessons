package com.dao;

import com.configurator.ConfigProperty;
import com.configurator.IConfigurator;
import com.configurator.PropertyFilePath;
import com.configurator.PropertyName;
import com.dependencyService.DependencyService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    //for mysql

    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.URL)
    private String url;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.USER)
    private String user;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.PASSWORD)
    private String password;

    private Connection con;
    public Logger log = Logger.getLogger(ConnectionUtil.class);
    private static volatile ConnectionUtil instance;

    private ConnectionUtil() {
    }

    public static ConnectionUtil getConnectionUtil() {
        ConnectionUtil localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectionUtil.class) {
                localInstance = instance;
                if (localInstance == null) {
                    IConfigurator configurator = (IConfigurator) DependencyService.getDI().getInstance(IConfigurator.class);
                    instance = new ConnectionUtil();
                    configurator.configure(instance);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        if (con != null) {
            return con;
        } else {
            try {
                con = DriverManager.getConnection(url, user, password);
                return con;

            } catch (SQLException e) {
                log.error(e.toString());
                return null;
            }
        }
    }
}
