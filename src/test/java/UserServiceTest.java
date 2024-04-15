import org.example.User;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UserServiceTest {
    @Test
    public void testGetUserById() {
        // Créez un mock pour UserRepository

        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class) ;

        // Créez un utilisateur fictif pour les tests
        long userId = 12;
        User mockUser = new User(userId, "belouahem oussama", "oussamabelouahem@example.com");

        // Configurez le mock pour renvoyer l'utilisateur fictif lorsque findById est appelé avec l'ID correspondant
        Mockito.when(userRepositoryMock.findUserById(userId)).thenReturn(mockUser);

        // Créez une instance de UserService en utilisant le mock UserRepository
        UserService userService = new UserService(userRepositoryMock);

        // Appelez la méthode getUserById avec l'ID de l'utilisateur fictif
        User result = userService.getUserById(userId);

        // Vérifiez que l'utilisateur retourné correspond à l'utilisateur fictif
        //Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(mockUser, result);
    }
}
