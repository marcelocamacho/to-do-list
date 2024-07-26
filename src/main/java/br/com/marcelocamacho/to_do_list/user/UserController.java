package br.com.marcelocamacho.to_do_list.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public String create( @RequestBody UserModel userModel ){
        System.out.println(userModel.getName());
        var userCreated = this.userRepository.save(userModel);
        return userCreated.toString();
    }
}
