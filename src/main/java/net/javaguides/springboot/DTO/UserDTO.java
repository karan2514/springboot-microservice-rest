package net.javaguides.springboot.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDTO Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    @Schema(
            description = "User First Name"
    )
    @NotEmpty
    private String firstName;
    @Schema(
            description = "User Last Name"
    )
    @NotEmpty
    private String lastName;
    @Schema(
            description = "User Email Address"
    )
    @NotEmpty
    @Email
    private String email;
}
