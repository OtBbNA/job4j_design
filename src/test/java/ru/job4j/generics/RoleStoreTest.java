package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenRolenameIsJunior() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Junior", 2));
        Role result = store.findById("1");
        assertThat(result.getRolename(), is("Junior"));
    }

    @Test
    public void whenNoAddAndFindThenRolenameIsNull() {
        RoleStore store = new RoleStore();
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenAddAndReplaceThenRolenameIsTrainee() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Junior", 2));
        store.replace("1", new Role("1", "Trainee", 3));
        Role result = store.findById("1");
        assertThat(result.getRolename(), is("Trainee"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Junior", 2));
        store.replace("2", new Role("2", "Trainee", 3));
        Role result = store.findById("1");
        assertThat(result.getRolename(), is("Junior"));
    }

    @Test
    public void whenAddAndDeleteThenRolenameIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Junior", 2));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenAddAndDeleteThenRolenameIsJunior() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Junior", 2));
        store.delete("2");
        Role result = store.findById("1");
        assertThat(result.getRolename(), is("Junior"));
    }

    @Test
    public void whenAddAndFindByIdThenRolenameIsMiddle() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Junior", 2));
        store.add(new Role("2", "Trainee", 1));
        store.add(new Role("3", "Middle", 1));
        Role result = store.findById("3");
        assertThat(result.getRolename(), is("Middle"));
    }

    @Test
    public void whenAddAndFindByIdThenRolenameIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Junior", 2));
        Role result = store.findById("2");
        assertNull(result);
    }
}