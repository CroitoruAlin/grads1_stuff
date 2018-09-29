package training;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;




public class FactorySessionProvider {

    private  SessionFactory sessionFactory;
    private StandardServiceRegistry serviceRegistry;

    private void createSessionFactory()
    {
        serviceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources metadataSources=new MetadataSources(serviceRegistry);
        Metadata metadata=metadataSources.getMetadataBuilder().build();
        sessionFactory=metadata.getSessionFactoryBuilder().build();
    }
    public SessionFactory getSessionFactory()
    {
        createSessionFactory();
        return sessionFactory;
    }
    public void shutdown()
    {
        if(sessionFactory!=null)
            sessionFactory.close();
    }

}
