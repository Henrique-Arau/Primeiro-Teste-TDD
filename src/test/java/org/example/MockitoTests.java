package org.example;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MockitoTests {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito() {

        List<String> lista = Mockito.mock(ArrayList.class);

        Mockito.when( lista.size() ).thenReturn(20);

        int size = lista.size();

        Assertions.assertThat(size).isEqualTo(20);

        Mockito.verify(lista).size();
    }
}
