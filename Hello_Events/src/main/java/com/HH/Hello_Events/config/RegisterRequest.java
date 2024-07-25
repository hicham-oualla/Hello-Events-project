package com.HH.Hello_Events.config;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String fullName ;
    private String email ;
    private String password ;

}
