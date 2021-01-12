package service;

import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.repository.UserRepository;
import com.example.javai_interview_question_answer_platform.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void createUserHappyFlow() {
        //arrange

        User user = new User("Cristina", "Grecu", "grecu@yahoo.com", 22, "Parola1!");
        User savedUser = new User(1, "Cristina", "Grecu", "grecu@yahoo.com", 22, "Parola1!", false);

        System.out.println(Optional.of(user));
        System.out.println(Optional.of(savedUser));
         when(userRepository.getByEmail(user.getEmail()))
               .thenReturn(Optional.of(user));
        when(userRepository.createUser(user)).thenReturn(savedUser);
        //act
        User result = userService.createUser(user);

        //assert
        System.out.println(result.getId());
        assertEquals(savedUser.getId(), result.getId());
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getAge(), result.getAge());
        assertEquals(user.getPassword(), result.getPassword());
        assertEquals(savedUser.isLoggedIn(), result.isLoggedIn());

        verify(userRepository, times(1)).createUser(user);

    }

}