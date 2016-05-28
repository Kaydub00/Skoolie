# Skoolie

Skoolie is a School Information System built on Java and the Spring platform.


# Deploying Skoolie
Skoolie is currently built to be deployed on Tomcat with MySQL.

To deploy a local instance you will need Tomcat and MySQL. You will also need to build the application via Maven. 

The easiest method to do all this is to install Netbeans and include Tomcat with the install. Setup an instance of MySQL either locally or remotely and create a database and user for Skoolie to use.
Once this is completed, create a database.properties file in the skoolie-data project. (skoolie-data/src/main/resources/database.properties)

This file needs the following attributes:

* database.url = jdbc:mysql://{ip address or url}
* database.user = {dbuser}
* database.password = {dbpassword}
* database.coredb = {db name}
* database.driver = com.mysql.jdbc.Driver