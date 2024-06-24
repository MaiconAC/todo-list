package com.maicon.todo_list_api.config;

import com.maicon.todo_list_api.models.AccountModel;
import com.maicon.todo_list_api.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AccountModel> user = accountRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No account found with this username");
        }

        return User.builder().username(user.get().getEmail()).password(user.get().getPassword()).build();
    }
}
