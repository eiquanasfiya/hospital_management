package service;

import repository.AuthanticationRepository;

public class AuthanticationService {

    public static String loginType(String username, String userPassword) {
        AuthanticationRepository authanticationRepository=new AuthanticationRepository();
        return authanticationRepository.login(username,userPassword);
    }
}
