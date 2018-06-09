package br.com.agenda.core.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    @Query(value="select * from tab_user u where u.username=?1 and exists (select * tab_contact c where c.id=?2 and c.fk_id_user=u.id)",nativeQuery = true)
    User findUserByUsernameAndContact(String username, Long id);
}