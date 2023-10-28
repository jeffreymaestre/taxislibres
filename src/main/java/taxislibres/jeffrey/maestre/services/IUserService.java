package taxislibres.jeffrey.maestre.services;

import taxislibres.jeffrey.maestre.models.User;

import java.util.List;

public interface IUserService {
    public User save(User user);
    public User update(User user);
    public void delete(Long id);
    public List<User> findAll();
    public User findById(Long id);
}
