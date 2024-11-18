package com.guillermodelamora.portafolioPersonal.repository;

import com.guillermodelamora.portafolioPersonal.entity.Account;
import com.guillermodelamora.portafolioPersonal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Búsqueda por nombre de usuario
    Optional<User> findByUsername(String username);

    // Búsqueda por email
    Optional<User> findByEmail(String email);

    // Verificar si el nombre de usuario existe
    boolean existsByUsername(String username);

    // Verificar si el correo electrónico existe
    boolean existsByEmail(String email);

    // Búsqueda por nombre de usuario o correo electrónico
    Optional<User> findByUsernameOrEmail(String username, String email);

    // Buscar usuarios por un patrón en el nombre de usuario
    @Query("SELECT u FROM User u WHERE u.username LIKE %:username%")
    List<User> findByUsernameContaining(@Param("username") String username);

    // Buscar por relación con Account (requiere que Account esté correctamente mapeado)
    List<User> findByAccount(Account account);

    // Actualizar la contraseña por nombre de usuario
    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.username = :username")
    int updatePasswordByUsername(@Param("password") String password, @Param("username") String username);

    // Eliminar usuario por email
    @Modifying
    @Query("DELETE FROM User u WHERE u.email = :email")
    void deleteByEmail(@Param("email") String email);
}
