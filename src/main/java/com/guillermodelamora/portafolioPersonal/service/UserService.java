package com.guillermodelamora.portafolioPersonal.service;

import com.guillermodelamora.portafolioPersonal.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // Crear un nuevo usuario
    User createUser(User user);

    // Buscar un usuario por ID
    Optional<User> getUserById(Long id);

    // Buscar un usuario por username
    Optional<User> getUserByUsername(String username);

    // Buscar un usuario por email
    Optional<User> getUserByEmail(String email);

    // Obtener todos los usuarios
    List<User> getAllUsers();

    // Actualizar usuario
    User updateUser(User user);

    // Eliminar un usuario
    void deleteUser(Long id);
}
