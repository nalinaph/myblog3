package com.myblog.myblog3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        List<TestLogin> logins = Arrays.asList(
                new TestLogin("mike", "testing"),
                new TestLogin("stallin", "testing"),
                new TestLogin("smith", "testing"));
        //System.out.println(logins);
        List<TestLoginDto> dto = logins.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
        System.out.println(dto);
    }

    static TestLoginDto mapToDto(TestLogin login)
    {
        TestLoginDto dto = new TestLoginDto();
        dto.setUserName(login.getUserName());
        dto.setPassWord(login.getPassWord());
        return dto;
    }

}
