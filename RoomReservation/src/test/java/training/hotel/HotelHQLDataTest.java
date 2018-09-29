package training.hotel;


import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.ScriptResolver;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.config.SchemaConfig;
import com.wix.mysql.distribution.Version;
import org.assertj.core.api.Assert;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import training.FactorySessionProvider;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HotelHQLDataTest {
    final Logger logger = LoggerFactory.getLogger(HotelHQLDataTest.class);
    private FactorySessionProvider factorySessionProvider;
    private EmbeddedMysql mysqld;
    @Before
    public void before()
    {
        factorySessionProvider=new FactorySessionProvider();
        MysqldConfig config= MysqldConfig.aMysqldConfig(Version.v5_7_latest).withPort(3306).withUser("user","").build();
        SchemaConfig schemaConfig= SchemaConfig.aSchemaConfig("rdbms").withScripts(ScriptResolver.classPathScript("init.sql")).build();
        mysqld= EmbeddedMysql.anEmbeddedMysql(config).addSchema(schemaConfig).start();


    }
    @Test
    public void findAll() {

        List<Hotel> allHotels = new HotelHQLData(factorySessionProvider.getSessionFactory()).findAll();
        logger.info(allHotels.toString());
        assertThat(allHotels.size()).isEqualTo(8);

    }
    @After
    public void releaseSession()
    {
        if(factorySessionProvider!=null)
            factorySessionProvider.shutdown();
        if(mysqld!=null)
            mysqld.stop();

    }

    @Test
    public void getHotelsWithAirConditioning() {
        assertThat(new HotelHQLData(factorySessionProvider.getSessionFactory()).getHotelsWithAirConditioning().size()).isEqualTo(5);
    }
}
