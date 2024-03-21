package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bookinghotel.entity.TokenConfirm;
import vn.techmaster.bookinghotel.model.TokenType;

import java.util.Optional;

public interface TokenConfirmRepository extends JpaRepository<TokenConfirm, Integer> {
    Optional<TokenConfirm> findByTokenAndTokenType(String token, TokenType tokenType);
}
