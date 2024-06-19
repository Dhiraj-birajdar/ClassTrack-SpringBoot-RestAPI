package edu.classtrack.security;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = {"/adduser","/add"},consumes = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(value = {"/adduser","/add"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@Valid @RequestBody UserDto userDto) {
        if(userDto.getRole().equalsIgnoreCase("ADMIN")){
            return ResponseEntity.badRequest().body("invalid role only faculty and student are allowed");
        }
        if (userDetailsService instanceof InMemoryUserDetailsManager) {
            InMemoryUserDetailsManager manager = (InMemoryUserDetailsManager) userDetailsService;
            if(manager.userExists(userDto.getUsername())){
                return ResponseEntity.badRequest().body("User already exists");
            }
            manager.createUser(User.withUsername(userDto.getUsername())
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .roles(userDto.getRole())
                    .build());
            logger.info("User added with username: {}, password: {}, role: {}", userDto.getUsername(), userDto.getPassword(), userDto.getRole());
            return ResponseEntity.ok("User added");
        }
        return ResponseEntity.badRequest().body("User not added");
    }

    @DeleteMapping("/deleteuser/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        if (userDetailsService instanceof InMemoryUserDetailsManager manager) {
            manager.deleteUser(username);
            logger.warn("User deleted with username: {}", username);
            return ResponseEntity.ok("User deleted");
        }
        return ResponseEntity.badRequest().body("User not deleted");
    }

}
