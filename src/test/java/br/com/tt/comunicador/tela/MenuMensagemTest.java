package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.exceptions.TamanhoMensagemInvalidoException;
import br.com.tt.comunicador.model.Mensagem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MenuMensagemTest {

    @Mock
    Util utilMock;
    MenuMensagem menuMensagem;

    @BeforeEach
    void inicializa(){
        menuMensagem = new MenuMensagem(utilMock);
    }

    @Test
    void deveriaCriarNovaMensagem(){
        Mockito.when(utilMock.read())
                .thenReturn("Olá mundo!");

        //Ação
        Mensagem retorno = menuMensagem.novaMensagem();

        //Verificação
        Assertions.assertNotNull(retorno);
        Assertions.assertEquals("Olá mundo!", retorno.getTexto());
    }

    @Test
    void deveriaFalharTamanhoMinimo(){
        Mockito.when(utilMock.read())
                .thenReturn("Olá");

        //Act
        Mensagem retorno = menuMensagem.novaMensagem();

        //Assert
        Assertions.assertNull(retorno);
    }

    @Test
    void deveriaFalharTamanhoMinimoComExecao() {
        Mockito.when(utilMock.read())
                .thenReturn("Olá");

        //Act
        TamanhoMensagemInvalidoException e =
                Assertions.assertThrows(
                        TamanhoMensagemInvalidoException.class,
                        () -> menuMensagem.novaMensagemComExcecao());

        Assertions.assertEquals(
                "Tamanho mínimo: 5",
                e.getMessage());
    }

}