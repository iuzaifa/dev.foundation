package in.huzaifa.cloudshareapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private String id;
    private String clerkId;
    private String email;
    private String firstname;
    private String lastname;
    private Integer credits;
    private String photoUrl;
    private Instant createAt;
}
