package com.NOBank.internetBanking.DAO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.NOBank.internetBanking.Model.Transaction;

public interface TransactionDAO {
    @Select("SELECT id, password from transactiontable WHERE email = #{email}")
    void getId(Transaction transaction);

	@Select("SELECT sender, receiver, amount, timestamp  from transactiontable WHERE (sender = #{account} OR receiver = #{account})")
	List<Transaction> selectList(String account);

	@Insert("INSERT into transactiontable (sender, receiver, amount, timestamp) VALUES(#{sender}, #{receiver}, #{amount}, #{timestamp})    ")
	void save(Transaction transaction);
		
    @Delete("DELETE FROM transactiontable WHERE sender = #{sender} AND timestamp = #{timestamp}")
	void delete(Transaction transaction);

}