package com.tcc.doapet.factory;

import com.tcc.doapet.model.dto.request.ONGRequest;
import com.tcc.doapet.model.dto.response.ONGResponse;
import com.tcc.doapet.model.entity.ONG;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class ONGFactory {


    public static ONG getONG(){
        return ONG.builder()
                .id(1L)
                .name("ONG Patinhas unidas")
                .email("patinhasunidas@email.com")
                .password("123")
                .phoneNumber("15984985768")
                .street("Rua Célia Asse Jacob")
                .number("669")
                .neighborhood("Jardim Imperial")
                .city("Sorocaba")
                .state("Sorocaba")
                .cnpj("04912441000110")
                .pix("patinhasunidas@email.com")
                .presidentName("Cláudia Carolina Sara da Luz")
                .biography("A ONG Patinhas unidas foi fundada em 2014 com o propósito de dar uma nova vida para os animais de rua")
                .active(true)
                .build();
    }

    public static ONG getONGTwo(){
        return ONG.builder()
                .id(2L)
                .name("ONG Focinhos Carinhosos")
                .email("focinhoscarinhosos@email.com")
                .password("123")
                .phoneNumber("11982746982")
                .street("Alameda Piratuba")
                .number("198")
                .neighborhood("Residencial Morada dos Lagos")
                .city("Barueri")
                .state("SP")
                .cnpj("91310562000197")
                .pix("focinhoscarinhosos@email.com")
                .presidentName("Benedito Vicente Ribeiro")
                .biography("A Focinhos Carinhosos atua na cidade de Barueri desde 2007, prestando serviços e ajudando os animaizinhos necessitados.")
                .active(true)
                .build();
    }

    public static ONGResponse getONGResponse(){
        return ONGResponse.builder()
                .id(1L)
                .name("ONG Patinhas unidas")
                .email("patinhasunidas@email.com")
                .phoneNumber("15984985768")
                .street("Rua Célia Asse Jacob")
                .number("669")
                .neighborhood("Jardim Imperial")
                .city("Sorocaba")
                .state("Sorocaba")
                .cnpj("04912441000110")
                .pix("patinhasunidas@email.com")
                .presidentName("Cláudia Carolina Sara da Luz")
                .biography("A ONG Patinhas unidas foi fundada em 2014 com o propósito de dar uma nova vida para os animais de rua")
                .active(true)
                .build();
    }

    public static ONGResponse getONGResponseTwo(){
        return ONGResponse.builder()
                .id(2L)
                .name("ONG Focinhos Carinhosos")
                .email("focinhoscarinhosos@email.com")
                .phoneNumber("11982746982")
                .street("Alameda Piratuba")
                .number("198")
                .neighborhood("Residencial Morada dos Lagos")
                .city("Barueri")
                .state("SP")
                .cnpj("91310562000197")
                .pix("focinhoscarinhosos@email.com")
                .presidentName("Benedito Vicente Ribeiro")
                .biography("A Focinhos Carinhosos atua na cidade de Barueri desde 2007, prestando serviços e ajudando os animaizinhos necessitados.")
                .active(true)
                .build();
    }

    public static ONGRequest getONGRequest(){
        return ONGRequest.builder()
                .name("ONG Patinhas unidas")
                .email("patinhasunidas@email.com")
                .password("123")
                .phoneNumber("15984985768")
                .street("Rua Célia Asse Jacob")
                .number("669")
                .neighborhood("Jardim Imperial")
                .city("Sorocaba")
                .state("Sorocaba")
                .cnpj("04912441000110")
                .pix("patinhasunidas@email.com")
                .presidentName("Cláudia Carolina Sara da Luz")
                .biography("A ONG Patinhas unidas foi fundada em 2014 com o propósito de dar uma nova vida para os animais de rua")
                .active(true)
                .build();
    }

    public static List<ONGResponse> getONGResponseArray(){
        return List.of(getONGResponse(), getONGResponseTwo());
    }

    public static List<ONG> getONGArray(){
        return List.of(getONG(), getONGTwo());
    }

    public static Page<ONGResponse> getPageableONGResponse(){
        return new PageImpl<>(getONGResponseArray());
    }

}
