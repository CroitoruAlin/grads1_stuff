package training.hotel;


import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.ScriptResolver;
import com.wix.mysql.SqlScriptSource;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.config.SchemaConfig;
import com.wix.mysql.distribution.Version;
import org.assertj.core.api.AssertJProxySetup;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.After;
import org.junit.Assert;
import org.assertj.core.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class HotelSqlDataTest {
    EmbeddedMysql mysqld;

    @Before
    public void setUp() throws Exception {

        MysqldConfig config= MysqldConfig.aMysqldConfig(Version.v5_7_latest).withPort(3306).withUser("user","").build();
        SchemaConfig schemaConfig= SchemaConfig.aSchemaConfig("rdbms").withScripts(ScriptResolver.classPathScript("init.sql")).build();
        mysqld= EmbeddedMysql.anEmbeddedMysql(config).addSchema(schemaConfig).start();
    }

    @Test
    public void testAllHotelsWithAC() {
        List<Hotel> hotelsExpected = new ArrayList<>();
        hotelsExpected.add(new Hotel(2L, "Tongabezi", 4, 7L));
        hotelsExpected.add(new Hotel(5L,"Ritz",	4,6L));
        hotelsExpected.add(new Hotel(6L,"Longitude 131",4,	8L));
        hotelsExpected.add(new Hotel(8L,"Belmond Grand Hotel",	5,	4L));
        AssertionsForClassTypes.assertThat(hotelsExpected).isEqualTo(new HotelSqlData("jdbc:mysql://localhost:3306/rdbms").getHotelsWithAirConditioning());
    }

    @After
    public void tearDown() throws Exception {
        if(mysqld!=null)
            mysqld.stop();
    }
}
