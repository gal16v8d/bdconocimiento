package com.gsdd.knowledgedb.controller;

import static org.mockito.BDDMockito.given;

import com.gsdd.knowledgedb.service.UsuarioService;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

class UsuarioControllerTest {

  @Mock private UsuarioService service;
  private UsuarioController controller;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    controller = new UsuarioController(service);
  }

  @Test
  void testCancel() {
    Assertions.assertEquals("redirect:/usuario/listar", controller.cancel());
  }

  @Test
  void testList() {
    given(service.listEnabled()).willReturn(Collections.emptyList());
    ModelAndView mav = controller.list();
    Assertions.assertTrue(mav.getModel().containsKey("usuarios"));
  }
}
