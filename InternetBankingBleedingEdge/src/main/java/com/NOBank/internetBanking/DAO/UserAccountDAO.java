package com.NOBank.internetBanking.DAO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.NOBank.internetBanking.Model.UserAccount;

public interface UserAccountDAO {
    @Select("SELECT email, count(*) as NUM FROM users WHERE email = #{email} GROUP BY email")
    void checkEmail(UserAccount useraccount);

    @Select("SELECT id, email, password, account1, account2, account3, account4, account5, firstname, lastname, beneficiary1, beneficiary2, beneficiary3, beneficiary4, beneficiary5, phone, DOB from users")
    List<UserAccount> retreiveAllAccounts();

	@Insert("INSERT into users (email,password,account1,firstname,lastname,phone,DOB) VALUES(#{email}, #{password},#{account1}, #{firstname}, #{lastname}, #{phone},#{DOB})")
	void save(UserAccount useraccount);
	
	@Select("SELECT id, email, password, account1, account2, account3, account4, account5, firstname, lastname, beneficiary1, beneficiary2, beneficiary3, beneficiary4, beneficiary5, phone, DOB from users WHERE email = #{email} and password = #{password}")
	UserAccount getAccountData(UserAccount useraccount);

	@Select("SELECT id, email, password, account1, account2, account3, account4, account5, firstname, lastname, beneficiary1, beneficiary2, beneficiary3, beneficiary4, beneficiary5, phone, DOB from users WHERE id = #{id}")
	UserAccount getId(UserAccount useraccount);

	@Update("UPDATE users SET email=#{email}, password=#{password}, account1=#{account1}, account2=#{account2}, account3=#{account3}, account4=#{account4}, account5=#{account5}, firstname=#{firstname}, lastname=#{lastname}, beneficiary1=#{beneficiary1}, beneficiary2=#{beneficiary2}, beneficiary3=#{beneficiary3}, beneficiary4=#{beneficiary4}, beneficiary5=#{beneficiary5}, phone=#{phone}, DOB=#{DOB}  WHERE id = #{id}")
	void update(UserAccount useraccount);
	
    @Delete("DELETE FROM users WHERE id = #{id}")
	void delete(int id);

    
}