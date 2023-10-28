package taxislibres.jeffrey.maestre.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taxislibres.jeffrey.maestre.models.User;
import taxislibres.jeffrey.maestre.repositorys.UserRepository;
import taxislibres.jeffrey.maestre.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping("/user")
    public List<User> index(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        User user = userService.findById(id);
        if(user != null){
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/user")
    public ResponseEntity<User> create (@Valid @RequestBody User user){
        User createUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<User> updatePartial (@Valid @RequestBody User user, @PathVariable Long id){
        User userActualizado = userService.update(user);
        if (userActualizado != null){
            return ResponseEntity.ok(userActualizado);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
