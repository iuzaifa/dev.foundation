package com.academiapro.cms.entiy;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "auth_user")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String firstname;
    private String lastname;

    @Email
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private LocalDate birthday;

    private String bloodType;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Document> documents;

    /* ---------- AUTH FIELDS ---------- */
    private String password;
    private boolean passwordChanged;
    private boolean isActive = true;
    private boolean enabled = true;
    private boolean emailVerified;
    private boolean emailUnsubscribed;

    /* ---------- AUDIT ---------- */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;


    /* ---------- ROLES ---------- */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> role;

    @PrePersist
    public void ensureUsername() {
        if (this.username == null) {
            this.username = this.firstname + "_" + System.currentTimeMillis();
        }
    }
}
