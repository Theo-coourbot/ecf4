package com.example.celestialobject;

import com.example.celestialobject.entity.CelestialObjectApp;
import com.example.celestialobject.repository.CelestialObjectAppRepository;
import com.example.celestialobject.service.CelestialObjectAppService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class CelestialObjectApplicationTests {

    @Mock
    CelestialObjectAppRepository celestialObjectAppRepository;
    @InjectMocks
    CelestialObjectAppService celestialObjectAppService;

//    @BeforeEach
//    void setUp(){
//        List<CelestialObjectApp> celestialObjectAppList = Arrays.asList(
//                celestialObjectAppService.createCelstiaObj("etoile", "soleil"),
//                celestialObjectAppService.createCelstiaObj("plenete", "mercure"),
//                celestialObjectAppService.createCelstiaObj("plenete", "venus")
//
//        );
//    }


    @Test void shouldAddNewCeletialObjectWhenValidDataProvided() {

        CelestialObjectApp celestialObjectApp = new CelestialObjectApp("etoile", "soleil");
        Mockito.when(celestialObjectAppRepository.save(celestialObjectApp)).thenReturn(celestialObjectApp);


        CelestialObjectApp result = celestialObjectAppService.createCelstiaObj("etoile", "soleil");


        Assertions.assertEquals(celestialObjectApp, result);
    }

    @Test
    public void shouldReturnCelestialObjByIdWhenExists() {
        CelestialObjectApp celestialObjectApp = new CelestialObjectApp(1,"etoile", "soleil");

        Mockito.when(celestialObjectAppRepository.findById(1)).thenReturn(Optional.of(celestialObjectApp));


        CelestialObjectApp result = celestialObjectAppService.findByCelestialObjId(1);



        Assertions.assertEquals(celestialObjectApp, result);

    }

    @Test
    public void shouldRaiseExceptionWhenCelestialNotFound() {

        CelestialObjectApp celestialObjectApp = new CelestialObjectApp(1,"etoile", "soleil");
        Mockito.when(celestialObjectAppRepository.save(celestialObjectApp)).thenReturn(celestialObjectApp);

        CelestialObjectApp result = celestialObjectAppService.findByCelestialObjId(1);



        Assertions.assertThrowsExactly(RuntimeException.class, ()->{
           celestialObjectAppService.findByCelestialObjId(2);
        });
    }





}
