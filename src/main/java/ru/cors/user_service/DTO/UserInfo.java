package ru.cors.user_service.DTO;

import lombok.Data;
import ru.cors.user_service.model.User;

import java.util.Random;

@Data
public class UserInfo {
    private String username;
    private String email;
    private String phone;
    private Boolean isOauth;
    private int passwordLength;

    public UserInfo(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.isOauth = user.getIsOauth();
        this.passwordLength = new Random().nextInt(9) + 8;
    }
}
