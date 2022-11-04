import com.example.entregable.dao.OdontologoDao.OdontologoDaoH2;
import com.example.entregable.entidades.Odontologo;
import com.example.entregable.servicios.OdontologoService;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";
    public static void main(String[] args) throws IOException {
        startLogger();
        var service = new OdontologoService(new OdontologoDaoH2());


        Odontologo odontologo = new Odontologo("sony","rodriguez",3);
        service.agregar(odontologo);
        service.update(odontologo);

        var buscar = (service.buscar(3));
        System.out.println(buscar.getNombre()+" "+buscar.getApellido()+" "+buscar.getMatricula());

        var buscando = (service.buscar(2));
        System.out.println(buscando.getNombre()+" "+buscando.getApellido()+" "+buscando.getMatricula());


        Odontologo odontologo1 = new Odontologo("justo","pablo",6);
        Odontologo odontologo2 = new Odontologo("sony","eelio",2);
        Odontologo odontologo4 = new Odontologo("sony","eelio",2);
        service.agregar(odontologo2);
        service.agregar(odontologo4);

        Odontologo odontologo3 = new Odontologo("lucas","sanchez",1);
        service.agregar(odontologo3);
        service.delete(1);

    }

    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }
}
