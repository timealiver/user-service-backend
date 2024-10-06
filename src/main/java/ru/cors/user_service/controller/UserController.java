package ru.cors.user_service.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cors.user_service.DTO.UserInfo;
import ru.cors.user_service.model.User;
import ru.cors.user_service.repository.UserRepo;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
private final UserRepo userRepo;

    @GetMapping("/all")
    public List<User> getAllUsersFromDb() {
        return userRepo.findAll();
    }

    @GetMapping("/isExist")
    public Boolean isExistInDb(@RequestParam("username") String username ) {
        var user =  userRepo.findByUsername(username);
        return user != null;
    }

    @PostMapping("/updateUser")
    public Boolean updateUser(@RequestBody Map<String, Object> userData) {
        String newUsername = (String) userData.get("newUsername");
        String newPassword = (String) userData.get("newPassword");
        String newEmail = (String) userData.get("newEmail");

        ObjectId id = new ObjectId("670259be33306f905a3e9e13");
        User user = userRepo.findById(id).orElse(null);
        if(user != null) {
            if(newUsername != null) {
                user.setUsername(newUsername);
            }
            if(newPassword != null) {
                user.setPassword(newPassword);
            }
            if(newEmail != null) {
                user.setEmail(newEmail);
            }
            userRepo.save(user);
            return true;
        }

        return false;
    }
    @PostMapping("/userInfo")
    public ResponseEntity<UserInfo> userInfoFromDb(@RequestParam("username") String username ) {
        var user =  userRepo.findByUsername(username);
        if (user != null) {
            UserInfo userInfo = new UserInfo(user);
            return ResponseEntity.ok(userInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
