package com.github.dhodja92.javateam.crud;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;

public final class UpdateJavaTeamMemberRequest {

    private Integer id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    public UpdateJavaTeamMemberRequest() {
        //
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        UpdateJavaTeamMemberRequest that = (UpdateJavaTeamMemberRequest) o;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName);
    }

    @Override
    public String toString() {
        return "UpdateJavaTeamMemberRequest{" +
                "id=" + this.id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static final class Builder {

        private Integer id;
        private String firstName;
        private String lastName;

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

        public UpdateJavaTeamMemberRequest build() {
            UpdateJavaTeamMemberRequest updateRequest = new UpdateJavaTeamMemberRequest();
            updateRequest.setId(this.id);
            updateRequest.setFirstName(this.firstName);
            updateRequest.setLastName(this.lastName);
            return updateRequest;
        }
    }
}
