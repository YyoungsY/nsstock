package com.example.stocks.repository.stock;

import com.example.stocks.entity.market.KospiIndexEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface KospiIndexRe extends JpaRepository<KospiIndexEn, LocalDate> {

    // 코스피 종목 최신 날짜 기준으로 조회
    Optional<KospiIndexEn> findFirstByOrderByDateDesc();
    List<KospiIndexEn> findByDateGreaterThanEqualOrderByDateAsc(LocalDate startDate);
}