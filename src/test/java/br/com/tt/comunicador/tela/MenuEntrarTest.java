package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class) //JUNIT 5
//@RunWith(MockitoJUnitRunner.class) //JUNIT 4
class MenuEntrarTest {

    @Mock
    Util util;

    @Test
    void deveriaEntrarComSucesso(){
        LocalDate nascimento = LocalDate.of(1981,05,06);
        //preparação
        Mockito.when(util.read())
                .thenReturn("wenzelcr")
                .thenReturn("Cláudio")
                .thenReturn("06/05/1981");
        //ação
        Usuario usuario = new MenuEntrar(util).entrar();

        //verificação
        assertEquals( "wenzelcr", usuario.getUsername());
        assertEquals( "Cláudio", usuario.getNome());
        assertEquals( nascimento, usuario.getNascimento());
        Mockito.verify(util,Mockito.times(3)).read();
    }

}