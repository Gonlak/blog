package bo;

import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Integer id;
    @NonNull private String username;
    @NonNull private String email;
    @NonNull private String password;
    @NonNull private String firstname;
    @NonNull private String lastname;
    @NonNull private LocalDate dateCreated;

    public User(@NonNull String username, @NonNull String password) {
        super();
        this.username = username;
        this.password = password;
        this.dateCreated = LocalDate.now();
    }
}

