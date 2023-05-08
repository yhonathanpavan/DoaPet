package com.tcc.doapet.factory;

import com.tcc.doapet.model.dto.request.DonorRequest;
import com.tcc.doapet.model.dto.response.DonorResponse;
import com.tcc.doapet.model.entity.Donor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDate;
import java.util.List;

public class DonorFactory {


    public static Donor getDonor() {
        return Donor.builder()
                .id(1L)
                .name("Davi Filipe Oliver Oliveira")
                .email("davifilipeoliveira@kuehne-nagel.com")
                .password("123")
                .phoneNumber("12982613354")
                .street("Rua José Ferreira")
                .number("406")
                .neighborhood("Tinga")
                .city("Caraguatatuba")
                .state("SP")
                .cpf("84545610803")
                .birthdate(LocalDate.of(2003, 3, 5))
                .profilePicture("aasssh")
                .status(true)
                .build();
    }

    public static Donor getDonorTwo() {
        return Donor.builder()
                .id(2L)
                .name("Eduardo Pedro Henrique Luiz Ramos")
                .email("eduardo.pedro.ramos@multmed.com.br")
                .password("123")
                .phoneNumber("11999693910")
                .street("Via de Pedestre Sonho de Verão")
                .number("406")
                .neighborhood("Parque Guaianazes")
                .city("São Paulo")
                .state("SP")
                .cpf("92188673859")
                .birthdate(LocalDate.of(2003, 3, 1))
                .profilePicture("aasssh")
                .status(true)
                .build();
    }

    public static DonorResponse getDonorResponse() {
        return DonorResponse.builder()
                .id(1L)
                .name("Davi Filipe Oliver Oliveira")
                .email("davifilipeoliveira@kuehne-nagel.com")
                .phoneNumber("12982613354")
                .street("Rua José Ferreira")
                .number("406")
                .neighborhood("Tinga")
                .city("Caraguatatuba")
                .state("SP")
                .cpf("84545610803")
                .birthdate(LocalDate.of(2003, 3, 5))
                .profilePicture("aasssh")
                .status(true)
                .build();
    }

    public static DonorResponse getDonorResponseTwo() {
        return DonorResponse.builder()
                .id(2L)
                .name("Eduardo Pedro Henrique Luiz Ramos")
                .email("eduardo.pedro.ramos@multmed.com.br")
                .phoneNumber("11999693910")
                .street("Via de Pedestre Sonho de Verão")
                .number("406")
                .neighborhood("Parque Guaianazes")
                .city("São Paulo")
                .state("SP")
                .cpf("92188673859")
                .birthdate(LocalDate.of(2003, 3, 1))
                .profilePicture("aasssh")
                .status(true)
                .build();
    }

    public static DonorRequest getDonorRequest() {
        return DonorRequest.builder()
                .name("Davi Filipe Oliver Oliveira")
                .email("davifilipeoliveira@kuehne-nagel.com")
                .phoneNumber("12982613354")
                .street("Rua José Ferreira")
                .number("406")
                .neighborhood("Tinga")
                .city("Caraguatatuba")
                .state("SP")
                .cpf("84545610803")
                .birthdate(LocalDate.of(2003, 3, 5))
                .profilePicture("aasssh")
                .build();
    }

    public static List<DonorResponse> getDonorResponseArray() {
        return List.of(getDonorResponse(), getDonorResponseTwo());
    }

    public static List<Donor> getDonorArray() {
        return List.of(getDonor(), getDonorTwo());
    }

    public static Page<DonorResponse> getPageableDonorResponse() {
        return new PageImpl<>(getDonorResponseArray());
    }

}
