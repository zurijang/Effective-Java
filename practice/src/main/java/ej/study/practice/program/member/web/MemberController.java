package ej.study.practice.program.member.web;

import ej.study.practice.program.member.service.MemberService;
import ej.study.practice.program.member.service.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/member/list")
    public String memberList(Model model, HttpServletRequest req) throws Exception{
        List<MemberDto> memberList = memberService.memberList();
        model.addAttribute("memberList",memberList);
        return "member/memberList";

    }
}
