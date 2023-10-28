package taxislibres.jeffrey.maestre.services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taxislibres.jeffrey.maestre.models.User;
import taxislibres.jeffrey.maestre.repositorys.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public User save(@Valid User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(@Valid User user) {
        User userActual = userRepository.findById(user.getId()).orElse(null);
        if (userActual == null){
            return null;
        }
        userActual.setName(user.getName());
        userActual.setAge(user.getAge());
        userActual.setEmail(user.getEmail());
        return userRepository.save(userActual);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
