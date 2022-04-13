package br.com.erudio.controller;

import br.com.erudio.model.Cambio;
import br.com.erudio.service.CambioService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cambio-service")
@AllArgsConstructor
public class CambioController {

    private Environment environment;
    private CambioService cambioService;

    @GetMapping(value = "/{amount}/{from}/{to}")
    public ResponseEntity<Cambio> findCambio(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {

        return ResponseEntity.ok().body(cambioService.findByCambio(from, to, amount));
    }

}
