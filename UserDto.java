
import com.effectivejava.items.constraintvalidation.constraints.PasswordValid;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)//adds return this to each setter function
public class UserDto {

    private String username;

    @NotEmpty
    @NotNull
    @PasswordValid
    private String password;
}
