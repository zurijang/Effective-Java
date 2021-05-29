package ej.study.practice.program.member.service;

import ej.study.practice.program.member.service.dto.MemberDto;

import java.util.List;

public interface MemberService {
    public List<MemberDto> memberList() throws Exception;
}
