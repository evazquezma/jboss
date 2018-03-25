# Jboss datasources and transactions tests

## Jboss config
Datasources config: ''
<subsystem xmlns="urn:jboss:domain:datasources:1.2">
    <datasources>
        <datasource jta="false" jndi-name="java:jboss/datasources/ExampleDSNoJTA" pool-name="ExampleDSNoJTA" enabled="true" use-java-context="true">
            <connection-url>jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
            <driver>h2</driver>
            <security>
                <user-name>sa</user-name>
                <password>sa</password>
            </security>
        </datasource>
        <datasource jta="false" jndi-name="java:jboss/datasources/ExampleDSNoJTA2" pool-name="ExampleDSNoJTA2" enabled="true" use-java-context="true">
            <connection-url>jdbc:h2:mem:test2;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
            <driver>h2</driver>
            <security>
                <user-name>sa</user-name>
                <password>sa</password>
            </security>
        </datasource>
        <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true">
            <connection-url>jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
            <driver>h2</driver>
            <security>
                <user-name>sa</user-name>
                <password>sa</password>
            </security>
        </datasource>
        <datasource jndi-name="java:jboss/datasources/ExampleDS2" pool-name="ExampleDS2" enabled="true" use-java-context="true">
            <connection-url>jdbc:h2:mem:test2;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
            <driver>h2</driver>
            <security>
                <user-name>sa</user-name>
                <password>sa</password>
            </security>
        </datasource>
        <xa-datasource jndi-name="java:jboss/datasources/ExampleDSXA" pool-name="ExampleDSXA" enabled="true" use-java-context="true" use-ccm="true">
            <xa-datasource-property name="URL">
                jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
            </xa-datasource-property>
            <xa-datasource-property name="User">
                sa
            </xa-datasource-property>
            <xa-datasource-property name="Password">
                sa
            </xa-datasource-property>
            <driver>h2</driver>
            <xa-pool>
                <is-same-rm-override>false</is-same-rm-override>
            </xa-pool>
        </xa-datasource>
        <xa-datasource jndi-name="java:jboss/datasources/ExampleDSXA2" pool-name="ExampleDSXA2" enabled="true" use-java-context="true" use-ccm="true">
            <xa-datasource-property name="URL">
                jdbc:h2:mem:test2;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
            </xa-datasource-property>
            <xa-datasource-property name="User">
                sa
            </xa-datasource-property>
            <xa-datasource-property name="Password">
                sa
            </xa-datasource-property>
            <driver>h2</driver>
            <xa-pool>
                <is-same-rm-override>false</is-same-rm-override>
            </xa-pool>
        </xa-datasource>
        <drivers>
            <driver name="h2" module="com.h2database.h2">
                <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
            </driver>
        </drivers>
    </datasources>
</subsystem>
''

## Play
Set datasources in 'database-config.xml'. Deploy the application and go to http://localhost:8080/datasources/test