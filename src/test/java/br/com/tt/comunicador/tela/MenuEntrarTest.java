package br.com.tt.comunicador.tela;
import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.exceptions.EstadoInexistenteException;
import br.com.tt.comunicador.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class) //JUNIT 5
//@RunWith(MockitoJUnitRunner.class) JUNIT 4
class MenuEntrarTest {

    @Mock
    Util util;

    @Test
    void deveriaEntrarComSucesso() throws EstadoInexistenteException {
//        MockitoAnnotations.initMocks(this);
        //Preparação - Arrange
        Mockito.when(util.read())
                .thenReturn("lptn")
                .thenReturn("Gilberto")
                .thenReturn("SC")
                .thenReturn("01/10/1999");

        //Ação - Act
        Usuario usuario =
                new MenuEntrar(util).entrar();

        //Verificação - Assert
        LocalDate nascimentoEsperado
                = LocalDate.of(1999, 10, 01);

        assertEquals("lptn",usuario.getUsername());
        assertEquals("Gilberto", usuario.getNome());
        assertEquals("SC", usuario.getEstado().name());
        assertEquals("Santa Catarina", usuario.getEstado().getDescricao());
        assertEquals(nascimentoEsperado,usuario.getNascimento());

        Mockito.verify(util,
                Mockito.times(4)
        ).read();
    }

    /* @Test
     void deveriaFalharComUserAdminComSucesso(){
         Mockito.when(util.read())
                 .thenReturn("admin");
         //Ação - Act
         Assertions.assertThrows(IllegalArgumentException.class,
         () -> new MenuEntrar(util).entrar());
         Mockito.verify(util).read();
     }*/
    @Test
    void deveriaSerIgualA3(){
        //Preparação
        //Ação
        int resultado = 2+1;
        //Verificação
        assertEquals(3, resultado);
    }

    @Test
    void deveriaEntrarComSucessoComEstado() throws EstadoInexistenteException {
//        MockitoAnnotations.initMocks(this);
        //Preparação - Arrange
        Mockito.when(util.read())
                .thenReturn("lptn")
                .thenReturn("Gilberto")
                .thenReturn("RS")
                .thenReturn("01/10/1999");

        //Ação - Act
        Usuario usuario =
                new MenuEntrar(util).entrar();

        //Verificação - Assert
        LocalDate nascimentoEsperado
                = LocalDate.of(1999, 10, 01);

        assertEquals("lptn",usuario.getUsername());
        assertEquals("Gilberto", usuario.getNome());
        assertEquals("RS", usuario.getEstado().name());
        assertEquals("Rio Grande do Sul", usuario.getEstado().getDescricao());
        assertEquals(nascimentoEsperado,usuario.getNascimento());

        Mockito.verify(util,
                Mockito.times(4)
        ).read();
    }

    @Test
    void deveriaEntrarComSucessoComEstadoInexistente(){
//        MockitoAnnotations.initMocks(this);
        //Preparação - Arrange
        Mockito.when(util.read())
                .thenReturn("lptn")
                .thenReturn("Gilberto")
                .thenReturn("ZZ")
                .thenReturn("01/10/1999");

        //Ação - Act
        EstadoInexistenteException e =
                assertThrows(
                        EstadoInexistenteException.class,
                        () ->new MenuEntrar(util).entrar());

        assertEquals(
                "Estado inexistente: ZZ"
                , e.getMessage());

        Mockito.verify(util,
                Mockito.times(3)
        ).read();
    }
}