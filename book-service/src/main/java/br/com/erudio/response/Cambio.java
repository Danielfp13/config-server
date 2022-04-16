package br.com.erudio.response;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cambio implements Serializable {

    private Long id;
    private String from;
    private String to;
    private Double convertionFactor;
    private Double ConvertionValue;
    private String environment;
}
