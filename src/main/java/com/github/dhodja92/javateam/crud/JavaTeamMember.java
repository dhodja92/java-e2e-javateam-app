package com.github.dhodja92.javateam.crud;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public final class JavaTeamMember {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String userHandle;

    @JsonCreator
    private JavaTeamMember(
            @JsonProperty("id") Integer id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("userHandle") String userHandle
    ) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.firstName = Objects.requireNonNull(firstName, "firstName cannot be null");
        this.lastName = Objects.requireNonNull(lastName, "lastName cannot be null");
        this.userHandle = Objects.requireNonNull(userHandle, "userHandle cannot be null");
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUserHandle() {
        return this.userHandle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || this.getClass() != o.getClass()) { return false; }
        JavaTeamMember that = (JavaTeamMember) o;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.userHandle, that.userHandle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.userHandle);
    }

    @Override
    public String toString() {
        return "JavaTeamMember{" +
                "id=" + this.id +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", userHandle='" + this.userHandle + '\'' +
                '}';
    }

    public static final class Builder {

        private Integer id;
        private String firstName;
        private String lastName;
        private String userHandle;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder userHandle(String userHandle) {
            this.userHandle = userHandle;
            return this;
        }

        public JavaTeamMember build() {
            return new JavaTeamMember(this.id, this.firstName, this.lastName, this.userHandle);
        }
    }
}
