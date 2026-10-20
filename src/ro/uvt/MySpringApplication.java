package ro.uvt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ro.uvt.difexamples.ClientComponent;
import ro.uvt.difexamples.SingletonComponent;
import ro.uvt.difexamples.TransientComponent;

@SpringBootApplication
public class MySpringApplication {

    public static void main(String[] args) {
        // Gets a handle of dependency injection context
        ApplicationContext context =
                SpringApplication.run(MySpringApplication.class, args);

        // Gets an instance of TransientComponent from the DI context
        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        // Every time an instance is required, the DI context creates a new one
        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        // Gets the unique instance of SingletonComponent
        // (it was created while the application was loading)
        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        // Every time an instance is required, the DI context returns the same one
        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        // Gets an instance of a class that requires singleton/transient components
        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        // One can also request an instance from DI context by name
        c = (ClientComponent) context.getBean("clientComponent");
        c.operation();
    }
}
