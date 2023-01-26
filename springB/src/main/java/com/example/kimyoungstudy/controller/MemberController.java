package com.example.kimyoungstudy.controller;

import com.example.kimyoungstudy.domain.Member;
import com.example.kimyoungstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    //세터 주입방식하면 이 메소드는 퍼블릭으로 열려있기 때문에 ...  호출  ~변경의 위험
    }


    @GetMapping("/members/new")
    public  String creatForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());

        System.out.println(memberForm.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list (Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}

