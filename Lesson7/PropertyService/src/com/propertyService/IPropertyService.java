package com.propertyService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public interface IPropertyService {
    Properties getProperties(String propertyPath) throws IOException;
}
