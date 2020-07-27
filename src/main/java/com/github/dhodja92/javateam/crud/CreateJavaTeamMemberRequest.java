package com.github.dhodja92.javateam.crud;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;

public final class CreateJavaTeamMemberRequest {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    public CreateJavaTeamMemberRequest() {
        //
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || this.getClass() != o.getClass()) { return false; }
        CreateJavaTeamMemberRequest that = (CreateJavaTeamMemberRequest) o;
        return Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName);
    }

    @Override
    public String toString() {
        return "CreateJavaTeamMemberRequest{" +
                "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                '}';
    }
}
