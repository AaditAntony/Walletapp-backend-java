package com.walletapp.walletapp.service;



import com.walletapp.walletapp.model.User;
import com.walletapp.walletapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, double initialBalance) {
        User user = new User(name, initialBalance);
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public User addMoney(Long id, double amount) {
        User user = getUser(id);
        user.setBalance(user.getBalance() + amount);
        return userRepository.save(user);
    }

    @Transactional
    public User spendMoney(Long id, double amount) {
        User user = getUser(id);
        if (user.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        user.setBalance(user.getBalance() - amount);
        return userRepository.save(user);
    }
}
