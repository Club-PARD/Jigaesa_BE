package com.pard.namukkun.user.entity;

import com.pard.namukkun.post.entity.Post;
import com.pard.namukkun.user.dto.UserCreateDTO;
import com.pard.namukkun.user.dto.UserUpdateDTO;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userId;
    private String kakaoId;
    private String nickName;
    private String email;

    private Integer local;

    private String profileImage; // kakao profile image


//    private // TODO 유저가 쓴 글 저장
//
//    public User(User user) {
//        this.authId = user.getAuthId();
//        this.email = user.getEmail();
//        this.nickName = user.getNickName();
//    }

    public static User toEntity(UserCreateDTO userCreateDTO) {
        return User.builder()
                .nickName(userCreateDTO.getNickName())
                .email(userCreateDTO.getEmail())
                .build();
    }

    public void updateNickName(String nickName) {
        this.nickName = nickName;
    }
}