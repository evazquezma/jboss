# Jboss datasources and transactions tests

## Post
http://trabajosdesisifo.blogspot.com.es/2018/03/jboss-datasources-and-transactions.html


## Jboss config
Datasources config:
<pre>
<code>
&lt;subsystem xmlns=&quot;urn:jboss:domain:datasources:1.2&quot;&gt;
    &lt;datasources&gt;
        &lt;datasource jta=&quot;false&quot; jndi-name=&quot;java:jboss/datasources/ExampleDSNoJTA&quot; pool-name=&quot;ExampleDSNoJTA&quot; enabled=&quot;true&quot; use-java-context=&quot;true&quot;&gt;
            &lt;connection-url&gt;jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE&lt;/connection-url&gt;
            &lt;driver&gt;h2&lt;/driver&gt;
            &lt;security&gt;
                &lt;user-name&gt;sa&lt;/user-name&gt;
                &lt;password&gt;sa&lt;/password&gt;
            &lt;/security&gt;
        &lt;/datasource&gt;
        &lt;datasource jta=&quot;false&quot; jndi-name=&quot;java:jboss/datasources/ExampleDSNoJTA2&quot; pool-name=&quot;ExampleDSNoJTA2&quot; enabled=&quot;true&quot; use-java-context=&quot;true&quot;&gt;
            &lt;connection-url&gt;jdbc:h2:mem:test2;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE&lt;/connection-url&gt;
            &lt;driver&gt;h2&lt;/driver&gt;
            &lt;security&gt;
                &lt;user-name&gt;sa&lt;/user-name&gt;
                &lt;password&gt;sa&lt;/password&gt;
            &lt;/security&gt;
        &lt;/datasource&gt;
        &lt;datasource jndi-name=&quot;java:jboss/datasources/ExampleDS&quot; pool-name=&quot;ExampleDS&quot; enabled=&quot;true&quot; use-java-context=&quot;true&quot;&gt;
            &lt;connection-url&gt;jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE&lt;/connection-url&gt;
            &lt;driver&gt;h2&lt;/driver&gt;
            &lt;security&gt;
                &lt;user-name&gt;sa&lt;/user-name&gt;
                &lt;password&gt;sa&lt;/password&gt;
            &lt;/security&gt;
        &lt;/datasource&gt;
        &lt;datasource jndi-name=&quot;java:jboss/datasources/ExampleDS2&quot; pool-name=&quot;ExampleDS2&quot; enabled=&quot;true&quot; use-java-context=&quot;true&quot;&gt;
            &lt;connection-url&gt;jdbc:h2:mem:test2;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE&lt;/connection-url&gt;
            &lt;driver&gt;h2&lt;/driver&gt;
            &lt;security&gt;
                &lt;user-name&gt;sa&lt;/user-name&gt;
                &lt;password&gt;sa&lt;/password&gt;
            &lt;/security&gt;
        &lt;/datasource&gt;
        &lt;xa-datasource jndi-name=&quot;java:jboss/datasources/ExampleDSXA&quot; pool-name=&quot;ExampleDSXA&quot; enabled=&quot;true&quot; use-java-context=&quot;true&quot; use-ccm=&quot;true&quot;&gt;
            &lt;xa-datasource-property name=&quot;URL&quot;&gt;
                jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
            &lt;/xa-datasource-property&gt;
            &lt;xa-datasource-property name=&quot;User&quot;&gt;
                sa
            &lt;/xa-datasource-property&gt;
            &lt;xa-datasource-property name=&quot;Password&quot;&gt;
                sa
            &lt;/xa-datasource-property&gt;
            &lt;driver&gt;h2&lt;/driver&gt;
            &lt;xa-pool&gt;
                &lt;is-same-rm-override&gt;false&lt;/is-same-rm-override&gt;
            &lt;/xa-pool&gt;
        &lt;/xa-datasource&gt;
        &lt;xa-datasource jndi-name=&quot;java:jboss/datasources/ExampleDSXA2&quot; pool-name=&quot;ExampleDSXA2&quot; enabled=&quot;true&quot; use-java-context=&quot;true&quot; use-ccm=&quot;true&quot;&gt;
            &lt;xa-datasource-property name=&quot;URL&quot;&gt;
                jdbc:h2:mem:test2;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
            &lt;/xa-datasource-property&gt;
            &lt;xa-datasource-property name=&quot;User&quot;&gt;
                sa
            &lt;/xa-datasource-property&gt;
            &lt;xa-datasource-property name=&quot;Password&quot;&gt;
                sa
            &lt;/xa-datasource-property&gt;
            &lt;driver&gt;h2&lt;/driver&gt;
            &lt;xa-pool&gt;
                &lt;is-same-rm-override&gt;false&lt;/is-same-rm-override&gt;
            &lt;/xa-pool&gt;
        &lt;/xa-datasource&gt;
        &lt;drivers&gt;
            &lt;driver name=&quot;h2&quot; module=&quot;com.h2database.h2&quot;&gt;
                &lt;xa-datasource-class&gt;org.h2.jdbcx.JdbcDataSource&lt;/xa-datasource-class&gt;
            &lt;/driver&gt;
        &lt;/drivers&gt;
    &lt;/datasources&gt;
&lt;/subsystem&gt;
</code>
</pre>


## Play
Set datasources in 'database-config.xml'. Deploy the application and go to http://localhost:8080/datasources/test
