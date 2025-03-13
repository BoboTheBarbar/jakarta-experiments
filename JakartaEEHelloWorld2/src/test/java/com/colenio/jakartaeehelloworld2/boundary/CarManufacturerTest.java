package com.colenio.jakartaeehelloworld2.boundary;

import com.colenio.jakartaeehelloworld2.control.CarCreationListener;
import com.colenio.jakartaeehelloworld2.entity.Specifcation;
import jakarta.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@ExtendWith(ArquillianExtension.class)
class CarManufacturerTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    public CarManufacturer carManufacturer;

    @Inject
    @Spy
    CarCreationListener carCreationListener;

    @Inject
    Specifcation specifcation;

    @Test
    void createAndListenCarEvent() {
        // when
        carManufacturer.createCar(specifcation);

        // then
        verify(carCreationListener).carCreatedEvent(any());
    }
}