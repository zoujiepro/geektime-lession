package com.viepub.thinking.in.spring.dependency.injection;

import com.viepub.thinking.in.spring.ioc.overview.domain.User;
import lombok.*;

/**
 * @Descrption :
 * @Author: zoujie
 * @Date: 2020-8-26
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserHolder {

    private User user;


}
