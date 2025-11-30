package com.example.stocks.repository.user;

import com.example.stocks.entity.user.UserInfoEn;
import com.example.stocks.entity.user.UserWidgetSettingsEn;
import com.example.stocks.entity.user.UserWidgetSettingsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 사용자 별 위젯 세팅 값
@Repository
public interface UserWidgetSettingsRe extends JpaRepository<UserWidgetSettingsEn, UserWidgetSettingsId> {
    void deleteAllByUserInfo(UserInfoEn userInfoEn);
}