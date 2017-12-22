package com.blog.service.impl.member;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.member.MemberDao;
import com.blog.entity.member.Member;
import com.blog.service.member.IMemberService;

@Service(value = "memberService")
public class MemberServiceImpl implements IMemberService {

	@Resource(name="memberDao")
	private MemberDao memberDao; 
	
 	/**根据ID获取唯一*/
	public Member getById(Integer id){
		return memberDao.getById(id);
	}
	
	/**根据条件获取列表 分页*/
	public List<Member> getMembers(Map<String, String> queryMap, Integer start, Integer size){
		return memberDao.getMembers(queryMap,start,size);
	}
    
    /**根据条件获取数量 分页*/
    public Integer getMembersCount(Map<String, String> queryMap){
    	return memberDao.getMembersCount(queryMap);
    }
    
     /**保存*/
	public Integer insert(Member member){
		return memberDao.insert(member);
	}
	
	 /**更新*/
	public Integer update(Member member){
		return memberDao.update(member);
	}
	
	/**删除*/
	public Integer delById(Integer id){
		return memberDao.delById(id);
	}

	/**根据用户名查询*/
	@Override
	public Member getByUsername(String username) {
		return memberDao.getByUsername(username);
	}

	/**根据对象查询*/
	@Override
	public List<Member> getByProperties(Map<String, String> queryMap) {
		return memberDao.getByProperties(queryMap);
	}
}
