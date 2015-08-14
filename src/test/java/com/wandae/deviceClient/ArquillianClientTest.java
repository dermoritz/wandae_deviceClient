package com.wandae.deviceClient;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

import com.google.common.base.Strings;

@RunWith(Arquillian.class)
public abstract class ArquillianClientTest {

    
    @Deployment(testable = false)
    public static WebArchive deploy() {
        return ShrinkWrap.create(WebArchive.class, "test.war").addAsResource("META-INF/beans.xml")
                         .addPackages(true, "com.wandae.deviceClient").addClasses(Strings.class)
                         .addPackages(true, "com.wandae.common");
    }

    @ArquillianResource
    protected URL base;
}
