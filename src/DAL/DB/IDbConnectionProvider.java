package DAL.DB;

import java.sql.Connection;
import java.util.Properties;

public interface IDbConnectionProvider {

    /**
     * Get the active connection to the database.
     *
     * @return The current active connection.
     */
    Connection getConnection();

    /**
     * Get the name of the database.
     *
     * @return The database name.
     */
    String getDatabase();

    /**
     * Get the host of the database.
     *
     * @return The host for the database.
     */
    String getHost();

    /**
     * Get the database user.
     *
     * @return The database user.
     */
    String getUser();

    /**
     * Get the database user password.
     *
     * @return The database user password.
     */
    String getPassword();

    /**
     * Get the database port.
     *
     * @return The database port.
     */
    int getPort();

    /**
     * Connect to the database.
     */
    void connect();

    /**
     * Reconnect to the database.
     */
    void reconnect();

    /**
     * Set the database name.
     *
     * @param database The name of the database name.
     */
    void setDatabase(String database);

    /**
     * Set the host.
     *
     * @param host Set the host.
     */
    void setHost(String host);

    /**
     * Set the database user.
     *
     * @param user the database user.
     */
    void setUser(String user);

    /**
     * Set the database password.
     *
     * @param password The database user password.
     */
    void setPassword(String password);

    /**
     * Set the database port.
     *
     * @param port The port to use.
     */
    void setPort(int port);

    /**
     * Load the specified settings file from path.
     */
    void loadSettingsFile(String path);

    /**
     * Set the specified settings file.
     *
     * @param path
     */
    void setSettingsFile(String path);

    /**
     * Get the path for the settings file.
     *
     * @return
     */
    String getSettingsFile();

    /**
     * Get the database settings properties.
     *
     * @return
     */
    Properties getDatabaseProperties();
}
