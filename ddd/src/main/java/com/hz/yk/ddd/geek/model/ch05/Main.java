package com.hz.yk.ddd.geek.model.ch05;

import com.hz.yk.ddd.geek.model.ch05.context.SocialContext;
import com.hz.yk.ddd.geek.model.ch05.context.SubscriptionContext;
import com.hz.yk.ddd.geek.model.ch05.models.Subscription;
import com.hz.yk.ddd.geek.model.ch05.models.User;

/**
 * @author wuzheng.yk
 * @date 2021/11/22
 */
public class Main {

    private UserRepository userRepository;

    public void transfer() {
        final User user = userRepository.findUserById(9999L);
        final User friend = userRepository.findUserById(8888L);

        final SocialContext.Contact contact = userRepository.inSocialContext().asContact(user);

        final SubscriptionContext.Reader reader = userRepository.inSubscriptionConetxt().asReader(user);
        final Subscription subsctiption = reader.getSubsctiption(112211L);

        // 朋友间的赠送
        //if (contact.isFriend(friend)) {
        //    reader.transfer(subsctiption, friend);
        //}
        
        //“只有朋友间才能赠送”属于领域逻辑。我们希望它被富集到模型中,而不是在模型外
        reader.transfer(subsctiption, friend);

    }
}
