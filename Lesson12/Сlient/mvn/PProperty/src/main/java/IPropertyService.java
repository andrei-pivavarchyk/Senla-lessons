import java.util.Properties;

public interface IPropertyService {
    Properties getProperties(String propertyPath) throws Exception;
}
