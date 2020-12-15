
package models.API;


import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String id;

    private Boolean active;

    private Boolean anonymous;

    private Boolean headless;

    private List<String> authorities;

    private int janusId;

    private Boolean testMode;

    private String affiliateId;

    private String email;

    private String externalAuthToken;

    private String externalAuthType;

    private Boolean fast;

    private String firstName;

    private String grantType;

    private String lastName;

    private Meta meta;

    private String password;

    private Boolean rememberMe;

    private String timezone;



}
