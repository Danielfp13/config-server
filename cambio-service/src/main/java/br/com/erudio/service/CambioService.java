package br.com.erudio.service;

import br.com.erudio.model.Cambio;
import br.com.erudio.repository.CambioRepository;
import br.com.erudio.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class CambioService {

    private CambioRepository cambioRepository;
    private Environment environment;

    public Cambio findByCambio(String from, String to, BigDecimal amount){
        Cambio cambio = cambioRepository.findByFromAndTo(from,to)
                .orElseThrow( () -> new ObjectNotFoundException("Moeda não suportada."));
        return convertCambio(cambio, amount);
    }

    private Cambio convertCambio(Cambio cambio, BigDecimal amount) {
        cambio.setEnvironment( environment.getProperty("local.server.port"));
        cambio.setConvertionValue(
                cambio.getConvertionFactor().multiply(amount).setScale(2, RoundingMode.CEILING));
        return cambio;
    }
}
