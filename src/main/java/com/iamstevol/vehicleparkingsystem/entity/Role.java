package com.iamstevol.vehicleparkingsystem.entity;

import com.iamstevol.vehicleparkingsystem.constant.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Role extends BaseEntity{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "role_id", updatable = false, nullable = false)
    private String roleId;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private RoleEnum name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(getName(), role.getName()).append(getUsers(), role.getUsers()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(getName()).append(getUsers()).toHashCode();
    }
}
