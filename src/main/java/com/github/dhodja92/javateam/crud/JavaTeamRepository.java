package com.github.dhodja92.javateam.crud;

import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JavaTeamRepository {

    private final Map<Integer, JavaTeamMember> members;

    public JavaTeamRepository() {
        this.members = new HashMap<>();
        this.initialize();
    }

    public JavaTeamMember findById(Integer id) {
        return this.members.get(id);
    }

    public Collection<JavaTeamMember> findAll() {
        return this.members.values();
    }

    public void create(CreateJavaTeamMemberRequest createRequest) {
        this.addMember(this.members.size() + 1, createRequest.getFirstName(), createRequest.getLastName());
    }

    public void update(UpdateJavaTeamMemberRequest updateRequest) {
        this.addMember(updateRequest.getId(), updateRequest.getFirstName(), updateRequest.getLastName());
    }

    public JavaTeamMember remove(JavaTeamMember javaTeamMember) {
        return this.members.remove(javaTeamMember.getId());
    }

    private void initialize() {
        this.members.clear();
        this.addMember(1, "Bruno", "Kovac");
        this.addMember(2, "Dominik", "Hodja");
        this.addMember(3, "Ivan", "Miklec");
        this.addMember(4, "Mario", "Slatinac");
        this.addMember(5, "Marko", "Marin");
        this.addMember(6, "Mislav", "Skomrak");
        this.addMember(7, "Tin", "Bubanko");
        this.addMember(8, "Zeljko", "Margeta");
        this.addMember(9, "Domagoj", "Latecki");
        this.addMember(10, "Luka", "Juric");
        this.addMember(11, "Roko", "Spahija");
        this.addMember(12, "Sven", "Vidak");
        this.addMember(13, "Vedran", "Pavic");
    }

    private void addMember(int id, String firstName, String lastName) {
        JavaTeamMember teamMember = JavaTeamMember.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .userHandle(firstName.toLowerCase().charAt(0) + lastName.toLowerCase())
                .build();
        this.members.put(id, teamMember);
    }
}
