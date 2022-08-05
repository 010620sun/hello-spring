package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository =new MemoryMemberRepository();

    @AfterEach
    public void aftereach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member=new Member();
        member.setName("spring");

        repository.save(member);

        Member result=repository.findById(member.getId()).get();
        System.out.println("result = "+(result==member));
        Assertions.assertEquals(member,result);
    }

    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 =new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result=repository.findByName("spring1").get();

        Assertions.assertEquals(member1,result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result=repository.findAll();

        Assertions.assertEquals(result.size(),2);

    }
}
